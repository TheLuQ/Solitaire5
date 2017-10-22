/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solitaire5;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;

/**
 *
 * @author Lukas
 */
public class GameLoop extends AnimationTimer{    
    public Timeline animation;
    private Solitaire5 game;
    
    public GameLoop(Solitaire5 game){
        this.game = game;
    }
    @Override
    public void handle(long now) {
        animation = new Timeline(now);
        game.gameUpdate();
    }
    
}
