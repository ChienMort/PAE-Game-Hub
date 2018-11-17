package application;

import javafx.application.Application;
import javafx.stage.Stage;
import resources.sounds.ProjectSound;

public class Launcher extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage stage) throws Exception
	{

		ProjectSound ps = new ProjectSound();
		
		stage.setTitle("Game Hub");
		stage.setScene(Login.Login(stage));
		stage.show();
		ps.playMenuMusic();
		
	}
	
}