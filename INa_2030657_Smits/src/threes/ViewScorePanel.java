package threes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ViewScorePanel extends JPanel{

	private int Score;
	private ModGridPanel m_GridPanel;
	private Font f = new Font("SansSerif", Font.BOLD, 20);
	private Font f1 = new Font("SansSerif",Font.PLAIN , 12);
	private Font f2 = new Font("SansSerif", Font.BOLD, 15);
	private int size;
	
	public ViewScorePanel(ModGridPanel m_GridPanel) {
			this.m_GridPanel = m_GridPanel;
			this.size = (int) (m_GridPanel.getSize() * 102.5);
			this.setPreferredSize(new Dimension(size, 70));
			this.setBackground(Color.BLACK);	
		}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Score = 0;
		for (ModTile tile : m_GridPanel.getTiles()){
			Score = Score + tile.getValue();
		}
		
		g.setColor(Color.WHITE);
		g.setFont(f2);
		g.drawString(Integer.toString(m_GridPanel.getNumberOfMoves()), size/2 - 9, 20);
		
		g.setColor(Color.YELLOW);
		g.setFont(f);
		g.drawString(m_GridPanel.getTekst(), size/2 - 40, 40);
		
		g.setColor(Color.GREEN);
		g.setFont(f1);
		g.drawString("Gertjan Smits 2030657", size/2 - 60, 60);
	}

}
