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


public class HDR
        extends Effect {

    public HDR(EditorRuntime root) {
        super(root);
    }


    public void process() {
        BufferedImage inBufferedImage = active.getImage();
        Mat img = Convert.img2Mat(inBufferedImage);
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
        Mat out = new Mat();
        Photo.detailEnhance(img, out, 12,0.08F);
        BufferedImage outBufferedImage = Convert.mat2Img(out);
        active.setImage(outBufferedImage);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "HDR";
    }
}
