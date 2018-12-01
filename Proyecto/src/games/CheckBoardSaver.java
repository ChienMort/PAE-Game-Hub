package games;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CheckBoardSaver {

	public CheckTile[][] board;
	public int blacks;
	public int whites;
	
	public CheckBoardSaver(){
		this.board = CheckBoard.board;
		this.blacks = CheckBoard.blacks;
		this.whites = CheckBoard.whites;
	}

	public void update(){
		this.board = CheckBoard.board;
		this.blacks = CheckBoard.blacks;
		this.whites = CheckBoard.whites;

	}
	
	public void save(){
		 try {
			 File f = new File("checkSession.dat");
			 CheckBoardSaver e = new CheckBoardSaver();
	         FileOutputStream fileOut = new FileOutputStream(f);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in saves");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }	
	}
	
	public void load(){
		CheckBoardSaver e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("checkSession.dat");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (CheckBoardSaver) in.readObject();
	         in.close();
	         fileIn.close();
	         CheckBoard.board = e.board;
	         CheckBoard.blacks = e.blacks;
	         CheckBoard.whites = e.whites;
	      } catch (IOException i) {
	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("ERR Load");
	         c.printStackTrace();
	      }
	}
	
}
