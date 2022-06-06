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
	private Integer lineSize;
	private Integer lineBlur;
	private Integer imgBlur;
	private Integer diameter;
	private Integer radius;
	
	public Cartoon(EditorRuntime root) {
		super(root);
		this.lineSize = 7;
		this.lineBlur = 5;
		this.imgBlur  = 7;
		this.diameter = 15;
		this.radius   = 30;
	}
	
	public Cartoon(EditorRuntime root, Integer ls, Integer lb, Integer ib,
		Integer d, Integer r) {
		super(root);
		this.lineSize = ls;
		this.lineBlur = lb;
		this.imgBlur  = ib;
		this.diameter = d;
		this.radius   = r;
	}
	
	private Mat edgeMask(Mat img) {
		Mat gray = new Mat();
		Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
		Mat grayBlur = new Mat();
		Imgproc.medianBlur(gray, grayBlur, this.lineBlur);
		Mat edges = new Mat();
		Imgproc.adaptiveThreshold(grayBlur,edges, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,
			Imgproc.THRESH_BINARY, this.lineSize, this.lineBlur);
		Mat colorImg = new Mat();
		Imgproc.bilateralFilter(edges, colorImg, this.lineSize, this.radius, this.radius);
		Mat appliedEdges = new Mat();
		Core.bitwise_and(colorImg, edges, appliedEdges);
		Imgproc.cvtColor(edges, edges, Imgproc.COLOR_GRAY2RGB);
		return edges;
	}
	
	private Mat lessColors(Mat img) {
		Imgproc.cvtColor(img, img, Imgproc.COLOR_BGRA2BGR);
		Mat dest = new Mat();
		Imgproc.bilateralFilter(img, dest, this.diameter, this.radius, this.radius);
		Mat blurred = new Mat();
		Imgproc.medianBlur(dest, blurred, this.imgBlur);
		return blurred;
	}
	
	private Mat cartoon(Mat img) {
		Mat edges = edgeMask(img);
		Mat lessColors = lessColors(img);
		Mat cartoon = new Mat();
		Core.bitwise_and(edges, lessColors, cartoon);
		return cartoon;
	}
	
	public void doEffect() {
		BufferedImage inBufferedImage = active.getImage();
		Mat img = Convert.img2Mat(inBufferedImage);
		Mat effect = cartoon(img);
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
