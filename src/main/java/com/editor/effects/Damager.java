package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class Damager
        extends Effect {

    private Integer size;
    public Damager(EditorRuntime root) {
        super(root);
    }
    public Damager(EditorRuntime root, Integer size) {
        super(root);
        this.size = size;
    }
	
    private int randomRGB(int min, int max)
    {
        int random = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random;
    }
	
    public void randomPixels() {
        for (int i = 0; i < active.getLayerWidth(); i++) {
            for (int j = randomRGB(1, 10); j < active.getLayerHeight(); j+=randomRGB(1, 10)) {
                int rgb = active.getRGB(i, j);
                int a = rgb >> 24 & 0xFF;
                int r = randomRGB(0,255);
                int g = randomRGB(0,255);
                int b = randomRGB(0,255);
                rgb = (a << 24) + (r << 16) + (g << 8) + (b);
                active.setRGB(i, j, rgb);
            }
        }
    }

    public void process()
    {
        for(int i=0; i<this.size; i++)
        {
            randomPixels();
            addProgress(100/this.size);
        }
        active.update();
        setProgress(100);
        addToHistory();
    }

    @Override
    public String toString() {
        return "Damager";
    }
}

