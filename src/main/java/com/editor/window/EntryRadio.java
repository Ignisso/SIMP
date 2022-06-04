package com.editor.window;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;

public class EntryRadio
extends JRadioButtonMenuItem {
	protected EditorRuntime root;
	
	public EntryRadio(EditorRuntime root, String name, boolean selected) {
		super(name, selected);
		this.root = root;
	}
	
	public EntryRadio(EditorRuntime root, String name, boolean selected, Icon icon) {
		super(name, icon, selected);
		this.root = root;
	}
}