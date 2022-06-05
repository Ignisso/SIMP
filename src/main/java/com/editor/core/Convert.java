package com.editor.core;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import java.awt.image.BufferedImage;

public class Convert {
	public static Mat img2Mat(BufferedImage in) {
		Mat out;
		byte[] data;
		int r, g, b;
		int width = in.getWidth();
		int height = in.getHeight();
		
		if(in.getType() == BufferedImage.TYPE_INT_RGB) {
			out = new Mat(height, width, CvType.CV_8UC3);
			data = new byte[height * width * (int)out.elemSize()];
			int[] dataBuff = in.getRGB(0, 0, width, height, null, 0, width);
			for(int i = 0; i < dataBuff.length; i++) {
				data[i*3] = (byte) ((dataBuff[i] >> 16) & 0xFF);
				data[i*3 + 1] = (byte) ((dataBuff[i] >> 8) & 0xFF);
				data[i*3 + 2] = (byte) ((dataBuff[i] >> 0) & 0xFF);
			}
		}
		else if(in.getType() == BufferedImage.TYPE_4BYTE_ABGR) {
			out = new Mat(height, width, CvType.CV_8UC4);
			data = new byte[height * width * (int)out.elemSize()];
			int[] dataBuff = in.getRGB(0, 0, width, height, null, 0, width);
			for(int i = 0; i < dataBuff.length; i++) {
				data[i*4] = (byte) ((dataBuff[i] >> 16) & 0xFF);
				data[i*4 + 1] = (byte) ((dataBuff[i] >> 8) & 0xFF);
				data[i*4 + 2] = (byte) ((dataBuff[i] >> 0) & 0xFF);
				data[i*4 + 3] = (byte) ((dataBuff[i] >> 24) & 0xFF);
			}
		}
		else {
			out = new Mat(height, width, CvType.CV_8UC1);
			data = new byte[height * width * (int)out.elemSize()];
			int[] dataBuff = in.getRGB(0, 0, width, height, null, 0, width);
			for(int i = 0; i < dataBuff.length; i++) {
				r = (byte) ((dataBuff[i] >> 16) & 0xFF);
				g = (byte) ((dataBuff[i] >> 8) & 0xFF);
				b = (byte) ((dataBuff[i] >> 0) & 0xFF);
				data[i] = (byte)((0.21 * r) + (0.71 * g) + (0.07 * b)); //luminosity
			}
		}
		out.put(0, 0, data);
		return out;
	}

	public static BufferedImage mat2Img(Mat in) {
		int width = in.width();
		int height = in.height();
		BufferedImage out;
		byte[] data = new byte[height * width * (int)in.elemSize()];
		int type;
		in.get(0, 0, data);
		
		if (in.channels() == 1)
			type = BufferedImage.TYPE_BYTE_GRAY;
		else if (in.channels() == 3)
			type = BufferedImage.TYPE_3BYTE_BGR;
		else
			type = BufferedImage.TYPE_4BYTE_ABGR;
		
		out = new BufferedImage(width, height, type);
		
		out.getRaster().setDataElements(0, 0, width, height, data);
		return out;
	}
}