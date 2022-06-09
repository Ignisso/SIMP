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
		createHistoryEntry();
		Workspace workspace = root.getWindow().getWorkspace();
		Image image = workspace.getImage();
		if (image == null)
			return;
		Layer layer = image.getActiveLayer();
		if (layer == null)
			return;
		if (!layer.isVisible())
			return;
		
		Thread t = new Thread() {
			public void run() {
				Point beg = workspace.getMousePosition(true);
				if (beg == null)
					return;
				Integer lxp = layer.getXpos();
				Integer lyp = layer.getYpos();
				Point end = null;
				while (make) {
					end = workspace.getMousePosition(true);
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
		addToHistory();
	}
	
	@Override
	public String toString() {
		return "Layer Shift";
	}
}