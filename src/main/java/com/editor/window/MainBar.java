package com.editor.window;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.file.*;
import com.editor.window.edit.*;
import com.editor.window.tools.*;
import com.editor.window.effects.*;

public class MainBar
extends JMenuBar {
	public MainBar(EditorRuntime root) {
		super();
		add(new MenuFile(root));
		add(new MenuEdit(root));
		add(new MenuTools(root));
		add(new MenuEffects(root));
		//add(new MenuView(root));
		//add(new MenuHelp(root));
	}
}
