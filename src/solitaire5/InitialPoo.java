/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lukas
 */
public class InitialPoo extends Base {
    private List<Card> cardsOnPoo = new ArrayList<>(); //boundsInParentProperty();
    
    public InitialPoo() {
        super("file:src\\res\\dickbutt.png");
    }
    
    public void addToPoo(Card card){
        addToPoo(Arrays.asList(card));
    }
    
    public void addToPoo(List<Card> cards){
        cardsOnPoo.addAll(cards);
    }
    
}
