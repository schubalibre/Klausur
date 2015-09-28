package serialisierung;

public class Serialisierung {
	public static void main(String[] args) {
		Player player = new Player(args[0]);
		
		player.addRandomAsset();
		player.removeAsset();
		player.addRandomAsset();
		player.addRandomAsset();
		player.storeAvatar(args[0]);
		
		System.out.println("Finish with " + player.avatar.numberOfAssets() + " assets");
	}
}
