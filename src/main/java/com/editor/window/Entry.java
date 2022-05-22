package com.editor.window;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;

public class Entry
extends JMenuItem {
	protected EditorRuntime root;
	
	public Entry(EditorRuntime root, String name) {
		super(name);
		this.root = root;
	}
}