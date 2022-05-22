package com.editor.window;

import javax.swing.*;
import com.editor.core.*;

public class MenuFile
extends JMenu {
	public MenuFile(EditorRuntime root) {
		super("File");
		this.add(new EntryNew(root));
		this.add(new EntryOpen(root));
		this.add(new EntrySave(root));
		this.add(new EntrySaveAs(root));
		this.add(new EntryExit(root));
	}
}