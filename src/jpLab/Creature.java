package jpLab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Random;


/**
 * @author Kacper Chrostowski
 * Generalnie jest to klasa po której będzie dziedziczyć obiekt kulki
 * Jest stworzona na podstawie Klasy Figura z zajęć o Animacji(te odbijające sie figury)
 * (nie wiem czy kręcenie jest potrzebne. narazie nie robie jak bede miał czas to sprawdze,
 * jak nie bede miał czasu to jak już będzie pole animacji trzeba puścić kulke i zobaczyć jak sie odbija,
 * jeżeli nie odbije sie o losowy kąt to trzeba dodać rotacje przez odkomentowanie oznaczonych linii kodu)
 *
 */
public abstract  class Creature implements Runnable, ActionListener {
    //bufor
    protected Graphics2D buffer;

    protected Area area;

    // przeksztalcenie obiektu
    protected AffineTransform aft;


    //do rysowania
    protected Shape shape;

    //przesunięcie(wektor)
    private int dx,dy;

    private int delay;

    private double rot;   //jak potrzeba rotacji to odkomentuj

    //wymiary rysunku
    private int width;
    private int height;

    //rozmiar figury. on decyduje jak duża jest kulka
    public int size;

    //kolor figury
    //trzeba ustalić czy ustalamy na twardo czy losujemy
    //imo na twardo bo tych kulek ma być mało a jak przypadkiem wylosujemy
    //jeden kolor do dwóch kulek to będzie niejasne kto wygra
    private Color clr;

    protected static final Random rand = new Random();



    public Creature(Graphics2D buf, int del, int w, int h, int s, Color cl){
        delay=del;
        width=w;
        height=h;
        size=s;
        buffer=buf;
        dx= 1+ rand.nextInt(3);
        dy= 1+ rand.nextInt(3);
        clr=cl;
        rot = 0.1 * rand.nextDouble();  //jak potrzeba rotacji to odkomentuj
    }
    @Override
    public void run(){
        /**
         * tutaj uwaga bo wszyskie kulki pojawią sie w jednym spocie
         * albo pojawiamy kulki z jakąs przerwą od siebie(np. 1s) <-wole to
         * albo losujemy pozycje w zakresie pola animacji(wtedy trzeba jakoś przekazac tutaj rozmiary)
         */
        aft.translate(100,100);
        area.transform(aft);
        shape=area;

        //przygotowanie naastepnej klatki animacji
        while(true){
            shape=nextFrame();
            try{
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected Shape nextFrame(){
        // zapamietanie na zmiennej tymczasowej
        // aby nie przeszkadzalo w wykreslaniu
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
        // zwiekszenie lub zmniejszenie

        // konstrukcja przeksztalcenia
        aft.translate(cx, cy);

        aft.rotate(rot);
        aft.translate(-cx, -cy);
        aft.translate(dx, dy);
        // przeksztalcenie obiektu
        area.transform(aft);
        return area;
    }

    @Override
    public void actionPerformed(ActionEvent event){
        //wnetrze
        buffer.setColor(clr);
        buffer.fill(shape);
        //ramka
        buffer.setColor(Color.BLACK);
        buffer.draw(shape);
    }

}
