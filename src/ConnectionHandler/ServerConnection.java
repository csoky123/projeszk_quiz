package ConnectionHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerConnection {
    
    private QuizQuestion currentQuestion;

    final String IP = "localhost";
    final int PORT = 4567;
    Socket s;
    Scanner sc;
    PrintWriter pw;

    /**
     * Az osztály kezeli a szerverrel a kapcsolatot.
     * TCP kapcsolatot tart fent.
     * @throws IOException Sikertelen írás/olvasás esetén dobja.
     */
    public ServerConnection() throws IOException {
        s = new Socket(IP, PORT);
        sc = new Scanner(s.getInputStream());
        pw = new PrintWriter(s.getOutputStream());
    }
    
    /**
     * Új kérdést generáltat a szerverrel.
     * @return Az új kérdés
     */
    public String nextQuestion() {
        //System.out.println("ServerConnection: nextQuestion()");
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
    
    /**
     * A jelenlegi kérdésre adható válaszokat adja vissza
     * @return A válaszok egy ArrayList objektumban
     */
    public ArrayList<String> getAnswers() {
        //System.out.println("ServerConnection: getAnswers()");
        return currentQuestion.getAnswers();
    };
    
    /**
     * A paraméterként kapott választ továbbítja a szervernek és megmondja, hogy helyes-e.
     * @param answer A válasz, melynek helyességét ellenőrzi.
     * @return Igaz, ha helyes, hamis, ha nem.
     */
    public Boolean isCorrect(String answer) {
	//System.out.println("ServerConnection: isCorrect()");
        pw.println("isCorrect");
        pw.println(answer);
        pw.flush();
        return sc.nextInt() == 1;
    }
    
    /**
     * Visszaadja a jelenlegi kérdésre a helyes választ.
     * @return A helyes válasz.
     */
    public String getCorrectAnswer() {
        //System.out.println("ServerConnection: getCorrectAnswer()");
        pw.println("getCorrectAnswer");
        pw.flush();
        return sc.nextLine();
    }
    
    /**
     * Lezárja a kapcsolatot a szerver felé.
     * @throws IOException 
     */
    public void quit() throws IOException {
        pw.println("quit");
        pw.flush();
        s.close();
    }
}
