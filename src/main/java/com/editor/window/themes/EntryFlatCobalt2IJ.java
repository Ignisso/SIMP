package com.editor.window.themes;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;

public class EntryFlatCobalt2IJ
extends EntryRadio {
	public EntryFlatCobalt2IJ(EditorRuntime root) {
		super(root, "FlatCobalt2IJ", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getWindow().setTheme(new FlatCobalt2IJTheme(), 0xDDDDDD);
			}
		});
	}
}