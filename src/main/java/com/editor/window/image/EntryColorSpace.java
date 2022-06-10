package com.editor.window.image;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.image.*;
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
				Image image = root.getWindow().getWorkspace().getImage();
				if (image == null)
					return;
				DialogBox db = new DialogBox(root.getWindow(), "Set dimension",
					DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				String[] labels = {"Mono Channel", "RGB", "RGBA"};
				InteractiveRadio ir = new InteractiveRadio(labels);
				switch (image.getChannels()) {
					case BufferedImage.TYPE_BYTE_GRAY:
						ir.setSelected(0);
						break;
					case BufferedImage.TYPE_3BYTE_BGR:
						ir.setSelected(1);
						break;
					case BufferedImage.TYPE_4BYTE_ABGR:
						ir.setSelected(2);
						break;
				}
				db.addApplet(ir);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						try {
							System.out.println(ir.getValue());
							switch (ir.getValue()) {
								case 0:
									image.setChannels(BufferedImage.TYPE_BYTE_GRAY);
								case 1:
									image.setChannels(BufferedImage.TYPE_3BYTE_BGR);
								case 2:
									image.setChannels(BufferedImage.TYPE_4BYTE_ABGR);
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(root.getWindow(), ex.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				
			}
		});
	}
}