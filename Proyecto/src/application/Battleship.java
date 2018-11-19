package application;

import games.BattleBoard;
import games.BattleTile;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Battleship {

	
	
	public static Scene battleship(Stage stage){
		
		BorderPane rootPane = new BorderPane();
		GridPane GamePane = new GridPane();
		
		//
		BattleBoard Board = new BattleBoard();
		//
		
		//Game display
		
		//End
		
		rootPane.setCenter(GamePane);
		
		Scene scene = new Scene(rootPane, 800, 600);
		return scene;
	}
}
