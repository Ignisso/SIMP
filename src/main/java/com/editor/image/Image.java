package com.editor.image;

import javax.swing.*;
import com.editor.window.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Image
extends JLayeredPane implements Cloneable {
	private MainWindow       window;
	private Integer          activeLayer;
	private ArrayList<Layer> layers;
	private double           zoom;
	
	public Image(MainWindow window) {
		super();
		this.window      = window;
		this.activeLayer = null;
		this.layers      = new ArrayList<Layer>();
		this.zoom        = 1.f;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void addLayer(BufferedImage image) {
		Layer layer = new Layer(this.window, image, this.layers.size(), this.zoom);
		this.layers.add(layer);
		this.add(layer, this.layers.size());
		this.activeLayer = this.layers.size();
		layer.update(this.zoom);
	}
	
	public void update() {
		for (Layer l : this.layers)
			l.update();
	}
	
	public void update(double scale) {
		for (Layer l : this.layers)
			l.update(scale);
	}
	
	public void zoomOut() {
		if (this.zoom > 0.01f) {
			this.zoom -= (this.zoom * 0.25f);
			this.update(this.zoom);
			this.window.validate();
			this.window.repaint();
		}
	}
	
	public void zoomIn() {
		if (this.zoom < 100.f) {
			this.zoom += (this.zoom * 0.25f);
			this.update(this.zoom);
			this.window.validate();
			this.window.repaint();
		}
	}
}
