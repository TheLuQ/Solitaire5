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
public class Card extends Base implements IFigure, IColor{
    private final Figure figure;
    private final int number;
    
    public Card(String img, Figure figure, int number) {
        super(img);
        this.number = number;
        this.figure = figure;
    }

    @Override
    public Figure getFigure() {
       return this.figure;
    }

    @Override
    public Color getColor() {
        return figure.getColor();
    }
    
}
