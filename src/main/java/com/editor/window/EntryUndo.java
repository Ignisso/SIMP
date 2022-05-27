package com.editor.window;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;

public class EntryUndo
extends Entry {
	public EntryUndo(EditorRuntime root) {
		super(root, "Undo");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this.history.undo()
			}
		});
	}
}
