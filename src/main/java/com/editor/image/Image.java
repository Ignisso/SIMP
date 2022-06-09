package com.editor.image;

import com.editor.core.*;
import com.editor.window.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import java.io.File;

public class Image
extends JComponent implements Cloneable {
	private MainWindow       window;
	private Integer          activeLayer;
	private ArrayList<Layer> layers;
	private double           scale;
	private Integer          X;
	private Integer          Y;
	private Integer          width;
	private Integer          height;
	private int              imageFormat;
	
	private void fillAlpha(Graphics g, int size) {
		int pixels = size;
		g.setColor(new Color(0x333333));
		int col = 0;
		int row = 0;
		int maxcols = this.getHeight();
		int maxrows = this.getWidth();
		//if (maxcols > this.window.getWorkspace().getHeight())
		//	maxcols = window.getHeight();
		//if (maxrows > this.window.getWorkspace().getWidth())
		//	maxrows = window.getWidth();
		while (pixels * col < maxcols) {
			int y_offset = col * pixels;
			while (pixels * row < maxrows) {
				int x_offset = row * pixels;
				g.fillRect(x_offset, y_offset, pixels, pixels);
				row+=2;
			}
			col++;
			row = (col % 2);
		}
		row = 1;
		col = 0;
		g.setColor(new Color(0x555555));
		while (pixels * col < maxcols) {
			int y_offset = col * pixels;
			while (pixels * row < maxrows) {
				int x_offset = row * pixels;
				g.fillRect(x_offset, y_offset, pixels, pixels);
				row+=2;
			}
			col++;
			row = ((col + 1) % 2);
		}
	}
	
	private ArrayList<Layer> getLayers() {
		return this.layers;
	}
	
	private BufferedImage mergeLayers() {
		BufferedImage result;
		result = new BufferedImage(this.width, this.height, this.imageFormat);
		Graphics g = result.getGraphics();
		for (Layer l : this.layers) {
			g.translate(l.getXpos(), l.getYpos());
			g.drawImage(l.getImage(), 0, 0, null);
			g.translate(-l.getXpos(), -l.getYpos());
		}
		g.dispose();
		return result;
	}
	
	public Image(MainWindow window) {
		super();
		this.window      = window;
		this.activeLayer = null;
		this.layers      = new ArrayList<Layer>();
		this.scale       = 1.f;
		this.X           = 0;
		this.Y           = 0;
		this.width       = 0;
		this.height      = 0;
	}
	
	private Image(MainWindow window, Integer activeLayer, ArrayList<Layer> layers,
		double scale, Integer X, Integer Y, Integer w, Integer h, Rectangle bounds,
		int channels) {
        super();
        this.window      = window;
        this.activeLayer = activeLayer;
        this.layers      = new ArrayList<Layer>();
        for(Layer l : layers) {
			Layer cloned = l.clone();
			cloned.setParent(this);
            this.layers.add(cloned);
			this.add(cloned);
        }
        this.scale       = scale;
        this.X           = X;
        this.Y           = Y;
		this.width       = w;
		this.height      = h;
		this.imageFormat = channels;
		this.setBounds(bounds);
    }
	
    public Image clone() {
        return new Image(this.window, this.activeLayer, this.layers, this.scale,
			this.X, this.Y, this.width, this.height, this.getBounds(), this.imageFormat);
    }
	
	public void setSettings(Image img) {
		this.scale = img.scale;
		this.X     = img.X;
		this.Y     = img.Y;
	}
	
	public void setDimension(Integer width, Integer height) {
		this.width  = width;
		this.height = height;
		this.setSize((int)(width * this.getScale()), (int)(height * this.getScale()));
		this.update();
	}
	
	public int getChannels() {
		return this.imageFormat;
	}
	
	public void setChannels(int channels) throws UnsupportedFormat {
		for (Layer l : this.layers) {
			Mat img = Convert.img2Mat(l.getImage());
			int conversion = 0;
			if (img.type() == CvType.CV_8UC1) {
				if (channels == BufferedImage.TYPE_3BYTE_BGR)
					conversion = Imgproc.COLOR_GRAY2BGR;
				else if (channels == BufferedImage.TYPE_4BYTE_ABGR)
					conversion = Imgproc.COLOR_GRAY2BGRA;
				else
					throw new UnsupportedFormat();
			}
			else if (img.type() == CvType.CV_8UC3) {
				if (channels == BufferedImage.TYPE_BYTE_GRAY)
					conversion = Imgproc.COLOR_BGR2GRAY;
				else if (channels == BufferedImage.TYPE_4BYTE_ABGR)
					conversion = Imgproc.COLOR_BGR2BGRA;
				else
					throw new UnsupportedFormat();
			}
			else if (img.type() == CvType.CV_8UC4) {
				if (channels == BufferedImage.TYPE_BYTE_GRAY)
					conversion = Imgproc.COLOR_BGRA2GRAY;
				else if (channels == BufferedImage.TYPE_3BYTE_BGR)
					conversion = Imgproc.COLOR_BGRA2BGR;
				else
					throw new UnsupportedFormat();
			}
			else
				throw new UnsupportedFormat();
			Imgproc.cvtColor(img, img, conversion);
			BufferedImage out = Convert.mat2Img(img);
			l.setImage(out);
		}
		this.imageFormat = channels;
		this.update();
	}
	
	public double getScale() {
		return this.scale;
	}
	
	public void setPosition(Integer x, Integer y) {
		this.X = x;
		this.Y = y;
		this.update();
	}
	
	public Integer getXpos() {
		return this.X;
	}
	
	public Integer getYpos() {
		return this.Y;
	}
	
	public Layer getActiveLayer() {
		if (activeLayer == null)
			return null;
		return this.layers.get(this.activeLayer);
	}
	
	public void exportToFile(File file, String format) {
		try {
			ImageIO.write(this.mergeLayers(), format, file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addLayer(BufferedImage image) {
		if (this.layers.size() == 0) {
			this.X      = this.window.getWidth() / 2;
			this.Y      = this.window.getHeight() / 2;
			this.width  = image.getWidth();
			this.height = image.getHeight();
			setSize(this.width, this.height);
			this.X -= image.getWidth() / 2;
			this.Y -= image.getHeight() / 2;
			this.imageFormat = image.getType();
		}
		
		Layer layer = new Layer(this.window, image, this.layers.size(), this);
		this.layers.add(layer);
		this.add(layer);
		this.activeLayer = this.layers.size() - 1;
		layer.update();
	}
	
	public void update() {
		this.setLocation(this.X, this.Y);
		for (Layer l : this.layers)
			l.update();
	}
	
    public void zoomOut(Integer x, Integer y) {
        if (this.scale > 0.01f) {
            this.scale -= (this.scale * 0.15f);
            this.X += (int)((x - this.getWidth() / 2) * 0.15f);
            this.Y += (int)((y - this.getHeight() / 2) * 0.15f);
            this.setSize((int)(this.width * this.scale), (int)(this.height * this.scale));
            this.update();
        }
    }
    
    public void zoomIn(Integer x, Integer y) {
        if (this.scale < 100.f) {
            this.scale += (this.scale * 0.15f);
            this.X += (int)((this.getWidth() / 2 - x) * 0.15f);
            this.Y += (int)((this.getHeight() / 2 - y) * 0.15f);
            this.setSize((int)(this.width * this.scale), (int)(this.height * this.scale));
            this.update();
        }
    }
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g.create();
		this.fillAlpha(g2d, 10);
		Integer dispSizeX = (int)(this.width * this.scale) - 1;
		Integer dispSizeY = (int)(this.height * this.scale) - 1;
		int[] x = {0, dispSizeX, dispSizeX, 0};
		int[] y = {0, 0, dispSizeY, dispSizeY};
		g2d.setColor(new Color(0x00E3E3));
		g2d.drawPolygon(x, y, 4);
		super.paintComponent(g2d);
		g2d.dispose();
	}
}