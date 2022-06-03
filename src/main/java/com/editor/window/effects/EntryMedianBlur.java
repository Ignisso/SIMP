package com.editor.window.effects;

import com.editor.core.EditorRuntime;
import com.editor.effects.MedianBlur;
import com.editor.image.Layer;
import com.editor.window.Entry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryMedianBlur extends Entry {
    public EntryMedianBlur(EditorRuntime root) {
        super(root, "MedianBlur");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MedianBlur(root);
			}
        });
    }
}
