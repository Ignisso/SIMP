package com.editor.window.tools;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.tools.*;
import com.editor.window.*;

public class EntryPen
extends EntryRadio {
	public EntryPen(EditorRuntime root) {
		super(root, "Pen", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getSettings().changeTool(new Pen(root));
			}
		});
	}
}