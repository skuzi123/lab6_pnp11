package jpLab;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Circles extends Element {
    Random random = new Random();
    public Circles(Graphics2D buf, int del, int w, int h) {
        super(buf, del, w, h);
        shape = new Ellipse2D.Float(0,0,40,40);
        aft = new AffineTransform();
        area = new Area(shape);
    }
}
