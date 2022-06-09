package com.editor.image;

import javax.swing.*;
import com.editor.window.*;
import java.awt.image.*;
import java.awt.geom.AffineTransform;
import java.awt.*;

public class Layer
extends JComponent {
	private MainWindow    window;
	private boolean       visible;
	private Integer       index;
	private BufferedImage image;
	private Image         parent;
	private Integer       X;
	private Integer       Y;
	private double        rotate;
	
	public Layer(MainWindow window, BufferedImage image, Integer index, Image parent) {
		super();
		this.image   = image;
		this.visible = true;
		this.index   = index;
		this.window  = window;
		this.parent  = parent;
		this.X       = 0;
		this.Y       = 0;
		this.rotate  = 0.f;
		this.setSize((int)(image.getWidth() * parent.getScale()),
			(int)(image.getHeight() * parent.getScale()));
	}
	
	private Layer(MainWindow window, boolean visible, Integer index,
		BufferedImage image, Image parent, Integer X, Integer Y, double rotate) {
		super();
		this.window  = window;
		this.visible = visible;
		this.index   = index;
		ColorModel cm = image.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = image.copyData(null);
		BufferedImage clonedImage =
			new BufferedImage(cm, raster, isAlphaPremultiplied, null);
		this.image   = clonedImage;
		this.parent  = parent;
		this.X       = X;
		this.Y       = Y;
		this.rotate  = rotate;
	}
	
	public Layer clone() {
		return new Layer(this.window, this.visible, this.index, this.image,
			this.parent, this.X, this.Y, this.rotate);
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setParent(Image parent) {
		this.parent = parent;
	}
	
	public void setRGB(int x, int y, int rgb) {
		this.image.setRGB(x, y, rgb);
	}
	
	public int getRGB(int x, int y) {
		return this.image.getRGB(x, y);
	}
	
	public Integer getAbsoluteRGB(int x, int y) {
		x-=this.X;
		y-=this.Y;
		if (x < 0 || x >= this.image.getWidth() || y < 0 || y >= this.image.getHeight())
			return null;
		else
			return this.image.getRGB(x, y);
	}
	
	public double getRotation() {
		return this.rotate;
	}
	
	public void setRotation(double degree) {
		this.rotate = degree;
		this.update();
	}
	
	public Integer getLayerWidth() {
		return this.image.getWidth();
	}
	
	public Integer getLayerHeight() {
		return this.image.getHeight();
	}
	
	public void changeVisibility() {
		this.visible = !this.visible;
		this.repaint();
	}
	
	public boolean getVisibility() {
		return this.visible;
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
	
	public void setAbove() {
		
	}
	
	public void setBelow() {
		
	}
	
	public void setIndex(Integer i) {
		this.index = i;
	}
	
	public Integer getIndex() {
		return this.index;
	}
	
	public void update() {
		this.setSize((int)(image.getWidth() * parent.getScale()),
			(int)(image.getHeight() * parent.getScale()));
		this.setLocation((int)(this.X * this.parent.getScale()),
			(int)(this.Y * this.parent.getScale()));
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (this.visible) {
			AffineTransform at = new AffineTransform();
			at.scale(this.parent.getScale(), this.parent.getScale());
			Graphics2D g2d = (Graphics2D)g.create();
			Integer dispSizeX = (int)(this.image.getWidth() * this.parent.getScale()) - 1;
			Integer dispSizeY = (int)(this.image.getHeight() * this.parent.getScale()) - 1;
			int[] x = {0, dispSizeX, dispSizeX, 0};
			int[] y = {0, 0, dispSizeY, dispSizeY};
			//g2d.rotate(Math.toRadians(this.rotate), dispSizeX / 2, dispSizeY / 2);
			g2d.drawImage(this.image, at, null);
			//g2d.rotate(Math.toRadians(-this.rotate), dispSizeX / 2, dispSizeY / 2);
			if (this == this.parent.getActiveLayer()) {
				g2d.setColor(new Color(0xE3E300));
				g2d.drawPolygon(x, y, 4);
			}
			super.paintComponent(g2d);
			g2d.dispose();
		}
	}
}