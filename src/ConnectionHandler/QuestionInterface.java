package ConnectionHandler;

import java.rmi.RemoteException;

public interface QuestionInterface extends java.rmi.Remote{
    public QuizQuestion getNewQuestion() throws RemoteException;
    public Boolean isCorrect(String answer) throws RemoteException;
    public String getCorrectAnswer() throws RemoteException;
}
