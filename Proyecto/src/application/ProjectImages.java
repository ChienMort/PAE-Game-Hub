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
	
	public Image chessImage = new Image(getClass().getResourceAsStream("../resources/chess.jpg"));
	public Image battleImage = new Image(getClass().getResourceAsStream("../resources/battle.jpg"));
	public Image gatoImage = new Image(getClass().getResourceAsStream("../resources/gato.jpg"));
	public Image bg1 = new Image(getClass().getResourceAsStream("../resources/DotTexture.jpg"));
	public Image header = new Image(getClass().getResourceAsStream("../resources/Header.jpg"));
	public Image chessPreview = new Image(getClass().getResourceAsStream("../resources/chessPreview.jpg"));
	public Image battlePreview = new Image(getClass().getResourceAsStream("../resources/battlePreview.jpg"));
	public Image gatoPreview = new Image(getClass().getResourceAsStream("../resources/gatoPreview.png"));
	public Image defaultUserIcon = new Image(getClass().getResourceAsStream("../resources/defaultUserIcon.jpg"));
	public Image darkTile = new Image(getClass().getResourceAsStream("../resources/WaterTile.jpg"));
	public Image lightTile = new Image(getClass().getResourceAsStream("../resources/MissedTile.jpg"));
	public Image blackPiece = new Image(getClass().getResourceAsStream("../resources/BlackPiece.png"));
	public Image whitePiece = new Image(getClass().getResourceAsStream("../resources/WhitePiece.png"));
	
	
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
	
	public ImageView getCheckPiece(int n){
		switch(n){
		default:
		return new ImageView(blackPiece);
		
		case 1:
		return new ImageView(whitePiece);
		
		}
	}
	
	public Background getTileColor(int n){
		switch(n){
		
		default:
			ImagePattern pat = new ImagePattern(darkTile, 0, 0, 30, 30, false);
			BackgroundFill bf = new BackgroundFill(pat, CornerRadii.EMPTY, Insets.EMPTY);
			Background bg = new Background(bf);
			return bg;
			
		case 1:
			ImagePattern pot = new ImagePattern(lightTile, 0, 0, 30, 30, false);
			BackgroundFill gbf = new BackgroundFill(pot, CornerRadii.EMPTY, Insets.EMPTY);
			Background gbg = new Background(gbf);
			return gbg;
			
		}
	}
	
	public Background backGround1(){
	ImagePattern pat = new ImagePattern(bg1, 0, 0, 120, 120, false);
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
