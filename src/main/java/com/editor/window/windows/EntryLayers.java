package com.editor.window.windows;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.icons.*;

public class EntryLayers
extends EntryCheckBox {
	public EntryLayers(EditorRuntime root) {
		super(root, "Layers");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
	}
}