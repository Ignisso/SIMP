package com.editor.window.themes;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.*;

public class EntryIntelliJ
extends EntryRadio {
	public EntryIntelliJ(EditorRuntime root) {
		super(root, "FlatLaf IntelliJ", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getWindow().setTheme(new FlatIntelliJLaf(), 0xDDDDDD);
			}
		});
	}
}