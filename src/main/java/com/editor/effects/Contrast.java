package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class Contrast
extends Effect {
    private Integer contrast;
	
    public Contrast(EditorRuntime root) {
        super(root);
        this.contrast = 5;
    }

    public Contrast(EditorRuntime root, Integer contrast) {
        super(root);
        this.contrast = contrast;
    }
	
    public void process() {
        for (int i = 0; i < active.getLayerWidth(); i++) {
            for (int j = 0; j < active.getLayerHeight(); j++) {
                int rgb = active.getRGB(i, j);
                int a = rgb >> 24 & 0xFF;
                int r = rgb >> 16 & 0xFF;
                int g = rgb >> 8 & 0xFF;
                int b = rgb & 0xFF;
                float factor = (259 * ((float)this.contrast + 255)) / (255 * (259 - (float)this.contrast));
                r = (int) (factor*(r-128) + 128);
                g = (int) (factor*(g-128) + 128);
                b = (int) (factor*(b-128) + 128);
                r = Math.max(Math.min(255, r), 0);
                g = Math.max(Math.min(255, g), 0);
                b = Math.max(Math.min(255, b), 0);

                rgb = (a << 24) + (r << 16) + (g << 8) + (b);
                active.setRGB(i, j, rgb);
                addProgress((active.getLayerWidth() / 20* i)/100);
            }
        }
        active.update();
        setProgress(100);
		addToHistory();
    }
	
	@Override
	public String toString() {
		return "Contrast";
	}
}
