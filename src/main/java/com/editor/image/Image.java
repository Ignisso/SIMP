package com.editor.image;

import javax.swing.*;
import com.editor.window.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class Image
extends JLayeredPane implements Cloneable {
	private MainWindow       window;
	private Integer          activeLayer;
	private ArrayList<Layer> layers;
	private double           scale;
	private Integer          X;
	private Integer          Y;
	
	public Image(MainWindow window) {
		super();
		this.window      = window;
		this.activeLayer = null;
		this.layers      = new ArrayList<Layer>();
		this.scale       = 1.f;
		this.X           = 0;
		this.Y           = 0;
	}
	
	private Image(MainWindow window, Integer activeLayer,
		ArrayList<Layer> layers, double scale, Integer X, Integer Y) {
        super();
        this.window      = window;
        this.activeLayer = activeLayer;
        this.layers      = new ArrayList<Layer>();
        for(Layer l : layers) {
			Layer cloned = l.clone();
			cloned.setParent(this);
            this.layers.add(cloned);
			this.add(cloned, l.getIndex());
        }
        this.scale       = scale;
        this.X           = X;
        this.Y           = Y;
    }

    public Image clone() {
        return new Image(this.window, this.activeLayer, this.layers,
			this.scale, this.X, this.Y);
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
	
	public void addLayer(BufferedImage image) {
		Layer layer = new Layer(this.window, image, this.layers.size(), this);
		this.layers.add(layer);
		this.add(layer, this.layers.size());
		this.activeLayer = this.layers.size() - 1;
		layer.update();
	}
	
	public void update() {
		for (Layer l : this.layers)
			l.update();
	}
	
	public void zoomOut(Integer x, Integer y) {
		if (this.scale > 0.01f) {
			this.scale -= (this.scale * 0.15f);
			this.X -= (int)((this.getWidth() / 2 - x) * 0.15f);
			this.Y -= (int)((this.getHeight() / 2 - y) * 0.15f);
			this.update();
			this.window.validate();
			this.window.repaint();
		}
	}
	
	public void zoomIn(Integer x, Integer y) {
		if (this.scale < 100.f) {
			this.scale += (this.scale * 0.15f);
			this.X += (int)((this.getWidth() / 2 - x) * 0.15f);
			this.Y += (int)((this.getHeight() / 2 - y) * 0.15f);
			this.update();
			this.window.validate();
			this.window.repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(0x1E1E22));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}