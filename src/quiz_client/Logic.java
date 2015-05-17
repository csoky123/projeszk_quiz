
package quiz_client;

import ConnectionHandler.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import quiz_client.gui.MainFrame;

public class Logic {

    private String question;
    private ArrayList<String> answers = new ArrayList<>();
    private ServerConnection connection;
    private MainFrame gui;
    
    public Logic(MainFrame gui) {
        try {
            connection = new ServerConnection();
        } catch (Exception e) {}
        this. gui = gui;
    }
    
    public void newQuestionRequest() throws RemoteException{
        getQuestion();
        getAnswers();
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
        System.out.println("Logic: new answers requested from server\n");
        return answers;
    }
    
    public boolean correctAnswer(int i) throws RemoteException {
        if(answers.get(i).equals(connection.getCorrectAnswer())==true)
            return true;
        else return false;
    }
    
    
}
