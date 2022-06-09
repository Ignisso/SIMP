package com.editor.window.themes;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;

public class EntryDarcula
extends EntryRadio {
	public EntryDarcula(EditorRuntime root) {
		super(root, "FlatLaf Darcula", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getWindow().setTheme(new FlatDarculaLaf(), 0x2E2E32);
			}
		});
	}
}