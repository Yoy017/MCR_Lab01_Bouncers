import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board extends JPanel implements ActionListener {

    private List<Entity> entities;
    private final Timer timer;
    private static final int DELAY = 20;
    private static final Random random = new Random();

    public Board(int nbEntities) {
        this.entities = new ArrayList<>();
        setPreferredSize(new Dimension(500, 600));

        for(int i = 0; i < nbEntities; i++) {
            Entity entity;
            if(random.nextBoolean())
                entity = new Square();
            else
                entity = new Circle();

            // panel is created, set initial position
            entity.x = random.nextInt(getPreferredSize().width - entity.size);
            entity.y = random.nextInt(getPreferredSize().height - entity.size);

            entities.add(entity);
        }

        // update the board every DELAY ms
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Entity entity : entities)
            entity.move(this);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Entity entity : entities)
            entity.draw(g);
    }
}
