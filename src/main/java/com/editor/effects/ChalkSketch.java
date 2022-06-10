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


public class ChalkSketch
        extends Effect {

    public ChalkSketch(EditorRuntime root) {
        super(root);
    }


    public void process() {
        BufferedImage inBufferedImage = active.getImage();
        addProgress(12);
        Mat img = Convert.img2Mat(inBufferedImage);
        addProgress(11);
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
        addProgress(7);
        Mat invertedImg= new Mat();
        addProgress(15);
        Core.bitwise_not(img,invertedImg);
        addProgress(12);
        Mat blurred = new Mat();
        addProgress(17);
        Imgproc.GaussianBlur(invertedImg, blurred, new Size(21,21), 0,0);
        addProgress(9);
        Mat invertedBlur = new Mat();
        addProgress(4);
        Core.bitwise_not(blurred,invertedBlur);
        addProgress(5);
        Mat pencil = new Mat();
        Core.divide(img,invertedBlur,pencil,256);
        addProgress(6);
        BufferedImage outBufferedImage = Convert.mat2Img(pencil);

        active.setImage(outBufferedImage);
        active.update();
        setProgress(100);
        addToHistory();
    }

    @Override
    public String toString() {
        return "Chalk Sketch";
    }
}
