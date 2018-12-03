package application;

import javax.swing.JOptionPane;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import localization.ProjectLocale;
import resources.sounds.ProjectSound;

public class Gato
{
	static DBConnection dbtg;
	
	static boolean ac = true;
	static boolean[] cuadro = new boolean[9], xs = new boolean[9], cs = new boolean[9];
	static boolean first = false, beginning = true, equis;
	static int turn;
	
	static Rectangle uno = new Rectangle(146, 146);
	static Rectangle dos = new Rectangle(146, 146);
	static Rectangle tres = new Rectangle(146, 146);
	static Rectangle cuatro = new Rectangle(146, 146);
	static Rectangle cinco = new Rectangle(146, 146);
	static Rectangle seis = new Rectangle(146, 146);
	static Rectangle siete = new Rectangle(146, 146);
	static Rectangle ocho = new Rectangle(146, 146);
	static Rectangle nueve = new Rectangle(146, 146);
	
	static Rectangle v1 = new Rectangle(11, 460);
	static Rectangle v2 = new Rectangle(11, 460);
	static Rectangle v3 = new Rectangle(460, 11);
	static Rectangle v4 = new Rectangle(460, 11);
	
	static Line x1 = new Line(180, 30, 306, 156);
	static Line x2 = new Line(180, 156, 306, 30);
	static Line x3 = new Line(337, 30, 463, 156);
	static Line x4 = new Line(337, 156, 463, 30);
	static Line x5 = new Line(494, 30, 620, 156);
	static Line x6 = new Line(494, 156, 620, 30);
	static Line x7 = new Line(180, 187, 306, 313);
	static Line x8 = new Line(180, 313, 306, 187);
	static Line x9 = new Line(337, 187, 463, 313);
	static Line x10 = new Line(337, 313, 463, 187);
	static Line x11 = new Line(494, 187, 620, 313);
	static Line x12 = new Line(494, 313, 620, 187);
	static Line x13 = new Line(180, 344, 306, 470);
	static Line x14 = new Line(180, 470, 306, 344);
	static Line x15 = new Line(337, 344, 463, 470);
	static Line x16 = new Line(337, 470, 463, 344);
	static Line x17 = new Line(494, 344, 620, 470);
	static Line x18 = new Line(494, 470, 620, 344);
	static Circle c1 = new Circle(243, 93, 65, Color.TRANSPARENT);
	static Circle c2 = new Circle(400, 93, 65, Color.TRANSPARENT);
	static Circle c3 = new Circle(557, 93, 65, Color.TRANSPARENT);
	static Circle c4 = new Circle(243, 250, 65, Color.TRANSPARENT);
	static Circle c5 = new Circle(400, 250, 65, Color.TRANSPARENT);
	static Circle c6 = new Circle(557, 250, 65, Color.TRANSPARENT);
	static Circle c7 = new Circle(243, 407, 65, Color.TRANSPARENT);
	static Circle c8 = new Circle(400, 407, 65, Color.TRANSPARENT);
	static Circle c9 = new Circle(557, 407, 65, Color.TRANSPARENT);
	
