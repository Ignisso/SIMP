package com.editor.core;

import com.editor.tools.*;

public class Settings {
	RGBA color1st;
	RGBA color2nd;
	Tool activeTool;
	
	public Settings() {
		this.color1st   = new RGBA(0x00000000);
		this.color2nd   = new RGBA(0xFFFFFF00);
		this.activeTool = new Pen(this);
	}
	
	public void changeTool(Tool tool) {
		this.activeTool = tool;
	}
	
	public void setColor1st(Integer rgb) {
		this.color1st = new RGBA(rgb);
	}
	
	public void setColor2nd(Integer rgb) {
		this.color2nd = new RGBA(rgb);
	}
}