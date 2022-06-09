package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryColorGaussianBlur
		extends Entry {
	public EntryColorGaussianBlur(EditorRuntime root) {
		super(root, "ColorGaussianBlur");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBox db = new DialogBox(root.getWindow(), "Effect Color Gaussian Blur",
						DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				InteractiveSlider is = new InteractiveSlider("Strength:", 1, 10);
				db.addApplet(is);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						Effect effect = new ColorGaussianBlur(root, is.getValue());
						if (effect.isActiveLayer()) {
							effect.doEffect();
						}
					}
				});
			}
		});
	}
}