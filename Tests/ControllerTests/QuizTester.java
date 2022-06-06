package ControllerTests;

import Controller.Quiz;
import Model.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.lang.reflect.Executable;
import java.util.Vector;




public class QuizTester {
    public static final int ELEMENTS = 5;
    public static final int PAUSETIME = 100;

    @Before
    public void setup (){
        tested = new Quiz(generateQuestionVector(ELEMENTS));
    }
    public Vector<Question> generateQuestionVector (int n){
        Vector<Question> questionVector = new Vector<>();
        for (int i = 0; i < n;i++){
            questionVector.add(new Question(Integer.toString(i)));
        }
        return questionVector;
    }

    @Test
    public void questionConstructorWorks (){
        for (int i = 0; i < ELEMENTS; i++){
            Assert.assertFalse(tested.getQuestionAt(i).isAnswered());
            Assert.assertEquals("Question description initialization does not work in the constructor",tested.getOrder()[i].toString(),tested.getQuestionAt(i).getDescription());
        }
    }

    @Test
    public void checkQuestionSize (){
        Assert.assertEquals("Question size does not match elements of elements",ELEMENTS,tested.getNOfQuestions());
    }
    @Test
    public void totalTimeIsZero (){
        Assert.assertEquals("Quiz total time is not initialized correctly",0,tested.getTotalQuizTime());
    }
    @Test
    public void questionForwardUpdatesQuestionNumber () {
        tested.setCurrentQuestionN(0);
        tested.questionForward();
        Assert.assertEquals("Question forward does not update question number correctly",1,tested.getCurrentQuestionN() );
    }
    @Test
    public void questionBackwardUpdatesQuestionNumber () {
        tested.setCurrentQuestionN(1);
        tested.questionBackward();
        Assert.assertEquals("Question forward does not update question number correctly",0,tested.getCurrentQuestionN() );
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void questionForwardThrowsException (){
        tested.setCurrentQuestionN(ELEMENTS - 1);
        tested.questionForward();
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void questionBackwardThrowsExecption (){
        tested.setCurrentQuestionN(0);
        tested.questionBackward();
    }
    @Test
    public void questionTimeUpdateWorks () throws InterruptedException {
        tested.starQuiz();
        Thread.sleep(PAUSETIME);
        tested.questionForward();
        Assert.assertEquals("Answer time does not match",PAUSETIME,tested.getQuestionAt(0).getAnswerTime());
    }
    @Test
    public void quizTotalTimeUpdateWorks () throws InterruptedException {
        tested.starQuiz();
        Thread.sleep(PAUSETIME);
        tested.questionForward();
        Assert.assertEquals("Total time time does not match",PAUSETIME,tested.getTotalQuizTime());
    }
    @Test
    public void quizQuestionBackWorks ()throws InterruptedException{
        tested.starQuiz();
        Thread.sleep(PAUSETIME);
        tested.questionForward();
        Thread.sleep(PAUSETIME);
        tested.questionBackward();
        Thread.sleep(PAUSETIME);
        tested.questionForward();
        Assert.assertEquals("Answer time does not match",2*PAUSETIME,tested.getQuestionAt(0).getAnswerTime());
    }
    @Test
    public void quizPauseWorks () throws InterruptedException {
        tested.starQuiz();
        Thread.sleep(PAUSETIME);
        tested.pauseTimer();
        Thread.sleep(PAUSETIME);
        tested.startTimer();
        Thread.sleep(PAUSETIME);
        tested.pauseTimer();
        Assert.assertEquals("Answer time does not match",2*PAUSETIME,tested.getQuestionAt(0).getAnswerTime());
    }



    Quiz tested;
}
