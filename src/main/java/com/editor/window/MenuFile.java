package com.editor.window;

import javax.swing.*;

public class MenuFile
extends JMenu {
	public MenuFile() {
		super("File");
		this.add(new EntryNew());
		this.add(new EntryOpen());
		this.add(new EntrySave());
		this.add(new EntrySaveAs());
		this.add(new EntryExit());
	}
}