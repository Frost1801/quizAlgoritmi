package Controller;

import Model.Question;

import java.util.*;

public class Quiz {
    //creates the quiz
    public Quiz(Vector<Question> questionVector){
        //sets current question as 0
        currentQuestion = 0;

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

    //getters and setters
    public Question getQuestionAt (int key){
        return questions.get(key);
    }

    public int getNOfQuestions() {
        return nOfQuestions;
    }


    //attributes

    private Integer [] order;
    private int currentQuestion;
    private int nOfQuestions;
    private HashMap<Integer, Question> questions;
}
