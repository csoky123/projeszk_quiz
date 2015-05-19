/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import quiz_client.Logic;

/**
 *
 * @author Vuk
 */
public class MainFrame extends JFrame {
    
    private int selectedAnswer = 0;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private String correctAns = "";
    private QuizButton buttonA = new QuizButton("answer A", 0);
    private QuizButton buttonB = new QuizButton("answer B", 1);
    private QuizButton buttonC = new QuizButton("answer C", 2);
    private QuizButton buttonD = new QuizButton("answer D", 3);
    private ArrayList<QuizButton> buttons = new ArrayList<>();
    private JLabel questionLabel = new JLabel("Question?");
    private JLabel statsLabel = new JLabel("<html><font size=\"6\" color=\"green\">Correct: " + correctAnswers + "      </font><font size=\"6\" color=\"red\">Incorrect: " + incorrectAnswers + "</font></html>" );
    
    
    private Logic logic;
    
    /**
     * Az A válaszgomb ActionListener-je, lekéri a logikától helyes-e a válasz,
     * továbbá az eredményt kiértékelésre küldi.
     */
    private final ActionListener answerListenerA = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click A!");
            selectedAnswer = 0;
            try {
                result(logic.correctAnswer(0));
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    /**
     * A B válaszgomb ActionListener-je, lekéri a logikától helyes-e a válasz,
     * továbbá az eredményt kiértékelésre küldi.
     */
    private final ActionListener answerListenerB = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click B!");
            selectedAnswer = 1;
            try {
                result(logic.correctAnswer(1));
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    /**
     * A C válaszgomb ActionListener-je, lekéri a logikától helyes-e a válasz,
     * továbbá az eredményt kiértékelésre küldi.
     */
    private final ActionListener answerListenerC = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click C!");
            selectedAnswer = 2;
            try {
                result(logic.correctAnswer(2));
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    /**
     * A D válaszgomb ActionListener-je, lekéri a logikától helyes-e a válasz,
     * továbbá az eredményt kiértékelésre küldi.
     */
    private final ActionListener answerListenerD = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click D!");
            selectedAnswer = 3;
            try {
                result(logic.correctAnswer(3));
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    /**
     * A Quiz GUI fő frame-jének a konstruktora, létrehozza a grafikus felületet.
     */
    public MainFrame() {
        super("Quiz - by Team 21");
        setSize(400,670);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setGui();
        createMenuBar();
        try {
            logic = new Logic(this);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        correctAnswers = 0;
        incorrectAnswers = 0;
        endGame(false);
    }
    
    /**
     * Létrehozza és hozzácsatolja a menüsort az ablakhoz, betölti a menübe a 
     * választható opciókat.
     */
    private void createMenuBar(){
        JMenuBar menubar = new JMenuBar();
        
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem newGame = new JMenuItem("New game");
        newGame.setToolTipText("Start a new game");
        newGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("NEW GAME!");
                try {
                    newGame();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        JMenuItem exitGame = new JMenuItem("Exit");
        exitGame.setToolTipText("Exit from application");
        exitGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        file.add(newGame);
        file.add(new JSeparator());
        file.add(exitGame);
        menubar.add(file);
        
        setJMenuBar(menubar);
    }
    
    /**
     * Felépíti az ablak (JFrame) grafikáját, hozzáadja a komponenseket,
     * konkrétan a kérdés JLabel-t, a négy válaszgomb QuizButton-t és az
     * eredmény JLabel-t. Beállítja azok kinézetét.
     */
    private void setGui() {
        
        buttons.add(buttonA);
        buttons.add(buttonB);
        buttons.add(buttonC);
        buttons.add(buttonD);
        
        for(QuizButton qb : buttons){
            qb.setFocusable(false);
        }
        clearButtonsColor();
        
        buttons.get(0).addActionListener(answerListenerA);
        buttons.get(1).addActionListener(answerListenerB);
        buttons.get(2).addActionListener(answerListenerC);
        buttons.get(3).addActionListener(answerListenerD);
        
        this.setLayout(new BorderLayout());
        
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel quizPanel  = new JPanel();
        JPanel scorePanel = new JPanel();
        
        quizPanel.setLayout(new GridLayout(2, 1));
        
        northPanel.setLayout(new FlowLayout());
        questionLabel.setPreferredSize(new Dimension(250, 180));
        questionLabel.setVerticalAlignment(JLabel.CENTER);
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setForeground(Color.WHITE);
        northPanel.add(questionLabel);
        
        southPanel.setLayout(new GridLayout(2, 2));
        southPanel.add(buttons.get(0));
        southPanel.add(buttons.get(1));
        southPanel.add(buttons.get(2));
        southPanel.add(buttons.get(3));
        
        scorePanel.setLayout(new GridLayout(1,1));
        scorePanel.setSize(100, 100);
        scorePanel.add(statsLabel);
        statsLabel.setHorizontalAlignment(JLabel.CENTER);
        
        quizPanel.add(northPanel);
        quizPanel.add(southPanel);
        
        this.add(quizPanel, BorderLayout.NORTH);
        this.add(scorePanel, BorderLayout.SOUTH);
        
        northPanel.setBackground(Color.DARK_GRAY);
    }
    
    /**
     * Beállítja a válaszgombok színeit.
     */
    private void clearButtonsColor(){
        for(QuizButton qb : buttons){
            qb.setBackground(Color.ORANGE);
            qb.setForeground(Color.BLACK);
        }
    }
    
    /**
     * Új kérdés inicializálása, azaz a logikától kér egy kérdést négy darab 
     * lehetséges válasszal.
     * @throws IOException 
     */
    private void init() throws IOException{
        
        statsLabel.setText("<html><font size=\"6\" color=\"green\">Correct: " + correctAnswers+  "      </font><font size=\"6\" color=\"red\">Incorrect: " + incorrectAnswers + "</font></html>");     
        clearButtonsColor();
        revalidate();
        repaint();
        System.out.println("MainFrame: init() - new question req from logic");
        logic.newQuestionRequest();
    }
    
    /**
     * logika számára használatos metódus, amivel beállítja a kérdést és a 
     * négy válaszlehetőséget a kérdés JLabel-be és a válaszgombokba.
     * @param question
     * @param answers 
     */
    
    public void setNewQuestion(String question, ArrayList<String> answers){
        questionLabel.setText("<html><div align=\"center\"><font size=\"5\">" + question + "</font></div></html>");
        buttons.get(0).setText("<html><div align=\"center\">" + answers.get(0) + "</div></html>");
        buttons.get(1).setText("<html><div align=\"center\">" + answers.get(1) + "</div></html>");
        buttons.get(2).setText("<html><div align=\"center\">" + answers.get(2) + "</div></html>");
        buttons.get(3).setText("<html><div align=\"center\">" + answers.get(3) + "</div></html>");
        revalidate();
        repaint();
    }
    
    /**
     * A felhasználó válaszának kiértékelését megjelenítő metódus. 
     * Üzen a felhasználónak egy MessageBox-szal a válasza helyességéről.
     * @param b
     * @throws IOException 
     */
    private void result(boolean b) throws IOException{
        if(b) {
            ++correctAnswers;            
        } else {
            ++incorrectAnswers;
        }
        statsLabel.setText("<html><font size=\"6\" color=\"green\">Correct: " + correctAnswers+  "      </font><font size=\"6\" color=\"red\">Incorrect: " + incorrectAnswers + "</font></html>");     

        if(b) {
            JOptionPane.showMessageDialog(null, "Correct! :D");
          
        } else {
            boolean b2 = false;
            int i = 0;
            while(!b2 && i<4){
                if(logic.correctAnswer(i)) correctAns = buttons.get(i).getText();
                ++i;
            }
            JOptionPane.showMessageDialog(null, "Wrong answer! :/\nThe correct answer is: " + correctAns);

        }
        
        if(correctAnswers + incorrectAnswers == 10) endGame(true);
        else {
            revalidate();
            repaint();

            init();
        }
    }
    
    /**
     * Új játék inicializálása. 
     * @throws IOException 
     */
    private void newGame() throws IOException{
        
        for(QuizButton qb : buttons)
        {
            qb.setEnabled(true);
        }
        clearButtonsColor();
        correctAnswers = 0;
        incorrectAnswers = 0;
        // init
        init();
    }
    
    /**
     * Jelen futó játék befejezése és a végeredmény grafikus közlése a 
     * felhasználóval.
     * @param b 
     */
    private void endGame(boolean b){
        for(QuizButton qb : buttons){
            qb.setEnabled(false);
            qb.setText("");
        }
        questionLabel.setText("");
        statsLabel.setText("");
        revalidate();
        repaint();

        if(b) JOptionPane.showMessageDialog(null, "Congratulations, your result is " + correctAnswers + " out of 10 questions! :D");
    }
}
