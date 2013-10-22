import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LatticePanel extends JPanel {
	
	private int h, w, side;
	private GameOfLife game;
	
    public LatticePanel(GameOfLife game, int side) {
    	h = game.getHeight();
    	w = game.getWidth();
    	
    	this.game = game;
    	this.side = side;
    	
        setPreferredSize(new Dimension(w * side, h * side));
        
        MouseListener ml = new LatticeMouseListener(game, this);
        addMouseListener(ml);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Go through the state matrix
        for (int x = 0; x < w; x++) {
        	for (int y = 0; y < h; y++) {
        		render(x, y, game.get(x, y));
        	}
        }
    }
    
    public void render(int x, int y, boolean on) {
    	int x0 = x * side;
    	int y0 = (h -y)* side;
    	
    	Graphics g = getGraphics();
    	
    	if (on) {
    		g.setColor(Color.BLACK);
    	} else {
    		g.setColor(Color.WHITE);
    	}
    	
        g.drawRect(x0, y0-side, side, side);
        g.fillRect(x0, y0-side, side, side);
    }
    
    public void refresh() {
    	this.paintComponent(this.getGraphics());
    }

	public int getSideLength() {
		return side;
	}

	public void highlight(int x) {
		for (int y = 0; y < h; y++) {
			boolean on = game.get(x, y);
	    	Graphics g = getGraphics();

			if (on) {
	    		g.setColor(Color.ORANGE);
		    	int x0 = x * side;
		    	int y0 = (h -y)* side;
		        g.drawRect(x0, y0-side, side, side);
		        g.fillRect(x0, y0-side, side, side);
			}
		}
	}

	public void unhighlight(int x) {
		for (int y = 0; y < h; y++) {
			render(x, y, game.get(x, y));
		}
	}
	
}