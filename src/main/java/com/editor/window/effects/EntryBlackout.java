package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;
import com.editor.history.*;

public class EntryBlackout
extends Entry {
	public EntryBlackout(EditorRuntime root) {
		super(root, "Blackout");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Layer l = root.getWindow().getWorkspace().getImage().getActiveLayer();
				if (l != null) {
					new Blackout(l);
					Command ec = new EditImageCommand(
						root.getWindow().getWorkspace(), "Blackout");
					root.getHistory().insert(ec);
				}
			}
		});
	}
}