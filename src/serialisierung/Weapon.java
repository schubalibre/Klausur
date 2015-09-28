package serialisierung;

import java.io.Serializable;

import javafx.scene.image.Image;

public abstract class Weapon extends Asset implements Serializable {
	protected Image img;
	protected String description;
	
	public static final int DAGGER_STRENGTH = 5;
	public static final int SWORD_STRENGTH = 10;
	public static final int DAGGER_VALUE = 20;
	public static final int SWORD_VALUE = 50;
	
	public Image getImage(){ return img;}
	public String getDescription(){ return description;}
}
