package org.example.sheet7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

 class CombinedProgram extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Combined Program");

        // Panel for changing background color
        Pane panel = new Pane();
        panel.setStyle("-fx-background-color: white;");
        panel.setOnMousePressed(e -> panel.setStyle("-fx-background-color: black;"));
        panel.setOnMouseReleased(e -> panel.setStyle("-fx-background-color: white;"));

        // Text field for text case conversion
        TextField textField = new TextField();
        textField.setPromptText("Enter text...");

        // Buttons for text case conversion
        Button upperButton = new Button("Upper Case");
        upperButton.setOnAction(e -> textField.setText(textField.getText().toUpperCase()));

        Button lowerButton = new Button("Lower Case");
        lowerButton.setOnAction(e -> textField.setText(textField.getText().toLowerCase()));

        // Horizontal box to hold the text field and buttons
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(textField, upperButton, lowerButton);

        // Text to display mouse position
        Text mousePositionText = new Text();
        panel.setOnMouseMoved(e -> mousePositionText.setText("Mouse Position: (" + e.getX() + ", " + e.getY() + ")"));

        // Border pane to organize the layout
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(panel);
        borderPane.setBottom(hbox);
        borderPane.setTop(mousePositionText);

        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
