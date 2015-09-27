package serialisierung;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.prism.Image;

public class Avatar implements Serializable{

	protected String name;
	protected int coins;
	protected Image image;
	protected List<Asset> assets = new ArrayList<>(); 
	
	public Avatar(String name){
		this.name = name;
		coins = 10;
		assets.add(new Dagger(name+"-dagger"));
		assets.add(new Wisdom(Realm.Farming, 2));
	}
	
	public int numberOfAssets() {
		return assets.size();
	}
	
	public void addAsset(Asset asset){
		this.assets.add(asset);
	}
	
	public Asset getAsset(int index) {
		return assets.get(index);
	}
	
	public void removeAsset(int index){
		assets.remove(index);
	}

}
