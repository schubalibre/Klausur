package binding;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingsBsp5 extends Application {

    private static final double INITIAL_STAND = 0.3;

    @Override
    public void start(Stage primaryStage) {

        Slider slider = new Slider();
        slider.setValue(INITIAL_STAND);
        TextField field = new TextField();
        field.setText(new Double(INITIAL_STAND).toString());

        field.textProperty().bindBidirectional(slider.valueProperty(), NumberFormat.getNumberInstance());

        GridPane grid = new GridPane();
        grid.add(slider, 0, 0);
        grid.add(field, 0, 1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
} 
