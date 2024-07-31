package kroryi.javafxboard.controller;

public enum UI {
    //fxml 파일이 있는 경로. LIST는 키임.
    LIST("/kroryi/javafxboard/boardlist-view.fxml"),
    INSERT("/kroryi/javafxboard/INSERT.fxml"),
    READ("/kroryi/javafxboard/READ.fxml"),
    UPDATE("/kroryi/javafxboard/UPDATE.fxml"),
    HOME("/kroryi/javafxboard/HOME.fxml"),
    REGISTER("/kroryi/javafxboard/REGISTER.fxml"),
    LOGIN("/kroryi/javafxboard/LOGIN.fxml");


    private final String path;

    UI(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
