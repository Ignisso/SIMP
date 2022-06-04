package com.editor.window.themes;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.*;

public class EntryLight
extends EntryRadio {
	public EntryLight(EditorRuntime root) {
		super(root, "FlatLaf Light", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getWindow().setTheme(new FlatLightLaf(), 0xDDDDDD);
			}
		});
	}
}