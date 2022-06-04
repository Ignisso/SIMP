package com.editor.window;

import javax.swing.*;

public class DialogBox
extends JDialog {
	private JPanel options;
	
	public DialogBox(Window window, String title) {
		super(window, title, true);
		this.options = new JPanel();
		this.setSize(300, 100);
		double x = window.getLocation().getX() - 150.f;
		double y = window.getLocation().getY() - 50.f;
		x += window.getSize().getWidth() / 2;
		y += window.getSize().getHeight() / 2;
		this.setLocation((int)x, (int)y);
	}
	
	public void addApplet(JComponent applet) {
		this.options.add(applet);
	}
	
	public void finish() {
		this.options.add(new JButton("Apply"));
		this.options.add(new JButton("Canel"));
		this.add(this.options);
		setVisible(true);
	}
}