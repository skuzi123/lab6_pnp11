/**
 *
 */
package jpLab;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Random;

public abstract class Element implements Runnable, ActionListener{

    protected Graphics2D buffer;
    protected Area area;
    protected Shape shape;
    protected AffineTransform aft;

    // przesuniecie
    private int dx, dy;
    // rozciaganie
    private double sf;
    // kat obrotu
    private double an;
    private int delay;
    private int width;
    private int height;
    private Color clr;

    protected static final Random rand = new Random();

    public Element(Graphics2D buf, int del, int w, int h) {
        delay = del;
        buffer = buf;
        width = w;
        height = h;

        dx = 1 + rand.nextInt(5);
        dy = 1 + rand.nextInt(5);
        sf = 1;
        an = 0.1;

        clr = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), 255);
    }

    @Override
    public void run() {
        aft.translate(5, 5);
        area.transform(aft);
        shape = area;

        while (true) {
            shape = nextFrame();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }

    protected Shape nextFrame() {
        area = new Area(area);
        aft = new AffineTransform();
        Rectangle bounds = area.getBounds();
        int cx = bounds.x + bounds.width / 2;
        int cy = bounds.y + bounds.height / 2;
        // odbicie
        if (cx < 0 || cx > width)
            dx = -dx;
        if (cy < 0 || cy > height)
            dy = -dy;
        // konstrukcja przeksztalcenia
        aft.translate(cx, cy);
        aft.scale(sf, sf);
        aft.rotate(an);
        aft.translate(-cx, -cy);
        aft.translate(dx, dy);
        // przeksztalcenie obiektu
        area.transform(aft);
        return area;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        buffer.setColor(clr.brighter());
        buffer.fill(shape);
        buffer.setColor(clr.darker());
        buffer.draw(shape);
    }

}
