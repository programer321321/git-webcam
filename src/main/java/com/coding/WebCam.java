package com.coding;




import com.github.sarxos.webcam.Webcam;
import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.jcodec.api.SequenceEncoder;
import org.jcodec.api.awt.*;
import org.jcodec.common.Codec;
import org.jcodec.common.Format;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rational;
import org.jcodec.scale.AWTUtil;
import org.jcodec.common.io.SeekableByteChannel;

import javax.imageio.ImageIO;
import java.awt.*;
import org.jcodec.common.model.ColorSpace;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class WebCam {
    String path = "C:\\Users\\acer\\Desktop\\Images\\frame.jpg";
    File file = new File(path);
    int codec = avcodec.AV_CODEC_ID_H264;
    Webcam camera = Webcam.getDefault();
    FFmpegFrameRecorder videoRecording;
    Java2DFrameConverter fileConverter = new Java2DFrameConverter();
    Method math = new Method();
    int first = 0;
    public WebCam() {

    }
    public void video(ArrayList<BufferedImage> captures, String outputFile) throws IOException {
        BufferedImage image = captures.get(first);
        videoRecording = new FFmpegFrameRecorder(outputFile, image.getWidth(), image.getHeight());
        videoRecording.setVideoCodec(codec);
        videoRecording.setFormat(".mp4");
        videoRecording.setFrameRate(math.fps(1000));
        videoRecording.start();
        for(BufferedImage capture : captures)
            videoRecording.record(fileConverter.convert(capture));
        videoRecording.stop();
        videoRecording.release();
        System.out.println("video doen check");
    }
    public void begin() {
        camera.open();
    }
    public void saveFrame() {
        try {
            camera.open();
            ImageIO.write(camera.getImage(), "JPG", file);
        }
        catch(IOException cam) {
            cam.printStackTrace();
        }
    }
    public Image getImage() {
        return camera.getImage();
    }
    public String getFrame() {
        return "C:\\Users\\acer\\Desktop\\Images\\frame.jpg";
    }
}
