package com.editor.tools;

import com.editor.core.*;
import com.editor.image.*;
import java.awt.event.*;
import java.awt.Point;

public class Pipette
extends Tool {
	private boolean make;
	
	public Pipette(EditorRuntime root) {
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
				while (make) {
					Point p = layer.getMousePosition(true);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					if (p != null)
						System.out.printf("%08X\n", layer.getAbsoluteRGB(
							(int)(p.getX() / img.getScale()), (int)(p.getY() / img.getScale())));
				}
			}
		};
		t.start();
	}
	
	public void mouseReleased(MouseEvent e) {
		this.make = false;
	}
}