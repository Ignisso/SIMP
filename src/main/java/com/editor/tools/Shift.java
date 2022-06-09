package com.editor.tools;

import com.editor.core.*;
import com.editor.image.*;
import java.awt.event.*;
import java.awt.Point;

public class Shift
extends Tool {
	private boolean make;
	
	public Shift(EditorRuntime root) {
		super(root);
	}
	
	public void mousePressed(MouseEvent e) {
		this.make = true;
		Workspace workspace = root.getWindow().getWorkspace();
		Image image = workspace.getImage();
		if (image == null)
			return;
		
		Thread t = new Thread() {
			public void run() {
				Point beg = workspace.getMousePosition(true);
				if (beg == null)
					return;
				Integer lxp = image.getXpos();
				Integer lyp = image.getYpos();
				Point end = null;
				while (make) {
					end = workspace.getMousePosition(true);
					try {
						Thread.sleep(20);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					if (end != null)
						image.setPosition((int)(end.getX() - beg.getX() + lxp),
							(int)(end.getY() - beg.getY() + lyp));
				}
			}
		};
		t.start();
	}
	
	public void mouseReleased(MouseEvent e) {
		this.make = false;
	}
}