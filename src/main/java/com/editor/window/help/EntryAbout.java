package com.editor.window.help;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.icons.*;

public class EntryAbout
extends Entry {
	public EntryAbout(EditorRuntime root) {
		super(root, "About");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(root.getWindow(),
				"SIMP - Simple Image Modifying Program\n\nAuthors:\n" +
				"Mateusz Jurczak\nMikolaj Matuszewski\nJulia Parobczy",
				"About SIMP",JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}