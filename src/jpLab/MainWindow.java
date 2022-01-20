package jpLab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private int delay = 10;

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 600;
    private JButton buttonStart;

    public MainWindow() {
        this.setTitle("agar.io");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        buttonStart = new JButton("START");
        buttonStart.addActionListener(new buttonStartListener());
        add(buttonStart);
    }

    class buttonStartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            buttonStart.setVisible(false);
            Animation animation = new Animation();
            animation.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            setBackground(Color.BLACK);
            setLayout(null);
            add(animation);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    animation.initialize();
                    animation.addFig();
                    animation.animate();
                }
            });
        }
    }
}
