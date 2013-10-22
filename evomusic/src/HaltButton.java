import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class HaltButton extends JButton {
	
	public HaltButton(GameRunner runner) {
		super("Quit");
		
		MouseListener mouseListener = new ButtonListener(runner);
		addMouseListener(mouseListener);
	}
	
	private class ButtonListener implements MouseListener {

		private GameRunner runner;
		
		public ButtonListener(GameRunner runner) {
		    this.runner = runner;
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.out.println("Attempting to halt.");
			System.exit(0);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
