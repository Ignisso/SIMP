package com.editor.effects;

import com.editor.core.*;
import com.editor.history.*;
import com.editor.image.*;
import com.editor.window.*;
import javax.swing.JProgressBar;

public abstract class Effect {
	protected EditorRuntime root;
	protected Layer         active;
	protected Command       command;
	protected JProgressBar  progress;
	
	public Effect(EditorRuntime root) {
		this.root = root;
		this.command = new EditImageCommand(root.getWindow().getWorkspace(),
			this.toString());
		this.command.restore();
		this.active = root.getWindow().getWorkspace().getImage().getActiveLayer();
		DialogBox db = new DialogBox(root.getWindow(), this.toString() + " progress...");
		this.progress = new JProgressBar(0);
		progress.setMinimum(0);
		progress.setStringPainted(true);
		progress.setVisible(true);
		db.addApplet(this.progress);
		db.finish();
		this.progress.setSize(300, 40);
	}
	
	public abstract void doEffect();
	
	public void setMaxProgress(Integer max) {
		this.progress.setMaximum(max);
	}
	
	public void setProgress(Integer progress) {
		this.progress.setValue(progress);
		this.progress.repaint();
	}
	
	public void incrementProgress() {
		this.progress.setValue(this.progress.getValue() + 1);
		this.progress.repaint();
	}
	
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