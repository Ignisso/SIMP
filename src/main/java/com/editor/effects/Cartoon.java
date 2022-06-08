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
		this.lineSize = 2 * ls - 1;
		this.lineBlur = 2 * lb - 1;
		this.imgBlur  = 2 * ib - 1;
		this.diameter = d;
		this.radius   = r;
	}
	
	private Mat edgeMask(Mat img) {
		Mat gray = new Mat();
		Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
		addProgress(4);
		Mat grayBlur = new Mat();
		Imgproc.medianBlur(gray, grayBlur, this.lineBlur);
		addProgress(9);
		Mat edges = new Mat();
		Imgproc.adaptiveThreshold(grayBlur,edges, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,
			Imgproc.THRESH_BINARY, this.lineSize, this.lineBlur);
		addProgress(8);
		Mat colorImg = new Mat();
		Imgproc.bilateralFilter(edges, colorImg, this.lineSize, this.radius, this.radius);
		addProgress(14);
		Mat appliedEdges = new Mat();
		Core.bitwise_and(colorImg, edges, appliedEdges);
		Imgproc.cvtColor(edges, edges, Imgproc.COLOR_GRAY2RGB);
		addProgress(6);
		return edges;
	}
	
	private Mat lessColors(Mat img) {
		Imgproc.cvtColor(img, img, Imgproc.COLOR_BGRA2BGR);
		addProgress(6);
		Mat dest = new Mat();
		Imgproc.bilateralFilter(img, dest, this.diameter, this.radius, this.radius);
		addProgress(12);
		Mat blurred = new Mat();
		Imgproc.medianBlur(dest, blurred, this.imgBlur);
		addProgress(12);
		return blurred;
	}
	
	private Mat cartoon(Mat img) {
		Mat edges = edgeMask(img);
		Mat lessColors = lessColors(img);
		Mat cartoon = new Mat();
		Core.bitwise_and(edges, lessColors, cartoon);
		addProgress(6);
		return cartoon;
	}
	
	public void process() {
		BufferedImage inBufferedImage = active.getImage();
		addProgress(4);
		Mat img = Convert.img2Mat(inBufferedImage);
		addProgress(4);
		Mat effect = cartoon(img);
		addProgress(4);
		BufferedImage outBufferedImage = Convert.mat2Img(effect);
		addProgress(4);
		active.setImage(outBufferedImage);
		addProgress(3);
		active.update();
		addProgress(4);
		addToHistory();
	}
	
	@Override
	public String toString() {
		return "Cartoon";
	}
}
