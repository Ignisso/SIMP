package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class Blackout
extends Effect {
	private Integer step;
	
	public Blackout(EditorRuntime root) {
		super(root);
		this.step = 2;
	}
	
	public Blackout(EditorRuntime root, Integer step) {
		super(root);
		this.step = step;
	}
	public void process() {
		for (int i = 0; i < active.getLayerWidth(); i+=this.step) {
			setProgress(100 * (i+1)/active.getLayerWidth());
			for (int j = 0; j < active.getLayerHeight(); j+=this.step) {
				active.setRGB(i, j, 0xFF000000);
			}
		}
		active.update();
		addToHistory();		
	}
	
	@Override
	public String toString() {
		return "Blackout";
	}
}