package application;

import javax.swing.JOptionPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import localization.ProjectLocale;
import resources.sounds.ProjectSound;

public class Register
{
	public static Scene register(Stage stage, ProjectSound ps, DBConnection dbt)
	{
		//Ricardo - Agregando cosas para adaptar el código
		int sceneWidth = 280, sceneHeight = 340;
		ProjectImages pi = new ProjectImages();
		
		//Añadiendo lenguajes
		ChoiceBox<String> cb = new ChoiceBox<String>();
		cb.getItems().addAll("English", "Español");
		
		//Tec - Código
		Button lbtn = new Button(ProjectLocale.rb.getString("register"));
		Button cbtn = new Button(ProjectLocale.rb.getString("login"));
		TextField utf = new TextField();
		TextField mtf = new TextField();
		Label ulb = new Label(ProjectLocale.rb.getString("user"));
		Label plb = new Label(ProjectLocale.rb.getString("password"));
		Label mlb = new Label(ProjectLocale.rb.getString("mail"));
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
		gp.add(mlb, 0, 2);
		gp.add(mtf, 1, 2);
		gp.add(lbtn, 1, 3);
		gp.add(cb, 0, 5);
		gp.add(cbtn, 1, 6);
		gp.setHgap(10.0);
		gp.setVgap(20.0);
		
		
		Scene scene =  new Scene(gp, sceneWidth, sceneHeight);

		cbtn.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
		{
			stage.setScene(Login.login(stage, ps, dbt));
		});
		
		lbtn.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
		{
			if(utf.getText().equals("null") || utf.getText().equals(""))
				JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("inuser"));
			else if(pf.getText().equals(""))
				JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("inpass"));
			else if(mtf.getText().length() < 3)
				JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("inmail"));
			else
			{
				String re = dbt.register(utf.getText(), pf.getText(), mtf.getText());
				if(re.equals(""))
				{
					dbt.usuario =  utf.getText();
					stage.close();
					JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("rme"));
					stage.setScene(MainMenu.Menu(stage, ps, dbt));
					stage.show();
				}
				else if(re.contains("uniUser"))
					JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("uerr"));
				else if(re.contains("uniMail"))
					JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("merr"));
				else
					JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("ltt"));
			}
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
			stage.setTitle(ProjectLocale.rb.getString("title"));
			cbtn.setText(ProjectLocale.rb.getString("register"));
			mlb.setText(ProjectLocale.rb.getString("mail"));
		});
		
		return scene;
	}
}