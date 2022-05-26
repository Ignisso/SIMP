package com.editor.history;

import com.editor.image.Image;

public class EditImageCommand extends Command {

	Image img;
	Memento memento;

	public EditImageCommand() {
		
	}

	@Override
	public void execute() {

	}

	@Override
	public void unExecute() {
		img = memento.recallImage();
	}
}
