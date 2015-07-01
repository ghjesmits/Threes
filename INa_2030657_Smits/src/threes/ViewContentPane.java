package threes;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ViewContentPane extends JPanel {
	
	private ViewGridPanel myGridPanel;
	private ViewScorePanel myScorePanel;

	public ViewContentPane(ConApplication conApplication, ModGridPanel m_GridPanel) {
		// TODO Auto-generated constructor stub
		myGridPanel = new ViewGridPanel(m_GridPanel);
		myScorePanel = new ViewScorePanel(m_GridPanel);
		
		this.setLayout(new BorderLayout());
		this.add(myGridPanel, BorderLayout.CENTER);
		this.add(myScorePanel, BorderLayout.SOUTH);
	}

}
