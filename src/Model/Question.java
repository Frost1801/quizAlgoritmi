package Model;

public class Question {
    //represents a question on the program
    public Question(String descr){
        description = descr;
        answerTime = 0;
        answered = false;
        correct = false;
    }

    //getters and setters
    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(long answerTime) {
        this.answerTime = answerTime;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    //attributes
    private String description;
    private long answerTime;
    private boolean answered;
    private boolean correct;
}
