package com.editor.history;

import com.editor.image.Image;

public abstract class Command {

	Image img;
	Memento memento;

	public abstract void execute();
	public abstract void unExecute();
}
