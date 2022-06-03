package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class Blackout
extends Effect {
	public Blackout(EditorRuntime root) {
		super(root);
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