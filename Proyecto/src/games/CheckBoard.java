package games;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import application.Battleship;

public class CheckBoard {
	
	public static int size=8;
	public static CheckTile[][] board = new CheckTile[size][size];
	private static int exists = 0;
	public static int blacks = 12;
	public static int whites = 12;
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
	
	//Init end
	
	//Funciones de utilidad
	public static void resetBoard(){
		blacks=12;
		whites=12;
		for(int i = 0; i<size; i++){
			for(int o=0; o<size; o++){
				board[i][o].state=0;
			}
		}
		for(int i=0; i<size; i++){		
			if(i%2==1){
				board[0][i].state=1;
				board[2][i].state=1;
				board[6][i].state=2;
			}
			if(i%2==0){
				board[1][i].state=1;
				board[5][i].state=2;
				board[7][i].state=2;
				}
			}
		Battleship.update();
	}
	
	//Funciones de movimiento
		//Left
		public static void moveRight1(int x, int y){
			//System.out.println("T1");
			if( ((x+1) < 8) && (board[x][y].state!=0) && (board[x][y].state==1)){//Checa que no salga del tablero
				//System.out.println("T2");
				switch(board[x+1][y].state){
				case 0:
					board[x+1][y].state=1;
					board[x][y].state=0;
					Battleship.update();
				break;
				
				case 2:
					board[x+1][y].state=1;
					board[x][y].state=0;
					whites--;
					Battleship.update();
					break;
					}
			}
		}
		
		public static void moveRight2(int x, int y){
			if( ((x+2) < 8) && (board[x][y].state!=0) && (board[x][y].state==1) ){//Checa que no salga del tablero
			switch(board[x+2][y].state){
			case 0:
				board[x+2][y].state=1;
				board[x][y].state=0;
				Battleship.update();
			break;
			
			case 2:
				board[x+2][y].state=1;
				board[x][y].state=0;
				whites--;
				Battleship.update();
				break;
				}
			}
		}
		
		public static void moveUp(int x, int y){
			//System.out.println("T1");
			if( ((x+1) < 8) && ((y-1) >= 0) && (board[x][y].state!=0) && (board[x][y].state==1)){//Checa que no salga del tablero
				//System.out.println("T2");
				switch(board[x+1][y-1].state){
				case 0:
					board[x+1][y-1].state=1;
					board[x][y].state=0;
					Battleship.update();
				break;
				
				case 2:
					board[x+1][y-1].state=1;
					board[x][y].state=0;
					whites--;
					Battleship.update();
					break;
					}
			}
		}
		
		public static void moveDown(int x, int y){
			//System.out.println("T1");
			if( ((x+1) < 8) && (y+1 < 8) && (board[x][y].state!=0) && (board[x][y].state==1)){//Checa que no salga del tablero
				//System.out.println("T2");
				switch(board[x+1][y+1].state){
				case 0:
					board[x+1][y+1].state=1;
					board[x][y].state=0;
					Battleship.update();
				break;
				
				case 2:
					board[x+1][y+1].state=1;
					board[x][y].state=0;
					whites--;
					Battleship.update();
					break;
					}
			}
		}
		
		//Right
		public static void moveLeft1(int x, int y){
			//System.out.println("T1");
			if( ((x-1) >= 0) && (board[x][y].state!=0) && (board[x][y].state==2)){//Checa que no salga del tablero
				//System.out.println("T2");
				switch(board[x-1][y].state){
				case 0:
					board[x-1][y].state=2;
					board[x][y].state=0;
					Battleship.update();
				break;
				
				case 1:
					board[x-1][y].state=2;
					board[x][y].state=0;
					blacks--;
					Battleship.update();
					break;
					}
			}
		}
		
		public static void moveLeft2(int x, int y){
			if( ((x-2) >= 0) && (board[x][y].state!=0) && (board[x][y].state==2) ){//Checa que no salga del tablero
			switch(board[x-2][y].state){
			case 0:
				board[x-2][y].state=2;
				board[x][y].state=0;
				Battleship.update();
			break;
			
			case 1:
				board[x-2][y].state=2;
				board[x][y].state=0;
				blacks--;
				Battleship.update();
				break;
				}
			}
		}
		
		public static void moveLeftUp(int x, int y){
			//System.out.println("T1");
			if( ((x-1) >= 0) && ((y-1) >= 0) && (board[x][y].state!=0) && (board[x][y].state==2)){//Checa que no salga del tablero
				//System.out.println("T2");
				switch(board[x-1][y-1].state){
				case 0:
					board[x-1][y-1].state=2;
					board[x][y].state=0;
					Battleship.update();
				break;
				
				case 1:
					board[x-1][y-1].state=2;
					board[x][y].state=0;
					blacks--;
					Battleship.update();
					break;
					}
			}
		}
		
		public static void moveLeftDown(int x, int y){
			//System.out.println("T1");
			if( ((x-1) >= 0) && (y+1 < 8) && (board[x][y].state!=0) && (board[x][y].state==2)){//Checa que no salga del tablero
				//System.out.println("T2");
				switch(board[x-1][y+1].state){
				case 0:
					board[x-1][y+1].state=2;
					board[x][y].state=0;
					Battleship.update();
				break;
				
				case 1:
					board[x-1][y+1].state=2;
					board[x][y].state=0;
					blacks--;
					Battleship.update();
					break;
					}
			}
		}
		public static void win(){
			if(whites==0){ 
				JOptionPane.showMessageDialog(new JPanel(), "Black side wins!","Result", JOptionPane.INFORMATION_MESSAGE);
				resetBoard();
			}else if(blacks==0){
				JOptionPane.showMessageDialog(new JPanel(), "White side wins!" ,"Result", JOptionPane.INFORMATION_MESSAGE);
				resetBoard();

			}
		}
		
		
		
}
