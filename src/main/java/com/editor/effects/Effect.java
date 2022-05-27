package com.editor.effects;

import com.editor.image.*;

public abstract class Effect {
	protected Layer active;
	
	public Effect(Layer layer) {
		this.active = layer;
		this.doEffect();
	}
	
	public abstract void doEffect();
}