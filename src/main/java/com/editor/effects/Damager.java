package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class Damager
        extends Effect {

    public Damager(EditorRuntime root) {
        super(root);
    }
    private int randomRGB(int min, int max)
    {
        int random= (int)Math.floor(Math.random()*(max-min+1)+min);
        return random;
    }
    public void doEffect() {
        for (int i = randomRGB(5,10); i < active.getLayerWidth(); i+=6) {
            for (int j =randomRGB(1,4); j < active.getLayerHeight(); j+=7) {
                int rgb = active.getRGB(i, j);
                int a = rgb >> 24 & 0xFF;
                int r = randomRGB(0,255);
                int g = randomRGB(0,255);
                int b = randomRGB(0,255);
                rgb = (a << 24) + (r << 16) + (g << 8) + (b);
                active.setRGB(i, j, rgb);
            }
        }
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Damager";
    }
}
