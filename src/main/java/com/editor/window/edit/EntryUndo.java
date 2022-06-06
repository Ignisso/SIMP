package com.editor.window.edit;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;

public class EntryUndo
extends Entry {
	public EntryUndo(EditorRuntime root) {
		super(root, "Undo");
		root.getHistory().setUndo(this);
		KeyStroke ctrlZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK);
		this.setAccelerator(ctrlZ);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getHistory().undo();
			}
		});
	}
}
