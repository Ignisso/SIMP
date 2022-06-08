package com.editor.window.effects;

import javax.swing.*;
import com.editor.core.*;
import com.editor.effects.*;
import com.editor.window.*;

public class MenuEffects
extends JMenu {
	public MenuEffects(EditorRuntime root) {
		super("Effects");
		this.add(new EntryBlackAndWhite(root));
		this.add(new EntryBlackout(root));
		this.add(new EntryBrightness(root));
		this.add(new EntryCartoon(root));
		this.add(new EntryChalkSketch(root));
		this.add(new EntryContrast(root));
		this.add(new EntryCrayonSketch(root));
		this.add(new EntryDamager(root));
		this.add(new EntryGaussianBlur(root));
		this.add(new EntryMedianBlur(root));
		this.add(new EntryNegative(root));
		this.add(new EntryPencilSketch(root));
		this.add(new EntrySepia(root));
		this.add(new EntryTemperature(root));
		this.add(new EntryTint(root));
		this.add(new EntryWaterColor(root));

	}
}
