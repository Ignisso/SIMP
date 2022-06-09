package com.editor.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.history.*;
import com.editor.image.*;
import com.editor.window.*;

public abstract class Effect {
	protected EditorRuntime root;
	protected Layer         active;
	protected Command       command;
	protected JProgressBar  progress;
	protected DialogBox     db;
	protected EffectsWorker thread;
	
	public Effect(EditorRuntime root) {
		this.root = root;
		this.command = new EditImageCommand(root.getWindow().getWorkspace(),
			this.toString());
		this.command.restore();
		this.active = root.getWindow().getWorkspace().getImage().getActiveLayer();
		this.db = new DialogBox(root.getWindow(), this.toString() + " progress...",
			DialogBox.MB_CANCEL);
		this.progress = new JProgressBar(0);
		this.progress.setMaximum(100);
		progress.setMinimum(0);
		progress.setStringPainted(true);
		progress.setVisible(true);
		db.addApplet(this.progress);
		db.finish();
		this.thread = new EffectsWorker(this);
		db.doCancel(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.cancel(true);
			}
		});
	}
	
	public void doEffect() {
		thread.execute();
	}
	
	public void process() {
		
	}
	
	public void closeDialog() {
		this.db.close();
	}
	
	protected void setProgress(Integer progress) {
		this.progress.setValue(progress);
		System.out.println(this.progress.getValue());
		if (this.thread.isCancelled())
			throw new InterruptSignal();
	}
	
	protected void addProgress(Integer progress) {
		this.progress.setValue(this.progress.getValue() + progress);
		System.out.println(this.progress.getValue());
		if (this.thread.isCancelled())
			throw new InterruptSignal();
	}
	
	protected void addToHistory() {
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