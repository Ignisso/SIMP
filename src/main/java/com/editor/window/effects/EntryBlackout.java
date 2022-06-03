package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryBlackout
extends Entry {
	public EntryBlackout(EditorRuntime root) {
		super(root, "Blackout");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Effect effect = new Blackout(root);
				if (effect.isActiveLayer())
					effect.doEffect();
			}
		});
	}
}