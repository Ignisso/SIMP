package com.editor.tools;

import com.editor.core.*;
import com.editor.image.*;
import java.awt.event.*;
import java.awt.Point;

public class Zoom
extends Tool {
	public Zoom(EditorRuntime root) {
		super(root);
	}
	
	public void mousePressed(MouseEvent e) {
		Point p = root.getWindow().getWorkspace().getImage().getMousePosition(true);
		int x = (int)p.getX();
		int y = (int)p.getY();
		if (e.getButton() == MouseEvent.BUTTON1)
			root.getWindow().getWorkspace().getImage().zoomIn(x, y);
		else if (e.getButton() == MouseEvent.BUTTON3)
			root.getWindow().getWorkspace().getImage().zoomOut(x, y);
	}
}