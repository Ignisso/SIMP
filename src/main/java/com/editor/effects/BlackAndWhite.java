package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class BlackAndWhite
        extends Effect {


    private int numberOfShades;

    public BlackAndWhite(EditorRuntime root, int numberOfShades) {
        super(root);
        this.numberOfShades = numberOfShades;
    }

    public void doEffect() {
        for (int i = 0; i < active.getLayerWidth(); i++) {
            for (int j = 0; j < active.getLayerHeight(); j++) {
                int rgb = active.getRGB(i, j);
                int a = rgb >> 24 & 0xFF;
                int r = rgb >> 16 & 0xFF;
                int g = rgb >> 8 & 0xFF;
                int b = rgb & 0xFF;
                int grayscale=  (int) (0.299*r) + (int) (0.587*g) +
                        (int) (0.114*b) - numberOfShades;
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
    }
}

