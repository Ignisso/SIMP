package com.editor.window;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;

public class EntrySaveAs
extends Entry {
	public EntrySaveAs(EditorRuntime root) {
		super(root, "Save as");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// action
			}
		});
	}
}