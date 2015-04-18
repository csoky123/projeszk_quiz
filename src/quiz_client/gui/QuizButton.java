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
    
    private String id;
    
    public QuizButton(String text, String id) {
        super(text);
        this.id = id;
    }
    
    public String getID(){
        return id;
    }
    
    
}
