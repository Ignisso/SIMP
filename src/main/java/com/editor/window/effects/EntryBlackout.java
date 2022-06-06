package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryBlackout
extends Entry {
	public EntryBlackout(EditorRuntime root) {
		super(root, "Blackout");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBox db = new DialogBox(root.getWindow(), "Effect Blackout",
					DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				InteractiveSlider is = new InteractiveSlider("Pixel Distance:", 1, 255);
				db.addApplet(is);
				JSlider js = new JSlider(1, 255);
				JTextArea text = new JTextArea(Integer.toString(js.getValue()));
				JComponent[] group = {js, text};
				db.addApplet(group);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						Effect effect = new Blackout(root, is.getValue());
						if (effect.isActiveLayer()) {
							effect.doEffect();
						}
					}
				});
			}
		});
	}
}