package com.editor.window.file;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.icons.*;

public class EntryExit
extends Entry {
	public EntryExit(EditorRuntime root) {
		super(root, "Exit", new FlatClearIcon());
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}