package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;
import com.editor.window.assets.InteractiveSlider;

public class EntryMosaic
        extends Entry {
    public EntryMosaic(EditorRuntime root) {
        super(root, "Mosaic");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogBox db = new DialogBox(root.getWindow(), "Effect Mosaic",
                        DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
                InteractiveSlider is = new InteractiveSlider("Strength:", 1, 20);
                db.addApplet(is);
                db.finish();
                db.doApply(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        db.close();
                        Effect effect = new Mosaic(root, is.getValue());
                        if (effect.isActiveLayer()) {
                            effect.doEffect();
                        }
                    }
                });
            }
        });
    }
}