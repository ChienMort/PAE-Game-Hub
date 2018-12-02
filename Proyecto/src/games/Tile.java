package games;

import application.Checkers;
import application.ProjectImages;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class Tile {

	public ProjectImages pi = new ProjectImages();
	public int state;
	public ImageView currentImage = new ImageView();
	public int x, y;
	
	//0 = vacio, 1 = negra, 2 = blanca
	
	public Tile(int s, int x, int y){
		state = s;
		this.x = x;
		this.y = y;
			
		switch(s){
		default:
			currentImage.setImage(pi.emptyTile);
			break;
		case 1:
			currentImage.setImage(pi.blackPiece);
			break;
		case 2:
			currentImage.setImage(pi.whitePiece);
			break;
		}
		
		//Adding reaction to drags
		 currentImage.setOnDragDetected((MouseEvent event) -> {
			 
	         System.out.println("Drag detected for this: " +getX() +", " +getY());
	         Dragboard db = currentImage.startDragAndDrop(TransferMode.MOVE);
	         ClipboardContent content = new ClipboardContent();
	         
	         content.putImage(currentImage.getImage());
	         db.setContent(content);
	         event.consume();
	     });
		 
		 currentImage.setOnDragDropped((DragEvent event) -> {
	            Dragboard db = event.getDragboard();
	          
	            boolean success = false;
	            
	            if (db.hasImage()) {
	            	 Image nodeId = db.getImage();
	                
	                ImageView cloth = currentImage;
	                if (cloth != null) {
	                    // ... the item is removed from body
	                    // and added to an unequipped container.
	                    success = true;
	                }
	               
	            }
	            event.setDropCompleted(success);
	            event.consume();
	        });
		 
		currentImage.setOnDragOver((DragEvent event) -> {
			if (event.getGestureSource() != currentImage &&
	                    event.getDragboard().hasImage()) {
	                event.acceptTransferModes(TransferMode.MOVE);
	            }
	            event.consume();
	        });  
		
	}
	
	
	
public void setImage(int s){	
	
	
}
	


public int getX(){
	return x;
}

public int getY(){
	return y;
}

	}
	
