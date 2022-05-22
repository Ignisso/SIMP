package com.editor.window;

import javax.swing.*;
import com.editor.core.*;

public class MainBar
extends JMenuBar {
	public MainBar(EditorRuntime root) {
		super();
		add(new MenuFile(root));
		//this.add(new MenuEdit(this));
		//this.add(new MenuTools(this));
		//this.add(new MenuEffects(this));
		//this.add(new MenuView(this));
		//this.add(new MenuHelp(this));
	}
}