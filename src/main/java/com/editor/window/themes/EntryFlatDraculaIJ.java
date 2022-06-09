package com.editor.window.themes;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;

public class EntryFlatDraculaIJ
extends EntryRadio {
	public EntryFlatDraculaIJ(EditorRuntime root) {
		super(root, "FlatDraculaIJ", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getWindow().setTheme(new FlatDraculaIJTheme(), 0xDDDDDD);
			}
		});
	}
}