package aulas.exerciciosEntregar.criarTela;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CriacaoDeTela extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lbl_phone = new Label("Enter your phone number:");
        Label lbl_name = new Label("Enter your name:");
        TextField txt_phone = new TextField();
        TextField txt_name = new TextField();
        Button btn_ok = new Button("OK");
        Button btn_cancel = new Button("Cancel");

        txt_name.setPrefHeight(50);
        btn_ok.setMinWidth(140);
        btn_cancel.setMinWidth(140);

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 300, 200);
        FlowPane flow1 = new FlowPane();
        FlowPane flow2 = new FlowPane();
        FlowPane flow3 = new FlowPane();

        grid.setVgap(5);
        grid.setPadding(new Insets(10,0,0,5));
        flow3.setHgap(3);

        grid.add(flow1, 0, 0);
        grid.add(flow2, 0, 1);
        grid.add(flow3, 0, 3);

        flow1.getChildren().addAll(lbl_phone, txt_phone);
        flow2.getChildren().addAll(lbl_name, txt_name);
        flow3.getChildren().addAll(btn_ok, btn_cancel);


        primaryStage.setTitle("Graphic User Interface Test");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(CriacaoDeTela.class, args);
    }
}
