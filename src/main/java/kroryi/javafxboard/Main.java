package kroryi.javafxboard;

import javafx.application.Application;
import javafx.css.CssMetaData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.html.CSS;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LOGIN.fxml"));
//메인고침
        Scene scene = new Scene(fxmlLoader.load(), 880, 600);
        String css = getClass().getResource("/kroryi/javafxboard/Css.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("javaFX Board!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

//        stage.setOnCloseRequest(event -> {
//            event.consume();
//        });
    }

    public static void main(String[] args) {
        launch();
    }
}