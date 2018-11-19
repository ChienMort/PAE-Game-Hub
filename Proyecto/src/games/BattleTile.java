package games;

import javafx.scene.control.Button;

public class BattleTile {

	public state currState;
	public direction currDir;
	int shipSize;
	public Button button;
	
	public static enum state {
		Empty, Ship_Head, Ship_Body, Ship_Sunk
	}
	
	public static enum direction{
		up, down, left, right
	}
	
	public BattleTile(){
		currState = currState.Empty;
		currDir = direction.down;
		shipSize = 0;
		button = new Button();
	}
	
	
	public BattleTile(int s, int b){
		currState = currState.Empty;
		currDir = direction.down;
		shipSize = s;
		
		switch(b){
		
		
			default:
				button = new Button();
				button.setBackground(null);
		}
		
	}
	
	
	
}
