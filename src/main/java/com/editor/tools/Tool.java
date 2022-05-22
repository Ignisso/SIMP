package com.editor.tools;

import com.editor.core.*;

public abstract class Tool {
	private Settings settings;
	
	public Tool(Settings settings) {
		this.settings = settings;
	}
}