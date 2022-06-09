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


public class Inversion
        extends Effect {

    public Inversion(EditorRuntime root) {
        super(root);
    }


    public void process() {
        BufferedImage inBufferedImage = active.getImage();
        addProgress(15);
        Mat img = Convert.img2Mat(inBufferedImage);
        addProgress(17);
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
        addProgress(14);
        Mat negative = new Mat();
        addProgress(11);
        Core.bitwise_not(img,negative);
        addProgress(16);
        BufferedImage outBufferedImage = Convert.mat2Img(negative);
        addProgress(9);
        active.setImage(outBufferedImage);
        addProgress(18);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Inversion";
    }
}
