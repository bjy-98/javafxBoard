package kroryi.javafxboard.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kroryi.javafxboard.dto.Board;
import kroryi.javafxboard.service.BoardService;
import kroryi.javafxboard.service.BoardServiceImpl;
import kroryi.javafxboard.util.SceneUtil;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReadController implements Initializable {

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;

    @FXML
    private TextField tfRegDate;

    @FXML
    private TextArea taContent;



    private BoardService boardService = new BoardServiceImpl();
    int boardNo;

    List<Integer> numArr = new ArrayList<>();
    int targetValue = boardNo;
    int prevValue = -1;
    int nextValue = +1;

    public void read(int boardNo){
        numArr = listNum();
        this.targetValue = boardNo;
        this.boardNo = boardNo;
        Board board = boardService.select(boardNo);
//        System.out.println(board);
        tfTitle.setText(board.getTitle());
        tfWriter.setText(board.getWriter());
        tfRegDate.setText(board.getRegDate());
        taContent.setText(board.getContent());

    }

    public void moveToList(ActionEvent event) throws IOException {
//        System.out.println("글목록 화면으로 이동");
        SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());

    }

    public void moveToLogin(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, UI.LOGIN.getPath());

    }

    public void moveToDelete(ActionEvent event) throws IOException {
        showAlert(event);
    }

    public void moveToUpdate(ActionEvent event) throws IOException {
        UpdateController updateController = (UpdateController) SceneUtil.getInstance().getController(UI.UPDATE.getPath());
        updateController.read(boardNo);
        Parent root = SceneUtil.getInstance().getRoot();
        SceneUtil.getInstance().switchScene(event, UI.UPDATE.getPath(), root);
    }

    public void moveToPrev(ActionEvent event){
        numArr = listNum();
        read(prevValue);
    }

    public void moveToNext(ActionEvent event){
        numArr = listNum();
        read(nextValue);
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

    public List<Integer> listNum(){
        List<Board> boardList = new ArrayList<>();
        boardList = boardService.list();
        numArr.clear();
        for(Board board : boardList){
            numArr.add(board.getNo());
        }

        targetValue = boardNo;
        int idx = numArr.indexOf(targetValue);
        if(idx > 0){
            prevValue = numArr.get(idx - 1);
        }
        if(idx < numArr.size() - 1){
            nextValue = numArr.get(idx + 1);
        }
        return numArr;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listNum();
    }
}
