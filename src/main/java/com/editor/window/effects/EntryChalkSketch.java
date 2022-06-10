package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryChalkSketch
		extends Entry {
	public EntryChalkSketch(EditorRuntime root) {
		super(root, "Chalk Sketch");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Effect effect = new ChalkSketch(root);
				if (effect.isActiveLayer())
					effect.doEffect();
			}
		});
	}
}