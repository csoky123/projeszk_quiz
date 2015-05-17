
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
    
    public String getQuestion() throws RemoteException {
        question = connection.nextQuestion();
        return question;
    }
    
    public ArrayList<String> getAnswers() throws RemoteException {
        answers = connection.getAnswers();
        return answers;
    }
    
    
    
    
}
