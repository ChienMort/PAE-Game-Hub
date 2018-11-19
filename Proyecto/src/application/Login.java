package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import localization.ProjectLocale;

public class Login
{
	
	public static Scene Login(Stage stage){
		//Ricardo - Agregando cosas para adaptar el código
		int sceneWidth = 800, sceneHeight = 600;
		ProjectImages pi = new ProjectImages();
		
		//Tec - Código
		Button lbtn = new Button(ProjectLocale.rb.getString("login"));
		TextField utf = new TextField();
		Label ulb = new Label(ProjectLocale.rb.getString("user"));
		Label plb = new Label(ProjectLocale.rb.getString("password"));
		PasswordField pf = new PasswordField();
		GridPane gp = new GridPane();
		gp.setBackground(pi.backGround1());
		
		//Añadiendo lenguajes
		ChoiceBox<String> cb = new ChoiceBox<String>();
		ObservableList<String> choiceList = FXCollections.observableArrayList("Esp", "English");
		cb.setItems(choiceList);
		cb.setTooltip(new Tooltip("Language"));		
		
		utf.setMaxWidth(120.0);
		pf.setMaxWidth(120.0);
		gp.setAlignment(Pos.CENTER);
		
		gp.add(ulb, 0, 0);
		gp.add(utf, 1, 0);
		gp.add(plb, 0, 1);
		gp.add(pf, 1, 1);
		gp.add(lbtn, 1, 2);
		gp.add(cb, 0, 4);
		gp.setHgap(10.0);
		gp.setVgap(20.0);
		
		Scene scene =  new Scene(gp, sceneWidth, sceneHeight);
				
		cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                if(newValue.equals("Esp")) ProjectLocale.setLanguage(1);
            }
        });

		
		lbtn.setOnAction(eve->
		{
			if(cb.getValue().equals("Esp")) ProjectLocale.rb.getBundle(ProjectLocale.espanol.getDisplayName());
			stage.setScene(MainMenu.Menu(stage));
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