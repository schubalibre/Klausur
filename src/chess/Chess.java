package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chess extends Application {

	@Override
	public void start(Stage primaryStage){
		Color color = Color.BLACK;
		GridPane root = new GridPane();
		int spalten = 10;
		int zeilen = 10;
		for(int spalte = 0; spalte < spalten; spalte ++){
			for(int zeile = 0; zeile < zeilen; zeile ++){
				if(spalte % 2 == 0)
					color = (zeile % 2 == 0) ? Color.WHITE : Color.BLACK;
				else
					color = (zeile % 2 == 0) ? Color.BLACK : Color.WHITE;
				Rectangle rec = new Rectangle();
				root.add(rec, spalte, zeile);
				rec.widthProperty().bind(root.widthProperty().divide(spalten));
				rec.heightProperty().bind(root.heightProperty().divide(zeilen));
				rec.setFill(color);
			}
		}
		primaryStage.setTitle("Chess");
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
