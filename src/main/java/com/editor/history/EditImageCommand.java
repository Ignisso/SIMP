package com.editor.history;

import com.editor.image.*;

public class EditImageCommand extends Command {
	private MementoImage memento;
	
	public EditImageCommand(Workspace workspace, String name) {
		super(workspace, name);
		this.memento = new MementoImage();
		try {
			memento.memorizeImage(workspace.getImage());
		} catch (Exception e) {
			System.err.println("Could not make an effect");
		}
	}
	
	@Override
	public void restore() {
		Image savedImage = memento.recallImage();
		savedImage.setSettings(this.workspace.getImage());
		workspace.setImage(memento.recallImage());
	}
}
