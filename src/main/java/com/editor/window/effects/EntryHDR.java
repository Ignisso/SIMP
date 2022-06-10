package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryHDR
		extends Entry {
	public EntryHDR(EditorRuntime root) {
		super(root, "HDR");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Effect effect = new HDR(root);
				if (effect.isActiveLayer())
					effect.doEffect();
			}
		});
	}
}