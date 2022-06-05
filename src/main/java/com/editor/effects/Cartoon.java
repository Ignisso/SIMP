package com.editor.effects;

import com.editor.core.EditorRuntime;

import com.editor.core.*;
import com.editor.image.*;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;


public class Cartoon
        extends Effect {

    public Cartoon(EditorRuntime root) {
        super(root);
    }

    public void doEffect() {
		BufferedImage inBufferedImage = active.getImage();
		Mat img = Convert.img2Mat(inBufferedImage);
		Mat dest = new Mat();
		Imgproc.cvtColor(img,dest,Imgproc.COLOR_BGR2GRAY);
		Mat gray = new Mat();
		Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
		Mat blur = new Mat();
		Imgproc.medianBlur(gray, blur, 5);
		Mat edges = new Mat();
		Imgproc.adaptiveThreshold(blur,edges, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,
				Imgproc.THRESH_BINARY, 9, 9);
		Mat colorImg = new Mat();
		Imgproc.bilateralFilter(edges, colorImg, 9, 250, 250);
		Mat cartoon = new Mat();
		Core.bitwise_and(colorImg, edges, cartoon);
		BufferedImage outBufferedImage = Convert.mat2Img(cartoon);
		active.setImage(outBufferedImage);
		active.update();
		addToHistory();
	}

    @Override
    public String toString() {
        return "Cartoon";
    }
}
