package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryNegative
        extends Entry {
    public EntryNegative(EditorRuntime root) {
        super(root, "Negative");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Effect effect = new Negative(root);
                if (effect.isActiveLayer())
                    effect.doEffect();
            }
        });
    }
}