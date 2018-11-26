package resources.sounds;

import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ProjectSound
{
	
	public URL Council = getClass().getResource("1-07 The Student Council.mp3");
	public String CouncilString = Council.toExternalForm();
	
	public URL Nocturne = getClass().getResource("1-13 Nocturne.mp3");
	public String NocturneString = Nocturne.toExternalForm();
	
	public URL Concord = getClass().getResource("1-17 Concord.mp3");
	public String ConcordString = Concord.toExternalForm();
	
	public URL Afternoon = getClass().getResource("2-03 Afternoon.mp3");
	public String AfternoonString = Afternoon.toExternalForm();
	
	
	private Media councilMedia = new Media(CouncilString);
	private Media nocturneMedia = new Media(NocturneString);
	private Media concordMedia = new Media(ConcordString);
	private Media afternoonMedia = new Media(AfternoonString);
	
	
	private MediaPlayer councilPlayer = new MediaPlayer(councilMedia);
	private MediaPlayer nocturnePlayer = new MediaPlayer(nocturneMedia);
	private MediaPlayer concordPlayer = new MediaPlayer(concordMedia);
	private MediaPlayer afternoonPlayer = new MediaPlayer(afternoonMedia);
	
	
	private void shutUp(){
		councilPlayer.stop();
		nocturnePlayer.stop();
		concordPlayer.stop();
		afternoonPlayer.stop();
	}
	
	//private Status status = Status.UNKNOWN;
			
	public void playMenuMusic(String in)
	{
	
		shutUp();
		
		switch(in){
		case "Mute":
			break;
			
		case "Nocturne":
			nocturnePlayer.play();
			break;
			
		case "Concord":
			concordPlayer.play();
			break;
			
		case "Student Council":
				councilPlayer.play();
				break;
				
		case "Afternoon":
			afternoonPlayer.play();
			break;
		}
	}
}