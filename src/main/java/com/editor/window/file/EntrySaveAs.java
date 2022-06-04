package com.editor.window.file;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.icons.*;

public class EntrySaveAs
extends Entry {
	public EntrySaveAs(EditorRuntime root) {
		super(root, "Save as", new FlatFileChooserUpFolderIcon());
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// action
			}
		});
	}
}