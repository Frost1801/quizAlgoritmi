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
    private final int MEDIUM_GRID_LEFT_SPACING = 175;
    private final int GRID_BOTTOM_SPACING = 10;
    private final int MEDIUM_GRID_RIGHT_SPACING = 175;

    private final int BIG_GRID_LEFT_SPACING = 375;
    private final int BIG_GRID_RIGHT_SPACING = 375;
    private final int SMALL_GRID_LEFT_SPACING = 50;
    private final int SMALL_GRID_RIGHT_SPACING = 50;


    private final String PLAY_IMG_PATH = "/res/img/play.png";
    private final String PAUSE_IMG_PATH = "/res/img/pause.png";

    private final String LEFT_IMG_PATH = "/res/img/left-arrow.png";
    private final String RIGHT_IMG_PATH = "/res/img/right-arrow.png";
    private final String CHECK_IMG_PATH = "/res/img/check.png";
    private final String REMOVE_IMG_PATH = "/res/img/remove.png";
    private final double ICONS_RATIO = 0.5;

    private final String howToAnswerText = "Scegli la spunta se sapresti rispondere, la croce se non sapresti rispondere";
    private final String terminateQuizText = "Termina il Quiz";

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
        timeIndicationHolder = new JPanel(new GridBagLayout());
        navigationButtonsHolder = new JPanel(new GridBagLayout());
        pageIndicationNumbersHolder = new JPanel(new GridBagLayout());


        addTitle();
        addTimeIndicationHolderElements();
        addCenterPanelElements();
        addNavigationButtons();


        topPanel.add(timeIndicationHolder,BorderLayout.SOUTH);
        centerPanel.add(pageIndicationNumbersHolder,BorderLayout.SOUTH);
        bottomPanel.add(navigationButtonsHolder,BorderLayout.CENTER);
    }

    //adds title to the topPanel
    private void addTitle (){
        title = GUIElementsFactory.createStandardLabel(QUIZ_TITLE, Colors.TITLE.getColor(),GUIElementsFactory.TITLE_SIZE,true);
        topPanel.add(title,BorderLayout.CENTER);
    }

    //loads all the parts of time indication panel
    private void addTimeIndicationHolderElements (){
        addQuestionElapsedTime();
        addTotalElapsedTime();
        addPauseResumeButton();

    }
    private void addCenterPanelElements (){
        addQuestionText();
        addAnsweredNumber();
        addCurrentToTotal();
    }

    private void addNavigationButtons (){
        addHowToAnswer();
        addPreviousQuestion();
        addCheck();
        addXButton();
        addNextQuestion();
        addTerminateQuiz();
    }


    //TOP PANEL METHODS

    //adds elapsed question time label
    private void addQuestionElapsedTime  (){
        questionElapsedTime = GUIElementsFactory.createStandardLabel("0:19",Colors.TEXT.getColor(), GUIElementsFactory.MEDIUM_TEXT_SIZE,false);
        timeIndicationHolder.add(questionElapsedTime,GUIElementsFactory.createGridBagConstraint(0,0,GRID_TOP_SPACING, MEDIUM_GRID_LEFT_SPACING,GRID_BOTTOM_SPACING, MEDIUM_GRID_RIGHT_SPACING));
    }

    //adds pause/resume
    private void addPauseResumeButton (){
        pauseResume = GUIElementsFactory.createJButtonWithImage(PAUSE_IMG_PATH,Colors.BUTTON.getColor(), ICONS_RATIO);
        timeIndicationHolder.add(pauseResume,GUIElementsFactory.createGridBagConstraint(1,0,GRID_TOP_SPACING, MEDIUM_GRID_LEFT_SPACING,GRID_BOTTOM_SPACING, MEDIUM_GRID_RIGHT_SPACING));
        pauseResume.addActionListener(this);
        loadPausePlayIcons();
    }
    //adds total time JLabel
    private void addTotalElapsedTime(){
        totalElapsedTime = GUIElementsFactory.createStandardLabel("3:24",Colors.TEXT.getColor(), GUIElementsFactory.MEDIUM_TEXT_SIZE,false);
        timeIndicationHolder.add(totalElapsedTime,GUIElementsFactory.createGridBagConstraint(2,0,GRID_TOP_SPACING, MEDIUM_GRID_LEFT_SPACING,GRID_BOTTOM_SPACING, MEDIUM_GRID_RIGHT_SPACING));
    }
    //saves play/pause icons to avoid loading them every time
    private void loadPausePlayIcons (){
        playIcon = GUI.getFixedDimensionImage(PLAY_IMG_PATH, ICONS_RATIO);
        pauseIcon = GUI.getFixedDimensionImage(PAUSE_IMG_PATH, ICONS_RATIO);
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


    //CENTER PANEL METHODS
    private void addQuestionText (){
        String questionDescription = managed.getQuestionAt(managed.getCurrentQuestionN()).getDescription();
        questionText = GUIElementsFactory.createStandardLabel(questionDescription,Colors.TEXT.getColor(),GUIElementsFactory.MEDIUM_TEXT_SIZE,true);
        centerPanel.add(questionText,BorderLayout.CENTER);
    }

    private void addAnsweredNumber (){
        int number = managed.getAnswered();
        answered = GUIElementsFactory.createStandardLabel(Integer.toString(number),Colors.TEXT.getColor(),GUIElementsFactory.MEDIUM_TEXT_SIZE,false);
        GridBagConstraints gbc = GUIElementsFactory.createGridBagConstraint(0,0,GRID_TOP_SPACING, BIG_GRID_LEFT_SPACING,GRID_BOTTOM_SPACING, BIG_GRID_RIGHT_SPACING);
        pageIndicationNumbersHolder.add(answered,gbc);
    }

    private void addCurrentToTotal (){
        int current = managed.getCurrentQuestionN();
        int total = managed.getNOfQuestions();
        String combined = current + "/" + total;
        currentToTotal = GUIElementsFactory.createStandardLabel(combined,Colors.TEXT.getColor(),GUIElementsFactory.MEDIUM_TEXT_SIZE,false);
        GridBagConstraints gbc = GUIElementsFactory.createGridBagConstraint(1,0,GRID_TOP_SPACING, BIG_GRID_LEFT_SPACING,GRID_BOTTOM_SPACING, BIG_GRID_RIGHT_SPACING);
        pageIndicationNumbersHolder.add(currentToTotal,gbc);
    }

    //BOTTOM PANEL METHODS
    private void addHowToAnswer (){
        howToAnswer = GUIElementsFactory.createStandardLabel(howToAnswerText,Colors.TEXT.getColor(), GUIElementsFactory.MEDIUM_TEXT_SIZE,true);
        bottomPanel.add(howToAnswer,BorderLayout.NORTH);
    }


    private void addPreviousQuestion () {
        leftButton = GUIElementsFactory.createJButtonWithImage(LEFT_IMG_PATH,Colors.BUTTON.getColor(),ICONS_RATIO);
        GridBagConstraints gbc = GUIElementsFactory.createGridBagConstraint(0,0,GRID_TOP_SPACING, SMALL_GRID_LEFT_SPACING,GRID_BOTTOM_SPACING, SMALL_GRID_RIGHT_SPACING);
        navigationButtonsHolder.add(leftButton,gbc);
    }
    private void addNextQuestion () {
        rightButton = GUIElementsFactory.createJButtonWithImage(RIGHT_IMG_PATH,Colors.BUTTON.getColor(),ICONS_RATIO);
        GridBagConstraints gbc = GUIElementsFactory.createGridBagConstraint(3,0,GRID_TOP_SPACING, SMALL_GRID_LEFT_SPACING,GRID_BOTTOM_SPACING, SMALL_GRID_RIGHT_SPACING);
        navigationButtonsHolder.add(rightButton,gbc);
    }
    private void addCheck () {
        check = GUIElementsFactory.createJButtonWithImage(CHECK_IMG_PATH,Colors.BUTTON.getColor(),ICONS_RATIO);
        GridBagConstraints gbc = GUIElementsFactory.createGridBagConstraint(1,0,GRID_TOP_SPACING, SMALL_GRID_LEFT_SPACING,GRID_BOTTOM_SPACING, 0);
        navigationButtonsHolder.add(check,gbc);
    }
    private void addXButton () {
        x_button = GUIElementsFactory.createJButtonWithImage(REMOVE_IMG_PATH,Colors.BUTTON.getColor(),ICONS_RATIO);
        GridBagConstraints gbc = GUIElementsFactory.createGridBagConstraint(2,0,GRID_TOP_SPACING, 0,GRID_BOTTOM_SPACING, SMALL_GRID_RIGHT_SPACING);
        navigationButtonsHolder.add(x_button,gbc);
    }
    private void addTerminateQuiz (){
        terminateQuiz = GUIElementsFactory.createJButtonWithText(terminateQuizText,Colors.BUTTON.getColor());
        GridBagConstraints gbc = GUIElementsFactory.createGridBagConstraint(1,1,GRID_TOP_SPACING, SMALL_GRID_LEFT_SPACING,GRID_BOTTOM_SPACING, SMALL_GRID_RIGHT_SPACING);
        gbc.gridwidth = 2; 
        navigationButtonsHolder.add(terminateQuiz,gbc);
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


    private JButton leftButton;
    private JButton rightButton;
    private JButton check;
    private JButton x_button;
    private JButton pauseResume;
    private JButton terminateQuiz;

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
