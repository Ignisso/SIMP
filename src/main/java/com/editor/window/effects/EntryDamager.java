package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryDamager
        extends Entry {
    public EntryDamager(EditorRuntime root) {
        super(root, "Damager");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Effect effect = new Damager(root);
                if (effect.isActiveLayer())
                    effect.process();
            }
        });
    }
}
