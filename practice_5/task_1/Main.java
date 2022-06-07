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
        Text side1 = new Text("Сторона 1");
        Text side2 = new Text("Сторона 2");
        Text side3 = new Text("Сторона 3");

        Label label = new Label();

        TextField side1Field = new TextField();
        side1Field.setPrefColumnCount(2);

        TextField side2Field = new TextField();
        side2Field.setPrefColumnCount(2);

        TextField side3Field = new TextField();
        side3Field.setPrefColumnCount(2);

        Button button = new Button("Вычислить");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = "Что-то было не так";
                double num1;
                double num2;
                double num3;
                try {
                    num1 = Double.parseDouble(side1Field.getText());
                    num2 = Double.parseDouble(side2Field.getText());
                    num3 = Double.parseDouble(side3Field.getText());
                    double p = (num1 + num2 + num3) / 2;
                    result = "Площадь треугольника = " + Math.sqrt(p * (p - num1) * (p - num2) * (p - num3));

                } catch (NumberFormatException e) {
                    result = "Неверно введены числа";
                } catch (Exception e) {
                    result = "Ошибка вычисления";
                }
                label.setText(result);
            }
        });

        FlowPane flowPane1 = new FlowPane(side1, side1Field, side2, side2Field, side3, side3Field, button);
        flowPane1.setHgap(2);
        FlowPane flowPane2 = new FlowPane(label);
        FlowPane flowPane = new FlowPane(flowPane1, flowPane2);

        Group group = new Group(flowPane);

        Scene scene = new Scene(group);
        stage.setScene(scene);

        stage.setTitle("Площадь треугольника");
        stage.setWidth(500);
        stage.setHeight(250);
        stage.show();
    }

}
