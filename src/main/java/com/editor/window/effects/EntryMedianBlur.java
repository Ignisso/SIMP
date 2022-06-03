package com.editor.window.effects;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.window.*;
import com.editor.image.*;
import com.editor.effects.*;

public class EntryMedianBlur extends Entry {
    public EntryMedianBlur(EditorRuntime root) {
        super(root, "MedianBlur");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Effect effect = new MedianBlur(root);
				if (effect.isActiveLayer())
					effect.doEffect();
			}
        });
    }
}
