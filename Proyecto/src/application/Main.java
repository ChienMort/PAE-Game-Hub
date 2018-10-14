package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setScene(mainMenu(primaryStage));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	public static Scene mainMenu(Stage primaryStage){
		BorderPane rootPane = new BorderPane();
		int sceneW = 800;
		int sceneH = 600;
		Font font = new Font(40);
		ProjectImages projector = new ProjectImages();
		
		
		//Top
		HBox topSide = new HBox(3);
		Button userInfo = new Button("User Info");
		Text Title = new Text("Minigames");
		Title.setFont(Font.font(60));
		Circle status = new Circle(10);
	
		topSide.setPadding(new Insets(10, 100, 10, 100));
		topSide.setSpacing(100);
		topSide.getChildren().addAll(userInfo, Title, status);
		topSide.alignmentProperty().set(Pos.TOP_CENTER);
		topSide.setBackground(projector.backGround2());
		
		//Center
		int x= 300, y=150;
		VBox centerButtons = new VBox(3);
		centerButtons.setSpacing(40);
		
		Button ajedrez = new Button("Ajedrez");
		ajedrez.setPrefSize(x, y);
		ajedrez.setBackground(projector.ChessIcon(x, y));
		ajedrez.setFont(font);
		ajedrez.setAlignment(Pos.BASELINE_RIGHT);
		
		Button gato = new Button("Gato");
		gato.setPrefSize(x, y);
		gato.setBackground(projector.gatoIcon(x, y));
		gato.setFont(font);
		gato.setAlignment(Pos.BASELINE_RIGHT);
		
		
		Button battleShip = new Button("Battle Ship");
		battleShip.setPrefSize(x, y);
		battleShip.setBackground(projector.battleIcon(x, y));
		battleShip.setFont(font);
		battleShip.setAlignment(Pos.BASELINE_RIGHT);
		
		
		//centerButtons.setStyle("-fx-background-color: #6ECBB5;");
		centerButtons.setBackground(projector.backGround1());
		centerButtons.getChildren().addAll(ajedrez, gato, battleShip);
		
		//Right Image
		HBox hb = new HBox(1);
		hb.setBackground(projector.backGround1());
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
			            gamePreview.setImage(projector.getPreview(1));;
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
			            gamePreview.setImage(projector.getPreview(3));;
			        }
			});

		
		//Final
		Scene scene = new Scene(rootPane, sceneW, sceneH);
		scene.fillProperty().set(Color.BURLYWOOD);
		return scene;
	}
	
}
