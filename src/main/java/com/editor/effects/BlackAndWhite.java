package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class BlackAndWhite
extends Effect {
    private Integer numberOfShades;

    public BlackAndWhite(EditorRuntime root) {
        super(root);
        this.numberOfShades = 5;
    }

    public BlackAndWhite(EditorRuntime root, Integer numberOfShades) {
        super(root);
        this.numberOfShades = numberOfShades;
    }
	
    public void process() {
        for (int i = 0; i < active.getLayerWidth(); i++) {
            setProgress(100 * (i+1)/active.getLayerWidth());
            for (int j = 0; j < active.getLayerHeight(); j++) {
                int rgb = active.getRGB(i, j);
                int a = rgb >> 24 & 0xFF;
                int r = rgb >> 16 & 0xFF;
                int g = rgb >> 8 & 0xFF;
                int b = rgb & 0xFF;
                int grayscale=  (int) (0.299*r) + (int) (0.587*g) +
                        (int) (0.114*b) - this.numberOfShades;
                r = grayscale;
                g = grayscale;
                b = grayscale;
                r = Math.max(Math.min(255, r), 0);
                g = Math.max(Math.min(255, g), 0);
                b = Math.max(Math.min(255, b), 0);
                rgb = (a << 24) + (r << 16) + (g << 8) + (b);
                active.setRGB(i, j, rgb);
            }
        }
        active.update();
		addToHistory();
    }
	
	@Override
	public String toString() {
		return "Black and White";
	}
}

