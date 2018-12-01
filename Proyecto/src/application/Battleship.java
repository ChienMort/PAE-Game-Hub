package application;

import games.CheckBoard;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import localization.ProjectLocale;
import resources.sounds.ProjectSound;

public class Battleship{
	
	public static int[] bPos= new int[2];
	
	static Text leftText = new Text("none lol");
	static Text rightText = new Text("none yet lol");
	static ProjectImages pi = new ProjectImages();
	
	static Button rightToRight1 = new Button("Forward 1 space");
	static Button rightToRight2 = new Button("Forward 2 spaces");
	static Button rightToUp = new Button("Diagonal up");
	static Button rightToDown = new Button("Diagonal down");
	
	static Button toRight1 = new Button("Forward 1 space");
	static Button toRight2 = new Button("Forward 2 spaces");
	static Button toUp = new Button("Diagonal up");
	static Button toDown = new Button("Diagonal down");
	
	
	public static Scene Checkers(Stage stage, ProjectSound ps, DBConnection dbt){
		bPos[0]=0;
		bPos[1]=0;
		BorderPane rootPane = new BorderPane();
		ProjectImages pi = new ProjectImages();
		//Middle
		GridPane gp = new GridPane();
		CheckBoard.initBoard();
		CheckBoard.resetBoard();
		
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
		leftGp.setPadding(new Insets(50,1,50,1));
		
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
		rightGp.setPadding(new Insets(50,1,50,1));
		
		rightGp.add(rightText, 0, 0);
		rightGp.add(rightToRight1, 1, 2);
		rightGp.add(rightToRight2, 0, 2);
		rightGp.add(rightToUp, 1, 1);
		rightGp.add(rightToDown, 1, 3);
		VBox rightVbox = new VBox(rightGp);
		rightVbox.setAlignment(Pos.CENTER);
		rightVbox.setPadding(new Insets(50,1,50,1));
		
		//Right side buttons functionality
		rightToRight1.setOnMouseClicked(e->{
			CheckBoard.moveLeft1(bPos[0], bPos[1]);
		});
		
		rightToRight2.setOnMouseClicked(e->{
			CheckBoard.moveLeft2(bPos[0], bPos[1]);
		});
		rightToUp.setOnMouseClicked(e->{
			CheckBoard.moveLeftUp(bPos[0], bPos[1]);
		});
		rightToDown.setOnMouseClicked(e->{
			CheckBoard.moveLeftDown(bPos[0], bPos[1]);
		});
		
		
		//Bottom
		Button Reset, Back;
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
		hb1.setPadding(new Insets(5,20,5,20));
		
		//top

		String[] selection = { "Mute", "Student Council", "Afternoon", "Concord", "Nocturne"};
		ChoiceBox<String> music = new ChoiceBox<String>(FXCollections.observableArrayList(selection));
		music.getSelectionModel().selectFirst();
		
		music.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                ps.playMenuMusic(music.getValue());
                System.out.println((String)music.getValue());
            }
        });
		Text title = new Text("Checkers");
		title.setFont(Font.font(70));
		HBox topHBox = new HBox(title, music);
		topHBox.setBackground(pi.backGround2());
		topHBox.setAlignment(Pos.CENTER);
		topHBox.setPadding(new Insets(5,20,5,20));
		
		//Setsides
		rootPane.setTop(topHBox);
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
			if(i%2==0 && o%2==0) CheckBoard.board[i][o].button.setBackground(pi.getTileColor(0));
			else if(i%2!=0 && o%2!=0) CheckBoard.board[i][o].button.setBackground(pi.getTileColor(0));
			else CheckBoard.board[i][o].button.setBackground(pi.getTileColor(1));

			switch(CheckBoard.board[i][o].state){
				default:
					CheckBoard.board[i][o].button.setGraphic(null);					
					break;
					
				case 1:
					CheckBoard.board[i][o].button.setGraphic(pi.getCheckPiece(0));
					break;
					
				case 2:
					CheckBoard.board[i][o].button.setGraphic(pi.getCheckPiece(1));
					break;
			}
		}
	}
	CheckBoard.win();
	}//Func end
	
	public static void handleTurn(){
		if(CheckBoard.turn){
		rightToRight1.setDisable(true);
		rightToRight2.setDisable(true);
		rightToUp.setDisable(true);
		rightToDown.setDisable(true);
		
		toRight1.setDisable(false);
		toRight2.setDisable(false);
		toUp.setDisable(false);
		toDown.setDisable(false);
		CheckBoard.turn = false;
		}else{
			
		rightToRight1.setDisable(false);
		rightToRight2.setDisable(false);
		rightToUp.setDisable(false);
		rightToDown.setDisable(false);
			
		toRight1.setDisable(true);
		toRight2.setDisable(true);
		toUp.setDisable(true);
		toDown.setDisable(true);
		CheckBoard.turn = true;
			
		}
	}
	
}