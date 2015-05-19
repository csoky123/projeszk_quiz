
package quiz_client;

import ConnectionHandler.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import quiz_client.gui.MainFrame;
import java.io.*;

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
    
    /**
     * Meghívja a getQuestion és a getAnswers függvényeket.
     * Meghívja a setQuestionGUI függvényt.
     * @throws IOException 
     */
    public void newQuestionRequest() throws IOException{
        System.out.println("Logic: newQuestionRequest() - req new questions from srv");
        getQuestion();
        getAnswers();
        System.out.println("Logic: newQuestionRequest() - send new question to GUI");
        setQuestionGUI();
    }
    /**
     * Logic elküldi a lekérdezett kérdést és válaszokat a guinak.
     */
    public void setQuestionGUI() {
        gui.setNewQuestion(question, answers);
        System.out.println("Logic: sent new question to GUI\n");
    }
    
    /**
     * Lekér a szervertől egy kérdést.
     * @return a kérdés String-ként
     * @throws IOException 
     */
    public String getQuestion() throws IOException {
        question = connection.nextQuestion();
        System.out.println("Logic: new question requested from server\n");
        return question;
    }
    
    /**
     * Lekéri a szervertől a válaszokat. A lekért válaszokat random sorrendbe rakja.
     * @return a random sorrendbe rendezett válaszok egy ArrayList-ben tárolva
     * @throws IOException 
     */
    public ArrayList<String> getAnswers() throws IOException {
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
