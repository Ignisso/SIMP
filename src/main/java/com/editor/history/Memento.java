package com.editor.history;

import com.editor.image.Image;

public class Memento {
	Image img; 
	
	public Memento() { this.img = null; }

	public void memorizeImage(Image img) throws CloneNotSupportedException {
		this.img = (Image) img.clone();
	}
	
	public Image recallImage() {
		return img;
	
	}
}
