
public class GameRunner extends Thread {

	private LatticePanel lattice;
	private Game game;
	private Soundtrack soundtrack;
	
	int i = 0;
	public GameRunner(LatticePanel lattice, Game game, Soundtrack soundtrack) {
		this.lattice = lattice;
		this.game = game;
		this.soundtrack = soundtrack;
	}
	
	@Override
	public void run() {
    	lattice.refresh();
    	for (; i < 8; i++) {
        	soundtrack.play();
        	
    		game.evolve();
    		lattice.refresh();

    		if (Thread.interrupted()) {
    			System.exit(0);
    		}
        }

    	if (Thread.interrupted()) {
			System.exit(0);
    	}
    	soundtrack.tada();
    	System.exit(0);
	}

}
