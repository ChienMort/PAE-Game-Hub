package application;

import games.CheckBoard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import localization.ProjectLocale;
import resources.sounds.ProjectSound;

public class Battleship{
	
	public static int[] bPos= new int[2];
			
	static Text leftText = new Text("none lol");
	static Text rightText = new Text("none yet lol");
	
	
	public static Scene Checkers(Stage stage, ProjectSound ps, DBConnection dbt){
		bPos[0]=0;
		bPos[1]=0;
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
		//
		
		//Left Side
		GridPane leftGp = new GridPane();
		Button toRight1 = new Button("Forward 1 space");
		Button toRight2 = new Button("Forward 2 spaces");
		Button toUp = new Button("Diagonal up");
		Button toDown = new Button("Diagonal down");
		
		leftGp.add(leftText, 0, 0);
		leftGp.add(toRight1, 0, 2);
		leftGp.add(toRight2, 1, 2);
		leftGp.add(toUp, 0, 1);
		leftGp.add(toDown, 0, 3);
		VBox leftVbox = new VBox(leftGp);
		leftVbox.setAlignment(Pos.CENTER);
		
		//Left side functionality
		toRight1.setOnMouseClicked(e->{
			CheckBoard.moveRight1(bPos[0], bPos[1]);
		});
		
		toRight2.setOnMouseClicked(e->{
			CheckBoard.moveRight2(bPos[0], bPos[1]);
		});
		
		toUp.setOnMouseClicked(e->{
			CheckBoard.moveUp(bPos[0], bPos[1]);
		});
		
		toDown.setOnMouseClicked(e->{
			CheckBoard.moveDown(bPos[0], bPos[1]);
		});
		
		
		//Right Side
		GridPane rightGp = new GridPane();
		Button rightToRight1 = new Button("Forward 1 space");
		Button rightToRight2 = new Button("Forward 2 spaces");
		Button rightToUp = new Button("Diagonal up");
		Button rightToDown = new Button("Diagonal down");
		
		rightGp.add(rightText, 0, 0);
		rightGp.add(rightToRight1, 0, 2);
		rightGp.add(rightToRight2, 1, 2);
		rightGp.add(rightToUp, 1, 1);
		rightGp.add(rightToDown, 1, 3);
		VBox rightVbox = new VBox(rightGp);
		rightVbox.setAlignment(Pos.CENTER);
		
		//Right side buttons functionality
		
		//Bottom
		Button Save, Load, Reset, Back;
		Reset = new Button(ProjectLocale.rb.getString("restart"));
		Back = new Button(ProjectLocale.rb.getString("return"));
		Back.setOnMouseClicked(e ->{
			stage.setScene(MainMenu.Menu(stage, ps, dbt));
		});
		Reset.setOnMouseClicked(e->{
			CheckBoard.resetBoard();
		});
		HBox hb1 = new HBox(Back, Reset); 
		hb1.setAlignment(Pos.CENTER);
		
		//
		rootPane.setTop(new Text("Checkers"));
		rootPane.setRight(rightVbox);
		rootPane.setLeft(leftVbox);
		
		rootPane.setCenter(centerHb);
		rootPane.setBottom(hb1);
		rootPane.setBackground(pi.backGround1());
		//
		
		Scene scene = new Scene(rootPane, 800, 600);
		return scene;
	}
	
	
	
	public static void update(){
	leftText.setText("Selected: " +bPos[0] +", " +bPos[1] +" - Piezas: " +CheckBoard.blacks);
	rightText.setText("Selected: " +bPos[0] +", " +bPos[1]+" - Piezas: " +CheckBoard.whites);
	
	for(int i=0; i<CheckBoard.size; i++){
		for(int o=0; o<CheckBoard.size; o++){
			switch(CheckBoard.board[i][o].state){
				default:
					CheckBoard.board[i][o].button.setText("-");					
					break;
					
				case 1:
					CheckBoard.board[i][o].button.setText("B");
					break;
					
				case 2:
					CheckBoard.board[i][o].button.setText("W");
					break;
			}
		}
	}
	
	}//Func end
	
}