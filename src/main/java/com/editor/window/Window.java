package com.editor.window;

import javax.swing.*;
import com.editor.image.*;
import com.editor.core.*;

public abstract class Window
extends JFrame {
	public Window(EditorRuntime root, String title, int width, int height) {
		super(title);
		this.setSize(width, height);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void wDisplay() {
		this.setVisible(true);
	}
	
	public void wHide() {
		this.setVisible(false);
	}
}