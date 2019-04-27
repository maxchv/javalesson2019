package ua.step.examples.util.switcher;

import javax.swing.SwingUtilities;

/**
 * Класс отображает переключение битов
 * 
 * @author Maxim Gromko java 6
 * @since 0.0.1
 */
public class BitsSwitcher
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            BitFrame frame = new BitFrame();
            frame.setVisible(true);
        });
    }
}