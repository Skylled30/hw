import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonBounce extends Application {

    AnimationTimer B1Fly;
    AnimationTimer B2Fly;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 1500, 800);

        stage.setTitle("Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        class Timer {
            long s;
            long f;
        }
        Timer time = new Timer();

        Button button1 = new Button("B1");
        button1.setMinSize(100, 100);
        button1.setLayoutX(600);
        button1.setLayoutY(200);
        group.getChildren().add(button1);
        final double[] Button1Cords = new double[2];
        final double[] Button1StartCords = new double[2];
        final double[] Button1Speed = new double[2];


        Button button2 = new Button("B2");
        button2.setMinSize(100, 100);
        button2.setLayoutX(300);
        button2.setLayoutY(400);
        group.getChildren().add(button2);
        final double[] Button2Cords = new double[2];
        final double[] Button2StartCords = new double[2];
        final double[] Button2Speed = new double[2];

        button1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Button1Cords[0] = mouseEvent.getX();
                Button1Cords[1] = mouseEvent.getY();
                Button1StartCords[0] = mouseEvent.getSceneX();
                Button1StartCords[1] = mouseEvent.getSceneY();
                time.s = System.currentTimeMillis();
            }
        });

        button1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button1.setLayoutX(mouseEvent.getSceneX() - Button1Cords[0]);
                button1.setLayoutY(mouseEvent.getSceneY() - Button1Cords[1]);
            }
        });


        button1.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                time.f = System.currentTimeMillis();
                Button1Speed[0] = (mouseEvent.getSceneX() - Button1StartCords[0]) / (time.f - time.s);
                Button1Speed[1] = (mouseEvent.getSceneY() - Button1StartCords[1]) / (time.f - time.s);
                B1Fly.start();
                B2Fly.start();
            }
        });

        button2.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Button2Cords[0] = mouseEvent.getX();
                Button2Cords[1] = mouseEvent.getY();
                Button2StartCords[0] = mouseEvent.getSceneX();
                Button2StartCords[1] = mouseEvent.getSceneY();
                time.s = System.currentTimeMillis();
            }
        });

        button2.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button2.setLayoutX(mouseEvent.getSceneX() - Button2Cords[0]);
                button2.setLayoutY(mouseEvent.getSceneY() - Button2Cords[1]);
            }
        });

        button2.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                time.f = System.currentTimeMillis();
                Button2Speed[0] = (mouseEvent.getSceneX() - Button2StartCords[0]) / (time.f - time.s);
                Button2Speed[1] = (mouseEvent.getSceneY() - Button2StartCords[1]) / (time.f - time.s);
                B1Fly.start();
                B2Fly.start();
            }
        });


        B1Fly = new AnimationTimer() {
            @Override
            public void handle(long l) {
                button1.setLayoutX(button1.getLayoutX() + Button1Speed[0] * 10);
                button1.setLayoutY(button1.getLayoutY() + Button1Speed[1] * 10);

                if (button1.getLayoutX() >= 1400 | button1.getLayoutX() <= 0) {
                    Button1Speed[0] = -Button1Speed[0];
                }
                if (button1.getLayoutY() >= 700 | button1.getLayoutY() <= 0) {
                    Button1Speed[1] = -Button1Speed[1];
                }

                double crossX = Math.abs(button1.getLayoutX() -
                        button2.getLayoutX());
                double crossY = Math.abs(button1.getLayoutY() - button2.getLayoutY());
                if (crossX < button2.getWidth() && crossY < button2.getHeight()) {


                    Button2Speed[0] = Button1Speed[0];
                    Button2Speed[1] = Button1Speed[1];
                    Button1Speed[0] = 0;
                    Button1Speed[1] = 0;
                }
            }
        };
        B2Fly = new AnimationTimer() {
            @Override
            public void handle(long l) {
                button2.setLayoutX(button2.getLayoutX() + Button2Speed[0]*10);
                button2.setLayoutY(button2.getLayoutY() + Button2Speed[1]*10);

                if (button2.getLayoutX() >= 1400 | button2.getLayoutX() <= 0){
                    Button2Speed[0] = -Button2Speed[0];
                }
                if (button2.getLayoutY() >= 700 | button2.getLayoutY() <= 0){
                    Button2Speed[1] = -Button2Speed[1];
                }

                double crossX = Math.abs(button1.getLayoutX() - button2.getLayoutX());
                double crossY = Math.abs(button1.getLayoutY() - button2.getLayoutY());
                if (crossX < button2.getWidth() && crossY < button2.getHeight()) {


                    Button1Speed[0] = Button2Speed[0];
                    Button1Speed[1] = Button2Speed[1];
                    Button2Speed[0] = 0;
                    Button2Speed[1] = 0;
                }
            }
        };
    }
}
