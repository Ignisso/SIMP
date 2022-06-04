package com.editor.effects;

import com.editor.core.EditorRuntime;

import com.editor.core.*;
import com.editor.image.*;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;


public class Cartoon
        extends Effect {

    public Cartoon(EditorRuntime root) {
        super(root);
    }

    public static Mat img2Mat(BufferedImage in)
    {
        Mat out;
        byte[] data;
        int r, g, b;

        if(in.getType() == BufferedImage.TYPE_INT_RGB)
        {
            out = new Mat(240, 320, CvType.CV_8UC3);
            data = new byte[320 * 240 * (int)out.elemSize()];
            int[] dataBuff = in.getRGB(0, 0, 320, 240, null, 0, 320);
            for(int i = 0; i < dataBuff.length; i++)
            {
                data[i*3] = (byte) ((dataBuff[i] >> 16) & 0xFF);
                data[i*3 + 1] = (byte) ((dataBuff[i] >> 8) & 0xFF);
                data[i*3 + 2] = (byte) ((dataBuff[i] >> 0) & 0xFF);
            }
        }
        else
        {
            out = new Mat(240, 320, CvType.CV_8UC1);
            data = new byte[320 * 240 * (int)out.elemSize()];
            int[] dataBuff = in.getRGB(0, 0, 320, 240, null, 0, 320);
            for(int i = 0; i < dataBuff.length; i++)
            {
                r = (byte) ((dataBuff[i] >> 16) & 0xFF);
                g = (byte) ((dataBuff[i] >> 8) & 0xFF);
                b = (byte) ((dataBuff[i] >> 0) & 0xFF);
                data[i] = (byte)((0.21 * r) + (0.71 * g) + (0.07 * b)); //luminosity
            }
        }
        out.put(0, 0, data);
        return out;
    }

    public static BufferedImage mat2Img(Mat in)
    {
        BufferedImage out;
        byte[] data = new byte[320 * 240 * (int)in.elemSize()];
        int type;
        in.get(0, 0, data);

        if(in.channels() == 1)
            type = BufferedImage.TYPE_BYTE_GRAY;
        else
            type = BufferedImage.TYPE_3BYTE_BGR;

        out = new BufferedImage(320, 240, type);

        out.getRaster().setDataElements(0, 0, 320, 240, data);
        return out;
    }

    public void doEffect() {
        BufferedImage inBufferedImage = active.getImage();
        Mat img = img2Mat(inBufferedImage);
        Mat dest = new Mat();
        Imgproc.cvtColor(img,dest,Imgproc.COLOR_BGR2GRAY);
        Mat gray = new Mat();
        Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
        Mat blur = new Mat();
        Imgproc.medianBlur(gray, blur, 5);
        Mat edges = new Mat();
        Imgproc.adaptiveThreshold(blur,edges, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,
                Imgproc.THRESH_BINARY, 9, 9);
        Mat colorImg = new Mat();
        Imgproc.bilateralFilter(edges, colorImg, 9, 250, 250);
        Mat cartoon = new Mat();
        Core.bitwise_and(colorImg, edges, cartoon);
        BufferedImage outBufferedImage = mat2Img(cartoon);
        active.setImage(outBufferedImage);
        active.update();
        addToHistory();
    }

    @Override
    public String toString() {
        return "Cartoon";
    }
}
