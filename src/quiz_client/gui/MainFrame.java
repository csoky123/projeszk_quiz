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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vuk
 */
public class MainFrame extends JFrame {
    
    private QuizButton buttonA = new QuizButton("answer A", "A");
    private QuizButton buttonB = new QuizButton("answer B", "B");
    private QuizButton buttonC = new QuizButton("answer C", "C");
    private QuizButton buttonD = new QuizButton("answer D", "D");
    private JLabel questionLabel = new JLabel("Question?");
    
    // ButtonA listener
    private final ActionListener answerListernerA = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click A!");
            // add logic triggering
        }
    };
    
    // ButtonB listener
    private final ActionListener answerListenerB = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click B!");
            // add logic triggering
        }
    };
    
    // ButtonC listener
    private final ActionListener answerListenerC = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click C!");
            // add logic triggering
        }
    };
    
    // ButtonD listener
    private final ActionListener answerListenerD = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Click D!");
            // add logic triggering
        }
    };
    
    // Constructor
    public MainFrame() {
        super("Quiz");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setGui();
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
        buttonA.addActionListener(answerListernerA);
        buttonB.addActionListener(answerListenerB);
        buttonC.addActionListener(answerListenerC);
        buttonD.addActionListener(answerListenerD);
        
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
    
    // Logic calls this method to set the new question
    public void setNewQuestion(String question, String a, String b, String c, String d){
        questionLabel.setText(question);
        buttonA.setText(a);
        buttonB.setText(b);
        buttonC.setText(c);
        buttonD.setText(d);
        revalidate();
        repaint();
    }
}
