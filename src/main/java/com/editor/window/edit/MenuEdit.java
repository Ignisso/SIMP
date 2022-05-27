package com.editor.window.edit;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuEdit
extends JMenu {
	public MenuEdit(EditorRuntime root) {
		super("Edit");
		this.add(new EntryUndo(root));
		this.add(new EntryRedo(root));
	}
}
