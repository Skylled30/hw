package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text n1 = new Text("1 число");
        Text n2 = new Text("2 число");
        Text sign = new Text("знак");

        Label label = new Label();

        TextField n1Field = new TextField();
        n1Field.setPrefColumnCount(2);

        TextField n2Field = new TextField();
        n2Field.setPrefColumnCount(2);

        TextField signField = new TextField();
        signField.setPrefColumnCount(2);

        Button button = new Button("Вычислить");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = "Неверный ввод данных";
                double num1;
                double num2;
                try {
                    num1 = Double.parseDouble(n1Field.getText());
                    num2 = Double.parseDouble(n2Field.getText());
                    if (signField.getText().equals("+"))
                        result = "Ответ: " + (num1 + num2);
                    else if (signField.getText().equals("-"))
                        result = "Ответ: " + (num1 - num2);
                    else if (signField.getText().equals("*"))
                        result = "Ответ: " + num1 * num2;
                    else if (signField.getText().equals("/"))
                        result = "Ответ: " + num1 / num2;
                    else
                        result = "Неверно указан знак";
                } catch (NumberFormatException e) {
                    result = "Неверно введены числа";
                } catch (Exception e) {
                    result = "Произошла ошибка";
                }
                label.setText(result);
            }
        });

        FlowPane flowPane1 = new FlowPane(n1, n1Field, sign, signField, n2, n2Field, button);
        flowPane1.setHgap(2);
        FlowPane flowPane2 = new FlowPane(label);
        FlowPane flowPane = new FlowPane(flowPane1, flowPane2);

        Group group = new Group(flowPane);

        Scene scene = new Scene(group);
        stage.setScene(scene);

        stage.setTitle("Калькулятор");
        stage.setWidth(500);
        stage.setHeight(250);
        stage.show();
    }

}
