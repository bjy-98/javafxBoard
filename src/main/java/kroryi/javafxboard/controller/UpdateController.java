package kroryi.javafxboard.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kroryi.javafxboard.dto.Board;
import kroryi.javafxboard.service.BoardService;
import kroryi.javafxboard.service.BoardServiceImpl;
import kroryi.javafxboard.util.SceneUtil;

import java.io.IOException;

public class UpdateController {
    @FXML
    private TextField nameField;

    @FXML
    public TextField tfTitle;

    @FXML
    public TextField tfWriter;

    @FXML
    public TextField tfRegDate;

    @FXML
    public TextArea taContent;

    int boardNo;
    private BoardService boardService = new BoardServiceImpl();

    public void read(int boardNo){
        this.boardNo = boardNo;
        Board board = boardService.select(boardNo);
//        System.out.println(board);
        tfTitle.setText(board.getTitle());
        tfWriter.setText(board.getWriter());
        tfRegDate.setText(board.getRegDate());
        taContent.setText(board.getContent());

    }

    public void moveToUpdate(ActionEvent event) throws IOException {
        Board board = new Board(tfTitle.getText(), taContent.getText(),tfWriter.getText());
        board.setNo(boardNo);
        int result = boardService.update(board);
        if (result > 0) {
            System.out.println("수정이 완료되었습니다.");
            SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
        }
    }

    public void moveToList(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
    }

    public void moveToRead(ActionEvent event) throws IOException {
        ReadController readController = (ReadController) SceneUtil.getInstance().getController(UI.READ.getPath());
        readController.read(boardNo);
        Parent root = SceneUtil.getInstance().getRoot();
        SceneUtil.getInstance().switchScene(event, UI.READ.getPath(), root);
    }

    public void moveToDelete(ActionEvent event) throws IOException {
        showAlert(event);
    }


    private void showAlert(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("게시물을 삭제했습니다.");
        alert.setHeaderText("게시글을 정말 삭제 하시겠습니다? 글번호 : " + boardNo);
        alert.setContentText("삭제 후 복구는 불가합니다.");
        int result = 0;
        if(alert.showAndWait().get() == ButtonType.OK){
            result = boardService.delete(boardNo);
        }
        if(result > 0){
            System.out.println("글이 삭제되었습니다.");
            SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
        }
    }
}
