package com.editor.window.tools;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.tools.*;
import com.editor.window.*;

public class EntryShift
extends Entry {
	public EntryShift(EditorRuntime root) {
		super(root, "Shift");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getSettings().changeTool(new Shift(root));
			}
		});
	}
}