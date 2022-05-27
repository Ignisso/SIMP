package com.editor.tools;

import com.editor.core.*;
import com.editor.image.*;
import java.awt.event.*;
import java.awt.Point;

public class LayerShift
extends Tool {
	private boolean make;
	
	public LayerShift(EditorRuntime root) {
		super(root);
	}
	
	public void mousePressed(MouseEvent e) {
		this.make = true;
		Image img = root.getWindow().getWorkspace().getImage();
		if (img == null)
			return;
		Layer layer = img.getActiveLayer();
		if (layer == null)
			return;
		if (!layer.isVisible())
			return;
		
		Thread t = new Thread() {
			public void run() {
				Point beg = img.getMousePosition(true);
				Integer lxp = layer.getXpos();
				Integer lyp = layer.getYpos();
				Point end = null;
				while (make) {
					end = img.getMousePosition(true);
					try {
						Thread.sleep(20);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					if (end != null)
						layer.setPosition((int)((end.getX() - beg.getX()) / img.getScale() + lxp),
							(int)((end.getY() - beg.getY()) / img.getScale() + lyp));
				}
			}
		};
		t.start();
	}
	
	public void mouseReleased(MouseEvent e) {
		this.make = false;
	}
}