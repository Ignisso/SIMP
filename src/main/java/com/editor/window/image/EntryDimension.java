package com.editor.window.image;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.image.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.formdev.flatlaf.icons.*;

public class EntryDimension
extends Entry {
	public EntryDimension(EditorRuntime root) {
		super(root, "Set dimension");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image image = root.getWindow().getWorkspace().getImage();
				if (image == null)
					return;
				DialogBox db = new DialogBox(root.getWindow(), "Set dimension",
					DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				String[] labels = {"Width", "Height"};
				int[] initValues = new int[2];
				initValues[0] = image.getAbsoluteWidth();
				initValues[1] = image.getAbsoluteHeight();
				InteractiveInput ii = new InteractiveInput(labels, 1, 2048, 1, initValues);
				db.addApplet(ii);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						image.setDimension(ii.getValue(0), ii.getValue(1));
					}
				});
			}
		});
	}
}