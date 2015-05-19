package ConnectionHandler;

import java.util.ArrayList;

public class QuizQuestion{
    private final String question;
    private final ArrayList<String> answers;

    
    /**
     * A függvény visszaadja a jelenlegi kérdést.
     * @return A kérédés String
     */
    public String getQuestion() {
        return question;
    }

    /**
     * A függvény visszaadja a jelenlegi lehetséges válaszokat.
     * @return A válaszok egy ArrayList<String> objektumban
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }
    
    /**
     * Konstruktor, mely egy kérdésből es 
     * a válaszokat tartalmazó ArrayListből példányosít egy QuizQuestion objektumot
     * @param q A kérdés
     * @param answers A válaszok
     */
    public QuizQuestion(String q, ArrayList<String> answers) {
        question = q;
        this.answers = answers;
    }
    
    
}
