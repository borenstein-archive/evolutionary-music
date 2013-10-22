import javax.sound.midi.*;


public abstract class Soundtrack {
	
	protected Game game;
	
	// MIDI stuff -- not exactly sure how it works
	private Synthesizer synthesizer;
	protected MidiChannel[] channels ;
	
	public Soundtrack(Game game) {
		this.game = game;
		
		try {
			synthesizer = MidiSystem.getSynthesizer();
			synthesizer.open();
		} catch (MidiUnavailableException e) {
			throw new RuntimeException(e);
		}

		channels = synthesizer.getChannels();
	}
		
	public abstract void play();

	public abstract void tada();

	public boolean interrupted() {
		// TODO Auto-generated method stub
		return false;
	}
}
