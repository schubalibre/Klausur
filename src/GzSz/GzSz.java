package GzSz;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;



public class GzSz extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ListView<String> positiv = new ListView<>();
		ObservableList<String> posList = FXCollections.observableArrayList();
		positiv.setItems(posList);
		TextField posWord = new TextField();
		posWord.setOnAction(e -> posList.add(posWord.getText()));
		
		BorderPane root = new BorderPane();
		VBox plus = new VBox(positiv,posWord);
		
		root.setLeft(plus);
		
		primaryStage.setTitle("Gute und schlechte Kommentare");
		Scene scene = new Scene(root, 700, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
