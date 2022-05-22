package com.editor.window;

import javax.swing.*;
import com.editor.image.*;
import com.editor.core.*;

public class MainWindow
extends Window {
	Workspace workspace;
	
	public MainWindow(EditorRuntime root) {
		super(root, "Image Editor", 1200, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.workspace = new Workspace(this);
		this.setJMenuBar(new MainBar(root));
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
	}
	
	public Workspace getWorkspace() {
		return this.workspace;
	}
}