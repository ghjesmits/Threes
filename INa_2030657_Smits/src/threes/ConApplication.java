package threes;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ConApplication extends JFrame{
	
	private ModGridPanel m_GridPanel;
	private ViewContentPane v_ContentPane;

	public ConApplication(){
		MyKeyAdapter myKa = new MyKeyAdapter();
		m_GridPanel = new ModGridPanel(4, this);
		v_ContentPane = new ViewContentPane(this, m_GridPanel);
		this.setTitle("THREES Score: " + m_GridPanel.getTotalScore());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(v_ContentPane);
		this.addKeyListener(myKa);
		
		this.pack();
		this.setVisible(true);		
		run();
	}
	//music loop
	public void run(){
		playSound("music.wav", true);
		while (true)
		{

		}
	}
	
	public void playSound(String filename, boolean shouldLoop)
	{
		try
		{
			URI threesURI = null;
			try
			{
				URL threesURL = this.getClass().getResource(
						"/music/" + filename);
				threesURI = threesURL.toURI();
			} catch (URISyntaxException ex)
			{
				ex.printStackTrace();
			}
			if (threesURI != null)
			{
				File f = new File(threesURI);
				AudioInputStream audioInputStream = AudioSystem
						.getAudioInputStream(f.getAbsoluteFile());
				Clip clip = AudioSystem.getClip();

				clip.open(audioInputStream);
				if (shouldLoop)
				{
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				} else
				{
					clip.start();
				}
			}
		} catch (Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	private void moveTilesDown() {
		m_GridPanel.moveDown();
		m_GridPanel.setScore();
		this.setTitle("THREES Score: " + m_GridPanel.getTotalScore());
		this.repaint();
	}

	private void moveTilesUp() {
		m_GridPanel.moveUp();
		m_GridPanel.setScore();
		this.setTitle("THREES Score: " + m_GridPanel.getTotalScore());
		this.repaint();
	}

	private void moveTilesLeft() {
		m_GridPanel.moveLeft();
		m_GridPanel.setScore();
		this.setTitle("THREES Score: " + m_GridPanel.getTotalScore());
		this.repaint();
	}

	private void moveTilesRight() {
		m_GridPanel.moveRight();
		m_GridPanel.setScore();
		this.setTitle("THREES Score: " + m_GridPanel.getTotalScore());
		this.repaint();
	}
	//switch for keys
	private class MyKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {

			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				moveTilesRight();
				break;
			case KeyEvent.VK_LEFT:
				moveTilesLeft();
				break;
			case KeyEvent.VK_UP:
				moveTilesUp();
				break;
			case KeyEvent.VK_DOWN:
				moveTilesDown();
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(1);
				break;
			default:
				System.out.println("Unknown key");
				break;
			}	
		}
	}
}