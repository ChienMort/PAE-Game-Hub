package application;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.ImagePattern;

public class ProjectImages {
	
	// !!! Por ahora las funciones son un desastre, planeo optimizarlas después !!!
	
	private Image chessImage = new Image(getClass().getResourceAsStream("../resources/chess.jpg"));
	private Image battleImage = new Image(getClass().getResourceAsStream("../resources/battle.jpg"));
	private Image gatoImage = new Image(getClass().getResourceAsStream("../resources/gato.jpg"));
	private Image bg1 = new Image(getClass().getResourceAsStream("../resources/DotTexture.jpg"));
	private Image header = new Image(getClass().getResourceAsStream("../resources/Header.jpg"));
	private Image chessPreview = new Image(getClass().getResourceAsStream("../resources/chessPreview.jpg"));
	private Image battlePreview = new Image(getClass().getResourceAsStream("../resources/battlePreview.jpg"));
	private Image gatoPreview = new Image(getClass().getResourceAsStream("../resources/gatoPreview.jpg"));
	private Image defaultUserIcon = new Image(getClass().getResourceAsStream("../resources/defaultUserIcon.jpg"));
	
	public Image getPreview(int x){
		switch(x){
		default:
			return bg1;
		case 1:	
			return chessPreview;
		case 2:
			return battlePreview;
		case 3:
			return gatoPreview;
		}
	}
	
	public ImageView getIconImageView(int icon, int sizeX, int sizeY){
		ImageView iv = new ImageView();
		switch(icon){
			default:
				iv.setImage(defaultUserIcon);
		}
		return iv;
	}
	
	public Background backGround1(){
	ImagePattern pat = new ImagePattern(bg1, 0, 0, 800, 600, false);
		BackgroundFill bf = new BackgroundFill(pat, CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(bf);
		return bg;
	}
	
	public Background backGround2(){
		ImagePattern pat = new ImagePattern(header, 0, 0, 200, 100, false);
			BackgroundFill bf = new BackgroundFill(pat, CornerRadii.EMPTY, Insets.EMPTY);
			Background bg = new Background(bf);
			return bg;
		}
	
	public Background ChessIcon(int X, int Y){
		ImagePattern pat = new ImagePattern(chessImage, 0, 0, X, (Y - (10%Y)), false);
			BackgroundFill bf = new BackgroundFill(pat, CornerRadii.EMPTY, Insets.EMPTY);
			Background bg = new Background(bf);
			return bg;
		}
	
	public Background battleIcon(int X, int Y){
		ImagePattern pat = new ImagePattern(battleImage, 0, 0, X, (Y - (10%Y)), false);
			BackgroundFill bf = new BackgroundFill(pat, CornerRadii.EMPTY, Insets.EMPTY);
			Background bg = new Background(bf);
			return bg;
		}
	
	public Background gatoIcon(int X, int Y){
		ImagePattern pat = new ImagePattern(gatoImage, 0, 0, X, (Y - (10%Y)), false);
			BackgroundFill bf = new BackgroundFill(pat, CornerRadii.EMPTY, Insets.EMPTY);
			Background bg = new Background(bf);
			return bg;
		}
}
