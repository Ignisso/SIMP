package com.editor.effects;

import com.editor.core.*;
import com.editor.history.*;
import com.editor.image.*;

public abstract class Effect {
	protected Layer active;
	
	public Effect(EditorRuntime root) {
		Command ec = new EditImageCommand(root.getWindow().getWorkspace(),
			this.toString());
		ec.restore();
		this.active = root.getWindow().getWorkspace().getImage().getActiveLayer();
		this.doEffect();
		root.getHistory().insert(ec);
	}
	
	public abstract void doEffect();
	@Override
	public String toString() {
		return "Effect";
	}
}