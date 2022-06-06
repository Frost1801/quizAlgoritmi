package View.Panels;

import View.Colors;
import View.Frame.GUIElementsFactory;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel{
    private final String QUIZ_TITLE = "Unofficial ASD Quiz";


    public QuestionPanel(){

        setLayout(new BorderLayout());
        addFirstLevelPanels();
        addTitle();

        setVisible(true);


    }

    //adds first level panels to the questionPanel
    private void addFirstLevelPanels(){
        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        addTemporaryColors();



        add(topPanel, BorderLayout.NORTH);

        add(centerPanel,BorderLayout.CENTER);

        add(bottomPanel,BorderLayout.SOUTH);

    }
    //adds second level panels
    private void addSecondLevelPanels (){
        navigationButtonsHolder = new JPanel(new GridBagLayout());
        pageIndicationNumbersHolder = new JPanel();
        timeIndicationHolder = new JPanel();
    }

    //adds title to the topPanel
    private void addTitle (){
        title = GUIElementsFactory.createStandardLabel(QUIZ_TITLE, Colors.TITLE.getColor(),GUIElementsFactory.TITLE_SIZE);
        topPanel.add(title);
    }

    private void addCurrentQuestionTimer  (){
        questionElapsedTime = GUIElementsFactory.createStandardLabel("0:19",Colors.TEXT.getColor(), GUIElementsFactory.MEDIUM_TEXT_SIZE);
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

    //first level panels
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

    // second level panels
    private JPanel navigationButtonsHolder;
    private JPanel pageIndicationNumbersHolder;
    private JPanel timeIndicationHolder;


}
