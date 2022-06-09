package com.editor.window;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.file.*;
import com.editor.window.edit.*;
import com.editor.window.tools.*;
import com.editor.window.effects.*;
import com.editor.window.image.*;
import com.editor.window.themes.*;
import com.editor.window.windows.*;
import com.editor.window.help.*;

public class MainBar
extends JMenuBar {
	public MainBar(EditorRuntime root) {
		super();
		add(new MenuFile(root));
		add(new MenuEdit(root));
		add(new MenuTools(root));
		add(new MenuEffects(root));
		add(new MenuImage(root));
		add(new MenuTheme(root));
		add(new MenuWindows(root));
		add(new MenuHelp(root));
	}
}
