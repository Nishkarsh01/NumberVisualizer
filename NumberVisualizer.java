
/**
 *
 * The start method sets up the UI by creating a BorderPane and adding an input field for the number and a GridPane for the truck visualization.
 * The updateVisualization method is called whenever the user enters a number in the input field.
 * It clears the previous truck visualization and creates a new one based on the input number.
 * It calculates the size of the grid based on the square root of the input number, and adds ImageView instances for each truck to the GridPane.
 * The main method simply launches the application.
 * The truckImage instance is loaded from a URL and stored in memory to avoid downloading the image over the network every time the updateVisualization method is called. This optimization improves performance by reducing network latency and data transfer overhead.
 *
 * **/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NumberVisualizer extends Application {

    private TextField textField;
    private GridPane truckPane;
    private Image truckImage;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Create the input field for the number
        Label label = new Label("Enter a number:");
        label.setFont(Font.font(16));
        textField = new TextField();
        textField.setFont(Font.font(16));
        textField.setOnAction(e -> {
            updateVisualization();
        });
        HBox inputBox = new HBox(10, label, textField);
        inputBox.setAlignment(Pos.CENTER);
        root.setTop(inputBox);

        // Create the visualization for the number
        truckPane = new GridPane();
        truckPane.setAlignment(Pos.CENTER);
        root.setCenter(truckPane);
        BorderPane.setMargin(truckPane, new Insets(20));

        // Preload the truck image
        truckImage = new Image("https://img.icons8.com/ios-glyphs/1x/food-truck.png");

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Number Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Update the visualization based on the input number
    private void updateVisualization() {
        String input = textField.getText();
        int count = (int) Math.sqrt(Double.parseDouble(input));
        truckPane.getChildren().clear();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                ImageView truckView = new ImageView(truckImage);
                truckView.setFitWidth(20);
                truckView.setFitHeight(20);
                truckPane.add(truckView, j, i);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
