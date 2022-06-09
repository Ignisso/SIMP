package com.editor.window.image;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.formdev.flatlaf.icons.*;
import java.awt.image.BufferedImage;

public class EntryColorSpace
extends Entry {
	public EntryColorSpace(EditorRuntime root) {
		super(root, "Set color space");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBox db = new DialogBox(root.getWindow(), "Set dimension",
					DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				String[] labels = {"Mono Channel", "RGB", "RGBA"};
				InteractiveRadio ir = new InteractiveRadio(labels);
				db.addApplet(ir);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						try {
							switch(ir.getValue()) {
								case 0:
									root.getWindow().getWorkspace().getImage().setChannels(1);
								case 1:
									root.getWindow().getWorkspace().getImage().setChannels(3);
								case 2:
									root.getWindow().getWorkspace().getImage().setChannels(4);
								default:
									root.getWindow().getWorkspace().getImage().setChannels(4);
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(root.getWindow(), ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				
			}
		});
	}
}