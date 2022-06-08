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


public class WaterColor
        extends Effect {

    public WaterColor(EditorRuntime root) {
        super(root);
    }
    public void doEffect() {
        BufferedImage inBufferedImage = active.getImage();
        Mat img = Convert.img2Mat(inBufferedImage);
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
        Mat output = new Mat();
        Photo.stylization(img,output,60F,0.1F);
        BufferedImage outBufferedImage = Convert.mat2Img(output);
        active.setImage(outBufferedImage);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Water Color";
    }
}
