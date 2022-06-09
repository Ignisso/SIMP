package com.editor.window.assets;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class ColorPicker
extends JPanel {
	private InteractiveSlider red;
	private InteractiveSlider green;
	private InteractiveSlider blue;
	private JPanel            visual;
	
	public ColorPicker() {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.red   = new InteractiveSlider("R: ", 0, 255);
		this.green = new InteractiveSlider("G: ", 0, 255);
		this.blue  = new InteractiveSlider("B: ", 0, 255);
		this.visual = new JPanel();
		this.visual.setSize(300, 50);
		this.visual.setBackground(new Color(
			this.red.getValue(), this.green.getValue(), this.blue.getValue()));
		this.visual.setOpaque(true);
		this.add(this.red);
		this.add(this.green);
		this.add(this.blue);
		this.add(this.visual);
		this.bind();
	}
	
	public void bind() {
		this.red.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				visual.setBackground(new Color(red.getValue(),
					green.getValue(), blue.getValue()));
			}
		});
		this.green.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				visual.setBackground(new Color(red.getValue(),
					green.getValue(), blue.getValue()));
			}
		});
		this.blue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				visual.setBackground(new Color(red.getValue(),
					green.getValue(), blue.getValue()));
			}
		});
	}
	
	public int getValue() {
		int color = 0x00000000;
		color |= this.red.getValue();
		color <<= 8;
		color |= this.green.getValue();
		color <<= 16;
		color |= this.blue.getValue();
		color |= 0xFF000000;
		return color;
	}
}