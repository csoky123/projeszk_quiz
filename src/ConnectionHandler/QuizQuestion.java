package ConnectionHandler;

import java.io.Serializable;
import java.util.ArrayList;

public class QuizQuestion implements Serializable{
    private String question;
    private ArrayList<String> answers;

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
    
    public QuizQuestion(String q, ArrayList<String> answers) {
        question = q;
        this.answers = answers;
    }
    
    
}
