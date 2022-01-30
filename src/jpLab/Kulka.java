package jpLab;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 * Author: Kacper Chrostowski
 * to dla testów tylko sobie zrobiłem. Feel free żeby zmeinić
 */



public class Kulka extends Creature{
    public Kulka(Graphics2D buf, int del, int w, int h ,int s ,Color col){
        super(buf, del, w, h, s,col);
        shape= new Ellipse2D.Float(0,0,s,s);
        aft= new AffineTransform();
        area= new Area(shape);

    }
}
