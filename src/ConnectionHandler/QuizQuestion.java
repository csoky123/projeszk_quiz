package ConnectionHandler;

import java.util.ArrayList;

public class QuizQuestion{
    private final String question;
    private final ArrayList<String> answers;

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
