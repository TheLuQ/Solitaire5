/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        oyShift = 0;
        addCond = (cards, oldPoo) -> {
            oldPoo.removeFromPoo(cards);
            this.addToPoo(cards); // TO DO - REVERSE ORDER?
        };
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
    
    protected void setAddCond(BiConsumer<List<Card>, InitialPoo> cond){
        this.addCond = cond;
    }

    @Override
    public void accept(List<Card> cards, InitialPoo oldPoo) {
        addCond.accept(cards, this);
    }
    
}
