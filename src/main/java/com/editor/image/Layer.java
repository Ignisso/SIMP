package com.editor.image;

import javax.swing.*;
import com.editor.window.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Layer
extends JComponent {
	private MainWindow    window;
	private boolean       visible;
	private Integer       index;
	private BufferedImage image;
	private Image         parent;
	private Integer       X;
	private Integer       Y;
	
	public Layer(MainWindow window, BufferedImage image, Integer index, Image parent) {
		super();
		this.image   = image;
		this.visible = true;
		this.index   = index;
		this.window  = window;
		this.parent  = parent;
		this.X       = 0;
		this.Y       = 0;
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
	
	public void update() {
		Integer dispSizeX = (int)(this.image.getWidth() * this.parent.getScale());
		Integer dispSizeY = (int)(this.image.getHeight() * this.parent.getScale());
		Integer centerX   = (window.getWidth() / 2) - (dispSizeX / 2);
		Integer centerY   = (window.getHeight() / 2) - (dispSizeY / 2);
		this.setBounds(this.X + centerX, this.Y + centerY, dispSizeX, dispSizeY);
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (this.visible) {
			AffineTransform at = new AffineTransform();
			at.scale(this.parent.getScale(), this.parent.getScale());
			Graphics2D g2d = (Graphics2D)g.create();
			g2d.drawImage(this.image, at, null);
			super.paintComponent(g2d);
			g2d.dispose();
		}
	}
}