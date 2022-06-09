package com.editor.window.windows;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuWindows
extends JMenu {
	public MenuWindows(EditorRuntime root) {
		super("Windows");
		this.add(new EntryToolbox(root));
		this.add(new EntryLayers(root));
	}
}