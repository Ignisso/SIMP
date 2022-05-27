package com.editor.window.effects;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuEffects
extends JMenu {
	public MenuEffects(EditorRuntime root) {
		super("Effects");
		this.add(new EntryBlackout(root));
		this.add(new EntryBrightness(root));
		this.add(new EntryTint(root));
		this.add(new EntryTemperature(root));
		this.add(new EntryGaussianBlur(root));
	}
}