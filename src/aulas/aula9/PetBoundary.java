package aulas.aula9;

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
import java.util.ArrayList;
import java.util.List;

public class PetBoundary extends Application implements EventHandler<ActionEvent> {
    private TextField txt_id = new TextField();
    private TextField txt_nome = new TextField();
    private TextField txt_raca = new TextField();
    private TextField txt_peso = new TextField();
    private TextField txt_nasc = new TextField();

    private Button btn_pesquisar = new Button("Pesquisar");
    private Button btn_salvar = new Button("Salvar");

    private List<Pet> pets = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane painelBase = new BorderPane();
        Scene scn = new Scene(painelBase, 400, 300);

        GridPane painelCampos = new GridPane();

        painelCampos.add(new Label("Id "), 0, 0);
        painelCampos.add(new Label("Nome "), 0, 1);
        painelCampos.add(new Label("Raça "), 0, 2);
        painelCampos.add(new Label("Peso "), 0, 3);
        painelCampos.add(new Label("Nascimento "), 0, 4);

        painelCampos.add(txt_id, 1, 0);
        painelCampos.add(txt_nome, 1, 1);
        painelCampos.add(txt_raca, 1, 2);
        painelCampos.add(txt_peso, 1, 3);
        painelCampos.add(txt_nasc, 1, 4);

        painelCampos.add(btn_pesquisar, 0, 5);
        painelCampos.add(btn_salvar, 1, 5);

        btn_salvar.setOnAction(this);
        btn_pesquisar.setOnAction(this);
        painelBase.setCenter(painelCampos);
        stage.setScene(scn);
        stage.setTitle("Gestão de Pet");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(PetBoundary.class, args);
    }

    @Override
    public void handle(ActionEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Long id = !txt_id.getText().trim().isEmpty() ? Long.parseLong(txt_id.getText()):null;
        String nome = txt_nome.getText();
        String raca = txt_raca.getText();
        Double peso = !txt_peso.getText().trim().isEmpty() ? Double.parseDouble(txt_peso.getText()): null;
        LocalDate nasc = !txt_nasc.getText().trim().isEmpty() ? LocalDate.parse(txt_nasc.getText(), dtf) : null;
        if (event.getTarget() == btn_salvar) {
            try {
                pets.add(new Pet(id, nome, raca, peso, nasc));
                System.out.println("adicionado pet\nTotal de pets adicionado: " + pets.size());
            } catch (Exception e) {
                alertErro(e.getMessage(),"Erro de tipo de dado", "Erro ao adicinar Pet");
            }
        }
        if (event.getTarget() == btn_pesquisar) {

            if (nome != null || !nome.isEmpty()) {
                searchByPetName(dtf, nome);
            }else if(id != null){
                searchByPetId(dtf, id);
            }else{
                alertErro("Preencha o nome ou o id", "Erro na Pesquisa", "Nome ou ID devem ser informados");
            }
        }
    }

    private void searchByPetName(DateTimeFormatter dtf, String nome) {
        for (Pet pet : pets) {
            if (pet.getNome().equalsIgnoreCase(nome)) {
                insertInTxtFields(dtf, pet);
            }
        }
    }

    private void searchByPetId(DateTimeFormatter dtf, Long id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                insertInTxtFields(dtf, pet);
            }
        }
    }

    private void insertInTxtFields(DateTimeFormatter dtf, Pet pet) {
        txt_id.setText(String.valueOf(pet.getId()));
        txt_nome.setText(pet.getNome());
        txt_raca.setText(pet.getRaca());
        txt_peso.setText(String.valueOf(pet.getPeso()));
        txt_nasc.setText(dtf.format(pet.getNascimento()));
    }

    private void alertErro(String mensagem, String title, String header ) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(mensagem);

        alert.showAndWait();
    }
}
