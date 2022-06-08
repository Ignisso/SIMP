package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntrySepia
        extends Entry {
    public EntrySepia(EditorRuntime root) {
        super(root, "Sepia");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Effect effect = new Sepia(root);
                if (effect.isActiveLayer())
                    effect.doEffect();
            }
        });
    }
}
