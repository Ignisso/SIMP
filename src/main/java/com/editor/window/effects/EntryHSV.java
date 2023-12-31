package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryHSV
		extends Entry {
	public EntryHSV(EditorRuntime root) {
		super(root, "HSV");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Effect effect = new HSV(root);
				if (effect.isActiveLayer())
					effect.doEffect();
			}
		});
	}
}