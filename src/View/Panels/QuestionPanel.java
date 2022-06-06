package View.Panels;

import Controller.Quiz;
import View.Colors;
import View.Frame.GUIElementsFactory;
import View.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionPanel extends JPanel implements ActionListener {
    private final String QUIZ_TITLE = "Unofficial ASD Quiz";

    private final int GRID_TOP_SPACING = 10;
    private final int GRID_LEFT_SPACING = 175;
    private final int GRID_BOTTOM_SPACING = 10;
    private final int GRID_RIGHT_SPACING = 175;

    private final String PLAY_IMG_PATH = "/res/img/play.png";
    private final String PAUSE_IMG_PATH = "/res/img/pause.png";
    private final double PLAY_PAUSE_RATIO = 0.5;

    public QuestionPanel(Quiz managed){
        this.managed = managed;
        setLayout(new BorderLayout());
        addFirstLevelPanels();
        addSecondLevelPanels();

        setVisible(true);


    }

    //adds first level panels to the questionPanel
    private void addFirstLevelPanels(){
        topPanel = new JPanel(new BorderLayout());
        centerPanel = new JPanel(new BorderLayout());
        bottomPanel = new JPanel(new BorderLayout());

        addTemporaryColors();



        add(topPanel, BorderLayout.NORTH);

        add(centerPanel,BorderLayout.CENTER);

        add(bottomPanel,BorderLayout.SOUTH);

    }
    //adds second level panels
    private void addSecondLevelPanels (){
        navigationButtonsHolder = new JPanel(new GridBagLayout());
        pageIndicationNumbersHolder = new JPanel(new GridBagLayout());
        timeIndicationHolder = new JPanel(new GridBagLayout());

        addTitle();
        addTimeIndicationHolderElements();


        topPanel.add(timeIndicationHolder,BorderLayout.SOUTH);
    }

    //adds title to the topPanel
    private void addTitle (){
        title = GUIElementsFactory.createStandardLabel(QUIZ_TITLE, Colors.TITLE.getColor(),GUIElementsFactory.TITLE_SIZE);
        title.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(title,BorderLayout.CENTER);
    }

    //loads all the parts of time indication panel
    private void addTimeIndicationHolderElements (){
        addQuestionElapsedTime();
        addTotalElapsedTime();
        addPauseResumeButton();

    }
    //adds elapsed question time label
    private void addQuestionElapsedTime  (){
        questionElapsedTime = GUIElementsFactory.createStandardLabel("0:19",Colors.TEXT.getColor(), GUIElementsFactory.MEDIUM_TEXT_SIZE);
        timeIndicationHolder.add(questionElapsedTime,GUIElementsFactory.createGridBagConstraint(0,0,GRID_TOP_SPACING,GRID_LEFT_SPACING,GRID_BOTTOM_SPACING,GRID_RIGHT_SPACING));
    }

    //adds pause/resume
    private void addPauseResumeButton (){
        pauseResume = GUIElementsFactory.createJButtonWithImage(PAUSE_IMG_PATH,Colors.BUTTON.getColor(),PLAY_PAUSE_RATIO);
        timeIndicationHolder.add(pauseResume,GUIElementsFactory.createGridBagConstraint(1,0,GRID_TOP_SPACING,GRID_LEFT_SPACING,GRID_BOTTOM_SPACING,GRID_RIGHT_SPACING));
        pauseResume.addActionListener(this);
        loadPausePlayIcons();
    }
    //adds total time JLabel
    private void addTotalElapsedTime(){
        totalElapsedTime = GUIElementsFactory.createStandardLabel("3:24",Colors.TEXT.getColor(), GUIElementsFactory.MEDIUM_TEXT_SIZE);
        timeIndicationHolder.add(totalElapsedTime,GUIElementsFactory.createGridBagConstraint(2,0,GRID_TOP_SPACING,GRID_LEFT_SPACING,GRID_BOTTOM_SPACING,GRID_RIGHT_SPACING));
    }
    //saves play/pause icons to avoid loading them every time
    private void loadPausePlayIcons (){
        playIcon = GUI.getFixedDimensionImage(PLAY_IMG_PATH,PLAY_PAUSE_RATIO);
        pauseIcon = GUI.getFixedDimensionImage(PAUSE_IMG_PATH,PLAY_PAUSE_RATIO);
    }
    //whenever the play/pause button is pressed toggles the icon
    private void togglePlayPauseIcon (){
        if (managed.isPaused()){
            pauseResume.setIcon(playIcon);
        }
        else {
            pauseResume.setIcon(pauseIcon);
        }
    }




    //helper colors
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

    //saving the icon to avoid loading it every time play/pause button is pressed
    private ImageIcon pauseIcon;
    private ImageIcon playIcon;

    private Quiz managed;
    @Override
    public void actionPerformed(ActionEvent e) {

        //handles the clicking of the play/pause button
        if (e.getSource() == pauseResume ){
            if (managed.isPaused()){
                managed.startTimer();
                togglePlayPauseIcon();
            }
            else {
                managed.pauseTimer();
                togglePlayPauseIcon();
            }
        }
    }
}
