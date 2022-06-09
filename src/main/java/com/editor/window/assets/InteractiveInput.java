package com.editor.window.assets;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class InteractiveInput
extends JPanel {
	private JSpinner[] values;
	
	public InteractiveInput(String[] labels, int min, int max, int step) {
		super(new FlowLayout(FlowLayout.CENTER, 10, 5));
		values = new JSpinner[labels.length];
		for(int i = 0; i < labels.length; i++) {
			values[i] = new JSpinner(
				new SpinnerNumberModel(min, min, max, step)
			);
			this.add(values[i]);
			this.add(new JLabel(labels[i]));
		} 
	}

	public InteractiveInput(String[] labels, int min, int max, int step, int[] initValues) {
		super(new FlowLayout(FlowLayout.CENTER, 10, 5));
		values = new JSpinner[labels.length];
		for(int i = 0; i < labels.length; i++) {
			values[i] = new JSpinner(
				new SpinnerNumberModel(initValues[i], min, max, step)
			);
			this.add(values[i]);
			this.add(new JLabel(labels[i]));
		} 
	}
	
	public int getValue(int i) {
		return (Integer) this.values[i].getValue();
	}
}