	static EventHandler<MouseEvent> muno = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e)
        {
        	if(!cuadro[0])
        	{
        		cuadro[0] = true;
        		if(equis)
        		{
        			x1.setStroke(Color.BLACK);
        			x2.setStroke(Color.BLACK);
        			xs[0] = true;
        		}
        		else
        		{
        			c1.setStroke(Color.RED);
        			cs[0] = true;
        		}
        		send(0);
        	}
        }
	};
	static EventHandler<MouseEvent> mdos = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e)
        {
        	if(!cuadro[1])
        	{
        		cuadro[1] = true;
        		if(equis)
        		{
        			x3.setStroke(Color.BLACK);
        			x4.setStroke(Color.BLACK);
        			xs[1] = true;
        		}
        		else
        		{
        			c2.setStroke(Color.RED);
        			cs[1] = true;
        		}
        		send(1);
        	}
        }
	};
	
	static EventHandler<MouseEvent> mtres = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e)
        {
        	if(!cuadro[2])
        	{
        		cuadro[2] = true;
        		if(equis)
        		{
        			x5.setStroke(Color.BLACK);
        			x6.setStroke(Color.BLACK);
        			xs[2] = true;
        		}
        		else
        		{
        			c3.setStroke(Color.RED);
        			cs[2] = true;
        		}
        		send(2);
        	}
        }
	};
	static EventHandler<MouseEvent> mcuatro = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e)
        {
        	if(!cuadro[3])
        	{
        		cuadro[3] = true;
        		if(equis)
        		{
        			x7.setStroke(Color.BLACK);
        			x8.setStroke(Color.BLACK);
        			xs[3] = true;
        		}
        		else
        		{
        			c4.setStroke(Color.RED);
        			cs[3] = true;
        		}
        		send(3);
        	}
        }
	};
	static EventHandler<MouseEvent> mcinco = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e)
        {
        	if(!cuadro[4])
        	{
        		cuadro[4] = true;
        		if(equis)
        		{
        			x9.setStroke(Color.BLACK);
        			x10.setStroke(Color.BLACK);
        			xs[4] = true;
        		}
        		else
        		{
        			c5.setStroke(Color.RED);
        			cs[4] = true;
        		}
        		send(4);
        	}
        }
	};
	static EventHandler<MouseEvent> mseis = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e)
        {
        	if(!cuadro[5])
        	{
        		cuadro[5] = true;
        		if(equis)
        		{
        			x11.setStroke(Color.BLACK);
        			x12.setStroke(Color.BLACK);
        			xs[5] = true;
        		}
        		else
        		{
        			c6.setStroke(Color.RED);
        			cs[5] = true;
        		}
        		send(5);
        	}
        }
	};
	static EventHandler<MouseEvent> msiete = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e)
        {
        	if(!cuadro[6])
        	{
        		cuadro[6] = true;
        		if(equis)
        		{
        			x13.setStroke(Color.BLACK);
        			x14.setStroke(Color.BLACK);
        			xs[6] = true;
        		}
        		else
        		{
        			c7.setStroke(Color.RED);
        			cs[6] = true;
        		}
        		send(6);
        	}
        }
	};
	static EventHandler<MouseEvent> mocho = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e)
        {
        	if(!cuadro[7])
        	{
        		cuadro[7] = true;
        		if(equis)
        		{
        			x15.setStroke(Color.BLACK);
        			x16.setStroke(Color.BLACK);
        			xs[7] = true;
        		}
        		else
        		{
        			c8.setStroke(Color.RED);
        			cs[7] = true;
        		}
        		send(7);
        	}
        }
	};
	static EventHandler<MouseEvent> mnueve = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e)
        {
        	if(!cuadro[8])
        	{
        		cuadro[8] = true;
        		if(equis)
        		{
        			x17.setStroke(Color.BLACK);
        			x18.setStroke(Color.BLACK);
        			xs[8] = true;
        		}
        		else
        		{
        			c9.setStroke(Color.RED);
        			cs[8] = true;
        		}
            	send(8);
        	}
        }
	};
	
	public static void reset()
	{
		uno.setFill(Color.TRANSPARENT);
		dos.setFill(Color.TRANSPARENT);
		tres.setFill(Color.TRANSPARENT);
		cuatro.setFill(Color.TRANSPARENT);
		cinco.setFill(Color.TRANSPARENT);
		seis.setFill(Color.TRANSPARENT);
		siete.setFill(Color.TRANSPARENT);
		ocho.setFill(Color.TRANSPARENT);
		nueve.setFill(Color.TRANSPARENT);
		x1.setStroke(Color.TRANSPARENT);
		x2.setStroke(Color.TRANSPARENT);
		x3.setStroke(Color.TRANSPARENT);
		x4.setStroke(Color.TRANSPARENT);
		x5.setStroke(Color.TRANSPARENT);
		x6.setStroke(Color.TRANSPARENT);
		x7.setStroke(Color.TRANSPARENT);
		x8.setStroke(Color.TRANSPARENT);
		x9.setStroke(Color.TRANSPARENT);
		x10.setStroke(Color.TRANSPARENT);
		x11.setStroke(Color.TRANSPARENT);
		x12.setStroke(Color.TRANSPARENT);
		x13.setStroke(Color.TRANSPARENT);
		x14.setStroke(Color.TRANSPARENT);
		x15.setStroke(Color.TRANSPARENT);
		x16.setStroke(Color.TRANSPARENT);
		x17.setStroke(Color.TRANSPARENT);
		x18.setStroke(Color.TRANSPARENT);
		c1.setStroke(Color.TRANSPARENT);
		c2.setStroke(Color.TRANSPARENT);
		c3.setStroke(Color.TRANSPARENT);
		c4.setStroke(Color.TRANSPARENT);
		c5.setStroke(Color.TRANSPARENT);
		c6.setStroke(Color.TRANSPARENT);
		c7.setStroke(Color.TRANSPARENT);
		c8.setStroke(Color.TRANSPARENT);
		c9.setStroke(Color.TRANSPARENT);
		
		for(int i = 0; i < 9; i++)
		{
			cuadro[i] = false;
			xs[i] = false;
			cs[i] = false;
		}
	}
	
	public static Scene gato(Stage stage, ProjectSound ps, DBConnection dbt)
	{
		Pane ventana = new Pane();
		ProjectImages projector = new ProjectImages();
		
		ventana.setBackground(projector.backGround1());
		
		Button restart = new Button(ProjectLocale.rb.getString("restart"));
		restart.setLayoutX(190);
		restart.setLayoutY(530);
		Button regresar = new Button(ProjectLocale.rb.getString("return"));
		regresar.setLayoutX(590);
		regresar.setLayoutY(530);
		
		ventana.getChildren().addAll(restart, regresar);		
		
		regresar.setOnAction(eve->
		{
			ac = false;
			if(first)
			{
				dbt.clean();
				dbt.removeControlTable();
			}
			stage.setScene(MainMenu.Menu(stage, ps, dbt));
		});
		
		restart.setOnAction(eve->
		{
			ac = false;
			beginning = true;
			reset();
			if(first)
			{
				first = equis = false;
				dbt.cleanConTa();
			}
			else
			{
				first = equis = true;
			}
		});
		
		reset();
		
		uno.setStrokeWidth(0);
		uno.setX(170);
		uno.setY(20);
		
		dos.setStrokeWidth(0);
		dos.setX(327);
		dos.setY(20);
		
		tres.setStrokeWidth(0);
		tres.setX(484);
		tres.setY(20);
		
		cuatro.setStrokeWidth(0);
		cuatro.setX(170);
		cuatro.setY(177);
		
		cinco.setStrokeWidth(0);
		cinco.setX(327);
		cinco.setY(177);
		
		seis.setStrokeWidth(0);
		seis.setX(484);
		seis.setY(177);
		
		siete.setStrokeWidth(0);
		siete.setX(170);
		siete.setY(334);
		
		ocho.setStrokeWidth(0);
		ocho.setX(327);
		ocho.setY(334);
		
		nueve.setStrokeWidth(0);
		nueve.setX(484);
		nueve.setY(334);
		
		v1.setFill(Color.BLACK);
		v2.setFill(Color.BLACK);
		v3.setFill(Color.BLACK);
		v4.setFill(Color.BLACK);
		
		v1.setX(316);
		v1.setY(20);
		v1.setStrokeWidth(0);

		v2.setX(473);
		v2.setY(20);
		v2.setStrokeWidth(0);
		
		v3.setX(170);
		v3.setY(166);
		v3.setStrokeWidth(0);

		v4.setX(170);
		v4.setY(323);
		v4.setStrokeWidth(0);
		
		x1.setStrokeWidth(8);
		x2.setStrokeWidth(8);
		x3.setStrokeWidth(8);
		x4.setStrokeWidth(8);
		x5.setStrokeWidth(8);
		x6.setStrokeWidth(8);
		x7.setStrokeWidth(8);
		x8.setStrokeWidth(8);
		x9.setStrokeWidth(8);
		x10.setStrokeWidth(8);
		x11.setStrokeWidth(8);
		x12.setStrokeWidth(8);
		x13.setStrokeWidth(8);
		x14.setStrokeWidth(8);
		x15.setStrokeWidth(8);
		x16.setStrokeWidth(8);
		x17.setStrokeWidth(8);
		x18.setStrokeWidth(8);
		
		c1.setStrokeWidth(8);
		c2.setStrokeWidth(8);
		c3.setStrokeWidth(8);
		c4.setStrokeWidth(8);
		c5.setStrokeWidth(8);
		c6.setStrokeWidth(8);
		c7.setStrokeWidth(8);
		c8.setStrokeWidth(8);
		c9.setStrokeWidth(8);
		
		ventana.getChildren().addAll(x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15,x16,x17,x18);
		ventana.getChildren().addAll(c1,c2,c3,c4,c5,c6,c7,c8,c9);
		ventana.getChildren().addAll(uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, v1, v2, v3, v4);
		
		Thread thread = new Thread() //Hilo de manejo de juego (turnos) entre usuarios
		{
			int reviewed;
			
			public void run()
			{
				System.out.println("HILO CORRIENDO");
				while(ac) // while nobody had won or the board is full
				{
					check();
					if(first)
					{
						if(beginning)
						{
							dbt.createMatchTable();
							beginning = false;
						}
					}
					else
					{
						//System.out.println("waiting");
						beginning = false;
						reviewed =  dbt.checkControl();
						switch(reviewed)
						{
						case -1:
							break;
						case 1:
							break;
						default:
							if(turn < reviewed)
								fetch(dbt);
						}
					}
					try
					{
						Thread.sleep(1000);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				System.out.println("HILO CERRADO");
			}
		};
		
		
		Scene sce = new Scene(ventana, 800, 600);
		
		dbt.setID();
		do
		{
			//IF CANCEL BREAK SO IDENEMY == -1;
			dbt.setEnemy(JOptionPane.showInputDialog(null, ProjectLocale.rb.getString("enemyme")));
		}while(dbt.idenemy == -1);
		
		
		if(dbt.idenemy != -1)
		{
			if(dbt.idp < dbt.idenemy)
			{
				first = equis = true;
				turnEventsOn();
			}
			else
			{
				dbt.controlTable = "control_" + dbt.idenemy + "_" + dbt.idp;
				System.out.println(dbt.controlTable);
				first = equis = false;
			}
			dbtg = dbt;
			ac = true;
			turn = 1;
			thread.start();
			stage.setScene(MainMenu.Menu(stage, ps, dbt));
			return sce;
		}
		else
			return MainMenu.Menu(stage, ps, dbt);
	}
	
	private static void turnEventsOn()
	{
		uno.addEventHandler(MouseEvent.MOUSE_CLICKED, muno);
		dos.addEventHandler(MouseEvent.MOUSE_CLICKED, mdos);
		tres.addEventHandler(MouseEvent.MOUSE_CLICKED, mtres);
		cuatro.addEventHandler(MouseEvent.MOUSE_CLICKED, mcuatro);
		cinco.addEventHandler(MouseEvent.MOUSE_CLICKED, mcinco);
		seis.addEventHandler(MouseEvent.MOUSE_CLICKED, mseis);
		siete.addEventHandler(MouseEvent.MOUSE_CLICKED, msiete);
		ocho.addEventHandler(MouseEvent.MOUSE_CLICKED, mocho);
		nueve.addEventHandler(MouseEvent.MOUSE_CLICKED, mnueve);
		
		uno.setCursor(Cursor.HAND);
		dos.setCursor(Cursor.HAND);
		tres.setCursor(Cursor.HAND);
		cuatro.setCursor(Cursor.HAND);
		cinco.setCursor(Cursor.HAND);
		seis.setCursor(Cursor.HAND);
		siete.setCursor(Cursor.HAND);
		ocho.setCursor(Cursor.HAND);
		nueve.setCursor(Cursor.HAND);
	}
	
	private static void turnEventsOff()
	{
		uno.removeEventHandler(MouseEvent.MOUSE_CLICKED, muno);
		dos.removeEventHandler(MouseEvent.MOUSE_CLICKED, mdos);
		tres.removeEventHandler(MouseEvent.MOUSE_CLICKED, mtres);
		cuatro.removeEventHandler(MouseEvent.MOUSE_CLICKED, mcuatro);
		cinco.removeEventHandler(MouseEvent.MOUSE_CLICKED, mcinco);
		seis.removeEventHandler(MouseEvent.MOUSE_CLICKED, mseis);
		siete.removeEventHandler(MouseEvent.MOUSE_CLICKED, msiete);
		ocho.removeEventHandler(MouseEvent.MOUSE_CLICKED, mocho);
		nueve.removeEventHandler(MouseEvent.MOUSE_CLICKED, mnueve);
		
		uno.setCursor(Cursor.DEFAULT);
		dos.setCursor(Cursor.DEFAULT);
		tres.setCursor(Cursor.DEFAULT);
		cuatro.setCursor(Cursor.DEFAULT);
		cinco.setCursor(Cursor.DEFAULT);
		seis.setCursor(Cursor.DEFAULT);
		siete.setCursor(Cursor.DEFAULT);
		ocho.setCursor(Cursor.DEFAULT);
		nueve.setCursor(Cursor.DEFAULT);
	}
	
	private static void send(int i)
	{
		System.out.println("send");
		first = false;
		turnEventsOff();
		dbtg.send(turn, i); //inserts the cuadro position updated and creates a new turn row
		turn++;
		System.out.println("turn after send = " + turn);
	}
	
	private static void fetch(DBConnection dbt)
	{
		System.out.println("fetch");
		int u = dbt.fetch(turn); // Catches the change of cuadro of the current turn after its inserted for the other player
		update(u);
		turn++;
		first = true;
		turnEventsOn();
		System.out.println("turn after fetch = " + turn);
	}
	
	private static void update(int i)
	{
		cuadro[i] = true;
		if(equis)
			cs[i] = true;
		else
			xs[i] = true;
		switch(i)
		{
		case 0:
			if(equis)
				c1.setStroke(Color.RED);
			else
			{
				x1.setStroke(Color.BLACK);
				x2.setStroke(Color.BLACK);
			}
			break;
		case 1:
			if(equis)
				c2.setStroke(Color.RED);
			else
			{
				x3.setStroke(Color.BLACK);
				x4.setStroke(Color.BLACK);
			}
			break;
		case 2:
			if(equis)
				c3.setStroke(Color.RED);
			else
			{
				x5.setStroke(Color.BLACK);
				x6.setStroke(Color.BLACK);
			}
			break;
		case 3:
			if(equis)
				c4.setStroke(Color.RED);
			else
			{
				x7.setStroke(Color.BLACK);
				x8.setStroke(Color.BLACK);
			}
			break;
		case 4:
			if(equis)
				c5.setStroke(Color.RED);
			else
			{
				x9.setStroke(Color.BLACK);
				x10.setStroke(Color.BLACK);
			}
			break;
		case 5:
			if(equis)
				c6.setStroke(Color.RED);
			else
			{
				x11.setStroke(Color.BLACK);
				x12.setStroke(Color.BLACK);
			}
			break;
		case 6:
			if(equis)
				c7.setStroke(Color.RED);
			else
			{
				x13.setStroke(Color.BLACK);
				x14.setStroke(Color.BLACK);
			}
			break;
		case 7:
			if(equis)
				c8.setStroke(Color.RED);
			else
			{
				x15.setStroke(Color.BLACK);
				x16.setStroke(Color.BLACK);
			}
			break;
		case 8:
			if(equis)
				c9.setStroke(Color.RED);
			else
			{
				x17.setStroke(Color.BLACK);
				x18.setStroke(Color.BLACK);
			}
			break;
		}
	}
	
	private static void check()
	{
		if((cs[0] && cs[1] && cs[2]) ||
			(cs[3] && cs[4] && cs[5]) ||
			(cs[6] && cs[7] && cs[8]) ||
			(cs[0] && cs[3] && cs[6]) ||
			(cs[1] && cs[4] && cs[7]) ||
			(cs[2] && cs[5] && cs[8]) ||
			(cs[0] && cs[4] && cs[8]) ||
			(cs[2] && cs[4] && cs[6]))
		{
			ac = false;
			turnEventsOff();
			if(equis)
				JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("loser"));
			else
				JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("winner"));
			
		}
		else if((xs[0] && xs[1] && xs[2]) ||
				(xs[3] && xs[4] && xs[5]) ||
				(xs[6] && xs[7] && xs[8]) ||
				(xs[0] && xs[3] && xs[6]) ||
				(xs[1] && xs[4] && xs[7]) ||
				(xs[2] && xs[5] && xs[8]) ||
				(xs[0] && xs[4] && xs[8]) ||
				(xs[2] && xs[4] && xs[6]))
		{
				ac = false;
				turnEventsOff();
				if(equis)
					JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("winner"));
				else
					JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("loser"));
				
		}
		else if(cB())
		{
			ac = false;
			turnEventsOff();
			JOptionPane.showMessageDialog(null, ProjectLocale.rb.getString("draw"));
		}
	}
	private static boolean cB()
	{
		for(boolean k : cuadro)
			if(!k)
				return k;
		return true;
	}
}