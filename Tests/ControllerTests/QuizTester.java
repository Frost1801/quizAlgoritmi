package ControllerTests;

import Controller.Quiz;
import Model.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;



public class QuizTester {
    public static final int ELEMENTS = 5;

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
            Assert.assertEquals("Question description initialization does not work in the constructor",Integer.toString(i) ,tested.getQuestionAt(i).getDescription());
        }
    }

    @Test
    public void checkQuestionSize (){
        Assert.assertEquals("",ELEMENTS,tested.getNOfQuestions());
    }

    Quiz tested;
}
