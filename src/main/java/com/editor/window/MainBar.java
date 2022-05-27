package com.editor.window;

import javax.swing.*;
import com.editor.core.*;

public class MainBar
extends JMenuBar {
	public MainBar(EditorRuntime root) {
		super();
		add(new MenuFile(root));
		add(new MenuEdit(root));
		//add(new MenuTools(root));
		//add(new MenuEffects(root));
		//add(new MenuView(root));
		//add(new MenuHelp(root));
	}
}
