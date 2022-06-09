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
		Workspace workspace = root.getWindow().getWorkspace();
		Image image = workspace.getImage();
		if (image == null)
			return;
		Point p = workspace.getMousePosition(true);
		if (p == null)
			return;
		int x = (int)p.getX();
		int y = (int)p.getY();
		if (e.getButton() == MouseEvent.BUTTON1)
			image.zoomIn(x, y);
		else if (e.getButton() == MouseEvent.BUTTON3)
			image.zoomOut(x, y);
	}
}