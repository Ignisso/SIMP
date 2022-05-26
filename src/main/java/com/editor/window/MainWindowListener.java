package com.editor.window;

import javax.swing.*;
import com.editor.image.*;
import com.editor.core.*;
import java.awt.event.*;

public class MainWindowListener
implements ComponentListener {
	private Workspace workspace;
	
	public MainWindowListener(Workspace workspace) {
		this.workspace = workspace;
	}
	
	public void componentHidden(ComponentEvent e) {
		this.workspace.update();
	}
	
	public void componentMoved(ComponentEvent e) {
		this.workspace.update();
	}
	
	public void componentResized(ComponentEvent e) {
		this.workspace.update();
	}
	
	public void componentShown(ComponentEvent e) {
		this.workspace.update();
	}
}