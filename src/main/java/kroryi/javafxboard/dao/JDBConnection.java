package kroryi.javafxboard.dao;

import javafx.beans.property.SimpleStringProperty;
import kroryi.javafxboard.dto.Board;
import kroryi.javafxboard.service.BoardService;
import kroryi.javafxboard.service.BoardServiceImpl;

import java.sql.*;

public class JDBConnection {

    public Connection con;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public JDBConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javafxboard";
            String username = "root";
            String password = "030482";

            con = DriverManager.getConnection(url, username, password);
            System.out.println("DB 연결이 성공적으로 되었습니다.");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("DB연결 실패");
        }
    }

    //DB와 연결 잘되는지 확인용
//    public static void main(String[] args){
//        JDBConnection jdbc = new JDBConnection();
//
//        BoardDAO boardDAO = new BoardDAO();
//        boardDAO.selectList();
//        System.out.println(boardDAO.select(2).toString());
//        Board board = new Board(
//                new SimpleStringProperty("오늘 놀러갈까?"),
//                new SimpleStringProperty("날씨가 참 좋아."),
//                new SimpleStringProperty("유재석"));
//        boardDAO.insert(board);
//        boardDAO.selectList();

//        BoardDAO boardDAO = new BoardDAO();
//        Board board = new Board(new SimpleStringProperty("오늘 날씨 너무 덥다"),
//                new SimpleStringProperty("나중에 놀러가자"),
//                new SimpleStringProperty("박명수"));
//        board.setNo(6);
//        boardDAO.update(board);

//        BoardDAO boardDAO = new BoardDAO();
//        boardDAO.delete(2);

//
//        BoardService boardService = new BoardServiceImpl();
//        boardService.list();
//    }


}
