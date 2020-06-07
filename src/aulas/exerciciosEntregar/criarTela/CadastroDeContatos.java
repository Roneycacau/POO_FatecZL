package aulas.exerciciosEntregar.criarTela;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CadastroDeContatos extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lblId = new Label("ID: ");
        Label lblNome = new Label("Nome: ");
        Label lblTel = new Label("Telefone: ");
        TextField txtId = new TextField();
        TextField txtNome = new TextField();
        TextField txtTel = new TextField();
        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        BorderPane border = new BorderPane();
        Scene scene = new Scene(border, 600, 300);
        GridPane grid = new GridPane();
        FlowPane flow = new FlowPane();

        border.setCenter(grid);
        border.setBottom(flow);
        BorderPane.setAlignment(grid, Pos.TOP_LEFT);
        BorderPane.setAlignment(flow, Pos.CENTER_LEFT);
        BorderPane.setMargin(flow, new Insets(30));
        BorderPane.setMargin(grid, new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        txtId.setMinWidth(300);
        txtNome.setMinWidth(300);
        txtTel.setMinWidth(300);



        grid.add(lblId, 1, 1);
        grid.add(txtId, 5, 1);
        grid.add(lblNome, 1, 2);
        grid.add(txtNome, 5, 2);
        grid.add(lblTel, 1, 3);
        grid.add(txtTel, 5, 3);
        flow.getChildren().addAll(btnSalvar, btnPesquisar);

        primaryStage.setTitle("Untitled");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(CadastroDeContatos.class, args);
    }
}
