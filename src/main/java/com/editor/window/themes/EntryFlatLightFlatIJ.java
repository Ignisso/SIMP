package com.editor.window.themes;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;

public class EntryFlatLightFlatIJ
extends EntryRadio {
	public EntryFlatLightFlatIJ(EditorRuntime root) {
		super(root, "FlatLightFlatIJ", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getWindow().setTheme(new FlatLightFlatIJTheme(), 0xDDDDDD);
			}
		});
	}
}