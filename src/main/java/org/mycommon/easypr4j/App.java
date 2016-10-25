package org.mycommon.easypr4j;

import org.bytedeco.javacpp.opencv_core;
import org.mycommon.easypr4j.core.*;

import java.util.Vector;

import static org.bytedeco.javacpp.opencv_highgui.imread;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        testPlateRecognise();
//        testPlateDetect();
        testPlateLocate();
        testCharsRecognise();
        testColorDetect();
        testProjectedHistogram();
        testCharsIdentify();
    }


    public static void testPlateRecognise() {
        //String imgPath = "res/image/test_image/test.jpg";
        String imgPath = "res/image/test_image/plate_recognize.jpg";

        opencv_core.Mat src = imread(imgPath);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<opencv_core.Mat> matVector = new Vector<opencv_core.Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            CharsRecognise cr = new CharsRecognise();

            for (int i = 0; i < matVector.size(); ++i) {
                String result = cr.charsRecognise(matVector.get(i));
                System.out.println("Chars Recognised: " + result);
            }
        }
    }

    public static void testPlateDetect() {
        String imgPath = "res/image/test_image/test.jpg";

        opencv_core.Mat src = imread(imgPath);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<opencv_core.Mat> matVector = new Vector<opencv_core.Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            for (int i = 0; i < matVector.size(); ++i) {
                CoreFunc.showImage("Plate Detected", matVector.get(i));
            }
        }
    }

    public static void testPlateLocate() {
        String imgPath = "res/image/test_image/test.jpg";

        opencv_core.Mat src = imread(imgPath);

        PlateLocate plate = new PlateLocate();
        plate.setDebug(true);
        plate.setLifemode(true);

        Vector<opencv_core.Mat> resultVec = plate.plateLocate(src);

        int num = resultVec.size();
        for (int j = 0; j < num; j++) {
            // showImage("Plate Located " + j, resultVec.get(j));
        }

        return;
    }

    public static void testCharsRecognise() {
        String imgPath = "res/image/test_image/chars_recognise_huAGH092.jpg";

        opencv_core.Mat src = imread(imgPath);
        CharsRecognise cr = new CharsRecognise();
        cr.setCRDebug(true);
        String result = cr.charsRecognise(src);
        System.out.println("Chars Recognised: " + result);
    }

    public static void testColorDetect() {
        String imgPath = "res/image/test_image/core_func_yellow.jpg";

        opencv_core.Mat src = imread(imgPath);

        CoreFunc.Color color = CoreFunc.getPlateType(src, true);
        System.out.println("Color Deteted: " + color);
    }

    public static void testProjectedHistogram() {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        opencv_core.Mat src = imread(imgPath);
        CoreFunc.projectedHistogram(src, CoreFunc.Direction.HORIZONTAL);
    }

    public static void testCharsIdentify() {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        opencv_core.Mat src = imread(imgPath);
        CharsIdentify charsIdentify = new CharsIdentify();
        String result = charsIdentify.charsIdentify(src, false, true);
        System.out.println(result);
    }

}
