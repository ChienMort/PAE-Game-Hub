package games;

import application.Battleship;
import application.ProjectImages;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;

public class CheckTile {

	public ProjectImages pi = new ProjectImages();
	public int state=0;
	public Button button;
	public int x, y;
	
	public CheckTile(int s, int x, int y){
		state = s;
		this.x = x;
		this.y = y;
		switch(s){
		default:
			 button = new Button();
			break;
			
		case 1:
			button = new Button();
			break;
			
		case 2:
			button = new Button();
			break;
		}
		
		button.setOnAction(e->{
			System.out.println("Coord: " +x +", " +y);
			selected();
			Battleship.update();
		});
		button.setPrefSize(60, 60);

	}
	
	public Button getButton(){
		return button;
	}
	
	public void selected(){
		Battleship.bPos[0]=x;
		Battleship.bPos[1]=y;
		System.out.println("Coord: " +x +", " +y);
	}

	
	
}
