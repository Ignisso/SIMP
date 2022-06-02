package com.editor.history;

import com.editor.image.Image;

public class MementoImage {
	Image img;
	
	public MementoImage() {
		this.img = null;
	}
	
	public void memorizeImage(Image img) throws CloneNotSupportedException {
		this.img = img.clone();
	}
	
	public Image recallImage() {
		return img;
	}
}
