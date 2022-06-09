package com.editor.window.file;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import java.io.File;
import com.formdev.flatlaf.icons.*;

public class EntryOpen
extends Entry {
	public EntryOpen(EditorRuntime root) {
		super(root, "Open", new FlatTreeOpenIcon());
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