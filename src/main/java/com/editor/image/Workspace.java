package com.editor.image;

import com.editor.window.*;
import com.editor.core.*;
import com.editor.history.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Workspace
extends JComponent {
	private Image         image;
	private MainWindow    window;
	private EditorRuntime root;
	
	public Workspace(MainWindow window, EditorRuntime root) {
		this.root   = root;
		this.window = window;
		this.window.add(this);
		this.image  = null;
		this.update();
	}
	
	private void exportWorkspace(String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		writeObject(oos);
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeObject(this);
		oos.flush();
		oos.close();
	}

	public void loadNewImage(File image) {
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(image);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		if (this.image != null)
			this.remove(this.image);
		this.image = new Image(this.window);
		this.image.addLayer(bi);
		Command command = new EditImageCommand(this, "base");
		this.root.getHistory().insert(command);
		this.add(this.image);
		this.update();
	}
	
	public void setImage(Image img) {
		if (this.image != null)
			this.remove(this.image);
		this.image = img;
		this.add(this.image);
		this.update();
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public MainWindow getWindow() {
		return this.window;
	}
	
	public void update() {
		if (this.image != null)
			this.image.update();
		this.window.validate();
		this.window.repaint();
	}
}
