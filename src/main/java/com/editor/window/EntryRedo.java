package com.editor.window;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;

public class EntryRedo
extends Entry {
	public EntryRedo(EditorRuntime root) {
		super(root, "Redo");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this.history.redo()
			}
		});
	}
}
