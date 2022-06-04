package com.editor.window.tools;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.tools.*;
import com.editor.window.*;

public class EntryZoom
extends EntryRadio {
	public EntryZoom(EditorRuntime root) {
		super(root, "Zoom", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getSettings().changeTool(new Zoom(root));
			}
		});
	}
}