/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_client.gui;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import quiz_client.Logic;

/**
 *
 * @author Vuk
 */
public class MainFrame extends JFrame {
    
    private QuizButton buttonA = new QuizButton("answer A", 0);
    private QuizButton buttonB = new QuizButton("answer B", 1);
    private QuizButton buttonC = new QuizButton("answer C", 2);
    private QuizButton buttonD = new QuizButton("answer D", 3);
    private JLabel questionLabel = new JLabel("Question?");
    
    private Logic logic;
    
    // ButtonA listener
    private final ActionListener answerListenerA = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click A!");
            try {
                logic.correctAnswer(0);
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
            try {
                logic.correctAnswer(1);
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
            try {
                logic.correctAnswer(2);
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
            try {
                logic.correctAnswer(3);
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
        super("Quiz");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setGui();
        logic = new Logic(this);
        init();
    }
    
    private void setGui() {
        
        buttonA.setFocusable(false);
        buttonB.setFocusable(false);
        buttonC.setFocusable(false);
        buttonD.setFocusable(false);
        buttonA.setBackground(Color.CYAN);
        buttonB.setBackground(Color.YELLOW);
        buttonC.setBackground(Color.MAGENTA);
        buttonD.setBackground(Color.GREEN);
        
        buttonA.addActionListener(answerListenerA);
        buttonB.addActionListener(answerListenerB);
        buttonC.addActionListener(answerListenerC);
        buttonD.addActionListener(answerListenerD);
        /*buttonA.addActionListener(answerListener);
        buttonB.addActionListener(answerListener);
        buttonC.addActionListener(answerListener);
        buttonD.addActionListener(answerListener);*/
        
        this.setLayout(new GridLayout(2, 1));
        
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        
        northPanel.setLayout(new FlowLayout());
        questionLabel.setPreferredSize(new Dimension(380, 180));
        questionLabel.setVerticalAlignment(JLabel.CENTER);
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        northPanel.add(questionLabel);
        
        southPanel.setLayout(new GridLayout(2, 2));
        southPanel.add(buttonA);
        southPanel.add(buttonB);
        southPanel.add(buttonC);
        southPanel.add(buttonD);
        
        this.add(northPanel);
        this.add(southPanel);
    }
    
    private void init(){
        logic.newQuestionRequest();
    }
    
    // Logic calls this method to set the new question
    public void setNewQuestion(String question, ArrayList<String> answers){
        questionLabel.setText(question);
        buttonA.setText(answers.get(0));
        buttonB.setText(answers.get(1));
        buttonC.setText(answers.get(2));
        buttonD.setText(answers.get(3));
        revalidate();
        repaint();
    }
}
