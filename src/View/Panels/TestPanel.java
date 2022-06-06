package View.Panels;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel{

    public TestPanel (){
        testPanelHolder = new JPanel();
        addSurfacePanels();
        testPanelHolder.setVisible(true);
    }

    private void addSurfacePanels (){
        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        addTemporaryColors();

        testPanelHolder.add(topPanel, BorderLayout.NORTH);
        testPanelHolder.add(centerPanel,BorderLayout.CENTER);
        testPanelHolder.add(bottomPanel,BorderLayout.SOUTH);



    }

    //TODO temporary colors to understand che cazzo sta succedendo
    private void addTemporaryColors (){
        topPanel.setBackground(Color.blue);
        centerPanel.setBackground(Color.MAGENTA);
        bottomPanel.setBackground(Color.green);
    }


    private JPanel testPanelHolder;

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
