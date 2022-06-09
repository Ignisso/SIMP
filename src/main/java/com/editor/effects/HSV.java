package com.editor.effects;

import com.editor.core.EditorRuntime;

import com.editor.core.*;
import com.editor.image.*;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.photo.Photo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;


public class HSV
        extends Effect {

    public HSV(EditorRuntime root) {
        super(root);
    }


    public void process() {
        BufferedImage inBufferedImage = active.getImage();
        Mat img = Convert.img2Mat(inBufferedImage);
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
        Mat hsv = new Mat();
        Mat threshold = new Mat();
        Imgproc.cvtColor(img,hsv, Imgproc.COLOR_BGR2HSV);
        Core.inRange(hsv, new Scalar(170,80,50), new Scalar(120,40,40 ), threshold );
        BufferedImage outBufferedImage = Convert.mat2Img(threshold);
        active.setImage(outBufferedImage);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "HSV";
    }
}
