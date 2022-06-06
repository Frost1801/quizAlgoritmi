package View.Frame;

import Controller.Quiz;
import View.Colors;
import View.Panels.QuestionPanel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int WINDOW_HEIGHT = 900;
    public static final int WINDOW_WIDTH = 900;
    private static final String FRAME_TITLE = "Quiz Orale Algoritmi";
    private static final int BORDER_SIZE = 5;

    public MainFrame(Quiz managed){
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(FRAME_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.managed = managed;

        addColorBorder(this, Colors.BORDER.getColor());

        addQuestionPanel();

    }


    //adds a colored border to the destination frame
    private void addColorBorder (JFrame destination, Color borderColor){
        MatteBorder matteBorder = new MatteBorder(MainFrame.BORDER_SIZE, MainFrame.BORDER_SIZE, MainFrame.BORDER_SIZE, MainFrame.BORDER_SIZE, borderColor);
        destination.getRootPane().setBorder(matteBorder);
    }

    //creates and adds a QuestionPanel to the frame
    public void addQuestionPanel(){
        questionPanel = new QuestionPanel(managed);
        this.add(questionPanel,BorderLayout.CENTER);
    }

    QuestionPanel questionPanel;
    Quiz managed;



}
