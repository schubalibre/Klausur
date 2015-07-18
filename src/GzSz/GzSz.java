package GzSz;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
		Label text = new Label();
		TextField posWord = new TextField();
		posWord.setOnAction(e -> posList.add(posWord.getText()));
		
		BorderPane root = new BorderPane();
		VBox plus = new VBox();
		
		root.setLeft(plus);
		root.setLeft(text);
	}
}
