package games;

public class BattleBoard {
	
	private int size = 5;
	public BattleTile[][] board = new BattleTile[size][size];
	
	public int getSize(){ return size; }
	
	public BattleBoard(){
		initBoard();
	}
	
	private void initBoard(){
		for(int i=0; i<size; i++){
			for(int o=0; o<size; o++){
				if(i < 3 || o < 3) board[i][o] = new BattleTile(2);
				else board[i][o] = new BattleTile();
			}
		}
	}
	
	
}
