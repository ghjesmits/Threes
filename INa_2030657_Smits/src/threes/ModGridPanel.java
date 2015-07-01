package threes;

import java.util.ArrayList;
import java.util.List;

public class ModGridPanel {

	private ArrayList<ModTile> m_Tiles = new ArrayList<ModTile>();
	private int size;
	private String tekst = "Nothing";
	private int numberOfMoves;
	private int TotalScore = 0;
	private int gameOverCounter = 0;
	private Boolean gameOver;

	public ModGridPanel(int size, ConApplication conApplication) {
		this.size = size;
		FileHandler fh = new FileHandler();
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				m_Tiles.add(new ModTile((x * 102) + 2, (y * 102) + 2, 0));
			}
		}
		List<String> list = fh.readTextFile("/files/input.txt");
		if(list != null){
			for(String s: list){
				String[] split = s.split(" ");
				int tempI = Integer.valueOf(split[0]);
				int tempV = Integer.valueOf(split[2]);
				m_Tiles.get(tempI).setValue(tempV);
			}
		}else{
			setRandoms();
		}
		setScore();
	}

	private void setRandoms() {
		int numberOfNum = 0;
		while (numberOfNum < 7) {
			int randomArray = 0 + (int) (Math.random() * (size * size));
			int randomNum = 1 + (int) (Math.random() * 3);
			if (numberOfNum < 7 && m_Tiles.get(randomArray).getValue() == 0) {
				m_Tiles.get(randomArray).setValue(randomNum);
				numberOfNum++;
			}
		}
	}

	public void moveRight() {
		this.tekst = "RIGHTy!";
		numberOfMoves++;
		for (int i = m_Tiles.size() - 1; i >= 0; i--) {
			if (m_Tiles.get(i).getValue() != 0 && m_Tiles.get(i).getXPos() <  size * m_Tiles.get(0).getSize() - m_Tiles.get(0).getSize()) {
				if (m_Tiles.get(i + 1).getValue() == 0) {
					m_Tiles.get(i + 1).setValue(m_Tiles.get(i).getValue());
					m_Tiles.get(i).setValue(0);
				} else if ((m_Tiles.get(i).getValue() == 1 && m_Tiles
						.get(i + 1).getValue() == 2)
						|| (m_Tiles.get(i).getValue() == 2 && m_Tiles
								.get(i + 1).getValue() == 1)
						|| ((m_Tiles.get(i).getValue() == m_Tiles.get(i + 1)
								.getValue() && m_Tiles.get(i).getValue() != 1 && m_Tiles
								.get(i).getValue() != 2))) {
					
					m_Tiles.get(i + 1).setValue(m_Tiles.get(i).getValue()+ m_Tiles.get(i + 1).getValue());
					m_Tiles.get(i).setValue(0);
				}
			}
		}
		addRandom(2);
		checkGameOver();
	}

	public void moveLeft() {
		this.tekst = "Go LEFT!";
		numberOfMoves++;
		for (int i = 0; i < m_Tiles.size(); i++) {
			if (m_Tiles.get(i).getValue() != 0 && m_Tiles.get(i).getXPos() > 100) {
				if (m_Tiles.get(i - 1).getValue() == 0) {
					m_Tiles.get(i - 1).setValue(m_Tiles.get(i).getValue());
					m_Tiles.get(i).setValue(0);
				} else if ((m_Tiles.get(i).getValue() == 1 && m_Tiles
						.get(i - 1).getValue() == 2)
						|| (m_Tiles.get(i).getValue() == 2 && m_Tiles
								.get(i - 1).getValue() == 1)
						|| ((m_Tiles.get(i).getValue() == m_Tiles.get(i - 1)
								.getValue() && m_Tiles.get(i).getValue() != 1 && m_Tiles
								.get(i).getValue() != 2))) {
					
					m_Tiles.get(i - 1).setValue(m_Tiles.get(i).getValue() + m_Tiles.get(i - 1).getValue());
					m_Tiles.get(i).setValue(0);
				}
			}
		}
		addRandom(4);
		checkGameOver();
	}

	public void moveUp() {
		this.tekst = "Rise UP!";
		numberOfMoves++;
		for (int i = 0; i < m_Tiles.size(); i++) {
			if (m_Tiles.get(i).getValue() != 0 && m_Tiles.get(i).getYPos() > 100) {
				if (m_Tiles.get(i - size).getValue() == 0) {
					m_Tiles.get(i - size).setValue(m_Tiles.get(i).getValue());
					m_Tiles.get(i).setValue(0);
				} else if ((m_Tiles.get(i).getValue() == 1 && m_Tiles
						.get(i - size).getValue() == 2)
						|| (m_Tiles.get(i).getValue() == 2 && m_Tiles
								.get(i - size).getValue() == 1)
						|| ((m_Tiles.get(i).getValue() == m_Tiles.get(i - size)
								.getValue() && m_Tiles.get(i).getValue() != 1 && m_Tiles
								.get(i).getValue() != 2))) {
				
					m_Tiles.get(i - size).setValue(m_Tiles.get(i).getValue() + m_Tiles.get(i - size).getValue());
					m_Tiles.get(i).setValue(0);
				}
			}
		}
		addRandom(3);
		checkGameOver();
	}

	public void moveDown() {
		this.tekst = "DOWNio!";
		numberOfMoves++;
		for (int i = m_Tiles.size() - 1; i >= 0; i--) {
			if (m_Tiles.get(i).getValue() != 0 && m_Tiles.get(i).getYPos() <  size * m_Tiles.get(0).getSize() - m_Tiles.get(0).getSize()) {
				if (m_Tiles.get(i + size).getValue() == 0) {
					m_Tiles.get(i + size).setValue(m_Tiles.get(i).getValue());
					m_Tiles.get(i).setValue(0);
				} else if ((m_Tiles.get(i).getValue() == 1 && m_Tiles
						.get(i + size).getValue() == 2)
						|| (m_Tiles.get(i).getValue() == 2 && m_Tiles
								.get(i + size).getValue() == 1)
						|| ((m_Tiles.get(i).getValue() == m_Tiles.get(i + size)
								.getValue() && m_Tiles.get(i).getValue() != 1 && m_Tiles
								.get(i).getValue() != 2))) {
					
					m_Tiles.get(i + size).setValue(m_Tiles.get(i).getValue()+ m_Tiles.get(i + size).getValue());
					m_Tiles.get(i).setValue(0);
				}
			}
		}
		addRandom(1);
		checkGameOver();
	}
	
	private void addRandom(int x){
		for(int i = 0; i< m_Tiles.size(); i++){
			int randomNum = 1 + (int) (Math.random() * 3);
			int randomTile = 0 + (int) (Math.random() * size);
			//randomtegel bovenin
			if(x == 1 && m_Tiles.get(randomTile).getValue() == 0){
				m_Tiles.get(randomTile).setValue(randomNum);
				gameOverCounter = 0;
				break;
			}
			//randomtegel links
			else if(x == 2 && m_Tiles.get(randomTile * size).getValue() == 0){
				m_Tiles.get(randomTile * size).setValue(randomNum);
				gameOverCounter = 0;
				break;
			}
			//randomtegel beneden
			else if(x == 3 && m_Tiles.get(size * size - 1 - randomTile).getValue() == 0){
				m_Tiles.get(size * size - 1 - randomTile).setValue(randomNum);
				gameOverCounter = 0;
				break;
			}
			//randomtegel rechts
			else if(x == 4 && m_Tiles.get(randomTile * size + 3).getValue() == 0){
				m_Tiles.get(randomTile * size + 3).setValue(randomNum);
				gameOverCounter = 0;
				break;
			}else{
				gameOverCounter++;
			}
		}
	}

	public void checkGameOver() {
		if(getGameOverCounter() >= 60){
			gameOver = true;
			System.out.println("Game Over Total Score was:" + TotalScore);
			System.exit(1);
		}else{
			gameOver = false;
		}			
	}

	public Boolean getGameOver() {
		return gameOver;
	}

	public int getGameOverCounter() {
		return gameOverCounter;
	}

	public int getNumberOfMoves() {
		return numberOfMoves;
	}

	public String getTekst() {
		return tekst;
	}

	public ArrayList<ModTile> getTiles() {
		return m_Tiles;
	}

	public int getSize() {
		return size;
	}
	
	public void setScore() {
		TotalScore = 0;
		for(int i = 0; i < m_Tiles.size(); i++){
			int score = 0;
			switch (m_Tiles.get(i).getValue()) {
			case 3:
				score = 3;
				break;
			case 6:
				score = 9;
				break;
			case 12: 
				score = 27;
				break;
			case 24: 
				score = 81;
				break;
			case 48: 
				score = 243;
				break;
			case 96: 
				score = 729;
				break;
			case 192: 
				score = 2189;
				break;
			case 384: 
				score = 6561;
				break;
			case 768: 
				score = 19683;
				break;
			case 1536: 
				score = 59049;
				break;
			case 3072: 
				score = 177147;
			break;
			case 6144: 
				score = 531441;
			break;
			default:
				score = 0;
			break;
			}
			TotalScore = TotalScore + score;
		}
	}
	
	public int getTotalScore() {
		return TotalScore;
	}

}
