package com.editor.window.image;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.formdev.flatlaf.icons.*;

public class EntryDimension
extends Entry {
	public EntryDimension(EditorRuntime root) {
		super(root, "Set dimension");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBox db = new DialogBox(root.getWindow(), "Set dimension",
					DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				String[] labels = {"width", "height"};
				int[] initValues = new int[2];
				initValues[0] = root.getWindow().getWorkspace().getImage().getWidth();
				initValues[1] = root.getWindow().getWorkspace().getImage().getHeight();
				InteractiveInput ii = new InteractiveInput(labels, 1, 2048, 1, initValues);
				db.addApplet(ii);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						root.getWindow().getWorkspace().getImage().setDimension(ii.getValue(0), ii.getValue(1));
					}
				});
			}
		});
	}
}