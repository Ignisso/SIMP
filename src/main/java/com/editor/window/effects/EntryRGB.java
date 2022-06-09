package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryRGB
        extends Entry {
    public EntryRGB(EditorRuntime root) {
        super(root, "RGB");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogBox db = new DialogBox(root.getWindow(), "Effect RGB",
                        DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
                InteractiveSlider r = new InteractiveSlider("Red", 0, 255);
                InteractiveSlider g = new InteractiveSlider("Green:", 0, 255);
                InteractiveSlider b = new InteractiveSlider("Blue:", 0, 255);
                db.addApplet(r);
                db.addApplet(g);
                db.addApplet(b);
                db.finish();
                db.doApply(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        db.close();
                        Effect effect = new RGB(root, r.getValue(), g.getValue(),
                                b.getValue());
                        if (effect.isActiveLayer()) {
                            effect.doEffect();
                        }
                    }
                });
            }
        });
    }
}