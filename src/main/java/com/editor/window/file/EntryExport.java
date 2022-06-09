package com.editor.window.file;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.icons.*;

public class EntryExport
extends Entry {
	public EntryExport(EditorRuntime root) {
		super(root, "Export", new FlatFileViewFloppyDriveIcon());
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// action
			}
		});
	}
}