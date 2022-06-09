package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class Brightness 
extends Effect {
	private Integer effectStrength;
	
	public Brightness(EditorRuntime root) {
		super(root);
		this.effectStrength = 5;
	}

	public Brightness(EditorRuntime root, Integer effectStrength) {
		super(root);
		this.effectStrength = effectStrength;
	}
	
	public void process() {
		for (int i = 0; i < active.getLayerWidth(); i++) {
			for (int j = 0; j < active.getLayerHeight(); j++) {
				int rgb = active.getRGB(i, j);
				int a = rgb >> 24 & 0xFF;
				int r = rgb >> 16 & 0xFF;
				int g = rgb >> 8 & 0xFF;
				int b = rgb & 0xFF;
				r += this.effectStrength; g += this.effectStrength; b += this.effectStrength;
				r = Math.max(Math.min(255, r), 0);
				g = Math.max(Math.min(255, g), 0);
				b = Math.max(Math.min(255, b), 0);
				rgb = (a << 24) + (r << 16) + (g << 8) + (b);
				active.setRGB(i, j, rgb);
				addProgress((active.getLayerWidth() / 20* i)/100);
			}
		}
		setProgress(100);
		active.update();
		addToHistory();
	}
	
	@Override
	public String toString() {
		return "Brightness";
	}
}
