/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import javafx.event.Event;

/**
 *
 * @author Lukas
 */
public class InitialPoo extends Base implements BiConsumer<List<Card>, InitialPoo>{
    private List<Card> cardsOnPoo;
    protected double oyShift;
    private BiConsumer<List<Card>, InitialPoo> addCond;
    
    public InitialPoo() {
        super("file:src\\res\\dickbutt.png");
        cardsOnPoo  = new ArrayList<>();
        oyShift = 4;
        addCond = (cards, oldPoo) -> {
            oldPoo.removeFromPoo(cards);
            cardsOnPoo.addAll(cards);
            cards.forEach(card -> card.setPoo(this));
            this.moveCardsTo(cards);
        };
        
        //event test:
        this.setEventHandler(CardEvent.DRAG_CARD, ev -> {
            List<Card> cardsToDrag = cardsOnPoo.subList(cardsOnPoo.indexOf(ev.startDragCard), cardsOnPoo.size());
            moveCardsTo(cardsToDrag,ev.ox,ev.oy);
        });
    }
    
    private void moveCardsTo(List<Card> cards, double x, double y){ //basic moving of cards - only relocating
        double yTemp = y;
        for (Card card : cards) {
            Event.fireEvent(card, new CardEvent(this, card, CardEvent.MOVE_CARD, x, yTemp));
            yTemp += oyShift;
            card.toFront();
        }
    }
    
    private void moveCardsTo(List<Card> cards){ //move to this Poo
        moveCardsTo(cards,this.getLayoutX(),this.getLayoutY());
    }
    
    public void removeFromPoo(List<Card> cards){
        cardsOnPoo.removeAll(Arrays.asList(cards));
    }
    
    protected void setAddCond(BiConsumer<List<Card>, InitialPoo> cond){
        this.addCond = cond;
    }

    @Override
    public void accept(List<Card> cards, InitialPoo oldPoo) {
        addCond.accept(cards, oldPoo);
    }
    
}
