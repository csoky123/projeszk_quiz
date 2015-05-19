
package quiz_client;

import ConnectionHandler.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import quiz_client.gui.MainFrame;

public class Logic {

    private String question;
    private ArrayList<String> answers = new ArrayList<>();
    private ServerConnection connection;
    private MainFrame gui;
    /**
     * A Logic osztályt pédányosítani egy gui osztály segítségével lehet.
     * <p>
     * Létrehozza a kapcsolatot a szerverrel.
     * @param gui MainFrame példány
     * @throws Exception IOException
     */
    public Logic(MainFrame gui) throws Exception{
        System.out.println("Logic: try server connection");
        connection = new ServerConnection();
        this. gui = gui;
    }
    
    public void newQuestionRequest() throws RemoteException{
        System.out.println("Logic: newQuestionRequest() - req new questions from srv");
        getQuestion();
        getAnswers();
        System.out.println("Logic: newQuestionRequest() - send new question to GUI");
        setQuestionGUI();
    }
    
    public void setQuestionGUI() {
        gui.setNewQuestion(question, answers);
        System.out.println("Logic: sent new question to GUI\n");
    }
    
    public String getQuestion() throws RemoteException {
        question = connection.nextQuestion();
        System.out.println("Logic: new question requested from server\n");
        return question;
    }
    
    public ArrayList<String> getAnswers() throws RemoteException {
        answers = connection.getAnswers();
        Collections.shuffle(answers);
        System.out.println("Logic: new answers requested from server\n");
        return answers;
    }
    
    public boolean correctAnswer(int i) throws RemoteException {
        if(answers.get(i).equals(connection.getCorrectAnswer())==true)
            return true;
        else return false;
    }
    
}
