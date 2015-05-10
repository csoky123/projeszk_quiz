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
        Registry registry = LocateRegistry.getRegistry(9876);
        questionFactory = (QuestionInterface)registry.lookup("srv");
    }
    
    public String nextQuestion() throws RemoteException {
        currentQuestion = questionFactory.getNewQuestion();
        return currentQuestion.getQuestion();
    };
    
    public ArrayList<String> getAnswers() {
        return currentQuestion.getAnswers();
    };
    
    public Boolean isCorrect(String answer) throws RemoteException {
	return questionFactory.isCorrect(answer);
    }
    
    public String getCorrectAnswer() throws RemoteException {
        return questionFactory.getCorrectAnswer();
    }
}
