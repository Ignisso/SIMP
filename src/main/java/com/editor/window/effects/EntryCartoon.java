package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryCartoon
extends Entry {
	public EntryCartoon(EditorRuntime root) {
		super(root, "Cartoon");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBox db = new DialogBox(root.getWindow(), "Effect Cartoon",
					DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
				InteractiveSlider ls = new InteractiveSlider("Line Size:", 1, 30);
				InteractiveSlider lb = new InteractiveSlider("Line Blur:", 3, 19);
				InteractiveSlider ib = new InteractiveSlider("Image Blur:", 3, 19);
				InteractiveSlider d  = new InteractiveSlider("Diameter:", 1, 50);
				InteractiveSlider r  = new InteractiveSlider("Radius:", 1, 100);
				db.addApplet(ls);
				db.addApplet(lb);
				db.addApplet(ib);
				db.addApplet(d);
				db.addApplet(r);
				db.finish();
				db.doApply(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						db.close();
						Effect effect = new Cartoon(root, ls.getValue(), lb.getValue(),
							ib.getValue(), d.getValue(), r.getValue());
						if (effect.isActiveLayer()) {
							effect.doEffect();
						}
					}
				});
			}
		});
	}
}