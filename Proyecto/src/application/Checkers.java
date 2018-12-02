package application;

import java.util.ArrayList;
import java.util.List;

import games.CheckBoard;
import games.Tile;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import localization.ProjectLocale;
import resources.sounds.ProjectSound;

public class Checkers {

	public static Tile[][] checkBoard = new Tile[8][8];
	public static boolean firstTime = true;
	public static ProjectImages pi = new ProjectImages();
	
	
	public static void initBoard(){
		if(firstTime){
		for(int i=0; i<8; i++){
			for(int o=0; o<8; o++){
				if(i==0) checkBoard[i][o]=new Tile(1, i, o);
				else if(i==7) checkBoard[i][o]=new Tile(2, i, o);
				else checkBoard[i][o]=new Tile(0, i, o);
				}
			}
		firstTime = false; //Previene que esté creando muchos tableros
		}
	}
	
	public static void addToPane(GridPane gp){
		for(int i=0; i<8; i++){
			for(int o=0; o<8; o++){
				gp.add(checkBoard[i][o].currentImage, i, o);
			}
		}
	}
	
public static void swapSpaces(int x, int y, int o, int p){
	Tile bufferTile;
	bufferTile = checkBoard[x][y];
	checkBoard[o][p] = checkBoard[x][y];
	checkBoard[x][y] = bufferTile;
	
}
	
public static void update(){
	
}

public static Scene Checkers(Stage stage, ProjectSound ps, DBConnection dbt){
	BorderPane rootPane = new BorderPane();
	//Mid
	GridPane gp = new GridPane();
	VBox midVb = new VBox(gp);
	midVb.setAlignment(Pos.CENTER);
	//render
	initBoard();
	addToPane(gp);
	
	
	//Actions
	
	//Bottom
	Button Reset, Back;
	Reset = new Button(ProjectLocale.rb.getString("restart"));
	Back = new Button(ProjectLocale.rb.getString("return"));
	Reset.setPrefSize(60, 40);
	Back.setPrefSize(60, 40);
			
	Back.setOnMouseClicked(e ->{
		stage.setScene(MainMenu.Menu(stage, ps, dbt));
	});
	Reset.setOnMouseClicked(e->{
		CheckBoard.resetBoard();
	});
	HBox hb1 = new HBox(Back, Reset); 
	hb1.setAlignment(Pos.CENTER);
	hb1.setSpacing(50);
	
	
	//Top
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
	topHBox.setSpacing(50);
	topHBox.setBackground(pi.backGround2());
	topHBox.setAlignment(Pos.CENTER);

	
	//General
	rootPane.setBackground(pi.backGround1());
	
	rootPane.setBottom(hb1);
	rootPane.setCenter(midVb);
	BorderPane.setAlignment(midVb, Pos.CENTER);
	rootPane.setTop(topHBox);
	Scene scene = new Scene(rootPane, 800, 600);
	return scene;
	}
}


	

