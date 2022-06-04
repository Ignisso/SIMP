package com.editor.window.tools;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.tools.*;
import com.editor.window.*;

public class EntryLayerShift
extends EntryRadio {
	public EntryLayerShift(EditorRuntime root) {
		super(root, "Layer Shift", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getSettings().changeTool(new LayerShift(root));
			}
		});
	}
}