/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire5;

import javafx.event.Event;
import javafx.scene.paint.Color;

/**
 *
 * @author Lukas
 */
public class Card extends Base implements IFigure, IColor{
    private final Figure figure;
    private final int number;
    private InitialPoo poo;
    private double xOff, yOff;
    
    public Card(String img, Figure figure, int number,InitialPoo poo) {
        super(img);
        this.number = number;
        this.figure = figure;
        this.xOff = 0;
        this.yOff = 0;
        this.poo = poo;
        setManaged(false);
        
        //EVENTS TEST:
        this.setEventHandler(CardEvent.MOVE_CARD, ev -> {
            this.relocate(ev.ox, ev.oy);
        });
        
        setOnMousePressed(ev -> {
            xOff = ev.getX();
            yOff = ev.getY();
        });
        
        setOnDragDetected(ev -> {
            startFullDrag();
        });
        
        setOnMouseDragged(ev -> {
            Event.fireEvent(poo, new CardEvent(this,poo,CardEvent.DRAG_CARD, ev.getSceneX() - xOff, ev.getSceneY() - yOff));
        });
        //
    }

    @Override
    public Figure getFigure() {
       return this.figure;
    }

    @Override
    public Color getColor() {
        return figure.getColor();
    }
    
    public void setPoo(InitialPoo poo){
        this.poo = poo;
    }
    
    public InitialPoo getPoo(){
        return poo;
    }
}
