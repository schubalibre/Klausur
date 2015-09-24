package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
	import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gutundschlecht extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		ListView<String> positiv = new ListView<String>();
		ListView<String> negativ = new ListView<String>();
		
		ObservableList<String> positiveListe = FXCollections.observableArrayList();
		ObservableList<String> negativeListe = FXCollections.observableArrayList();
		
		positiv.setItems(positiveListe);
		negativ.setItems(negativeListe);
		
		Label text = new Label("dfglmsdklghselǵmsdlǵ sdlsd sd f+pghjstpho srop+h sdop hsdph sdkgh sdklh sdfg");
		
		TextField positivesWort = new TextField();
		TextField negativesWort = new TextField();
		
		positivesWort.setOnAction(e -> positiveListe.add(positivesWort.getText()));
		negativesWort.setOnAction(p -> negativeListe.add(negativesWort.getText()));
		
		BorderPane root = new BorderPane();
		
		Label labelNeg = new Label("Negative Kommentare");
		Label labelPos = new Label("Positive Kommentare");
		
		VBox plus = new VBox(labelPos,positiv, positivesWort);
		VBox minus = new VBox(labelNeg,negativ, negativesWort);

		root.setRight(minus);
		root.setLeft(plus);
		root.setBottom(text);
		
		primaryStage.setTitle("Gute und schlechte Kommentare");
		Scene scene = new Scene(root, 700, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		 
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
