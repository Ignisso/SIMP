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
		Image image = root.getWindow().getWorkspace().getImage();
		if (image == null)
			return;
		
		Thread t = new Thread() {
			public void run() {
				Point beg = image.getMousePosition(true);
				Integer lxp = image.getXpos();
				Integer lyp = image.getYpos();
				Point end = null;
				while (make) {
					end = image.getMousePosition(true);
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