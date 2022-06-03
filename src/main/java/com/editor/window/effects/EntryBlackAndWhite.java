package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryBlackAndWhite
extends Entry {
    public EntryBlackAndWhite(EditorRuntime root) {
        super(root, "BlackAndWhite");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Effect effect = new BlackAndWhite(root, 5);
				if (effect.isActiveLayer())
					effect.doEffect();
            }
        });
    }
}
