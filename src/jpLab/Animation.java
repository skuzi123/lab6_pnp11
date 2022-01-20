package jpLab;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Animation extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    Image image;
    Graphics2D device;
    Graphics2D buffer;

    private int delay = 10;
    private Timer timer;

    public Animation() {
        super();
        setBackground(Color.BLACK);
        timer = new Timer(delay, this);
    }

    public void initialize() {
        int width = getWidth();
        int height = getHeight();

        image = createImage(width, height);
        buffer = (Graphics2D) image.getGraphics();
        buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        device = (Graphics2D) getGraphics();
        device.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    void addFig() {
        for (int i = 0; i < 5; i++){ // startowa liczba kółek zjadających się
            Element el = new Circles(buffer, delay, getWidth(), getHeight());
            timer.addActionListener(el);
            new Thread(el).start();
        }
    }

    void animate() {
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                device.drawImage(image, 0, 0, null);
                buffer.clearRect(0, 0, getWidth(), getHeight());
            }
        });
    }
}
