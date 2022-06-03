package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;
import com.editor.history.*;

public class EntryGaussianBlur
extends Entry {
	public EntryGaussianBlur(EditorRuntime root) {
		super(root, "GaussianBlur");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GaussianBlur(root);
			}
		});
	}
}
