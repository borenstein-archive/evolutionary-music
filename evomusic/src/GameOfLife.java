
public class GameOfLife extends Game {


	// Use all the guts from the general "Game" class
	public GameOfLife(int width, int height) {
		super(width, height);
	}

	// This is the only thing you have to implement
	protected boolean calculateNextState(int x0, int y0) {
		int neighbors = 0;
		
		// First, check current state.
		boolean alive = get(x0, y0);

		
		// Iterate through neighbors.
		for (int x = x0 - 1; x <= x0+1; x++) {
			for (int y = y0 - 1; y <= y0+1; y++) {
				
				// (The self is not a neighbor.)
				if (x == x0 && y == y0) {
					continue;
				}

				// Add up live neighbors.
				if (get(x, y)) {
					neighbors += 1;
				}
			}
		}
		
		// If I am alive and I have two or three live neighbors, I should
		// stay alive.
		if (alive && (neighbors == 2 || neighbors == 3)) {
			return true;

		// If I am dead and I have three live neighbors, I should come alive.
		} else if (!alive && neighbors == 3) {
			return true;
			
		// In all other cases, I am dead.
		} else {
			return false;
		}
	}
	
}
