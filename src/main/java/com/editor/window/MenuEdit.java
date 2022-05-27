package com.editor.window;

import javax.swing.*;
import com.editor.core.*;

public class MenuEdit
extends JMenu {
	public MenuEdit(EditorRuntime root) {
		super("Edit");
		this.add(new EntryUndo(root));
		this.add(new EntryRedo(root));
	}
}
