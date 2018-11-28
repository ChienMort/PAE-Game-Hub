package application;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import localization.ProjectLocale;
import resources.sounds.ProjectSound;

public class Gato {

	public static Scene gato(Stage stage, ProjectSound ps, DBConnection dbt) {
		Pane ventana = new Pane();
		ProjectImages projector = new ProjectImages();
		
		Rectangle uno = new Rectangle(146, 146);
		Rectangle dos = new Rectangle(146, 146);
		Rectangle tres = new Rectangle(146, 146);
		Rectangle cuatro = new Rectangle(146, 146);
		Rectangle cinco = new Rectangle(146, 146);
		Rectangle seis = new Rectangle(146, 146);
		Rectangle siete = new Rectangle(146, 146);
		Rectangle ocho = new Rectangle(146, 146);
		Rectangle nueve = new Rectangle(146, 146);
		
		uno.setFill(Color.BLACK);
		uno.setStrokeWidth(0);
		uno.setX(170);
		uno.setY(20);
		uno.setCursor(Cursor.HAND);
		
		Scene sce = new Scene(ventana, 800, 600);
		ventana.setBackground(projector.backGround1());
		
		Button jugar = new Button(ProjectLocale.rb.getString("restart"));
		jugar.setLayoutX(125);
		jugar.setLayoutY(530);
		Button cargar = new Button(ProjectLocale.rb.getString("load"));
		cargar.setLayoutX(375);
		cargar.setLayoutY(530);
		Button regresar = new Button(ProjectLocale.rb.getString("return"));
		regresar.setLayoutX(625);
		regresar.setLayoutY(530);
		
		ventana.getChildren().addAll(jugar, cargar, regresar, uno);		
		
		regresar.setOnAction(eve->
		{
			stage.setScene(MainMenu.Menu(stage, ps, dbt));
		});
		
		return sce;
		
		
	}
	
}
