package com.editor.tools;

import com.editor.core.*;
import com.editor.history.*;
import java.awt.event.*;

public abstract class Tool
implements MouseListener {
	protected EditorRuntime root;
	protected Command       command;
	
	public Tool(EditorRuntime root) {
		this.root = root;
		root.getWindow().addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	protected void createHistoryEntry() {
		this.command = new EditImageCommand(root.getWindow().getWorkspace(),
			this.toString());
		this.command.restore();
	}
	
	protected void addToHistory() {
		this.root.getHistory().insert(this.command);
	}
	
	@Override
	public String toString() {
		return "Tool";
	}
}