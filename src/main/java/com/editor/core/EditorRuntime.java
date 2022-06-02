package com.editor.core;

import com.editor.history.*;
import com.editor.window.*;

public class EditorRuntime {
	private History    history;
	private Settings   settings;
	private MainWindow mainWindow;
	
	public EditorRuntime() {
		this.history    = new History();
		this.mainWindow = new MainWindow(this);
		this.settings   = new Settings(this);
	}
	
	public void launch() {
		this.mainWindow.wDisplay();
		//...
	}
	
	public Settings getSettings() {
		return this.settings;
	}
	
	public History getHistory() {
		return this.history;
	}
	
	public MainWindow getWindow() {
		return this.mainWindow;
	}
	
	public static void main(String[] args) {
		EditorRuntime editor = new EditorRuntime();
		editor.launch();
	}
}