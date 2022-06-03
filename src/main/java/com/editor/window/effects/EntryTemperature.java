package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryTemperature
extends Entry {
	public EntryTemperature(EditorRuntime root) {
		super(root, "Temperature");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Temperature(root, 10);
			}
		});
	}
}
