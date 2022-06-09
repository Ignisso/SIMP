package com.editor.effects;

import com.editor.core.*;
import com.editor.image.*;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;

public class Sharpness
        extends Effect {

    private Integer sharpness;
    public Sharpness(EditorRuntime root) {
        super(root);
    }
    public Sharpness(EditorRuntime root, Integer sharpness) {
        super(root);
        this.sharpness = sharpness;
    }
    private Mat sharpen(Mat img) {
        Imgproc.cvtColor(img,img,Imgproc.COLOR_BGRA2BGR);
        addProgress(12);
        Mat blurred = new Mat();
        addProgress(15);
        Imgproc.GaussianBlur(img, blurred, new Size(0,0), this.sharpness);
        addProgress(11);
        Core.addWeighted(img, 1.5, blurred, -0.5,0,blurred);
        addProgress(7);
        return blurred;
    }

    public void process() {
        BufferedImage inBufferedImage = active.getImage();
        addProgress(18);
        Mat img = Convert.img2Mat(inBufferedImage);
        addProgress(9);
        Mat effect = sharpen(img);
        addProgress(14);
        BufferedImage outBufferedImage = Convert.mat2Img(effect);
        addProgress(8);
        active.setImage(outBufferedImage);
        addProgress(6);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Sharpness";
    }
}
