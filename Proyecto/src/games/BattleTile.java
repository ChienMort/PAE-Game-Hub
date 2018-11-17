package games;

public class BattleTile {

	public state currState;
	public direction currDir;
	int shipSize;
	
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
	}
	
	
	public BattleTile(int s){
		currState = currState.Empty;
		currDir = direction.down;
		shipSize = s;
	}
	
	
	
}
