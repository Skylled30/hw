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

        Text text = new Text("Введите коэффициенты для решения квадратного уравнения ax^2 + bx + c = 0");
        text.setLayoutY(75);
        text.setLayoutX(20);

        Text a = new Text("a = ");
        Text b = new Text(", b = ");
        Text c = new Text(", c = ");
        Label res = new Label();

        TextField textField1 = new TextField();
        textField1.setPrefColumnCount(2);

        TextField textField2 = new TextField();
        textField2.setPrefColumnCount(2);

        TextField textField3 = new TextField();
        textField3.setPrefColumnCount(2);

        Button button = new Button("Вычислить");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = "Неверный ввод данных";
                if (!textField1.getText().equals("") && !textField2.getText().equals("") && !textField3.getText().equals("")) {
                    result = getCalculate(textField1.getText(), textField2.getText(), textField3.getText());
                }
                res.setText(result);
            }
        });

        FlowPane flowPane1 = new FlowPane(text);
        FlowPane flowPane2 = new FlowPane(Orientation.HORIZONTAL, 10, 10, a, textField1, b, textField2, c, textField3);
        flowPane2.setHgap(1);
        FlowPane flowPane3 = new FlowPane(button);
        FlowPane flowPane4 = new FlowPane(res);

        FlowPane flowPane5 = new FlowPane(Orientation.VERTICAL, 10, 10, flowPane1, flowPane2, flowPane3, flowPane4);

        Group group = new Group(flowPane5);

        Scene scene = new Scene(group);
        stage.setScene(scene);

        stage.setTitle("Решение уравнения");
        stage.setWidth(500);
        stage.setHeight(250);
        stage.show();
    }

    public String getCalculate(String a_, String b_, String c_){
        int a = Integer.parseInt(a_);
        int b = Integer.parseInt(b_);
        int c = Integer.parseInt(c_);
        String result = "";

        double d = b * b - 4 * a * c;
        if (d > 0){
            double rootX1 = (-b + Math.sqrt(d)) / (2 * a);
            double rootX2 = (-b - Math.sqrt(d)) / (2 * a);
            result = "Найдено 2 корня: x1 = " + rootX1 + ", x2 = " + rootX2;
        } else if (d == 0){
            double rootX1 = -b / (2 * a);
            result = "Найден 1 корень: x1 = " + rootX1;
        } else {
            result = "Уравнение не имеет корней";
        }
        return result;
    }
}
