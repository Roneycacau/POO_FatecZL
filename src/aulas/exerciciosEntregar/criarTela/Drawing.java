package aulas.exerciciosEntregar.criarTela;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Drawing extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 250);
        Canvas canvas = new Canvas(400, 250);
        group.getChildren().add(canvas);
        primaryStage.setScene(scene);
        GraphicsContext context = canvas.getGraphicsContext2D();

        context.setStroke(Color.BLACK);
        context.setLineWidth(1);
        context.beginPath();

        for (double altura = 0; altura < 150; altura += 10) {
            double y = 125 - (altura / 2);
            context.strokeOval(50, y, 200, altura);
        }
        for (double largura = 0; largura < 200; largura += 10) {
            double x = 150 - (largura / 2);
            context.strokeOval(x, 50, largura, 150);
        }
        context.stroke();
        context.beginPath();
        context.setLineWidth(2);
        context.rect(300, 50, 50, 60);
        context.moveTo(300, 50);
        context.lineTo(325, 30);
        context.lineTo(350, 50);
        context.stroke();

        primaryStage.setTitle("Drawing");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Drawing.class, args);
    }
}