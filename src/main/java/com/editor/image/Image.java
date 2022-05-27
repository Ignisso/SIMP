package com.editor.image;

import javax.swing.*;
import com.editor.window.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Image
extends JLayeredPane {
	private MainWindow       window;
	private Integer          activeLayer;
	private ArrayList<Layer> layers;
	private double           scale;
	
	public Image(MainWindow window) {
		super();
		this.window      = window;
		this.activeLayer = null;
		this.layers      = new ArrayList<Layer>();
		this.scale       = 1.f;
	}
	
	public double getScale() {
		return this.scale;
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
	
	public void zoomOut() {
		if (this.scale > 0.01f) {
			this.scale -= (this.scale * 0.25f);
			this.update();
			this.window.validate();
			this.window.repaint();
		}
	}
	
	public void zoomIn() {
		if (this.scale < 100.f) {
			this.scale += (this.scale * 0.25f);
			this.update();
			this.window.validate();
			this.window.repaint();
		}
	}
	
	public Layer getActiveLayer() {
		if (activeLayer == null)
			return null;
		return this.layers.get(this.activeLayer);
	}
}