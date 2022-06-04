package com.editor.window.tools;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.tools.*;
import com.editor.window.*;

public class EntryPipette
extends EntryRadio {
	public EntryPipette(EditorRuntime root) {
		super(root, "Pipette", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getSettings().changeTool(new Pipette(root));
			}
		});
	}
}