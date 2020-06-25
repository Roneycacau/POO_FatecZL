package aulas.exerciciosEntregar.crudaluno;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AlunoBoundary extends Application implements EventHandler<ActionEvent> {
    private TextField txt_id = new TextField();
    private TextField txt_ra = new TextField();
    private TextField txt_nome = new TextField();
    private TextField txt_nascimento = new TextField();

    private Button btn_adicionar = new Button("Adicionar");
    private Button btn_pesquisar = new Button("Pesquisar");

    private AlunoControl control = new AlunoControl();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        Scene scn = new Scene(bp, 400, 300);

        GridPane gp = new GridPane();

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

        bp.setCenter(gp);

        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AlunoBoundary.class, args);
    }

    @Override
    public void handle(ActionEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
