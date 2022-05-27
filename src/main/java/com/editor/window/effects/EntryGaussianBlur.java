package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryGaussianBlur
extends Entry {
	public EntryGaussianBlur(EditorRuntime root) {
		super(root, "GaussianBlur");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Layer l = root.getWindow().getWorkspace().getImage().getActiveLayer();
				if (l != null)
					new GaussianBlur(l).doEffect();
			}
		});
	}
}