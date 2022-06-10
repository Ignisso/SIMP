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


public class PencilSketch
		extends Effect {

	public PencilSketch(EditorRuntime root) {
		super(root);
	}


	public void process() {
		BufferedImage inBufferedImage = active.getImage();				  addProgress(15);
		Mat img = Convert.img2Mat(inBufferedImage);
		Mat gray = new Mat();
		Imgproc.cvtColor(img,gray,Imgproc.COLOR_RGB2GRAY);
		Mat invertedGray= new Mat();
		Core.bitwise_not(gray,invertedGray);
		Mat blurred = new Mat();											addProgress(35);
		Imgproc.GaussianBlur(invertedGray, blurred, new Size(21, 21), 0,0);
		Mat invertedBlur = new Mat();									   addProgress(15);
		Core.bitwise_not(blurred,invertedBlur);
		Mat pencil = new Mat();
		Core.divide(gray, invertedBlur, pencil, 256);
		BufferedImage outBufferedImage = Convert.mat2Img(pencil);
		active.setImage(outBufferedImage);								  addProgress(35);
		active.update();
		addToHistory();
	}

	@Override
	public String toString() {
		return "Pencil Sketch";
	}
}
