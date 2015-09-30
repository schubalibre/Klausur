package aktuelleKlausur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BindArea extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane borderPane = new BorderPane();
		
		TextField field = new TextField();
		TextArea area = new TextArea();
		area.setWrapText(true);
		area.textProperty().bind(field.textProperty());
		
		Button button = new Button("clear");
		
		button.setOnMouseClicked(e -> field.clear());
		
		borderPane.setTop(field);
		borderPane.setCenter(area);
		borderPane.setBottom(button);
		
		Scene scene = new Scene(borderPane,200,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
