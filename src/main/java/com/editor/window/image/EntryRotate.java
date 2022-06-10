package com.editor.window.image;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.tools.*;
import com.editor.window.assets.*;
import com.formdev.flatlaf.icons.*;
import java.awt.image.BufferedImage;

public class EntryRotate
extends Entry {
	public EntryRotate(EditorRuntime root) {
		super(root, "Rotate Image");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBox db = new DialogBox(root.getWindow(), "Rotate Image",
					DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				String[] labels = {"90", "180", "270"};
				InteractiveRadio ir = new InteractiveRadio(labels);
				db.addApplet(ir);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						Rotate t = new Rotate(root);
						try {
							switch(ir.getValue()) {
								case 0:
									t.rotation90();
									break;
								case 1:
									t.rotation180();
									break;
								case 2:
									t.rotation270();
									break;
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(root.getWindow(),
								ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				
			}
		});
	}
}