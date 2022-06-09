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

    public void process() {
        int[] tmp = new int[9];
        int[][] tmp2 = new int[active.getLayerWidth()][active.getLayerHeight()];
        for (int i = 1; i < active.getLayerWidth() - 1; i++) {
            for (int j = 1; j < active.getLayerHeight() - 1; j++) {
                tmp[0] = active.getRGB(i - 1, j - 1);
                tmp[1] = active.getRGB(i - 1, j);
                tmp[2] = active.getRGB(i - 1, j + 1);
                tmp[3] = active.getRGB(i, j - 1);
                tmp[4] = active.getRGB(i, j);
                tmp[5] = active.getRGB(i, j + 1);
                tmp[6] = active.getRGB(i + 1, j - 1);
                tmp[7] = active.getRGB(i + 1, j);
                tmp[8] = active.getRGB(i + 1, j + 1);

                int medianValue = (int) median(tmp);
                tmp2[i][j] = medianValue;
            }
        }

        for (int j=1; j< active.getLayerHeight()-1 ; j++)
        {
            tmp[0] = active.getRGB(0, j-1);
            tmp[1] = active.getRGB(0, j);
            tmp[2] = active.getRGB(0, j+1);
            tmp[3] = active.getRGB(1, j-1);
            tmp[4] = active.getRGB(1, j);
            tmp[5] = active.getRGB(1, j+1);
            int medianValue = (int) median(tmp);
            tmp2[0][j] = medianValue;
        }
        for (int j= 1; j< active.getLayerWidth()-1 ; j++)
        {
            tmp[0] = active.getRGB(j-1, 0);
            tmp[1] = active.getRGB(j, 0);
            tmp[2] = active.getRGB(j+1, 0);
            tmp[3] = active.getRGB(j-1, 1);
            tmp[4] = active.getRGB(j, 1);
            tmp[5] = active.getRGB(j+1, 1);
            int medianValue = (int) median(tmp);
            tmp2[j][0] = medianValue;
        }

        for (int j=1; j< active.getLayerHeight()-1 ; j++)
        {
            tmp[0] = active.getRGB(active.getLayerWidth()-1, j-1);
            tmp[1] = active.getRGB(active.getLayerWidth()-1, j);
            tmp[2] = active.getRGB(active.getLayerWidth()-1, j+1);
            tmp[3] = active.getRGB(active.getLayerWidth()-2, j-1);
            tmp[4] = active.getRGB(active.getLayerWidth()-2, j);
            tmp[5] = active.getRGB(active.getLayerWidth()-2, j+1);
            int medianValue = (int) median(tmp);
            tmp2[active.getLayerWidth()-1][j] = medianValue;
        }


        for (int j=1; j< active.getLayerWidth()-1 ; j++)
        {
            tmp[0] = active.getRGB(j-1, active.getLayerHeight() -2);
            tmp[1] = active.getRGB(j, active.getLayerHeight() -2);
            tmp[2] = active.getRGB(j+1, active.getLayerHeight() -2);
            tmp[3] = active.getRGB(j-1, active.getLayerHeight() -1);
            tmp[4] = active.getRGB(j, active.getLayerHeight() -1);
            tmp[5] = active.getRGB(j+1, active.getLayerHeight() -1);
            int medianValue = (int) median(tmp);
            tmp2[j][active.getLayerHeight() -1] = medianValue;
        }

        for (int i = 0; i < active.getLayerWidth(); i++) {
            for (int j = 0; j < active.getLayerHeight(); j++) {
                active.setRGB(i, j, tmp2[i][j]);
            }
        }
		active.update();
		addToHistory();
	}
	
	@Override
	public String toString() {
		return "Median Blur";
	}
}
