package com.editor.effects;

import com.editor.core.*;
import com.editor.history.*;
import com.editor.image.*;

public abstract class Effect {
	protected EditorRuntime root;
	protected Layer         active;
	protected Command       command;
	
	public Effect(EditorRuntime root) {
		this.root = root;
		this.command = new EditImageCommand(root.getWindow().getWorkspace(),
			this.toString());
		this.command.restore();
		this.active = root.getWindow().getWorkspace().getImage().getActiveLayer();
	}
	
	public abstract void doEffect();
	
	public void addToHistory() {
		this.root.getHistory().insert(this.command);
	}
	
	public boolean isActiveLayer() {
		if (this.active == null)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Effect";
	}
}