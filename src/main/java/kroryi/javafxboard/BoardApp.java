package kroryi.javafxboard;

import kroryi.javafxboard.dto.Board;
import kroryi.javafxboard.service.BoardService;
import kroryi.javafxboard.service.BoardServiceImpl;

public class BoardApp {

    static BoardService boardService = new BoardServiceImpl();

    public static void main(String[] args) {
        //목록보기
        for (Board board : boardService.list()) {
            System.out.println(board.getNo() + " " + board.getTitle() + " " + board.getWriter() + " " + board.getContent());
        }

        //게시글 추가
//        Board board = new Board();
//        board.setTitle("222");
//        board.setWriter("222");
//        board.setContent("222");
//        boardService.insert(board);


        //상세보기
//        Board selectedBoard = boardService.select(59);
//        if (selectedBoard != null) {
//            System.out.println(selectedBoard.getNo() + " | " +
//                    selectedBoard.getTitle() + " | " +
//                    selectedBoard.getWriter() + " | " +
//                    selectedBoard.getContent());
//        } else {
//            System.out.println("게시글을 찾을 수 없습니다.");
//        }



        //수정하기
//        Board updateBoard = boardService.select(59);
//        if (updateBoard != null) {
//            updateBoard.setTitle("수정된 제목");
//            updateBoard.setContent("수정된 내용");
//            updateBoard.setWriter("수정된 작성자");
//            boardService.update(updateBoard);
//
//            System.out.println("수정확인 ↓");
//            System.out.println(updateBoard.getNo() + " | " +
//                    updateBoard.getTitle() + " | " +
//                    updateBoard.getWriter() + " | " +
//                    updateBoard.getContent());
//        } else {
//            System.out.println("게시글을 찾을 수 없습니다.");
//        }



        //삭제하기
//        boardService.delete(59);
    }
}
