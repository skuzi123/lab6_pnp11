package jpLab;

import javax.swing.*;

public class App extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try{
                new MainWindow().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
