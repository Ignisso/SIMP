package com.editor.window.effects;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuEffects
extends JMenu {
	public MenuEffects(EditorRuntime root) {
		super("Effects");
		this.add(new EntryBlackout(root));
	}
}