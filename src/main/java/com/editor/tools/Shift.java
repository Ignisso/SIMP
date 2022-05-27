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
		Layer layer = root.getWindow().getWorkspace().getImage().getActiveLayer();
		if (layer == null)
			return;
		if (!layer.getVisibility())
			return;
		
		Thread t = new Thread() {
			public void run() {
				Point beg = root.getWindow().getWorkspace().getImage().getMousePosition(true);
				Integer lxp = layer.getXpos();
				Integer lyp = layer.getYpos();
				Point end = null;
				while (make) {
					end = root.getWindow().getWorkspace().getImage().getMousePosition(true);
					try {
						Thread.sleep(20);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					if (end != null)
						layer.setPosition((int)(end.getX() - beg.getX() + lxp),
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