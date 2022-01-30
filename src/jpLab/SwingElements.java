package jpLab;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;

/**
 *   @author Arek Pytka
 *
 *   Klasa ta tworzy predefiniowane elementy biblioteki Swing
 *   Feel free do dodawania kolejnych rzeczy lub zmieniania obecnych
*/
public class SwingElements {

    public SwingElements()
    {

    }

    public JButton createButton(String text)
    {
        return createButton(text, 90, 20);
    }

    public JButton createButton(String text, int width, int height)
    {
        JButton button = new JButton(text);

        button.setSize(width, height);
        button.setFocusable(false);

        return button;
    }

    public JSlider createSlider(int minValue, int maxValue, int defaultValue)
    {
        JSlider slider = new JSlider(minValue, maxValue, defaultValue);

        slider.setFocusable(false);
        slider.setSize(200,50);

        return slider;
    }
}
