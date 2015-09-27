package serialisierung;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class Player {
	static int assetnumber = 0;
	Avatar avatar;
	Random random = new Random();
	
	public Player(String avatarname){
		try{
			avatar = getAvatar(avatarname);
		} catch(ClassNotFoundException | IOException iox){
			avatar = new Avatar("DefaultAvatar");
			iox.printStackTrace();
		}
	}
	
	public void storeAvatar(String name){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name + ".avatar"));
			out.writeObject(avatar);
			out.close();
		}catch(IOException iox){
			iox.printStackTrace();
		}
	}

	private Avatar getAvatar(String name) throws IOException, ClassNotFoundException{
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(name + ".avatar"));
			avatar = (Avatar) in.readObject();
			return avatar;
		}catch(FileNotFoundException | EOFException fex){
			System.out.println("File not found: " + name +".avatar");
			avatar = new Avatar(name);
			return avatar;
		}
	}
	
	public void addRandomAsset(){
		int rand = random.nextInt(4);
		switch(rand){
			case 0: avatar.addAsset(new Dagger("dagger"+assetnumber)); break;
			case 1: avatar.addAsset(new Dagger("dagger"+assetnumber)); break;
			case 2: avatar.addAsset(new Wisdom(Realm.War,4)); break;
			case 3: avatar.addAsset(new Wisdom(Realm.Alchimy,4)); break;
		}
		assetnumber++;
	}
	
	public void removeAsset(){
		int rand = random.nextInt(avatar.numberOfAssets() + 3);
		if(rand < avatar.numberOfAssets()){
			avatar.removeAsset(rand);
		}
	}
}
