package jpLab;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    int windowWidth;
    int windowHeight;
    JPanel jPanel;

    public MainWindow() {
        this.setTitle("agar.io");
        windowWidth = 640;
        windowHeight = 480;
        this.setSize(windowWidth, windowHeight);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = this.getSize().width;
        int screenHeight = this.getSize().height;
        this.setLocation((width - screenWidth) / 2, (height - screenHeight) / 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        jPanel = new JPanel();
        jPanel.setBounds(0, 0, windowWidth, windowHeight);
        setContentPane(jPanel);
        jPanel.setLayout(null);
    }
}
