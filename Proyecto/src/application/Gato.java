package application;

import java.awt.Paint;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import localization.ProjectLocale;

public class Gato {

	public static Scene gato(Stage stage) {
		Pane ventana = new Pane();
		ProjectImages projector = new ProjectImages();
		
		Scene sce = new Scene(ventana, 800, 600);
		ventana.setBackground(projector.backGround1());
		Line ver1 = new Line(125, 15, 125, 300);
		Line ver2 = new Line(225, 15, 225, 300);
		
		Line hor1 = new Line(25, 110, 325, 110);
		Line hor2 = new Line(25, 205, 325, 205);
		
		Button jugar = new Button(ProjectLocale.rb.getString("restart"));
		jugar.setLayoutX(45);
		jugar.setLayoutY(315);
		Button cargar = new Button(ProjectLocale.rb.getString("load"));
		cargar.setLayoutX(150);
		cargar.setLayoutY(315);
		Button regresar = new Button(ProjectLocale.rb.getString("return"));
		regresar.setLayoutX(250);
		regresar.setLayoutY(315);
		
		Circle cir = new Circle(32);
		cir.setFill(Color.TRANSPARENT);
		cir.setStroke(Color.RED);
		cir.setStrokeWidth(8);
		cir.setLayoutX(175);
		cir.setLayoutY(60);
		
		Line equis1 = new Line(50, 40, 100, 90);
		Line equis2 = new Line(100, 40, 50, 90);
		equis1.setStroke(Color.BLUE);
		equis2.setStroke(Color.BLUE);
		equis1.setStrokeWidth(8);
		equis2.setStrokeWidth(8);
		
		
		ventana.getChildren().addAll(ver1, ver2, hor1, hor2, jugar, cargar, regresar, cir, equis1, equis2);		
		
		regresar.setOnAction(eve->
		{
			stage.setScene(MainMenu.Menu(stage));
		});
		
		return sce;
		
		
	}
	
}
