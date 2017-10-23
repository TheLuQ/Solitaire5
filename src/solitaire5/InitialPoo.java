/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.Event;

/**
 *
 * @author Lukas
 */
public class InitialPoo extends Base {
    private List<Card> cardsOnPoo;
    protected double oyShift;
    
    public InitialPoo() {
        super("file:src\\res\\dickbutt.png");
        cardsOnPoo  = new ArrayList<>();
        oyShift = 0;
    }
    
    public void addToPoo(Card card){
        addToPoo(Arrays.asList(card));
    }
    
    public void addToPoo(List<Card> cards){
        cards.forEach(card -> {
            double lastOy = cardsOnPoo.isEmpty() ? 
                    this.getLayoutY() : cardsOnPoo.get(cardsOnPoo.size() - 1).getLayoutY() + oyShift;
            Event.fireEvent(card, new CardEvent(this, card, CardEvent.MOVE_CARD, this.getLayoutX(), lastOy));
            card.toFront();
            cardsOnPoo.add(card);
        });
    }
    
    public void removeFromPoo(List<Card> cards){
        cardsOnPoo.removeAll(Arrays.asList(cards));
    }
    
}
