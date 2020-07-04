package aulas.exerciciosEntregar.crudaluno;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AlunoBoundary extends Application implements EventHandler<ActionEvent> {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private TextField txt_id = new TextField();
    private TextField txt_ra = new TextField();
    private TextField txt_nome = new TextField();
    private TextField txt_nascimento = new TextField();

    private Button btn_adicionar = new Button("Adicionar");
    private Button btn_pesquisar = new Button("Pesquisar");

    private AlunoControl control = new AlunoControl();

    private TableView<Aluno> tableView = new TableView<>(control.getAlunos());

    private void generateTable() {
        TableColumn<Aluno, Long> colId = new TableColumn<>("ID");
        TableColumn<Aluno, String> colRa = new TableColumn<>("RA");
        TableColumn<Aluno, String> colNome = new TableColumn<>("NOME");
        TableColumn<Aluno, String> colNascimento = new TableColumn<>("NASCIMENTO");

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colRa.setCellValueFactory(new PropertyValueFactory<>("ra"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colNascimento.setCellValueFactory(item -> new ReadOnlyStringWrapper(
                dtf.format(item.getValue().getNascimento()
        )));


        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> entityToBoundary(dtf, newValue)
        );
        tableView.getColumns().addAll(colId, colRa, colNome, colNascimento);
    }

    @Override
    public void start(Stage stage) {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 400, 300);

        GridPane gp = new GridPane();
        generateTable();
        gp.add(new Label("ID "), 0, 0);
        gp.add(new Label("RA "), 0, 1);
        gp.add(new Label("NOME "), 0, 2);
        gp.add(new Label("NASCIMENTO "), 0, 3);

        gp.add(txt_id, 1, 0);
        gp.add(txt_ra, 1, 1);
        gp.add(txt_nome, 1, 2);
        gp.add(txt_nascimento, 1, 3);

        gp.add(btn_adicionar, 0, 4);
        gp.add(btn_pesquisar, 1, 4);
        btn_adicionar.setOnAction(this);
        btn_pesquisar.setOnAction(this);

        bp.setTop(gp);
        bp.setCenter(tableView);

        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AlunoBoundary.class, args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getTarget() == btn_adicionar) {
        Aluno novoAluno = boundaryToEntity(dtf);
            control.adicionar(novoAluno);
            cleanFields();
        }
        if (event.getTarget() == btn_pesquisar) {
            Aluno resultado = control.pesquisar(txt_nome.getText());
            entityToBoundary(dtf, resultado);
        }
    }

    private void cleanFields() {
        txt_id.setText("");
        txt_ra.setText("");
        txt_nome.setText("");
        txt_nascimento.setText("");
    }

    private Aluno boundaryToEntity(DateTimeFormatter dtf) {
        Aluno a = new Aluno();

        try {
            a.setId(Long.parseLong(txt_id.getText()));
            a.setRa(txt_ra.getText());
            a.setNome(txt_nome.getText());
            a.setNascimento(LocalDate.parse(txt_nascimento.getText(), dtf));
        } catch (Exception e) {
            alertErro(e.getMessage(), "Erro de tipo de dado", "Erro ao adicionar Aluno");
        }
        return a;
    }

    private void entityToBoundary(DateTimeFormatter dtf, Aluno resultado) {
        txt_id.setText(String.valueOf(resultado.getId()));
        txt_ra.setText(resultado.getRa());
        txt_nome.setText(resultado.getNome());
        txt_nascimento.setText(dtf.format(resultado.getNascimento()));
    }

    private void alertErro(String mensagem, String title, String header) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(mensagem);

        alert.showAndWait();
    }
}
