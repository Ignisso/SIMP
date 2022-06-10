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
        BufferedImage inBufferedImage = active.getImage();          setProgress(5);
        Mat img = Convert.img2Mat(inBufferedImage);
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);           setProgress(22);
        Mat output = new Mat();                                     setProgress(41);
        Photo.stylization(img,output,60F,0.4F);                     setProgress(57);
        BufferedImage outBufferedImage = Convert.mat2Img(output);   setProgress(97);
        active.setImage(outBufferedImage);
        setProgress(100);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Water Color";
    }
}
