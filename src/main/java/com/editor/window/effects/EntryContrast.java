package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryContrast
extends Entry {
    public EntryContrast(EditorRuntime root) {
        super(root, "Contrast");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Effect effect = new Contrast(root, 10);
				if (effect.isActiveLayer())
					effect.doEffect();
            }
        });
    }
}
