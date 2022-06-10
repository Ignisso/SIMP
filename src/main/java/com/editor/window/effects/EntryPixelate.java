package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;
import com.editor.window.assets.InteractiveSlider;

public class EntryPixelate
        extends Entry {
    public EntryPixelate(EditorRuntime root) {
        super(root, "Pixelate");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogBox db = new DialogBox(root.getWindow(), "Effect Pixelate",
                        DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
                InteractiveSlider pixels = new InteractiveSlider("Number of Pixels", 1, 200);
                db.addApplet(pixels);
                db.finish();
                db.doApply(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        db.close();
                        Effect effect = new Pixelate(root, pixels.getValue());
                        if (effect.isActiveLayer()) {
                            effect.doEffect();
                        }
                    }
                });
            }
        });
    }
}