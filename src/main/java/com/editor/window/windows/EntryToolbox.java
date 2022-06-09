package com.editor.window.windows;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.icons.*;

public class EntryToolbox
extends EntryCheckBox {
	public EntryToolbox(EditorRuntime root) {
		super(root, "Toolbox");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
	}
}