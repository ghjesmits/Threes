package threes;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class ModTile {
	private int m_Size;
	private Color m_Color;
	private int XPos;
	private int YPos;
	private int value;
	
	public ModTile(int xPos, int yPos, int value)
	{
		setXPos(xPos);
		setYPos(yPos);
		setSize(100);
		setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		setColor(value);
	}

	public void setYPos(int yPos) {
		this.YPos = yPos;
	}

	public int getSize() {
		return m_Size;
	}

	public Color getColor() {
		return m_Color;
	}

	public int getXPos() {
		return XPos;
	}

	public int getYPos() {
		return YPos;
	}

	public void setXPos(int xPos) {
		this.XPos = xPos;
	}

	private void setSize(int size) {
		this.m_Size = size;
	}

	public void setColor(int value) {
		switch (value) {
		case 1:
			this.m_Color = Color.BLUE;
			break;
		case 2:
			this.m_Color = Color.RED;
			break;
		case 3: case 6: case 12: case 24: case 48: case 96: case 192: case 384: case 768: case 1536: case 3072: case 6144:
			this.m_Color = Color.WHITE;
			break;
		default:
			this.m_Color = Color.GRAY;
			break;
		}
	}
}
