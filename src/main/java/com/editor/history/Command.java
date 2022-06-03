package com.editor.history;

import com.editor.image.*;

public abstract class Command {
	protected String    name;
	protected Workspace workspace;
	
	public Command(Workspace workspace, String name) {
		this.name      = name;
		this.workspace = workspace;
	}
	public abstract void restore();
	
	@Override
	public String toString() {
		return name;
	}
}
