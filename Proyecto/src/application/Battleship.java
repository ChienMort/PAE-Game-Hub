package application;

import games.CheckBoard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import localization.ProjectLocale;
import resources.sounds.ProjectSound;

public class Battleship{
	public static Scene Checkers(Stage stage, ProjectSound ps, DBConnection dbt){
		BorderPane rootPane = new BorderPane();
		ProjectImages pi = new ProjectImages();
		//Middle
		GridPane gp = new GridPane();
		CheckBoard.initBoard();
		
		//Render shit
		for(int i = 0; i<8; i++){
			for(int o = 0; o<8; o++){
				gp.add(CheckBoard.board[i][o].getButton(), i, o);
			}
		}
		HBox centerHb = new HBox(gp);
		centerHb.setAlignment(Pos.CENTER);
		
		//Bottom
		Button Save, Load, Reset, Back;
		Reset = new Button(ProjectLocale.rb.getString("restart"));
		Back = new Button(ProjectLocale.rb.getString("return"));
		Back.setOnMouseClicked(e ->{
			stage.setScene(MainMenu.Menu(stage, ps, dbt));
		});
		
		HBox hb1 = new HBox(Back, Reset); 
		hb1.setAlignment(Pos.CENTER);

		
		//
		rootPane.setTop(new Text("Checkers"));
		rootPane.setRight(new Text("a"));
		rootPane.setLeft(new Text("a"));
		
		rootPane.setCenter(centerHb);
		rootPane.setBottom(hb1);
		rootPane.setBackground(pi.backGround1());
		//
		
		Scene scene = new Scene(rootPane, 800, 600);
		return scene;
	}
}