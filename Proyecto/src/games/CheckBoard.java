package games;


public class CheckBoard {
	
	private static int size=8;
	public static CheckTile[][] board = new CheckTile[size][size];
	private static int exists = 0;

	
	/*
	
	0 = Empty
	1 = Black Piece
	2 = White Piece
	
	*/
	
	public static void initBoard(){
		//Checa para que no esté creando nuevos tableros
		if(exists==0){
			for(int i = 0; i<size; i++){
				for(int o = 0; o<size; o++){
					board[i][o]=new CheckTile(0, i, o);
				}
			}
		//Poner las piezas
		for(int i=0; i<size; i++){
			
			if(i%2==1){
				board[0][i]=new CheckTile(1, 0, i);
				board[2][i]=new CheckTile(1, 2, i);
				board[6][i]=new CheckTile(2, 6, i);
			}
			
			if(i%2==0){
				board[1][i]=new CheckTile(1, 1, i);
				board[5][i]=new CheckTile(2, 5, i);
				board[7][i]=new CheckTile(2, 7, i);
			}
			}
		}
	}
	
}
