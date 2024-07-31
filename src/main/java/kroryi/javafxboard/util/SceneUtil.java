package kroryi.javafxboard.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;

public class SceneUtil {
    private static SceneUtil instance;

    Stage stage;
    Scene scene;
    Parent root;
    FXMLLoader loader;



    private SceneUtil() {

    }

    public static SceneUtil getInstance() {
        if (instance == null) {
            instance = new SceneUtil();
        }
        return instance;
    }

    //화면전환용 메서드 (버튼 클릭시 이벤트)
    public void switchScene(ActionEvent event, String fxml) throws IOException {
        loader = new FXMLLoader(getClass().getResource(fxml));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = getClass().getResource("/kroryi/javafxboard/Css.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    //마우스클릭시 이벤트 발생 -> MouseEvent
    public void switchScene(MouseEvent event, String fxml, Parent root) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = getClass().getResource("/kroryi/javafxboard/Css.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void switchScene(ActionEvent event, String fxml, Parent root) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = getClass().getResource("/kroryi/javafxboard/Css.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public Object getController(String fxml) throws IOException {
        loader = new FXMLLoader(getClass().getResource(fxml));
        root = loader.load();
        return loader.getController();
    }

    public static void setInstance(SceneUtil instance) {
        SceneUtil.instance = instance;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }
}
