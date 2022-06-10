package com.editor.tools;

import com.editor.core.Convert;
import com.editor.core.EditorRuntime;
import com.editor.image.Image;
import com.editor.image.Layer;
import com.editor.image.Workspace;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;

public class Rotate
extends Tool {

	public Rotate(EditorRuntime root) {
		super(root);
	}

	public void rotation90()
	{
		Image image = root.getWindow().getWorkspace().getImage();
		if (image == null)
			return;
		Layer active = image.getActiveLayer();
		if (active == null)
			return;
		BufferedImage inBufferedImage = active.getImage();
		Mat img = Convert.img2Mat(inBufferedImage);
		Mat out = new Mat();
		Core.rotate(img, out, Core.ROTATE_90_CLOCKWISE);
		BufferedImage outBufferedImage = Convert.mat2Img(out);
		image.setDimension(image.getAbsoluteHeight(), image.getAbsoluteWidth());
		active.setImage(outBufferedImage);
		active.update();
	}

	public void rotation180()
	{
		Image image = root.getWindow().getWorkspace().getImage();
		if (image == null)
			return;
		Layer active = image.getActiveLayer();
		if (active == null)
			return;
		BufferedImage inBufferedImage = active.getImage();
		Mat img = Convert.img2Mat(inBufferedImage);
		Mat out = new Mat();
		Core.rotate(img, out, Core.ROTATE_180);
		BufferedImage outBufferedImage = Convert.mat2Img(out);
		image.setDimension(image.getAbsoluteHeight(), image.getAbsoluteWidth());
		active.setImage(outBufferedImage);
		active.update();
	}

	public void rotation270()
	{
		Image image = root.getWindow().getWorkspace().getImage();
		if (image == null)
			return;
		Layer active = image.getActiveLayer();
		if (active == null)
			return;
		BufferedImage inBufferedImage = active.getImage();
		Mat img = Convert.img2Mat(inBufferedImage);
		Mat out = new Mat();
		Core.rotate(img, out, Core.ROTATE_180);
		Core.rotate(out,out, Core.ROTATE_90_CLOCKWISE);
		BufferedImage outBufferedImage = Convert.mat2Img(out);
		image.setDimension(image.getAbsoluteHeight(), image.getAbsoluteWidth());
		active.setImage(outBufferedImage);
		active.update();
	}
}
