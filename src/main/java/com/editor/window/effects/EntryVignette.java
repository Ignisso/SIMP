package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryVignette
		extends Entry {
	public EntryVignette(EditorRuntime root) {
		super(root, "Vignette");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Effect effect = new Vignette(root);
				//if (effect.isActiveLayer()) {
				//	effect.doEffect();
				//}
			}
		});
	}
}