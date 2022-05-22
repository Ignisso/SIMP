package com.editor.image;

import javax.swing.*;

public class Image
extends JLayeredPane {
	private Integer activeLayer;
	
	public Image() {
		super();
		this.activeLayer = null;
	}
}