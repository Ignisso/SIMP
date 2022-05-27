package com.editor.effects;

import com.editor.image.*;

public class Temperature 
extends Effect {

	private int effectStrength;
	
	public Temperature(Layer layer, int effectStrength) {
		super(layer);
		this.effectStrength = effectStrength; 
	}
	
	public void doEffect() {
		for (int i = 0; i < active.getLayerWidth(); i++) {
			for (int j = 0; j < active.getLayerHeight(); j++) {
				int rgb = active.getRGB(i, j);
				int a = rgb >> 24 & 0xFF;
				int r = rgb >> 16 & 0xFF;
				int g = rgb >> 8 & 0xFF;
				int b = rgb & 0xFF;
				if(effectStrength > 0) {
					r += effectStrength; g += effectStrength;
					r = Math.max(Math.min(255, r), 0);
					g = Math.max(Math.min(255, g), 0);
				} else {
					b -= effectStrength;
					b = Math.max(Math.min(255, b), 0);
				}
				rgb = (a << 24) + (r << 16) + (g << 8) + (b);
				active.setRGB(i, j, rgb);
			}
		}
		active.update();
	}
}