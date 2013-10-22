
public abstract class Game {
	protected boolean[][] state;
	protected int width, height;
	
	public Game(int width, int height) {
		this.height = height;
		this.width = width;
		state = new boolean[width][height];
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				state[x][y] = false;
			}
		}
	}
	
	public void set(int x, int y, boolean value) {
		state[x][y] = value;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean get(int x, int y) {	
		if (x == -1) {
			x = width - 1;
		}
		
		if (x == width) {
			x = 0;
		}
		
		if (y == -1) {
			y = height - 1;
		}
		
		if (y == height) {
			y = 0;
		}
		
		return state[x][y];
	}
	
	public void evolve() {
		// Make a copy of the state
		boolean[][] nextState = new boolean[width][height];
		
		// Look at each position
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				boolean value = calculateNextState(x, y);
				nextState[x][y] = value;
			}
		}
		
		state = nextState;
	}
	
	protected abstract boolean calculateNextState(int x, int y);
}
