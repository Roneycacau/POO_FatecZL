package aulas.aula6.exercicioemaula;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 600, 400);
        Label lbl_title = new Label("Login no Sistema");
        TextField txtf_user = new TextField("User");
        TextField txtf_password = new TextField("Password");
        Button btn_login = new Button("Login");
        Button btn_registration = new Button("Registration");

        pane.getChildren().add(lbl_title);
        pane.getChildren().add(txtf_user);
        pane.getChildren().add(txtf_password);
        pane.getChildren().add(btn_login);
        pane.getChildren().add(btn_registration);

        double lbl_titleX = (scene.getWidth() - (lbl_title.getWidth()/2))/2.5;
        double lbl_titleY = (scene.getHeight() - lbl_title.getHeight()) / 6;
        lbl_title.setScaleX(3);
        lbl_title.setScaleY(3);
        
//        lbl_title.setFont(new Font(30));
        lbl_title.relocate(lbl_titleX, lbl_titleY);

        double txtf_userX = lbl_titleX;
        double txtf_userY = lbl_titleY*2;
        txtf_user.relocate(txtf_userX,txtf_userY);


        double txtf_passwordX = lbl_titleX;
        double txtf_passwordY = txtf_userY + 50;
        txtf_password.relocate(txtf_passwordX,txtf_passwordY);

        double btn_loginX = lbl_titleX - 90;
        double btn_loginY = txtf_passwordY + 50;
        btn_login.relocate(btn_loginX,btn_loginY);


        double btn_registrationX = lbl_titleX + 100;
        double btn_registrationY = txtf_passwordY + 50;
        btn_registration.relocate(btn_registrationX,btn_registrationY);



        stage.setTitle("Formulário de Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Login.class, args);
    }
}
