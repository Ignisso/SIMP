package com.editor.tools;

import com.editor.core.*;
import com.editor.image.*;
import java.awt.event.*;

public class Zoom
extends Tool {
	public Zoom(EditorRuntime root) {
		super(root);
	}
	
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			root.getWindow().getWorkspace().getImage().zoomIn();
		else if (e.getButton() == MouseEvent.BUTTON3)
			root.getWindow().getWorkspace().getImage().zoomOut();
	}
}