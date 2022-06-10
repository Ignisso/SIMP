package com.editor.effects;

import com.editor.core.EditorRuntime;

import com.editor.core.*;
import com.editor.image.*;
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;
import org.opencv.photo.Photo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;


public class AverageBlur
        extends Effect {

    private Integer size;
    public AverageBlur(EditorRuntime root) {
        super(root);
    }
    public AverageBlur(EditorRuntime root, Integer size) {
        super(root);
        this.size = size;
    }


    public void process() {
        BufferedImage inBufferedImage = active.getImage();
        addProgress(12);
        Mat img = Convert.img2Mat(inBufferedImage);
        addProgress(15);
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
        addProgress(13);
        Mat out = new Mat();
        addProgress(10);
        Point point = new Point(-1,-1);
        addProgress(15);
        Size size = new Size(this.size,this.size);
        addProgress(20);
        Imgproc.blur(img,out, size, point, Core.BORDER_DEFAULT);
        addProgress(7);
        BufferedImage outBufferedImage = Convert.mat2Img(out);
        addProgress(8);
        active.setImage(outBufferedImage);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "AverageBlur";
    }
}
