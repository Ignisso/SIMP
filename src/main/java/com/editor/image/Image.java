package com.editor.image;

import javax.swing.*;
import com.editor.window.*;
import java.util.ArrayList;

public class Image
extends JLayeredPane {
	private MainWindow       window;
	private Integer          activeLayer;
	private ArrayList<Layer> layers;
	
	public Image(MainWindow window) {
		super();
		this.window      = window;
		this.activeLayer = null;
		this.layers      = new ArrayList<Layer>();
	}
	
	public void addLayer(Icon image) {
		this.layers.add(new Layer(this.window, image, this.layers.size()));
		this.add(this.layers.get(this.layers.size() - 1), this.layers.size());
		this.activeLayer = this.layers.size();
	}
}