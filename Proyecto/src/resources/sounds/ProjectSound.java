package resources.sounds;

import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;

public class ProjectSound {

	public URL mediaUrl = getClass().getResource("main_menu.mp3");
	public String mediaStringUrl = mediaUrl.toExternalForm();
	
	public Media media = new Media(mediaStringUrl);
	
	public MediaPlayer player = new MediaPlayer(media);
	
	
	private Status status = Status.UNKNOWN;
			
	public void playMenuMusic(){
		player.play();
		System.out.println(player.getStatus());
	}
	
	}
