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
    
    /**
     * a QuizButton konstruktora, származtatva a JButton osztályból.
     * @param text
     * @param id 
     */
    public QuizButton(String text, int id) {
        super(text);
        this.id = id;
    }
    /**
     * A QuizButton példányának ID lekérő metódusa.
     * @return 
     */
    public int getID(){
        return id;
    }
    /**
     * A QuizButton példányának ID beállító metódusa.
     * @param ID 
     */
    public void setID(int ID){
        this.id = ID;
    }
    
}
