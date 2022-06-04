package com.editor.window.file;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.icons.*;

public class EntryNew
extends Entry {
	public EntryNew(EditorRuntime root) {
		super(root, "New", new FlatTreeLeafIcon());
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// action
			}
		});
	}
}