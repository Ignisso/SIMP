package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryInversion
		extends Entry {
	public EntryInversion(EditorRuntime root) {
		super(root, "Inversion");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Effect effect = new Inversion(root);
				if (effect.isActiveLayer())
					effect.doEffect();
			}
		});
	}
}