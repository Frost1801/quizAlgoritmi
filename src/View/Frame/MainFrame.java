package View.Frame;

import View.Colors;
import View.Panels.QuestionPanel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int WINDOW_HEIGHT = 900;
    private static final int WINDOW_WIDTH = 900;
    private static final String FRAME_TITLE = "Quiz Orale Algoritmi";
    private static final int BORDER_SIZE = 5;

    public MainFrame(){
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addColorBorder(this, Colors.BORDER.getColor());

        addQuestionPanel();

    }

    private void addColorBorder (JFrame destination, Color borderColor){
        MatteBorder matteBorder = new MatteBorder(MainFrame.BORDER_SIZE, MainFrame.BORDER_SIZE, MainFrame.BORDER_SIZE, MainFrame.BORDER_SIZE, borderColor);
        destination.getRootPane().setBorder(matteBorder);
    }

    public void addQuestionPanel(){
        questionPanel = new QuestionPanel();
        this.add(questionPanel,BorderLayout.CENTER);
    }

    QuestionPanel questionPanel;



}
