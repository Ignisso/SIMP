package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryCrayonSketch
		extends Entry {
	public EntryCrayonSketch(EditorRuntime root) {
		super(root, "Crayon Sketch");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Effect effect = new CrayonSketch(root);
				if (effect.isActiveLayer())
					effect.doEffect();
			}
		});
	}
}