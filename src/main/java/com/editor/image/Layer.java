package com.editor.image;

import javax.swing.*;
import com.editor.window.*;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

public class Layer
extends JLabel {
	private MainWindow    window;
	private boolean       visible;
	private Integer       index;
	private BufferedImage image;
	
	public Layer(MainWindow window, BufferedImage image, Integer index, double zoom) {
		super(new ImageIcon(image));
		this.image   = image;
		this.visible = true;
		this.index   = index;
		this.window  = window;
		this.update(zoom);
	}
	
	public void changeVisibility() {
		this.visible = !this.visible;
	}
	
	public void setAbove() {
		
	}
	
	public void setBelow() {
		
	}
	
	public void setIndex(Integer i) {
		this.index = i;
	}
	
	public void update() {
		this.setBounds(0, 0, window.getWidth() - 12, window.getHeight() - 57);
	}
	
	public void update(double scale) {
		double width = this.image.getWidth() * scale;
		double height = this.image.getHeight() * scale;
		Image i = this.image.getScaledInstance((int)width, (int)height, Image.SCALE_FAST);
		
		this.setIcon(new ImageIcon(i));
		this.setBounds(0, 0, window.getWidth() - 12, window.getHeight() - 57);
	}
}