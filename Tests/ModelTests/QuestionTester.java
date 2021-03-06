package ModelTests;
import Model.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class QuestionTester {
    @Before
    public void setup (){
        tested = new Question("Question Description Test");
    }

    @Test
    //newly created question should appear as not answered
    public void answeredIsFalse (){
        Assert.assertFalse(tested.isAnswered());
    }

    public void answerTimeIsZero (){
        Assert.assertEquals("Answer time is not zero",0,tested.getAnswerTime());
    }
    Question tested;

}
