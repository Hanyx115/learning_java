package org.example.sheet7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public class ArithmeticCalculator extends Application {
        private TextField numField1, numField2, resultField;

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Arithmetic Calculator");

            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(5);
            grid.setHgap(5);

            Label numLabel1 = new Label("Number 1:");
            GridPane.setConstraints(numLabel1, 0, 0);
            numField1 = new TextField();
            GridPane.setConstraints(numField1, 1, 0);

            Label numLabel2 = new Label("Number 2:");
            GridPane.setConstraints(numLabel2, 0, 1);
            numField2 = new TextField();
            GridPane.setConstraints(numField2, 1, 1);

            Label resultLabel = new Label("Result:");
            GridPane.setConstraints(resultLabel, 0, 2);
            resultField = new TextField();
            resultField.setEditable(false);
            GridPane.setConstraints(resultField, 1, 2);

            Button addButton = new Button("Add");
            GridPane.setConstraints(addButton, 0, 3);
            addButton.setOnAction(e -> performOperation('+'));

            Button subtractButton = new Button("Subtract");
            GridPane.setConstraints(subtractButton, 1, 3);
            subtractButton.setOnAction(e -> performOperation('-'));

            Button multiplyButton = new Button("Multiply");
            GridPane.setConstraints(multiplyButton, 2, 3);
            multiplyButton.setOnAction(e -> performOperation('*'));

            Button divideButton = new Button("Divide");
            GridPane.setConstraints(divideButton, 3, 3);
            divideButton.setOnAction(e -> performOperation('/'));

            grid.getChildren().addAll(numLabel1, numField1, numLabel2, numField2, resultLabel, resultField,
                    addButton, subtractButton, multiplyButton, divideButton);

            Scene scene = new Scene(grid, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void performOperation(char operator) {
            try {
                double num1 = Double.parseDouble(numField1.getText());
                double num2 = Double.parseDouble(numField2.getText());
                double result = 0;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            resultField.setText("Cannot divide by zero");


                            public void main (String Object args;
                            )
                            launch();
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + operator);
                }
            } finally {

            }
        }}}
