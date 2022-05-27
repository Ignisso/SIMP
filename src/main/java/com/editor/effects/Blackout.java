package com.editor.effects;

import com.editor.image.*;

public class Blackout
extends Effect {
	public Blackout(Layer layer) {
		super(layer);
	}
	
	public void doEffect() {
		for (int i = 0; i < active.getLayerWidth(); i+=2) {
			for (int j = 0; j < active.getLayerHeight(); j+=2) {
				active.setRGB(i, j, 0x000000);
			}
		}
		active.update();
	}
}