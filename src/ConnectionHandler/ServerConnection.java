package ConnectionHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerConnection extends Thread {
    
    private QuizQuestion currentQuestion;

    final String IP = "localhost";
    final int PORT = 4567;
    Socket s;
    Scanner sc;
    PrintWriter pw;

    
    public ServerConnection() throws IOException {
        s = new Socket(IP, PORT);
        sc = new Scanner(s.getInputStream());
        pw = new PrintWriter(s.getOutputStream());
    }
    
    public String nextQuestion() {
        System.out.println("ServerConnection: nextQuestion()");
        pw.println("new");
        pw.println("getQuestion");
        pw.flush();
        
        String question = sc.nextLine();
        ArrayList<String> answers = new ArrayList();
        answers.add(sc.nextLine());
        answers.add(sc.nextLine());
        answers.add(sc.nextLine());
        answers.add(sc.nextLine());
        
        currentQuestion = new QuizQuestion(question, answers);
        return currentQuestion.getQuestion();
    };
    
    public ArrayList<String> getAnswers() {
        System.out.println("ServerConnection: getAnswers()");
        return currentQuestion.getAnswers();
    };
    
    public Boolean isCorrect(String answer) {
	System.out.println("ServerConnection: isCorrect()");
        pw.println("isCorrect");
        pw.println(answer);
        pw.flush();
        return sc.nextInt() == 1;
    }
    
    public String getCorrectAnswer() {
        System.out.println("ServerConnection: getCorrectAnswer()");
        pw.println("getCorrectAnswer");
        pw.flush();
        return sc.nextLine();
    }
    
}
