package com.editor.window;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import java.io.File;

public class EntryOpen
extends Entry {
	public EntryOpen(EditorRuntime root) {
		super(root, "Open");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser open = new JFileChooser();
				open.showOpenDialog(null);
				File selected = open.getSelectedFile();
				if (selected != null)
					root.getWindow().getWorkspace().loadNewImage(selected);
			}
		});
	}
}