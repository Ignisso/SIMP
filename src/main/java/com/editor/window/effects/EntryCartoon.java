package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryCartoon
        extends Entry {
    public EntryCartoon(EditorRuntime root) {
        super(root, "Cartoon");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Effect effect = new Cartoon(root);
                if (effect.isActiveLayer())
                    effect.doEffect();
            }
        });
    }
}