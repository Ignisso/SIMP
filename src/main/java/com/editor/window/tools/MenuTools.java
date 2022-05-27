package com.editor.window.tools;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuTools
extends JMenu {
	public MenuTools(EditorRuntime root) {
		super("Tools");
		this.add(new EntryShift(root));
		this.add(new EntryZoom(root));
	}
}