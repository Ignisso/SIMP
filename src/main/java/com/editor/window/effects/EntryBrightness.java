package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryBrightness
		extends Entry {
	public EntryBrightness(EditorRuntime root) {
		super(root, "Brightness");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBox db = new DialogBox(root.getWindow(), "Effect Brightness",
						DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				InteractiveSlider is = new InteractiveSlider("Strength:", -255, 255);
				db.addApplet(is);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						Effect effect = new Brightness(root, is.getValue());
						if (effect.isActiveLayer()) {
							effect.doEffect();
						}
					}
				});
			}
		});
	}
}