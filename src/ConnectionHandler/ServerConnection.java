package ConnectionHandler;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class ServerConnection {
    
    private QuestionInterface questionFactory;
    private QuizQuestion currentQuestion;
    
    public ServerConnection() throws RemoteException, NotBoundException{
        System.out.println("ServerConnection: Locate registry");
        Registry registry = LocateRegistry.getRegistry(9876);
        System.out.println("ServerConnection: new question factory");
        questionFactory = (QuestionInterface)registry.lookup("srv");
    }
    
    public String nextQuestion() throws RemoteException {
        System.out.println("ServerConnection: nextQuestion()");
        currentQuestion = questionFactory.getNewQuestion();
        return currentQuestion.getQuestion();
    };
    
    public ArrayList<String> getAnswers() {
        System.out.println("ServerConnection: getAnswers()");
        return currentQuestion.getAnswers();
    };
    
    public Boolean isCorrect(String answer) throws RemoteException {
	       System.out.println("ServerConnection: isCorrect()");
        return questionFactory.isCorrect(answer);
    }
    
    public String getCorrectAnswer() throws RemoteException {
        System.out.println("ServerConnection: getCorrectAnswer()");
        return questionFactory.getCorrectAnswer();
    }
    
}
