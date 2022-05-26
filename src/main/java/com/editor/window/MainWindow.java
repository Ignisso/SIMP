package com.editor.window;

import javax.swing.*;
import com.editor.image.*;
import com.editor.core.*;
import java.awt.event.*;
import java.io.*;

public class MainWindow
extends Window {
	private Workspace workspace;
	
	public MainWindow(EditorRuntime root) {
		super(root, "Image Editor", 1200, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.workspace = new Workspace(this);
		this.setJMenuBar(new MainBar(root));
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		this.addComponentListener(new MainWindowListener(this.workspace));
	}
	
	public Workspace getWorkspace() {
		return this.workspace;
	}
	
	public Workspace importWorkspace(String path) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		return (Workspace) ois.readObject();
	}
}
