package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ajedrez {
	public static Scene ajedrez(Stage stage) {
		GridPane bpane =new GridPane();
		Scene sce = new Scene(bpane, 800, 600);
		
		ProjectImages projector = new ProjectImages();
		bpane.setBackground(projector.backGround1());
		
		//Piezas blancas
		int torreW = 0x2656;
		String torW1 = Character.toString((char)torreW);
		Label tor = new Label(torW1);
		tor.setFont(new Font("Arial", 50));
		Label tor2 = new Label(torW1);
		tor2.setFont(new Font("Arial", 50));
		
		int caballoW = 0x2658;
		String cabW1 = Character.toString((char)caballoW);
		Label cab = new Label(cabW1);
		cab.setFont(new Font("Arial", 50));
		Label cab2 = new Label(cabW1);
		cab2.setFont(new Font("Arial", 50));
		
		int alfilW = 0x2657;
		String alfilW1 = Character.toString((char)alfilW);
		Label alf = new Label(alfilW1);
		alf.setFont(new Font("Arial", 50));
		Label alf2 = new Label(alfilW1);
		alf2.setFont(new Font("Arial", 50));
		
		int reyW = 0x2654;
		String reyWI = Character.toString((char)reyW);
		Label rey = new Label(reyWI);
		rey.setFont(new Font("Arial", 50));
		
		int reinaW = 0x2655;
		String reinaWI = Character.toString((char)reinaW);
		Label reina = new Label(reinaWI);
		reina.setFont(new Font("Arial", 50));
		
		int peonW = 0x2659;
		String peon1 = Character.toString((char)peonW);
		
		Label pW1 = new Label(peon1);
		Label pW2 = new Label(peon1);
		Label pW3 = new Label(peon1);
		Label pW4 = new Label(peon1);
		Label pW5 = new Label(peon1);
		Label pW6 = new Label(peon1);
		Label pW7 = new Label(peon1);
		Label pW8 = new Label(peon1);
		
		pW1.setFont(new Font("Arial", 50));
		pW2.setFont(new Font("Arial", 50));
		pW3.setFont(new Font("Arial", 50));
		pW4.setFont(new Font("Arial", 50));
		pW5.setFont(new Font("Arial", 50));
		pW6.setFont(new Font("Arial", 50));
		pW7.setFont(new Font("Arial", 50));
		pW8.setFont(new Font("Arial", 50));
		
		//Ordenar en pane
		GridPane.setConstraints(tor, 0, 0);
		GridPane.setConstraints(cab, 1, 0);
		GridPane.setConstraints(alf, 2, 0);
		GridPane.setConstraints(alf2, 5, 0);
		GridPane.setConstraints(rey, 3, 0);
		GridPane.setConstraints(reina, 4, 0);
		GridPane.setConstraints(cab2, 6, 0);
		GridPane.setConstraints(tor2, 7, 0);
		GridPane.setConstraints(pW1, 0, 1);
		GridPane.setConstraints(pW2, 1, 1);
		GridPane.setConstraints(pW3, 2, 1);
		GridPane.setConstraints(pW4, 3, 1);
		GridPane.setConstraints(pW5, 4, 1);
		GridPane.setConstraints(pW6, 5, 1);
		GridPane.setConstraints(pW7, 6, 1);
		GridPane.setConstraints(pW8, 7, 1);
		
		//Piezas negras
		int torreB = 0x265C;
		String torB1 = Character.toString((char)torreB);
		Label tor3 = new Label(torB1);
		tor3.setFont(new Font("Arial", 50));
		Label tor4 = new Label(torB1);
		tor4.setFont(new Font("Arial", 50));
		
		int caballoB = 0x265E;
		String cabB1 = Character.toString((char)caballoB);
		Label cab3 = new Label(cabB1);
		cab3.setFont(new Font("Arial", 50));
		Label cab4 = new Label(cabB1);
		cab4.setFont(new Font("Arial", 50));
		
		int alfilB = 0x265D;
		String alfilB1 = Character.toString((char)alfilB);
		Label alf3 = new Label(alfilB1);
		alf3.setFont(new Font("Arial", 50));
		Label alf4 = new Label(alfilB1);
		alf4.setFont(new Font("Arial", 50));
		
		int reyB = 0x265A;
		String reyBI = Character.toString((char)reyB);
		Label rey2 = new Label(reyBI);
		rey2.setFont(new Font("Arial", 50));
		
		int reinaB = 0x265B;
		String reinaBI = Character.toString((char)reinaB);
		Label reina2 = new Label(reinaBI);
		reina2.setFont(new Font("Arial", 50));
		
		int peonB = 0x265F;
		String peon2 = Character.toString((char)peonB);
		
		Label pB1 = new Label(peon2);
		Label pB2 = new Label(peon2);
		Label pB3 = new Label(peon2);
		Label pB4 = new Label(peon2);
		Label pB5 = new Label(peon2);
		Label pB6 = new Label(peon2);
		Label pB7 = new Label(peon2);
		Label pB8 = new Label(peon2);
		
		pB1.setFont(new Font("Arial", 50));
		pB2.setFont(new Font("Arial", 50));
		pB3.setFont(new Font("Arial", 50));
		pB4.setFont(new Font("Arial", 50));
		pB5.setFont(new Font("Arial", 50));
		pB6.setFont(new Font("Arial", 50));
		pB7.setFont(new Font("Arial", 50));
		pB8.setFont(new Font("Arial", 50));
		
		//Ordenar en pane
		GridPane.setConstraints(tor3, 0, 7);
		GridPane.setConstraints(cab3, 1, 7);
		GridPane.setConstraints(alf3, 2, 7);
		GridPane.setConstraints(alf4, 5, 7);
		GridPane.setConstraints(rey2, 3, 7);
		GridPane.setConstraints(reina2, 4, 7);
		GridPane.setConstraints(cab4, 6, 7);
		GridPane.setConstraints(tor4, 7, 7);
		GridPane.setConstraints(pB1, 0, 6);
		GridPane.setConstraints(pB2, 1, 6);
		GridPane.setConstraints(pB3, 2, 6);
		GridPane.setConstraints(pB4, 3, 6);
		GridPane.setConstraints(pB5, 4, 6);
		GridPane.setConstraints(pB6, 5, 6);
		GridPane.setConstraints(pB7, 6, 6);
		GridPane.setConstraints(pB8, 7, 6);
		
		//Tablero
		Rectangle cuadro1 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro2 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro3 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro4 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro5 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro6 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro7 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro8 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro9 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro10 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro11 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro12 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro13 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro14 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro15 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro16 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro17 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro18 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro19 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro20 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro21 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro22 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro23 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro24 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro25 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro26 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro27 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro28 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro29 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro30 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro31 = new Rectangle(50, 60, Color.LIGHTGREEN);
		Rectangle cuadro32 = new Rectangle(50, 60, Color.LIGHTGREEN);
		
		GridPane.setConstraints(cuadro1, 0, 0);
		GridPane.setConstraints(cuadro2, 2, 0);
		GridPane.setConstraints(cuadro3, 4, 0);
		GridPane.setConstraints(cuadro4, 6, 0);
		GridPane.setConstraints(cuadro5, 1, 1);
		GridPane.setConstraints(cuadro6, 3, 1);
		GridPane.setConstraints(cuadro7, 5, 1);
		GridPane.setConstraints(cuadro8, 7, 1);
		GridPane.setConstraints(cuadro9, 0, 2);
		GridPane.setConstraints(cuadro10, 2, 2);
		GridPane.setConstraints(cuadro11, 4, 2);
		GridPane.setConstraints(cuadro12, 6, 2);
		GridPane.setConstraints(cuadro13, 1, 3);
		GridPane.setConstraints(cuadro14, 3, 3);
		GridPane.setConstraints(cuadro15, 5, 3);
		GridPane.setConstraints(cuadro16, 7, 3);
		GridPane.setConstraints(cuadro17, 0, 4);
		GridPane.setConstraints(cuadro18, 2, 4);
		GridPane.setConstraints(cuadro19, 4, 4);
		GridPane.setConstraints(cuadro20, 6, 4);
		GridPane.setConstraints(cuadro21, 1, 5);
		GridPane.setConstraints(cuadro22, 3, 5);
		GridPane.setConstraints(cuadro23, 5, 5);
		GridPane.setConstraints(cuadro24, 7, 5);
		GridPane.setConstraints(cuadro25, 0, 6);
		GridPane.setConstraints(cuadro26, 2, 6);
		GridPane.setConstraints(cuadro27, 4, 6);
		GridPane.setConstraints(cuadro28, 6, 6);
		GridPane.setConstraints(cuadro29, 1, 7);
		GridPane.setConstraints(cuadro30, 3, 7);
		GridPane.setConstraints(cuadro31, 5, 7);
		GridPane.setConstraints(cuadro32, 7, 7);
		
		Button reiniciar = new Button("Reiniciar");
		Button cargar = new Button("Cargar");
		Button regresar = new Button("Regresar");
		
		regresar.setOnAction(eve->
		{
			stage.setScene(MainMenu.Menu(stage));
		});
		
		
		GridPane.setConstraints(reiniciar, 8, 2);
		GridPane.setConstraints(cargar, 8, 3);
		GridPane.setConstraints(regresar, 8, 4);
		
		bpane.getChildren().addAll(cuadro1, cuadro2, cuadro3, cuadro4, cuadro5,
				cuadro6, cuadro7, cuadro8, cuadro9, cuadro10,
				cuadro11,cuadro12,cuadro13,cuadro14,cuadro15,
				cuadro16,cuadro17,cuadro18,cuadro19,cuadro20,
				cuadro21,cuadro22,cuadro23,cuadro24,cuadro25,
				cuadro26,cuadro27,cuadro28,cuadro29,cuadro30,cuadro31,cuadro32,
				reiniciar, cargar, regresar);
		bpane.getChildren().addAll(tor, cab, alf, rey, reina, alf2, cab2, tor2, pW1, pW2, pW3, pW4, pW5, pW6, pW7, pW8);
		bpane.getChildren().addAll(tor3, cab3, alf3, rey2, reina2, alf4, cab4, tor4, pB1, pB2, pB3, pB4, pB5, pB6, pB7, pB8);
		
		return sce;
			
	}
}
