package com.editor.window.file;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;
import com.editor.image.*;
import com.editor.window.*;
import java.io.File;
import com.formdev.flatlaf.icons.*;

public class EntryExportAs
extends Entry {
	public EntryExportAs(EditorRuntime root) {
		super(root, "Export as", new FlatFileChooserUpFolderIcon());
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image img = root.getWindow().getWorkspace().getImage();
				if (img == null)
					return;
				JFileChooser export = new JFileChooser();
				export.setDialogType(JFileChooser.SAVE_DIALOG);
				FileFilter.addFilters(export);
				export.showSaveDialog(null);
				File output = export.getSelectedFile();
				if (output != null)
					img.exportToFile(output);
			}
		});
	}
}