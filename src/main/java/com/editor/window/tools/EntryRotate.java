package com.editor.window.tools;


import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.tools.Rotate;
import com.editor.tools.Tool;
import com.editor.window.*;
import com.editor.window.assets.*;
import com.formdev.flatlaf.icons.*;
import java.awt.image.BufferedImage;

public class EntryRotate
        extends Entry {
    public EntryRotate(EditorRuntime root) {
        super(root, "Rotate Image");
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DialogBox db = new DialogBox(root.getWindow(), "Rotate Image",
                        DialogBox.MB_APPLY | DialogBox.MB_CANCEL);
                String[] labels = {"90", "180", "270"};
                InteractiveRadio ir = new InteractiveRadio(labels);
                db.addApplet(ir);
                db.finish();
                db.doApply(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        db.close();
                        try {
                            switch(ir.getValue()) {
                                case 0:
                                    // Rotate by 90
                                    Tool tool = new Rotate(root); //?
                                case 1:
                                    // Rotate by 180
                                case 2:
                                    // Rotate by 270
                                default:
                                    // Rotate by 0
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(root.getWindow(), ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

            }
        });
    }
}
