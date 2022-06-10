package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class Temperature 
extends Effect {
	private Integer effectStrength;
	
	public Temperature(EditorRuntime root) {
		super(root);
		this.effectStrength = 5;
	}

	public Temperature(EditorRuntime root, Integer effectStrength) {
		super(root);
		this.effectStrength = effectStrength;
	}
	
	public void process() {
		for (int i = 0; i < active.getLayerWidth(); i++) {
			setProgress(100 * (i+1)/active.getLayerWidth());
			for (int j = 0; j < active.getLayerHeight(); j++) {
				int rgb = active.getRGB(i, j);
				int a = rgb >> 24 & 0xFF;
				int r = rgb >> 16 & 0xFF;
				int g = rgb >> 8 & 0xFF;
				int b = rgb & 0xFF;
				if(effectStrength > 0) {
					r += this.effectStrength; g += this.effectStrength;
					r = Math.max(Math.min(255, r), 0);
					g = Math.max(Math.min(255, g), 0);
				} else {
					b -= this.effectStrength;
					b = Math.max(Math.min(255, b), 0);
				}
				rgb = (a << 24) + (r << 16) + (g << 8) + (b);
				active.setRGB(i, j, rgb);
			}
		}
		active.update();
		addToHistory();
	}
	
	@Override
	public String toString() {
		return "Temperature";
	}
}
