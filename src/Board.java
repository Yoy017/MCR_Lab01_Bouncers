import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class Board extends JPanel implements ActionListener {

    final static Random random = new Random(42);
    private Entity[] entities;

    public Board(int nbEntities) {
        entities = new Entity[nbEntities];
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void run() {
        int len = entities.length;
        int half = len % 2 == 0 ? len / 2 : (len / 2) + 1;

        for(int i = 0; i < half; ++i) {
            entities[i] = new Square(random.nextInt(5));
        }

        for(int i = half + 1; i < entities.length; ++i) {
            entities[i] = new Circle(random.nextInt(5));
        }

        //for(Entity e : entities)
            //this.paintComponent(e);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("This is my custom Panel!",10,20);
        g.setColor(Color.RED);

        for(Entity entity : entities) {
            g.fillRect(entity.getEntitySize(), entity.getEntitySize(), entity.getEntitySize(), entity.getEntitySize());
            g.setColor(Color.BLACK);
            g.drawRect(entity.getEntitySize(), entity.getEntitySize(), entity.getEntitySize(), entity.getEntitySize());
        }
    }
}
