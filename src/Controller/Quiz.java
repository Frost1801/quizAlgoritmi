package Controller;

import Model.Question;

import java.util.*;

public class Quiz {
    //creates the quiz
    public Quiz(Vector<Question> questionVector){
        //sets current question as 0
        currentQuestionN = 0;
        totalQuizTime = 0;

        //loads the questions inside the map
        questions = new HashMap<>();
        for (int i = 0; i < questionVector.size(); i++){
            questions.put(i,questionVector.elementAt(i));
        }
        nOfQuestions = questions.size();

        //generates a random order to read the questions in
        order = new Integer[nOfQuestions];
        for (int i = 0; i < nOfQuestions; i++){
            order[i] = i;
        }
        order = shuffleArray(order);

    }

    //shuffles the array and returns it
    private static Integer[] shuffleArray (Integer [] array){
        List<Integer> tmp = Arrays.asList(array);
        Collections.shuffle(tmp);
        return tmp.toArray(array);
    }


    public void starQuiz (){
        currentQuestionN = 0;
        questionStartTime = System.currentTimeMillis();
    }

    public void questionForward (){
        if (currentQuestionN  < nOfQuestions - 1) {
            updateQuestionTime();
            currentQuestionN++;
        }
        else {
            throw new IndexOutOfBoundsException ("Tried to move question index over maximum index");
        }

    }

    public void questionBackward(){
        if (currentQuestionN>0){
            updateQuestionTime();
            currentQuestionN--;
        }
        else {
            throw new IndexOutOfBoundsException ("Tried to move question index under 0");
        }

    }

    //method called whenever switching questions
    private void updateQuestionTime(){
        //sets the finish time
        long questionFinishTime = System.currentTimeMillis();
        long additionalTime = questionFinishTime - questionStartTime; //calculates the difference between previous and final time
        long previousTime =  questions.get(order[currentQuestionN]).getAnswerTime();
        questions.get(order[currentQuestionN]).setAnswerTime(previousTime + additionalTime);
        totalQuizTime += additionalTime;
        questionStartTime = System.currentTimeMillis();
    }


    //getters and setters
    public Question getQuestionAt (int key){
        return questions.get(order[key]);
    }

    public int getNOfQuestions() {
        return nOfQuestions;
    }

    public long getTotalQuizTime() {
        return totalQuizTime;
    }

    public int getCurrentQuestionN() {
        return currentQuestionN;
    }

    public void setCurrentQuestionN(int currentQuestionN) {
        this.currentQuestionN = currentQuestionN;
    }

    public Integer[] getOrder() {
        return order;
    }

    //attributes

    private Integer [] order;
    private int currentQuestionN;
    private int nOfQuestions;
    private HashMap<Integer, Question> questions;

    //used to measure how much time it takes to
    long questionStartTime;
    long totalQuizTime;
}
