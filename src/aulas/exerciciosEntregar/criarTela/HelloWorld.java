package aulas.exerciciosEntregar.criarTela;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    @Override
    public void start(Stage stage){
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 200, 100);
        Label lb_hello = new Label("Hello World");

        pane.getChildren().add(lb_hello);
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(HelloWorld.class, args);
    }
}
