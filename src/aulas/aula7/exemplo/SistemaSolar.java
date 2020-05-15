package aulas.aula7.exemplo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class SistemaSolar extends Application {

    public Point2D centro(Image img, double centroX, double centroY) {
        Point2D d = new Point2D(centroX - img.getWidth() / 2,
                centroY - img.getHeight() / 2);
        return d;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group grp = new Group();
        Scene scn = new Scene(grp);
        primaryStage.setScene(scn);

        InputStream isEspaco = getClass()
                .getResourceAsStream("/images/space.png");
        Image img = new Image(isEspaco);
        Image imgSun = new Image(getClass()
                .getResourceAsStream("/images/sun.png"));
        Image imgEarth = new Image(getClass()
                .getResourceAsStream("/images/earth.png"));
        Image imgMars = new Image(getClass()
                .getResourceAsStream("/images/mars.png"));

        Canvas canvas = new Canvas(img.getWidth(), img.getHeight());
        grp.getChildren().add(canvas);
        GraphicsContext ctx = canvas.getGraphicsContext2D();
        double centroX = canvas.getWidth() / 2;
        double centroY = canvas.getHeight() / 2;

        final double[] angulo = new double[2];

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                ctx.drawImage(img, 0, 0);

                Point2D pointSun = centro(imgSun, centroX, centroY);


                double earthX = centroX + (100 * Math.cos(angulo[0]));
                double earthY = centroX + (50 * Math.sin(angulo[0]));
                Point2D pointEarth = centro(imgEarth, earthX, earthY);

                double marsX = centroX + (250 * Math.cos(angulo[1]));
                double marsY = centroX + (100 * Math.sin(angulo[1]));
                Point2D pointMars = centro(imgMars, marsX, marsY);

                angulo[0] += 0.02;
                angulo[1] += 0.014;

                if (Math.sin(angulo[0]) < -0.7) {
                    ctx.drawImage(imgEarth, pointEarth.getX(), pointEarth.getY());
                    ctx.drawImage(imgSun, pointSun.getX(),
                            pointSun.getY());
                } else {
                    ctx.drawImage(imgSun, pointSun.getX(),
                            pointSun.getY());
                    ctx.drawImage(imgEarth, pointEarth.getX(), pointEarth.getY());
                }
                ctx. drawImage(imgMars, pointMars.getX(), pointMars.getY());
            }
        }.start();


        primaryStage.setTitle("Sistema Solar");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(SistemaSolar.class, args);
    }
}
