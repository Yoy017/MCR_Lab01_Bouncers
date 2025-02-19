import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Bouncers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new Board(50));
//        final Board board = new Board(50);
//        frame.getContentPane().add(board, BorderLayout.CENTER);

        frame.setSize(500, 600);
        frame.setLayout(null);



        frame.pack();
        frame.setVisible(true);
    }
}