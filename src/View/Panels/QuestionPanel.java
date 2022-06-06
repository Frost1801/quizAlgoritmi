package View.Panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class QuestionPanel extends JPanel{

    public QuestionPanel(){
        this.setLayout(new BorderLayout());
        addSurfacePanels();
        this.setVisible(true);
    }

    private void addSurfacePanels (){
        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        addTemporaryColors();



        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(bottomPanel,BorderLayout.SOUTH);

        setSurfacePanelsVisible(true);


    }

    //TODO temporary colors to understand che cazzo sta succedendo
    private void addTemporaryColors (){
        topPanel.setBackground(Color.blue);
        centerPanel.setBackground(Color.MAGENTA);
        bottomPanel.setBackground(Color.green);
    }

    private void setSurfacePanelsVisible (boolean visible){
        topPanel.setVisible(visible);
        centerPanel.setVisible(visible);
        bottomPanel.setVisible(visible);
    }


    private JButton previousQuestion;
    private JButton nextQuestion;
    private JButton correct;
    private JButton wrong;
    private JButton pauseResume;

    private JLabel answered;
    private JLabel currentToTotal;
    private JLabel questionElapsedTime;
    private JLabel totalElapsedTime;

    private JLabel title;
    private JLabel howToAnswer;
    private JLabel questionText;

    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

    private JPanel navigationButtonsHolder;
    private JPanel pageIndicationNumbersHolder;
    private JPanel timeIndicationHolder;


}
