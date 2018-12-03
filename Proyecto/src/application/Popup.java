package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import localization.ProjectLocale;

public class Popup
{
	static String k = null;
	public static void run()
	{	
		Stage stage = new Stage();
		GridPane gp = new GridPane();
		Button btn =  new Button(ProjectLocale.rb.getString("send"));
		TextField tf = new TextField();
		
		btn.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
		{
			k = tf.getText();
			stage.close();
		});
		
		gp.add(tf, 0, 0);
		gp.add(btn, 0, 2);
		gp.setAlignment(Pos.CENTER);
		Scene scene = new Scene(gp, 250, 100);
		stage.setScene(scene);
		stage.show();
	}
}
