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


public class Negative
        extends Effect {

    public Negative(EditorRuntime root) {
        super(root);
    }


    public void doEffect() {
        BufferedImage inBufferedImage = active.getImage();
        Mat img = Convert.img2Mat(inBufferedImage);
        Mat negative = new Mat();
        Core.bitwise_not(img,negative);
        BufferedImage outBufferedImage = Convert.mat2Img(negative);
        active.setImage(outBufferedImage);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Negative";
    }
}
