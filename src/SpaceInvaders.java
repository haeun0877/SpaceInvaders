import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SpaceInvaders  extends JFrame implements KeyListener{
	private GameObject gameObject;
	private JTextArea textArea = new JTextArea();
	
	public SpaceInvaders () {
		setTitle("Let's play Space Invaders");
		setSize(1750,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 30));
		textArea.addKeyListener(this);
		add(textArea);
		textArea.setEditable(false);
		setVisible(true);
		gameObject= new GameObject(textArea);
		new Thread(new GameThread()).start();
	}

	public static void main(String[] args) {
		new SpaceInvaders();

	}
	
	class GameThread implements Runnable{
		public void run() {
			gameObject.drawAll();
			
	}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			gameObject.moveRightBlock();
			break;
		case KeyEvent.VK_LEFT:
			gameObject.moveLeftBlock();
			break;
		case KeyEvent.VK_DOWN:
			gameObject.moveDownBlock();
			break;
		case KeyEvent.VK_UP:
			gameObject.moveUpBlock();
			break;
		case KeyEvent.VK_SPACE:
			gameObject.spaceBar();
			break;
	}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}



