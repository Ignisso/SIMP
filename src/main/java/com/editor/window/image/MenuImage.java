package com.editor.window.image;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuImage
extends JMenu {
	public MenuImage(EditorRuntime root) {
		super("Image");
		this.add(new EntryDimension(root));
		this.add(new EntryColorSpace(root));
		this.add(new EntryRotate(root));
	}
}