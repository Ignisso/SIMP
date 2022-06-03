package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;

public class GaussianBlur 
extends Effect {
	private static final double[][] matrix = {{0.00, 0.01, 0.01, 0.01, 0.00},
											   {0.01, 0.05, 0.11, 0.05, 0.01},
											   {0.01, 0.11, 0.25, 0.11, 0.01},
											   {0.01, 0.05, 0.11, 0.05, 0.01},
											   {0.00, 0.01, 0.01, 0.01, 0.00}};

	public GaussianBlur(EditorRuntime root) {
		super(root);
	}

	private int gaussian(int i, int j, int[][] rgb) {
		
		int resR = 0;
		int resG = 0;
		int resB = 0;
		for(int x = Math.max(0, i-2); x <= Math.min(active.getLayerWidth() - 1, i + 2); x++) {
			for(int y = Math.max(0, j-2); y <= Math.min(active.getLayerHeight() - 1, j + 2); y++) {
				int r = rgb[x][y] >> 16 & 0xFF;
				int g = rgb[x][y] >> 8 & 0xFF;
				int b = rgb[x][y] & 0xFF;
				resR += matrix[2+x-i][2+y-j] * r;
				resG += matrix[2+x-i][2+y-j] * g;
				resB += matrix[2+x-i][2+y-j] * b;
			}
		}

		return (255 << 24) + (resR << 16) + (resG << 8) + (resB);
	}
	public void doEffect() {
		int[][] rgb = new int [active.getLayerWidth()][active.getLayerHeight()];
		for (int i = 0; i < active.getLayerWidth(); i++) {
			for (int j = 0; j < active.getLayerHeight(); j++) {
				rgb[i][j] = active.getRGB(i, j);
			}
		}

		for (int i = 0; i < active.getLayerWidth(); i++) {
			for (int j = 0; j < active.getLayerHeight(); j++) {
				active.setRGB(i, j, gaussian(i, j, rgb));
			}
		}
		active.update();
	}
}
