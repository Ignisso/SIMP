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


public class Mosaic
        extends Effect {

    private Integer size;
    public Mosaic(EditorRuntime root) {
        super(root);
    }
    public Mosaic(EditorRuntime root, Integer size) {
        super(root);
        this.size = size;
    }


    public void process() {
        BufferedImage inBufferedImage = active.getImage();
        addProgress(14);
        Mat img = Convert.img2Mat(inBufferedImage);
        addProgress(13);
        Imgproc.cvtColor(img, img, Imgproc.COLOR_BGRA2BGR);
        addProgress(11);
        Mat kernel = new Mat();
        addProgress(9);
        Size sizee = new Size(this.size,this.size);
        addProgress(16);
        kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, sizee);
        addProgress(17);
        Mat out = new Mat();
        addProgress(10);
        Imgproc.erode(img, out, kernel);
        addProgress(10);
        BufferedImage outBufferedImage = Convert.mat2Img(out);
        active.setImage(outBufferedImage);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Mosaic";
    }
}
