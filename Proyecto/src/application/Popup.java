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
	static String k = "";
	
	public static String run()
	{
		Stage stage = new Stage();
		GridPane gp = new GridPane();
		Scene scene = new Scene(gp, 250, 100);
		TextField utf = new TextField();
		Button lbtn = new Button(ProjectLocale.rb.getString("send"));
		
		gp.add(utf, 0, 0);
		gp.add(lbtn, 0, 1);
		
		gp.setAlignment(Pos.CENTER);
		
		lbtn.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
		{
			k = utf.getText();
			stage.close();
		});
		
		stage.setScene(scene);
		stage.show();
		while(stage.isShowing())
		{
			System.out.println("kk");
		}
		return k;
	}
}
