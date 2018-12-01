package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import localization.ProjectLocale;
import resources.sounds.ProjectSound;

public class MainMenu {
	
	public static Scene Menu(Stage stage, ProjectSound ps, DBConnection dbt)
	{
		BorderPane rootPane = new BorderPane();
		int sceneW = 800;
		int sceneH = 600;
		Font font = new Font(40);
		ProjectImages projector = new ProjectImages();
		
		
		//Top
		HBox topSide = new HBox(3);
		topSide.setBackground(projector.backGround2());
		String[] selection = { "Mute", "Student Council", "Afternoon", "Concord", "Nocturne"};
		ChoiceBox<String> music = new ChoiceBox<String>(FXCollections.observableArrayList(selection));
		music.getSelectionModel().selectFirst();
		
		music.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                ps.playMenuMusic(music.getValue());
                System.out.println((String)music.getValue());
            }
        });
		
		
		Text Title = new Text(ProjectLocale.rb.getString("games"));
		Title.setFont(Font.font(60));
	
		topSide.setPadding(new Insets(10, 100, 10, 100));
		topSide.setSpacing(100);
		topSide.getChildren().addAll(Title, music);
		topSide.alignmentProperty().set(Pos.TOP_CENTER);
		
		//Center
		int x= 300, y=150;
		VBox centerButtons = new VBox(3);
		centerButtons.setSpacing(40);
		
		Button ajedrez = new Button(ProjectLocale.rb.getString("chess_game"));
		ajedrez.setPrefSize(x, y);
		ajedrez.setBackground(projector.ChessIcon(x, y));
		ajedrez.setFont(font);
		ajedrez.setAlignment(Pos.BASELINE_RIGHT);
		
		Button gato = new Button(ProjectLocale.rb.getString("gato_game"));
		gato.setPrefSize(x, y);
		gato.setBackground(projector.gatoIcon(x, y));
		gato.setFont(font);
		gato.setAlignment(Pos.BASELINE_RIGHT);
		
		Button battleShip = new Button(ProjectLocale.rb.getString("battleship_game"));
		battleShip.setPrefSize(x, y);
		battleShip.setBackground(projector.battleIcon(x, y));
		battleShip.setFont(font);
		battleShip.setAlignment(Pos.BASELINE_RIGHT);
		
		
		//centerButtons.setStyle("-fx-background-color: #6ECBB5;");
		centerButtons.setBackground(projector.backGround1());
		centerButtons.getChildren().addAll(ajedrez, gato, battleShip);
		
		//Right Image
		HBox hb = new HBox(1);
		hb.alignmentProperty().set(Pos.CENTER_LEFT);
		
		ImageView gamePreview = new ImageView(projector.getPreview(2));
		gamePreview.setFitHeight(400);
		gamePreview.setFitWidth(400);
		
		hb.getChildren().add(gamePreview);
		rootPane.setRight(hb);
		
		//Add to root
		rootPane.setTop(topSide);
		rootPane.setCenter(centerButtons);
		
		//Actions
		ajedrez.addEventHandler(MouseEvent.MOUSE_ENTERED, 
			    new EventHandler<MouseEvent>() {
			        @Override public void handle(MouseEvent e) {
			            gamePreview.setImage(projector.getPreview(1));
			       
			        }
			});
		
		battleShip.addEventHandler(MouseEvent.MOUSE_ENTERED, 
			    new EventHandler<MouseEvent>() {
			        @Override public void handle(MouseEvent e) {
			            gamePreview.setImage(projector.getPreview(2));;
			        }
			});
		
		gato.addEventHandler(MouseEvent.MOUSE_ENTERED, 
			    new EventHandler<MouseEvent>() {
			        @Override public void handle(MouseEvent e) {

			            gamePreview.setImage(projector.getPreview(3));		

			            gamePreview.setImage(projector.getPreview(3));;
			        }
			});
		
		gato.setOnAction(eve->
		{
			stage.setScene(Gato.gato(stage, ps, dbt));
		});
		
		ajedrez.setOnAction(eve->{
			stage.setScene(Ajedrez.ajedrez(stage, ps, dbt));
			});
		
		battleShip.setOnAction(eve->{
			stage.setScene(Battleship.Checkers(stage, ps, dbt));
			
		});
		
		//Final
				rootPane.setBackground(projector.backGround1());		
				Scene scene = new Scene(rootPane, sceneW, sceneH);
				return scene;
	}
}
	//Unfinished
	
		
	


