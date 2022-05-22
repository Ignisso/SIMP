package com.editor.window;

import javax.swing.*;
import com.editor.image.*;

public class MainWindow
extends Window {
	Workspace workspace;
	
	public MainWindow() {
		super("Image Editor", 1200, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.workspace = new Workspace();
		this.setJMenuBar(new MainBar());
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
	}
}