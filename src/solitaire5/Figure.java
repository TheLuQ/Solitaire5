/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire5;

import javafx.scene.paint.Color;

/**
 *
 * @author Lukas
 */
public enum Figure {
    KIER(Color.RED),
    KARO(Color.RED),
    TREFL(Color.BLACK),
    PIK(Color.BLACK);
    
    private final Color col;
    
    Figure(Color col){
        this.col = col;
    }
        
    public Color getColor(){
        return this.col;
    }
}
