package serialisierung;

import java.io.Serializable;

abstract public class Asset implements Serializable {
	protected String name;
	protected int value;
	protected int strenght;
	
	public int getValue() {return value; }
	public int getStrenght() {return strenght; }
	public String getName() {return name; }
}
