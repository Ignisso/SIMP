package com.editor.window;

import javax.swing.*;
import com.editor.image.*;
import com.editor.core.*;
import java.awt.Graphics;
import java.awt.Color;
import com.formdev.flatlaf.*;

public abstract class Window
extends JFrame {
	public Window(EditorRuntime root, String title, int width, int height) {
		super(title);
		this.setSize(width, height);
		this.setTheme(new FlatDarkLaf(), 0x2E2E32);
	}
	
	public void setTheme(FlatLaf theme, Integer backgroundColor) {
		try {
			UIManager.setLookAndFeel(theme);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		this.getContentPane().setBackground(new Color(backgroundColor));
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void wDisplay() {
		this.setVisible(true);
	}
	
	public void wHide() {
		this.setVisible(false);
	}
}