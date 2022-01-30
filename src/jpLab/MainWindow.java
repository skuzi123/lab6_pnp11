package jpLab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainWindow extends JFrame {

    private static final SwingElements SWING_ELEMENTS = new SwingElements();

    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private JPanel jPanel;
    private AnimPanel kanwa;



    public MainWindow() {
        this.setTitle("agar.io");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {

        jPanel = new JPanel();
        jPanel.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        setContentPane(jPanel);
        jPanel.setLayout(null);

        kanwa= new AnimPanel();
        kanwa.setBounds(1, 1, WINDOW_WIDTH-10, WINDOW_HEIGHT-70);
        jPanel.add(kanwa);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                kanwa.init();

            }
        });

        JButton btnAnimate = SWING_ELEMENTS.createButton("Animate");
        btnAnimate.setBackground(Color.RED);
        btnAnimate.addActionListener(e -> kanwa.animate());
        btnAnimate.setLocation(110, WINDOW_HEIGHT-57);
        jPanel.add(btnAnimate);

        JButton btnAdd = SWING_ELEMENTS.createButton("Add");
        btnAdd.addActionListener( e -> kanwa.addCreature());
        btnAdd.setLocation(10, WINDOW_HEIGHT-57);
        jPanel.add(btnAdd);

        /**
         * to reskaluje okno animacji do wielkości całego okna
         */
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                int w=jPanel.getWidth(),h=jPanel.getHeight();
                kanwa.setBounds(10,10,w,h-30);

            }
        });

    }

}
