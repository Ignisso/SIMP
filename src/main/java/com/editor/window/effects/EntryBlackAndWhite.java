package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryBlackAndWhite
        extends Entry {
    public EntryBlackAndWhite(EditorRuntime root) {
        super(root, "Black and White");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogBox db = new DialogBox(root.getWindow(), "Effect Black and White",
                        DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
                InteractiveSlider is = new InteractiveSlider("Shades:", -255, 255);
                db.addApplet(is);
                db.finish();
                db.doApply(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        db.close();
                        Effect effect = new BlackAndWhite(root, is.getValue());
                        if (effect.isActiveLayer()) {
                            effect.doEffect();
                        }
                    }
                });
            }
        });
    }
}