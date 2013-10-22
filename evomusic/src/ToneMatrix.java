import java.util.ArrayList;


/**
 * Play the game of life according to the rules of a tone matrix.
 * @untested
 * @author David Bruce Borenstein
 *
 */
public class ToneMatrix extends Soundtrack {

	// Tones to play
	private int[] tones;
	
	// Nice ones: 8 11 12
	private int PROGRAM = 11;
	// How long to play a column (in ms)
	private int delay;
	
	private LatticePanel lattice;
	public ToneMatrix(Game game, LatticePanel lattice, int delay) {

		// You always have to have this line.
		super(game);
		
		this.lattice = lattice;
		
		for (int i = 0; i < 16; i++) {
			channels[i].programChange(PROGRAM);
		}		
		this.delay = delay;
		
		// Construct a vector of frequencies.
		int[] major = {0, 2, 4, 7, 9};
		int[] minor = {-3, 0, 2, 4, 7};
		tones = pentatonic(game.getHeight(), major);
	}

	public void tada() {
		channels[0].noteOn(48, 1000);
		channels[1].noteOn(60, 1000);
		channels[2].noteOn(64, 1000);
		for (int i = 0; i < tones.length; i++) {
			channels[i ].noteOn(tones[i], 1000);
		}
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ex) {
			return;
		}
	}
	private int[] pentatonic(int height, int[] offsets) {
		
		
		ArrayList<Integer> nl = new ArrayList<Integer>();
		
		for (int i = 0; i < height; i++) {
			int octave = i / 12;
			int o_i = i % 5;
			
			int note = 60 + (octave * 12) + offsets[o_i];
			
			nl.add(note);
		}

		
		// Convert to unboxed int array
		int[] tArr = new int[height];
		for (int i = 0; i < height; i++) {
			tArr[i] = nl.get(i);
		}

		// Return it
		return tArr;
	}

	@Override
	public void play() {
		for (int x = 0; x < game.getWidth(); x++) {
			int channel = 0;

			if (Thread.interrupted()) {
				return;
			}
			
			// Get list of notes to play
			int[] toPlay = getPlayTones(x);
			
			lattice.highlight(x);
			// Start playing
			for (int note : toPlay) {
		        channels[channel % 16].noteOn(note, 1000);
		        channel++;
			}
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				System.exit(0);
			}
			lattice.unhighlight(x);
		}

	}

	private int[] getPlayTones(int x) {
		// Create a variable length array (this is like std::vector)
		ArrayList<Integer> tonesList = new ArrayList<Integer>();

		for (int y = 0; y < game.getHeight(); y++) {
			if (game.get(x, y)) {
				tonesList.add(tones[y]);
			}
		}
		
		// Convert from an Integer list to an int[] array
		int[] ret = new int[tonesList.size()];
		for (int i = 0; i < tonesList.size(); i++) {
			ret[i] = tonesList.get(i);
			System.out.print("\t" + ret[i]);
		}
		System.out.println();
		return ret;
	}

	public void soundCheck() {
		for (int i = 0; i < tones.length; i++) {
	        channels[0].noteOn(tones[i], 1000);
			System.out.println(tones[i]);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				System.exit(0);
			}
	        channels[0].noteOff(tones[i]);

		}
	}
}
