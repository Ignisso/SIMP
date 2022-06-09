package com.editor.tools;

import com.editor.core.*;
import com.editor.image.*;
import java.awt.event.*;
import java.awt.Point;

public class Pen
extends Tool {
	private boolean make;
	private int color;
	
	public Pen(EditorRuntime root) {
		super(root);
		this.make = false;
		this.color = 0xFFFF0000;
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
		
		Thread draw = new Thread() {
			public void run() {
				Point old = null;
				while (make) {
					try {
						Thread.sleep(1);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					Point now = layer.getMousePosition(true);

					if (now != null && old == null) {
						layer.setRGB((int) (now.getX() / img.getScale()), (int)(now.getY() / img.getScale()), color);
					} else if (now != null && old != null) {

						int d = 0;
				 
				        int dx = (int) (Math.abs(old.getX() - now.getX()));
				        int dy = (int) (Math.abs(old.getY() - now.getY()));
				 
				        int dx2 = 2 * dx;
				        int dy2 = 2 * dy;
				 
				        int ix = now.getX() < old.getX() ? 1 : -1;
				        int iy = now.getY() < old.getY() ? 1 : -1;
				 
				        int x = (int) now.getX();
				        int y = (int) now.getY();
				 
				        if (dx >= dy) {
				            while (true) {
				                layer.setRGB((int) (x / img.getScale()), (int)(y / img.getScale()), color);
				                if (x == old.getX())
				                    break;
				                x += ix;
				                d += dy2;
				                if (d > dx) {
				                    y += iy;
				                    d -= dx2;
				                }
				            }
				        } else {
				            while (true) {
				           		layer.setRGB((int) (x / img.getScale()), (int)(y / img.getScale()), color);
				                if (y == old.getY())
				                    break;
				                y += iy;
				                d += dx2;
				                if (d > dy) {
				                    x += ix;
				                    d -= dy2;
				                }
				            }
				        }
				    }
					old = now;
				}
			}
		};
		Thread update = new Thread() {
			public void run() {
				while (make) {
					try {
						Thread.sleep(30);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					layer.update();
				}
			}
		};
		draw.start();
		update.start();
	}
	
	public void mouseReleased(MouseEvent e) {
		this.make = false;
	}
}