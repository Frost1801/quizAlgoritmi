package View;

import View.Panels.TestPanel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class GUI {
    private static final int WINDOW_HEIGHT = 900;
    private static final int WINDOW_WIDTH = 900;
    private static final String FRAME_TITLE = "Quiz Orale Algoritmi";



    public GUI (){
        mainFrame = createMainFrame();


        addTestFrame();


        mainFrame.setVisible(true);


    }

    private JFrame createMainFrame (){
        JFrame toReturn = new JFrame();
        toReturn.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        toReturn.setResizable(false);
        toReturn.setLocationRelativeTo(null);
        toReturn.setTitle(FRAME_TITLE);
        toReturn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addColorBorder(toReturn,Colors.BORDER.getColor(),5);
        return toReturn;
    }

    private void addColorBorder (JFrame destination, Color borderColor, int size){
        MatteBorder matteBorder = new MatteBorder(size, size, size, size, borderColor);
        destination.getRootPane().setBorder(matteBorder);
    }

    public void addTestFrame (){
        testPanel = new TestPanel();
        mainFrame.add(testPanel);
    }



    JFrame mainFrame;
    TestPanel testPanel;
}
