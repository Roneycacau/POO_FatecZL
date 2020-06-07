package aulas.exerciciosEntregar.criarTela;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Calculadora extends Application {

    private TextField txt_vistor = new TextField();
    private Button btn_CE = new Button("CE");
    private Button btn_0 = new Button("0");
    private Button btn_1 = new Button("1");
    private Button btn_2 = new Button("2");
    private Button btn_3 = new Button("3");
    private Button btn_4 = new Button("4");
    private Button btn_5 = new Button("5");
    private Button btn_6 = new Button("6");
    private Button btn_7 = new Button("7");
    private Button btn_8 = new Button("8");
    private Button btn_9 = new Button("9");
    private Button btn_decimal = new Button(",");
    private Button btn_igual = new Button("=");
    private Button btn_soma = new Button("+");
    private Button btn_subtracao = new Button("-");
    private Button btn_multiplicacao = new Button("*");
    private Button btn_divisao = new Button("/");

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");
        BorderPane border = new BorderPane();
        Scene scene = new Scene(border, 270, 300);
        GridPane grid = new GridPane();
        FlowPane flow = new FlowPane();
        TilePane tile2 = new TilePane();
        TilePane tile3 = new TilePane();
        TilePane tile4 = new TilePane();
        TilePane tile5 = new TilePane();

        border.setCenter(grid);
        BorderPane.setAlignment(grid, Pos.TOP_CENTER);
        BorderPane.setMargin(grid, new Insets(20));
        flow.setMaxWidth(300);
        grid.setMaxWidth(300);

        txt_vistor.setMinWidth(160);
        txt_vistor.setMinHeight(50);
        buttonSize(btn_CE, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6);
        buttonSize(btn_7, btn_8, btn_9, btn_decimal, btn_igual, btn_soma, btn_subtracao, btn_divisao);
        btn_multiplicacao.setMinSize(50, 50);

        btn_CE.setStyle("-fx-font-weight: bolder;" + "-fx-text-fill:#ffffff;" + "-fx-background-color: #ff0000;");

        btn_decimal.setStyle("-fx-font-weight: bolder");

        btn_igual.setStyle("-fx-font-weight: bolder;" + "-fx-text-fill:#ffffff;" + "-fx-background-color: #0000ff;");

        btn_soma.setStyle("-fx-font-weight: bolder");

        btn_subtracao.setStyle("-fx-font-weight: bolder");

        btn_divisao.setStyle("-fx-font-weight: bolder");

        btn_multiplicacao.setStyle("-fx-font-weight: bold");

        flow.getChildren().addAll(txt_vistor, btn_CE);
        tile2.getChildren().addAll(btn_7, btn_8, btn_9, btn_soma);
        tile3.getChildren().addAll(btn_4, btn_5, btn_6, btn_subtracao);
        tile4.getChildren().addAll(btn_1, btn_2, btn_3, btn_multiplicacao);
        tile5.getChildren().addAll(btn_decimal, btn_0, btn_igual, btn_divisao);
        grid.add(flow, 0, 0);
        grid.add(tile2, 0, 1);
        grid.add(tile3, 0, 2);
        grid.add(tile4, 0, 3);
        grid.add(tile5, 0, 4);

        grid.setVgap(5);
        flow.setHgap(5);
        tile2.setHgap(5);
        tile3.setHgap(5);
        tile4.setHgap(5);
        tile5.setHgap(5);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void buttonSize(Button btn_ce, Button btn_0, Button btn_1, Button btn_2, Button btn_3, Button btn_4, Button btn_5, Button btn_6) {
        btn_ce.setMinSize(50, 50);
        btn_0.setMinSize(50, 50);
        btn_1.setMinSize(50, 50);
        btn_2.setMinSize(50, 50);
        btn_3.setMinSize(50, 50);
        btn_4.setMinSize(50, 50);
        btn_5.setMinSize(50, 50);
        btn_6.setMinSize(50, 50);
    }

    public static void main(String[] args) {
        Application.launch(Calculadora.class, args);
    }
}
