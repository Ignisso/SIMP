package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;
import com.editor.window.assets.InteractiveSlider;

public class EntryAverageBlur
        extends Entry {
    public EntryAverageBlur(EditorRuntime root) {
        super(root, "Average Blur");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogBox db = new DialogBox(root.getWindow(), "Effect Average Blur",
                        DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
                InteractiveSlider is = new InteractiveSlider("Strength:", 1, 200);
                db.addApplet(is);
                db.finish();
                db.doApply(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        db.close();
                        Effect effect = new AverageBlur(root, is.getValue());
                        if (effect.isActiveLayer()) {
                            effect.doEffect();
                        }
                    }
                });
            }
        });
    }
}