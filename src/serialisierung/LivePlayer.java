package serialisierung;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LivePlayer extends Player {
	
	private Socket socket;
	private String name;
	private InputStream in;
	private OutputStream out;

	public LivePlayer(String avatarname, Socket socket) {
		super(avatarname);
		this.name = avatarname;
		this.socket = socket;
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void play() throws ClassNotFoundException, IOException{
		while(true){
			avatar = null;
			avatar = receiveAvatar();
			if(avatar == null){
				System.out.println(name + " accepted: Game Over");
				return;
			}
			addRandomAsset();
			addRandomAsset();
			addRandomAsset();
			assetnumber = avatar.numberOfAssets();
			if(assetnumber > 30){
				sendFinish();
				return;
			}
			sendAvatar();
			System.out.println(name + ": Avatar has now " + assetnumber + " assets");
		}
	}

	private void sendAvatar() throws IOException {
		//out.writeObject();
		
	}

	private void sendFinish() {
		// TODO Auto-generated method stub
		
	}

	private Avatar receiveAvatar() {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
}
