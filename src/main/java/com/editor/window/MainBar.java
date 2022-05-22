package com.editor.window;

import javax.swing.*;

public class MainBar
extends JMenuBar {
	public MainBar() {
		super();
		add(new MenuFile());
		//this.add(new MenuEdit(this));
		//this.add(new MenuTools(this));
		//this.add(new MenuEffects(this));
		//this.add(new MenuView(this));
		//this.add(new MenuHelp(this));
	}
}