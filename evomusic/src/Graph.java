import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * JPanel example from Stack Overflow
 * http://stackoverflow.com/questions/6118737/how-to-draw-in-jpanel-swing-graphics-java/6118873#6118873
 * 
 * @untested
 * @author David Bruce Borenstein
 *
 */
public class Graph extends JFrame {
    JPanel jp;

    public Graph() {
        super("Simple Drawing");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jp = new GPanel();
        add(jp);
    }

    public static void main(String[] args) {
        Graph g1 = new Graph();
        g1.setVisible(true);
    }

    class GPanel extends JPanel {
        public GPanel() {
            setPreferredSize(new Dimension(300, 300));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //rectangle originated at 10,10 and end at 240,240
            g.drawRect(10, 10, 240, 240);
                    //filled Rectangle with rounded corners.    
            g.fillRoundRect(50, 50, 100, 100, 80, 80);
        }
    }

}