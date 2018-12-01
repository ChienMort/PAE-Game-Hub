package application;

import javax.swing.JOptionPane;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import localization.ProjectLocale;
import resources.sounds.ProjectSound;

public class Login
{	
	public static Scene login(Stage stage, ProjectSound ps, DBConnection dbt)
	{
		//Ricardo - Agregando cosas para adaptar el código
		int sceneWidth = 280, sceneHeight = 340;
		ProjectImages pi = new ProjectImages();
		
		//Añadiendo lenguajes
		ChoiceBox<String> cb = new ChoiceBox<String>();
		cb.getItems().addAll("English", "Español");
		cb.getSelectionModel().selectFirst();
		//Tec - Código
		Button lbtn = new Button(ProjectLocale.rb.getString("login"));
		Button cbtn = new Button(ProjectLocale.rb.getString("register"));
		TextField utf = new TextField();
		Label ulb = new Label(ProjectLocale.rb.getString("user"));
		Label plb = new Label(ProjectLocale.rb.getString("password"));
		
		PasswordField pf = new PasswordField();
		GridPane gp = new GridPane();
		gp.setBackground(pi.backGround1());
		


		utf.setMaxWidth(120.0);
		pf.setMaxWidth(120.0);
		gp.setAlignment(Pos.CENTER);

		gp.add(ulb, 0, 0);
		gp.add(utf, 1, 0);
		gp.add(plb, 0, 1);
		gp.add(pf, 1, 1);
		gp.add(lbtn, 1, 2);
		gp.add(cb, 0, 4);
		gp.add(cbtn, 1, 5);
		gp.setHgap(10.0);
		gp.setVgap(20.0);
		
		
		Scene scene =  new Scene(gp, sceneWidth, sceneHeight);

		lbtn.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
		{
			if(dbt.login(utf.getText(), pf.getText()))
			{
				stage.close();
				stage.setScene(MainMenu.Menu(stage, ps, dbt));
				stage.show();
			}
			else
				JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("failedlogin"), ProjectLocale.rb.getString("titleFailedlogin"), 0);
		});
		
		cbtn.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
		{
			stage.setScene(Register.register(stage, ps, dbt));
		});

		cb.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) ->
		{
			switch(newValue)
			{
			case "English":
				 ProjectLocale.setBundleEng();
				break;
			case "Español":
				ProjectLocale.setBundleEsp();
				break;
			}
			lbtn.setText(ProjectLocale.rb.getString("login"));
			ulb.setText(ProjectLocale.rb.getString("user"));
			plb.setText(ProjectLocale.rb.getString("password"));
			cbtn.setText(ProjectLocale.rb.getString("register"));
			stage.setTitle(ProjectLocale.rb.getString("title"));
		});

		
		return scene;
	}
}

/*
class Mainscreen 
{    
    public static void run()
    {
    	Stage subStage = new Stage();
        subStage.setTitle("GAMES TIME");
        
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 640, 480);
        
        Button btn = new Button("Open New Stage");
        
        root.getChildren().add(btn);
        subStage.setScene(scene);
        subStage.show();
    }
}
*/

//class NextScreen
//{
//	public void run()
//	{
//		Stage stage = new Stage();
//        Button btn = new Button("Open New Stage");
//        btn.setOnAction(eve->
//        {
//        	NS.run();
//        	stage.close();
//        });
//		GridPane gp = new GridPane();
//		Scene scene =  new Scene(gp);
//	}
//}