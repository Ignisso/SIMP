package com.editor.tools;

import com.editor.core.*;
import java.awt.event.*;

public abstract class Tool
implements MouseListener {
	protected EditorRuntime root;
	
	public Tool(EditorRuntime root) {
		this.root = root;
		root.getWindow().addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}