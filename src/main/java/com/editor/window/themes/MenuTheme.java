package com.editor.window.themes;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuTheme
extends JMenu {
	public MenuTheme(EditorRuntime root) {
		super("Theme");
		ButtonGroup group = new ButtonGroup();
		EntryRadio e1 = new EntryLight(root);
		this.add(e1);
		group.add(e1);
		EntryRadio e2 = new EntryDark(root);
		this.add(e2);
		group.add(e2);
		EntryRadio e3 = new EntryIntelliJ(root);
		this.add(e3);
		group.add(e3);
		EntryRadio e4 = new EntryDarcula(root);
		this.add(e4);
		group.add(e4);
	}
}