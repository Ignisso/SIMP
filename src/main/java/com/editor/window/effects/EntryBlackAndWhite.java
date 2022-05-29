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
                Layer l = root.getWindow().getWorkspace().getImage().getActiveLayer();
                if (l != null)
                    new BlackAndWhite(l,20);
            }
        });
    }
}