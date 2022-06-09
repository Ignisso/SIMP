package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryVignette
        extends Entry {
    public EntryVignette(EditorRuntime root) {
        super(root, "Sepia");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogBox db = new DialogBox(root.getWindow(), "Effect Vignette",
                        DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
                db.finish();
                db.doApply(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        db.close();
                        Effect effect = new Vignette(root);
                        if (effect.isActiveLayer()) {
                            effect.doEffect();
                        }
                    }
                });
            }
        });
    }
}