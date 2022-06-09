package com.editor.window.assets;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class InteractiveRadio
extends JPanel {
	private JRadioButton[] values;
	
	public InteractiveRadio(String[] labels) {
		super(new FlowLayout(FlowLayout.CENTER, 10, 5));
		values = new JRadioButton[labels.length];
		for(int i = 0; i < labels.length; i++) {
			if(i == 0)
				values[i] = new JRadioButton(labels[i], true);
			else
				values[i] = new JRadioButton(labels[i]);
			this.add(values[i]);
		} 
	}
	
	public int getValue() {
		for(int i = 0; i < values.length; i++) {
			if(values[i].isSelected())
				return i;
		}
		return 0;
	}
}