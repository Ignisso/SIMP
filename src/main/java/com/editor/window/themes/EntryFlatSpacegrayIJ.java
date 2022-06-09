package com.editor.window.themes;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;

public class EntryFlatSpacegrayIJ
extends EntryRadio {
	public EntryFlatSpacegrayIJ(EditorRuntime root) {
		super(root, "FlatSpacegrayIJ", false);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root.getWindow().setTheme(new FlatSpacegrayIJTheme(), 0xDDDDDD);
			}
		});
	}
}