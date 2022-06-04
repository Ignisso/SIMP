package com.editor.window.themes;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.*;

public class EntryDark
extends EntryRadio {
	public EntryDark(EditorRuntime root) {
		super(root, "FlatLaf Dark", true);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getWindow().setTheme(new FlatDarkLaf(), 0x2E2E32);
			}
		});
	}
}