package games;

public class Board {
	
	public static Tile[][] board = new Tile[8][8];
	public static int exists = 0;
	
	
	public Board(){
		for(int i=0; i<8; i++){
			for(int o=0; o<8; o++){
				
				board[i][o] = new Tile(0, i, o);
				
				
				
			}
		}
		

		
	}
	
}
