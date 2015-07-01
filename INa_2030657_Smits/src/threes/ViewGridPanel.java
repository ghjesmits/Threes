package threes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ViewGridPanel extends JPanel {
	
	private ModGridPanel m_GridPanel;
	private Font f = new Font("SansSerif", Font.BOLD, 20);
	private int size;

	public ViewGridPanel(ModGridPanel m_GridPanel) {
		this.m_GridPanel = m_GridPanel;
		this.size = (int) (m_GridPanel.getSize() * 102.5);
		this.setPreferredSize(new Dimension(size, size));
		this.setBackground(Color.BLACK);	
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (ModTile tile : m_GridPanel.getTiles())
		{
			g.setColor(tile.getColor());
			g.fillRoundRect(tile.getXPos(), tile.getYPos(),
					tile.getSize(), tile.getSize(), 10, 10);
			g.setColor(Color.BLACK);
			g.setFont(f);
			if(tile.getValue() != 0){
				g.drawString(Integer.toString(tile.getValue()), tile.getXPos() + tile.getSize() / 2 - 4, tile.getYPos() + tile.getSize() / 2 + 8);
			}
		}
	}

}
