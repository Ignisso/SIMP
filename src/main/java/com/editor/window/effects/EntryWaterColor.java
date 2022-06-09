package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryWaterColor
        extends Entry {
    public EntryWaterColor(EditorRuntime root) {
        super(root, "Water Color");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Effect effect = new WaterColor(root);
                if (effect.isActiveLayer())
                    effect.doEffect();
            }
        });
    }
}
