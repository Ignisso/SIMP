package com.editor.window.help;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuHelp
extends JMenu {
	public MenuHelp(EditorRuntime root) {
		super("Help");
		this.add(new EntryAbout(root));
	}
}