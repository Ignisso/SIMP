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


    public void doEffect() {
        BufferedImage inBufferedImage = active.getImage();
        Mat img = Convert.img2Mat(inBufferedImage);
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
        Mat invertedImg= new Mat();
        Core.bitwise_not(img,invertedImg);
        Mat blurred = new Mat();
        Imgproc.GaussianBlur(invertedImg, blurred, new Size(21,21), 0,0);
        Mat invertedBlur = new Mat();
        Core.bitwise_not(blurred,invertedBlur);
        Mat pencil = new Mat();
        Core.divide(img,invertedBlur,pencil,256);
        BufferedImage outBufferedImage = Convert.mat2Img(pencil);

        active.setImage(outBufferedImage);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Chalk Sketch";
    }
}
