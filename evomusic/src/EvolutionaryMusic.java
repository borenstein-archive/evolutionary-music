import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class EvolutionaryMusic extends JFrame {
	// Side length (in pixels) for lattice
	private static final int SIDE = 20;
	private static final int WIDTH = 16;
	private static final int HEIGHT = 16;
	
	//private static final long WAIT = 150;
	
	public static void main(String[] args) {
		new EvolutionaryMusic();
	}
	
	public EvolutionaryMusic() {
		super("Evolutionary Music");
		setSize(WIDTH*SIDE, HEIGHT*SIDE+125);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        GameOfLife game = new GameOfLife(WIDTH, HEIGHT);

		LatticePanel latticePanel = new LatticePanel(game, SIDE);
		add(latticePanel, BorderLayout.CENTER);
		Soundtrack soundtrack = new ToneMatrix(game, latticePanel, 400);

        GameRunner runner = new GameRunner(latticePanel, game, soundtrack);
        
        JPanel lower = new JPanel();
        lower.setLayout(new BorderLayout());
        add(lower, BorderLayout.SOUTH);
        
        LaunchButton launch = new LaunchButton(runner);
        lower.add(launch, BorderLayout.NORTH);
        
        HaltButton halt = new HaltButton(runner);
        lower.add(halt, BorderLayout.SOUTH);
        
        // Draw a glider
        glider(game, 0, 0);
        glider(game, 3, 4);
        glider(game, 6, 8);
        glider(game, 9, 12);
        glider(game, 11, 4);
        glider(game, 13, 9);

        setVisible(true);
	}
	private void glider(Game game, int x0, int y0) {
	    game.set(x0, y0, true);
	    game.set(x0+1, y0, true);
	    game.set(x0+2, y0, true);
	    game.set(x0+2, y0+1, true);
	    game.set(x0+1, y0+2, true);
	}		
}
