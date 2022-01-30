package jpLab;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class AnimPanel extends JPanel implements ActionListener {

    /**
     * Zaczynam robić okno na którym będą latać te kulki.
     * Speedrun bo mam już mało czasu więc jak ktoś chce to wywalić lub całe przeprobić to proszę bardzo
     */

    //tutaj trzymać wszystkie żywe kulki i wątki
    ArrayList<Creature> kulki=new ArrayList<Creature>();
    ArrayList<Thread> watki=new ArrayList<Thread>();

    //bufor
    Image image;

    Graphics2D device;
    Graphics2D bufer;

    public int delay=70;
    private Timer timer;
private static Color color;
    public AnimPanel(){
        super();
        setBackground(Color.WHITE);
        Random random= new Random();
        this.color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        timer= new Timer(delay, this);


    }

    public void init(){
        int width=getWidth();
        int height= getHeight();

        image = createImage(width, height);
        bufer= (Graphics2D) image.getGraphics();
        bufer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        device = (Graphics2D) getGraphics();
        device.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


    }

    public void clearAll(){
        image=null;
        bufer=null;
        device=null;
        kulki.clear();
        init();
    }

    void animate(){
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }

    void addCreature(){
        Creature test=new Kulka(bufer,delay,getWidth(), getHeight(),10, color);
        kulki.add(test);
        timer.addActionListener(test);
        Thread boi=new Thread(test);
        watki.add(boi);
        boi.start();

    }
    /**
     * Author: Mateusz Skuza
     * Dodałem możliwość zmiany koloru
     * Dodałem możliwość losowego koloru
     */
    protected void setColor(int whichOne)
    {
        switch(whichOne)
        {
            case 1:
                this.color = JColorChooser.showDialog(null,"Choose a color",Color.black);
                break;
            case 2:
                Random random = new Random();
                this.color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                break;
        }


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        device.drawImage(image, 0, 0, null);
        bufer.clearRect(0, 0, getWidth(), getHeight());
    }
}
