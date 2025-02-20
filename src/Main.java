import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // thread safe
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bouncers");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(new Board(50));

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}