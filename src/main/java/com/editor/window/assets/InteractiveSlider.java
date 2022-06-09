package com.editor.window.assets;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class InteractiveSlider
extends JPanel {
	private JSlider  slider;
	private JSpinner spin;
	
	public InteractiveSlider(int min, int max) {
		super(new FlowLayout(FlowLayout.CENTER, 10, 5));
		this.slider = new JSlider(min, max);
		JSpinner spin = new JSpinner(
			new SpinnerNumberModel(slider.getValue(), min, max, 1));
		this.add(slider);
		this.add(spin);
		this.bind();
	}
	
	public InteractiveSlider(String name, int min, int max) {
		super(new FlowLayout(FlowLayout.CENTER, 10, 5));
		JLabel slidername = new JLabel(name);
		this.slider = new JSlider(min, max);
		this.spin = new JSpinner(
			new SpinnerNumberModel(slider.getValue(), min, max, 1));
		this.add(slidername);
		this.add(slider);
		this.add(spin);
		this.bind();
	}
	
	public void bind() {
		this.slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spin.setValue(slider.getValue());
			}
		});
		
		this.spin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				slider.setValue((int)spin.getValue());
			}
		});
	}
	
	public void addChangeListener(ChangeListener l) {
		this.slider.addChangeListener(l);
	}
	
	public int getValue() {
		return this.slider.getValue();
	}
}