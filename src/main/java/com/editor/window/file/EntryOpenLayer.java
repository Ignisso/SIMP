package com.editor.window.file;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.image.*;
import com.editor.window.*;
import java.io.File;
import com.formdev.flatlaf.icons.*;

public class EntryOpenLayer
extends Entry {
	public EntryOpenLayer(EditorRuntime root) {
		super(root, "Open as layer", new FlatTreeOpenIcon());
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image image = root.getWindow().getWorkspace().getImage();
				if (image == null)
					return;
				JFileChooser open = new JFileChooser();
				open.setDialogType(JFileChooser.OPEN_DIALOG);
				FileFilter.addFilters(open);
				open.showOpenDialog(null);
				File selected = open.getSelectedFile();
				if (selected != null)
					image.addLayer(selected);
			}
		});
	}
}