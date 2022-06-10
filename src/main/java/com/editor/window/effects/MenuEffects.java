package com.editor.window.effects;

import javax.swing.*;
import com.editor.core.*;
import com.editor.effects.*;
import com.editor.window.*;

public class MenuEffects
extends JMenu {
	public MenuEffects(EditorRuntime root) {
		super("Effects");
		this.add(new EntryAverageBlur(root));
		this.add(new EntryBlackAndWhite(root));
		this.add(new EntryBlackout(root));
		this.add(new EntryBrightness(root));
		this.add(new EntryCartoon(root));
		this.add(new EntryChalkSketch(root));
		this.add(new EntryColorGaussianBlur(root));
		this.add(new EntryContrast(root));
		this.add(new EntryCrayonSketch(root));
		this.add(new EntryDamager(root));
		this.add(new EntryGaussianBlur(root));
		this.add(new EntryHDR(root));
		//this.add(new EntryHSV(root));
		this.add(new EntryInversion(root));
		this.add(new EntryMedianBlur(root));
		this.add(new EntryMosaic(root));
		this.add(new EntryPencilSketch(root));
		this.add(new EntryPixelate(root));
		this.add(new EntryRGB(root));
		this.add(new EntrySepia(root));
		this.add(new EntrySharpness(root));
		this.add(new EntryTemperature(root));
		this.add(new EntryTint(root));
		//this.add(new EntryVignette(root));
		this.add(new EntryWaterColor(root));

	}
}
