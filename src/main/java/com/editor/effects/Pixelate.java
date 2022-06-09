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
import java.util.Vector;


public class Pixelate
        extends Effect {

    private Integer pixels;
    public Pixelate(EditorRuntime root) {
        super(root);
    }

    public Pixelate(EditorRuntime root, Integer pixels) {
        super(root);
        this.pixels = pixels;
    }


    public void process() {
        addProgress(13);
        BufferedImage inBufferedImage = active.getImage();
        addProgress(12);
        Mat img = Convert.img2Mat(inBufferedImage);
        addProgress(16);
        int height = active.getLayerHeight();
        int width = active.getLayerWidth();
        addProgress(12);
        Mat pixel = new Mat();
        Imgproc.resize(img, pixel, new Size(this.pixels,this.pixels), Imgproc.INTER_LINEAR);
        Mat out = new Mat();
        addProgress(15);
        Imgproc.resize(pixel, out, new Size(width,height),0,0, Imgproc.INTER_NEAREST);
        addProgress(16);
        BufferedImage outBufferedImage = Convert.mat2Img(out);
        addProgress(16);
        active.setImage(outBufferedImage);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Pixelate";
    }
}
