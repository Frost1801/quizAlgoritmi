package View;

import Controller.MyReader;
import Controller.Quiz;
import Model.Question;
import View.Frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;

import static View.Frame.MainFrame.WINDOW_HEIGHT;


public class GUI {

    public static String GENERAL_FONT = "Dialog";
    public static Double IMAGE_RESIZE_RATIO = 0.5;

    private static String TEXT_FILE_PATH = "/res/text/textSource.txt";

    public GUI () throws IOException {
        createQuiz();
        mainFrame = new MainFrame(managed);

        mainFrame.setVisible(true);


    }

    //returns an image ad JLabel of the correct size
    public static JLabel fitPicToFrame(String path, int windowHeight, double ratio){
        JLabel tmp = new JLabel();
        int width;
        int height;
        MyReader rd = new MyReader();
        BufferedImage img = rd.readImage(path);
        assert img != null;

        width = img.getWidth();
        height = img.getHeight();
        if (ratio == 0)
            ratio = findRatio(height,windowHeight);
        width *= ratio;
        height *= ratio;
        tmp.setSize(width,height);
        return tmp;
    }
    //FIXME rework the ratio
    private static double findRatio(int height, int windowHeight){
        int previous = height;
        int desiredHeight = (int) (windowHeight * IMAGE_RESIZE_RATIO);
        while (height > desiredHeight)
            height *= IMAGE_RESIZE_RATIO;
        return height/(double)previous;
    }

    public static ImageIcon getFixedDimensionImage (String path, double ratio){
        JLabel tmp = fitPicToFrame(path, WINDOW_HEIGHT,ratio);
        //image inserted
        MyReader rd = new MyReader();
        BufferedImage bufferedImage = rd.readImage(path);
        return new ImageIcon(new ImageIcon(bufferedImage).getImage().getScaledInstance(tmp.getWidth(), tmp.getHeight(), Image.SCALE_DEFAULT));
    }

    //FIXME non sono sicuro che vada bene avere questo metodo qua
    private void createQuiz () throws IOException {
        Vector<String> tmp = new Vector<>();
        MyReader rd = new MyReader();
        rd.readTxtFile(TEXT_FILE_PATH,tmp);
        Vector<Question> questionVector = new Vector<>();
        for (String st: tmp){
            questionVector.add(new Question(st));
        }
        managed = new Quiz(questionVector);
    }


    MainFrame mainFrame;
    Quiz managed;

}
