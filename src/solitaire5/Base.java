/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire5;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Lukas
 */
abstract class Base extends ImageView{
    private final double CARD_WIDTH = 117;
    private final double CARD_HEIGHT = 169;
    
    public Base(String img){
        super(new Image(img));
        setFitWidth(CARD_WIDTH);
        setFitHeight(CARD_HEIGHT);   
        
        this.setEventHandler(CardEvent.MOVE_CARD, ev -> {
            this.relocate(ev.ox, ev.oy);
        });
    }
    
}
