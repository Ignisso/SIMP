package com.editor.window.edit;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;

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