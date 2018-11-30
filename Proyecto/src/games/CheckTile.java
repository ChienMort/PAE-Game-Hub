package games;

import javafx.scene.control.Button;

public class CheckTile {

	public int state=0;
	public Button button;
	public int x, y;
	
	public CheckTile(int s, int x, int y){
		state = s;
		this.x = x;
		this.y = y;
		switch(s){
		default:
			 button = new Button(" ");
			break;
			
		case 1:
			button = new Button("B");
			break;
			
		case 2:
			button = new Button("W");
			break;
		}
		
		button.setOnAction(e->{System.out.println("Coord: " +x +", " +y);
		});
		button.setPrefSize(50, 50);
		
	}
	
	public Button getButton(){
		return button;
	}
	
	public void selected(){
		System.out.println("Coord: " +x +", " +y);
	}
	
}
