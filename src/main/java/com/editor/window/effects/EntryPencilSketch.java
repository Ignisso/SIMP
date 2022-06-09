package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryPencilSketch
        extends Entry {
    public EntryPencilSketch(EditorRuntime root) {
        super(root, "Pencil Sketch");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Effect effect = new PencilSketch(root);
                if (effect.isActiveLayer())
                    effect.process();
            }
        });
    }
}