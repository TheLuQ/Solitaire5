/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitaire5;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 *
 * @author lkettlex
 */
public class CardEvent extends Event{
    public static final EventType<CardEvent> MOVE_CARD = new EventType<CardEvent>(Event.ANY, "MOVE_CARD");
    public double ox, oy;
    
    public CardEvent(Object source, EventTarget target, EventType<? extends Event> eventType, double oy) {
        super(source, target, eventType);
        this.oy = oy;
        this.ox = ((Base)source).getLayoutX();
    }
    
    public CardEvent(Object source, EventTarget target, EventType<? extends Event> eventType, double ox, double oy) {
        super(source, target, eventType);
        this.ox = ox;
        this.oy = oy;
    }
    
}
