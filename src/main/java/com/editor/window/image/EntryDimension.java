package com.editor.window.image;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.icons.*;

public class EntryDimension
extends Entry {
	public EntryDimension(EditorRuntime root) {
		super(root, "Set dimension");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getWindow().getWorkspace().getImage().setDimension(1000, 1000);
			}
		});
	}
}