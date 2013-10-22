import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class LatticeMouseListener implements MouseListener {

	private Game game;
	private LatticePanel lattice;
	
	private boolean clicked;
	private int last_x, last_y;
	
	public LatticeMouseListener(Game game, LatticePanel lattice) {
		this.game = game;
		this.lattice = lattice;
	}
	
	@Override
	public void mouseClicked(MouseEvent mEvent) {
		int x = calc_x(mEvent.getX());
		int y = calc_y(mEvent.getY());
		
		boolean state = game.get(x, y);
		
		game.set(x, y, !state);
		lattice.render(x, y, !state);
	}

	
	private int calc_y(int y) {
		int yFlipped = (game.getHeight() * lattice.getSideLength()) - y;
		int yCoord = yFlipped / lattice.getSideLength();		
		return yCoord;
	}

	private int calc_x(int x) {
		int xCoord = x / lattice.getSideLength();		
		return xCoord;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
