/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_client.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import quiz_client.Logic;

/**
 *
 * @author Vuk
 */
public class MainFrame extends JFrame {
    
    private int selectedAnswer = 0;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private QuizButton buttonA = new QuizButton("answer A", 0);
    private QuizButton buttonB = new QuizButton("answer B", 1);
    private QuizButton buttonC = new QuizButton("answer C", 2);
    private QuizButton buttonD = new QuizButton("answer D", 3);
    private ArrayList<QuizButton> buttons = new ArrayList<>();
    private JLabel questionLabel = new JLabel("Question?");
    private JLabel statsLabel = new JLabel("<html><font size=\"6\" color=\"green\">Correct: " + correctAnswers + "      </font><font size=\"6\" color=\"red\">Incorrect: " + incorrectAnswers + "</font></html>" );
    
    
    private Logic logic;
    
    // ButtonA listener
    private final ActionListener answerListenerA = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click A!");
            selectedAnswer = 0;
            try {
                result(logic.correctAnswer(0));
                // add logic triggering
            } catch (RemoteException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    // ButtonB listener
    private final ActionListener answerListenerB = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click B!");
            selectedAnswer = 1;
            try {
                result(logic.correctAnswer(1));
                // add logic triggering
            } catch (RemoteException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    // ButtonC listener
    private final ActionListener answerListenerC = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click C!");
            selectedAnswer = 2;
            try {
                result(logic.correctAnswer(2));
                // add logic triggering
            } catch (RemoteException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    // ButtonD listener
    private final ActionListener answerListenerD = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click D!");
            selectedAnswer = 3;
            try {
                result(logic.correctAnswer(3));
                // add logic triggering
            } catch (RemoteException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    /*
    private final ActionListener answerListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("trigger logic with answer");
            logic.testAnswer(e.)
        }
    };*/
    
    // Constructor
    public MainFrame() {
        super("Quiz - by Team 21");
        setSize(400,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setGui();
        try {
            logic = new Logic(this);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        correctAnswers = 0;
        incorrectAnswers = 0;
        init();
    }
    
    private void setGui() {
        
        buttons.add(buttonA);
        buttons.add(buttonB);
        buttons.add(buttonC);
        buttons.add(buttonD);
        
        for(QuizButton qb : buttons){
            qb.setFocusable(false);
            qb.setForeground(Color.BLACK);
            //qb.setOpaque(false);
        }
        clearButtonsColor();
        
        buttons.get(0).addActionListener(answerListenerA);
        buttons.get(1).addActionListener(answerListenerB);
        buttons.get(2).addActionListener(answerListenerC);
        buttons.get(3).addActionListener(answerListenerD);
        
        
        //this.setLayout(new GridLayout(2, 1));
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
    
    private void clearButtonsColor(){
        for(QuizButton qb : buttons){
            qb.setBackground(Color.ORANGE);
        }
    }
    
    private void init(){
        
        
        clearButtonsColor();
        revalidate();
        repaint();
        try {
            System.out.println("MainFrame: init() - new question req from logic");
            logic.newQuestionRequest();
        } catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Logic calls this method to set the new question
    public void setNewQuestion(String question, ArrayList<String> answers){
        questionLabel.setText("<html><div align=\"center\"><font size=\"5\">" + question + "</font></div></html>");
        buttons.get(0).setText("<html><div align=\"center\">" + answers.get(0) + "</div></html>");
        buttons.get(1).setText("<html><div align=\"center\">" + answers.get(1) + "</div></html>");
        buttons.get(2).setText("<html><div align=\"center\">" + answers.get(2) + "</div></html>");
        buttons.get(3).setText("<html><div align=\"center\">" + answers.get(3) + "</div></html>");
        revalidate();
        repaint();
    }
    
    private void result(boolean b){
        if(b) {
            JOptionPane.showMessageDialog(null, "Correct! :D");
            ++correctAnswers;            
        } else {
            JOptionPane.showMessageDialog(null, "Bad answer! :/");
            ++incorrectAnswers;
        }
        statsLabel.setText("<html><font size=\"6\" color=\"green\">Correct: " + correctAnswers+  "      </font><font size=\"6\" color=\"red\">Incorrect: " + incorrectAnswers + "</font></html>");     

        revalidate();
        repaint();
        
        /*
        try {
        TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
                
        
        init();
    }
}
