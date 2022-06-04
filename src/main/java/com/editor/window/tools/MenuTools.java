package com.editor.window.tools;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuTools
extends JMenu {
	public MenuTools(EditorRuntime root) {
		super("Tools");
		ButtonGroup group = new ButtonGroup();
		EntryRadio e1 = new EntryShift(root);
		this.add(e1);
		group.add(e1);
		EntryRadio e2 = new EntryZoom(root);
		this.add(e2);
		group.add(e2);
		EntryRadio e3 = new EntryLayerShift(root);
		this.add(e3);
		group.add(e3);
		EntryRadio e4 = new EntryPipette(root);
		this.add(e4);
		group.add(e4);
	}
}