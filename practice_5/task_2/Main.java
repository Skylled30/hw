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
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;


public class Main extends Application {

    public static double[] mas;
    public static int length = 0;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mas = new double[1000];

        Text element = new Text("Элемент");
        Text index = new Text("Индекс");

        Label label = new Label();
        Label label2 = new Label();

        TextField elementField = new TextField();
        elementField.setPrefColumnCount(5);

        TextField indexField = new TextField();
        indexField.setPrefColumnCount(2);

        Button button = new Button("Добавить");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result;
                try {
                    double num = Double.parseDouble(elementField.getText());
                    System.out.println(num);
                    System.out.println(elementField.getText());
                    mas[length] = num;
                    length += 1;
                    getSortArr();
                    result = getArray(mas, length);
                } catch (Exception e){
                    result = "Неверный ввод данных";
                }
                elementField.setText("");
                label.setText(result);
            }
        });

        Button button2 = new Button("Удалить");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getNewArray(mas, length, Integer.parseInt(indexField.getText()));
                label.setText(getArray(mas, length));
            }
        });

        Button button3 = new Button("Сортировка");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getSortArray();
                label.setText(getArray(mas, length));
            }
        });

        FlowPane flowPane1 = new FlowPane(element, elementField, button);
        flowPane1.setHgap(2);
        FlowPane flowPane2 = new FlowPane(index, indexField, button2);
        flowPane2.setHgap(2);
        FlowPane flowPane3 = new FlowPane(label);
        FlowPane flowPane = new FlowPane(flowPane1, flowPane2, flowPane3, button3);

        Group group = new Group(flowPane);

        Scene scene = new Scene(group);
        stage.setScene(scene);

        stage.setTitle("Площадь треугольника");
        stage.setWidth(500);
        stage.setHeight(250);
        stage.show();
    }

    private void getSortArray() {
        int leftIndex = 0;
        int rightIndex = length - 1;
        for (int i = 0; i < length / 2; i++) {
            double temp = mas[leftIndex];
            mas[leftIndex] = mas[rightIndex];
            mas[rightIndex] = temp;
            leftIndex += 1;
            rightIndex -= 1;
        }
    }

    private void getNewArray(double[] mas1, int length1, int indexDel) {
        for (int i = indexDel; i < length1; i++) {
            mas[i] = mas[i + 1];
        }
        length -= 1;
    }

    private void getSortArr() {
        double[] mas2 = new double[length];
        for (int i = 0; i < length; i++) {
            mas2[i] = mas[i];
        }
        Arrays.sort(mas2);
        System.out.println(Arrays.toString(mas2));
        for (int i = 0; i < length; i++) {
            mas[i] = mas2[i];
        }
    }

    private String getArray(double[] mas, int length) {
        double[] mas2 = new double[length];
        for (int i = 0; i < length; i++) {
            mas2[i] = mas[i];
        }
        return Arrays.toString(mas2);
    }
}
