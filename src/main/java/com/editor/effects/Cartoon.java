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
	public Mat edgeMask(Mat img, int lineSize, int blurSize)
	{
		Mat gray = new Mat();
		Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
		Mat grayBlur = new Mat();
		Imgproc.medianBlur(gray, grayBlur, blurSize);
		Mat edges = new Mat();
		Imgproc.adaptiveThreshold(grayBlur,edges, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,
				Imgproc.THRESH_BINARY, lineSize, blurSize);
		Mat colorImg = new Mat();
		Imgproc.bilateralFilter(edges, colorImg, lineSize, 250, 250);
		Mat appliedEdges= new Mat();
		Core.bitwise_and(colorImg, edges, appliedEdges);
		Imgproc.cvtColor(edges, edges,Imgproc.COLOR_GRAY2RGB);
		return edges;
	}

	public Mat lessColors(Mat img, int numberOfColors)
	{
		Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
		int numDown = 2;
		Mat imgColor = new Mat();
		imgColor = img;
		Mat dest = new Mat();
		Imgproc.bilateralFilter(imgColor, dest, numberOfColors,9,7);
		Mat gray = new Mat();
		Imgproc.cvtColor(dest, gray, Imgproc.COLOR_RGB2GRAY);
		Mat blurred = new Mat();
		Imgproc.medianBlur(gray,blurred,7);

		return blurred;
	}

	public Mat cartoon(Mat img, int lineSize, int blurSize)
	{
		Mat edges = edgeMask(img, lineSize, blurSize);
		Mat lessColors = lessColors(img, 9);
		Imgproc.cvtColor(edges, edges, Imgproc.COLOR_RGB2GRAY);
		Mat cartoon = new Mat();
		Core.bitwise_and(edges, lessColors, cartoon);
		return cartoon;
	}


	public void doEffect() {
		BufferedImage inBufferedImage = active.getImage();
		Mat img = Convert.img2Mat(inBufferedImage);
		Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
		Mat effect = cartoon(img, 9, 3);
		Imgproc.cvtColor(effect, effect, Imgproc.COLOR_GRAY2RGBA);
		BufferedImage outBufferedImage = Convert.mat2Img(effect);
		active.setImage(outBufferedImage);
		active.update();
		addToHistory();
	}

	@Override
	public String toString() {
		return "Cartoon";
	}
}
