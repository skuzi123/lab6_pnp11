package jpLab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainWindow extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private JPanel jPanel;
   private AnimPanel kanwa;

    public MainWindow() {
        this.setTitle("agar.io");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        /**
         * Zamieniłem te 5 linijek w jedną (16 linia)
         */
//        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
//        int screenWidth = this.getSize().width;
//        int screenHeight = this.getSize().height;
//        this.setLocation((width - screenWidth) / 2, (height - screenHeight) / 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        jPanel = new JPanel();
        jPanel.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        setContentPane(jPanel);
        jPanel.setLayout(null);

        kanwa= new AnimPanel();
        kanwa.setBounds(10, 11, WINDOW_WIDTH-10, WINDOW_HEIGHT-140);
        jPanel.add(kanwa);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                kanwa.init();

            }
        });


        JButton btnAnimate = new JButton("Animate");
        btnAnimate.setBackground(Color.RED);
        btnAnimate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kanwa.animate();

            }
        });
        btnAnimate.setBounds(110, WINDOW_HEIGHT-57, 90, 20);
        jPanel.add(btnAnimate);




        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kanwa.addCreature();
            }
        });
        btnAdd.setBounds(10, WINDOW_HEIGHT-57, 90, 20);
        jPanel.add(btnAdd);





        /**
         * to reskaluje okno animacji do wielkości całego okna
         */
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                int w=jPanel.getWidth(),h=jPanel.getHeight();
                kanwa.setBounds(10,10,w-20,h-50);

            }
        });

    }

}
