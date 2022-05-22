package com.editor.image;

import javax.swing.*;
import com.editor.window.*;

public class Layer
extends JLabel {
	private MainWindow window;
	private boolean    visible;
	private Integer    index;
	
	public Layer(MainWindow window, Icon image, Integer index) {
		super(image);
		this.visible = true;
		this.index   = index;
		this.window  = window;
		this.setBounds(window.getBounds());
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
}