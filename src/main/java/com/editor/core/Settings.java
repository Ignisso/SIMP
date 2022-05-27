package com.editor.core;

import com.editor.tools.*;

public class Settings {
	RGBA          color1st;
	RGBA          color2nd;
	Tool          activeTool;
	EditorRuntime root;
	
	public Settings(EditorRuntime root) {
		this.root       = root;
		this.color1st   = new RGBA(0x00000000);
		this.color2nd   = new RGBA(0xFFFFFF00);
		this.activeTool = new Zoom(root);
	}
	
	public void changeTool(Tool tool) {
		this.root.getWindow().removeMouseListener(this.activeTool);
		this.activeTool = tool;
	}
	
	public void setColor1st(Integer rgb) {
		this.color1st = new RGBA(rgb);
	}
	
	public void setColor2nd(Integer rgb) {
		this.color2nd = new RGBA(rgb);
	}
	
	public EditorRuntime getRoot() {
		return this.root;
	}
}