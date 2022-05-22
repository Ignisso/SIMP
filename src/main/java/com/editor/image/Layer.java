package com.editor.image;

import javax.swing.*;

public class Layer
extends JLabel {
	private boolean   visible;
	private Image     root;
	private Integer   index;
	
	public Layer(Image img, Integer index) {
		this.visible = true;
		this.root    = img;
		this.index   = index;
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