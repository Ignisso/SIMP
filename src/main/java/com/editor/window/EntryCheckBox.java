package com.editor.window;

import javax.swing.*;
import java.awt.event.*;
import com.editor.core.*;

public class EntryCheckBox
extends JCheckBoxMenuItem {
	protected EditorRuntime root;
	
	public EntryCheckBox(EditorRuntime root, String name, boolean checked) {
		super(name, checked);
		this.root = root;
	}
	
	public EntryCheckBox(EditorRuntime root, String name, boolean checked, Icon icon) {
		super(name, icon, checked);
		this.root = root;
	}
}