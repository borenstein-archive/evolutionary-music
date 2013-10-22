import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class LaunchButton extends JButton {
	
	public LaunchButton(GameRunner runner) {
		super("Evolve music");
		
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
			runner.start();
			System.out.println("Evolutionary music");
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
