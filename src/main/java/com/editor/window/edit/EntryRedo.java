package com.editor.window.edit;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;

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
