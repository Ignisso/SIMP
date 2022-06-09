package com.editor.window.file;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuFile
extends JMenu {
	public MenuFile(EditorRuntime root) {
		super("File");
		this.add(new EntryNew(root));
		this.add(new EntryOpen(root));
		this.addSeparator();
		this.add(new EntrySave(root));
		this.add(new EntrySaveAs(root));
		this.addSeparator();
		this.add(new EntryExport(root));
		this.add(new EntryExportAs(root));
		this.addSeparator();
		this.add(new EntryExit(root));
	}
}