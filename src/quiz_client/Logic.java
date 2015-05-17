
package quiz_client;

import ConnectionHandler.*;
import java.rmi.RemoteException;

public class Logic {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private ServerConnection connection;
    
    public Logic() {
        try {
            connection = new ServerConnection();
        } catch (Exception e) {}
    }
    
    public String getQuestion() throws RemoteException {
        question = connection.nextQuestion();
        return question;
    }
    
    
    
    
}
