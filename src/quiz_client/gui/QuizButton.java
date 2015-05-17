/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_client.gui;

import javax.swing.JButton;

/**
 *
 * @author Vuk
 */
public class QuizButton extends JButton {
    
    private int id;
    
    public QuizButton(String text, int id) {
        super(text);
        this.id = id;
    }
    
    public int getID(){
        return id;
    }
    
    
}
