package aulas.exerciciosEntregar.interfacegraficasimples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
    private Button sair = new Button("Sair");
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 50, 50);
        bp.setLeft(new Label("Ola ... !!!"));
        bp.setBottom(sair);
        sair.setOnAction(this);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Janela de Teste");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getTarget() == sair){
            System.out.println(event);
            System.exit(0);
        }
    }
}
