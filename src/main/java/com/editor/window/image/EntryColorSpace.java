package com.editor.window.image;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.formdev.flatlaf.icons.*;
import java.awt.image.BufferedImage;

public class EntryColorSpace
extends Entry {
	public EntryColorSpace(EditorRuntime root) {
		super(root, "Set color space");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				root.getWindow().getWorkspace().getImage().setChannels(
					BufferedImage.TYPE_3BYTE_BGR);
				} catch (Exception ex) {
					System.out.println("Failed");
				}
			}
		});
	}
}