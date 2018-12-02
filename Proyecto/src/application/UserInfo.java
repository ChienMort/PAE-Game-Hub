package application;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserInfo {

	public static void run(){
		ProjectImages pi = new ProjectImages();
		Stage stage = new Stage();
		GridPane gp = new GridPane();
		Scene scene = new Scene(gp, 300, 150);
		
		Text user = new Text("User Name");
		Text misc = new Text("work in progress");
		
		
		gp.add(user, 3, 0);
		gp.add(misc, 3, 1);
		
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}
	
}
