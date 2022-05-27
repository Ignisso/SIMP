package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryTint
extends Entry {
	public EntryTint(EditorRuntime root) {
		super(root, "Tint");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Layer l = root.getWindow().getWorkspace().getImage().getActiveLayer();
				if (l != null)
					new Tint(l, 10).doEffect();
			}
		});
	}
}
