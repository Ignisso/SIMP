package com.editor.image;

import com.editor.window.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Workspace {
	private Image      image;
	private MainWindow window;
	
	public Workspace(MainWindow window) {
		this.window = window;
		this.image  = new Image(window);
		this.window.add(this.image);
		this.window.validate();
		this.window.repaint();
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
		
		this.window.remove(this.image);
		this.image = new Image(this.window);
		this.image.addLayer(bi);
		this.window.add(this.image);
		this.window.validate();
		this.window.repaint();
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public MainWindow getWindow() {
		return this.window;
	}
	
	public void update() {
		this.image.update();
		this.window.validate();
		this.window.repaint();
	}
}
