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


public class CrayonSketch
        extends Effect {

    public CrayonSketch(EditorRuntime root) {
        super(root);
    }


    public void process() {
        BufferedImage inBufferedImage = active.getImage();
        addProgress(14);
        Mat img = Convert.img2Mat(inBufferedImage);
        addProgress(12);
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
        addProgress(14);
        Mat sketch = new Mat();
        Mat sketch2 = new Mat();
        addProgress(20);
        Photo.pencilSketch(img,sketch,sketch2,60,0.1F);
        addProgress(17);
        BufferedImage outBufferedImage = Convert.mat2Img(sketch2);
        addProgress(15);
        active.setImage(outBufferedImage);
        addProgress(8);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Crayon Sketch";
    }
}
