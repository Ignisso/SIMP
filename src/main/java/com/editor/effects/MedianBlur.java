package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

import java.util.Arrays;

public class MedianBlur
        extends Effect {

    public MedianBlur(EditorRuntime root) {
        super(root);
    }

    static double median(int[] values) {
        Arrays.sort(values);
        double median;
        int totalElements = values.length;
        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = values[totalElements / 2] +
                    values[totalElements / 2 - 1];
            median = ((double) sumOfMiddleElements) / 2;
        } else {
            median = (double) values[values.length / 2];
        }
        return median;
    }

    public void doEffect() {
        int[] tmp = new int[9];
        for (int i = 1; i < active.getLayerWidth()-1; i++) {
            for (int j = 1; j < active.getLayerHeight()-1; j++) {
                tmp[0] = active.getRGB(i-1, j-1);
                tmp[1] = active.getRGB(i-1, j);
                tmp[2] = active.getRGB(i-1, j+1);
                tmp[3] = active.getRGB(i, j-1);
                tmp[4] = active.getRGB(i, j);
                tmp[5] = active.getRGB(i, j+1);
                tmp[6] = active.getRGB(i+1, j-1);
                tmp[7] = active.getRGB(i+1, j);
                tmp[8] = active.getRGB(i+1, j+1);

                int medianValue = (int) median(tmp);
                active.setRGB(i, j, medianValue);
            }
        }
        active.update();
    }
}
