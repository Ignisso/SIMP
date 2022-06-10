package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;
import com.editor.window.assets.InteractiveSlider;

public class EntrySharpness
        extends Entry {
    public EntrySharpness(EditorRuntime root) {
        super(root, "Sharpness");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogBox db = new DialogBox(root.getWindow(), "Effect Sharpness",
                        DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
                InteractiveSlider is = new InteractiveSlider("Strength:", 1, 15);
                db.addApplet(is);
                db.finish();
                db.doApply(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        db.close();
                        Effect effect = new Sharpness(root, is.getValue());
                        if (effect.isActiveLayer()) {
                            effect.doEffect();
                        }
                    }
                });
            }
        });
    }
}