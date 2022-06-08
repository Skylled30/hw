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

import java.util.Arrays;


public class Main extends Application {

    public static String[] mas;
    public static final int[] length = {0};

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mas = new String[100];

        Text element = new Text("Элемент");
        Text index = new Text("Индекс");

        Label label = new Label();

        TextField elementField = new TextField();
        elementField.setPrefColumnCount(5);

        TextField indexField = new TextField();
        indexField.setPrefColumnCount(2);

        Button button = new Button("Добавить");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String result = elementField.getText();
                mas[length[0]] = result;
                length[0] += 1;
                Arrays.sort(mas);
                elementField.setText("");
                label.setText(getArray(mas, length[0]));
            }
        });

        Button button2 = new Button("Удалить");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getNewArray(mas, length[0], Integer.parseInt(indexField.getText()));
                label.setText(getArray(mas, length[0]));
            }
        });

        Button button3 = new Button("Сортировка");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getSortArray(mas, length[0]);
                label.setText(getArray(mas, length[0]));
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

    private void getSortArray(String[] mas, int length1) {
        int leftIndex = 0;
        int rightIndex = length1 - 1;
        for (int i = 0; i < length1; i++) {
            String temp = mas[leftIndex];
            mas[leftIndex] = mas[rightIndex];
            mas[rightIndex] = temp;
        }
    }

    private void getNewArray(String[] mas1, int length1, int indexDel) {
        String[] mas2 = new String[length1 - 1];
//        for (int i = 0; i < indexDel; i++) {
//            mas[i] = mas1[i];
//        }
        for (int i = indexDel; i < length1; i++) {
            mas[i] = mas[i + 1];
        }
        length[0] -= 1;
    }

    private String getArray(String[] mas, int length) {
        String[] mas2 = new String[length];
        for (int i = 0; i < length; i++) {
            mas2[i] = mas[i];
        }
        return Arrays.toString(mas2);
    }

    public static void updateInfo(String[] mas){
        System.out.println();
    }
}
