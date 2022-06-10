package com.editor.window.file;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.image.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.formdev.flatlaf.icons.*;

public class EntryNew
extends Entry {
	public EntryNew(EditorRuntime root) {
		super(root, "New", new FlatTreeLeafIcon());
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image image = new Image(root.getWindow());
				root.getWindow().getWorkspace().setImage(image);
				if (image == null)
					return;
				DialogBox db = new DialogBox(root.getWindow(), "New project",
					DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				String[] labels = {"width", "height"};
				int[] initValues = new int[2];
				initValues[0] = 640;
				initValues[1] = 640;
				InteractiveInput ii = new InteractiveInput(labels, 1, 2048, 1, initValues);
				db.addApplet(ii);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						image.setDimension(ii.getValue(0), ii.getValue(1));
						image.setPosition(root.getWindow().getWidth() / 2 - ii.getValue(0) / 2, root.getWindow().getHeight() / 2 - ii.getValue(1) / 2);
					}
				});
			}
		});
	}
}