package kroryi.javafxboard.service;

import kroryi.javafxboard.dao.BoardDAO;
import kroryi.javafxboard.dto.Board;

import java.util.List;

public class BoardServiceImpl implements BoardService {

    private BoardDAO boardDAO = new BoardDAO();

    @Override
    public List<Board> list() {
        List<Board> boardList = boardDAO.selectList();
        return boardList;
    }

    @Override
    public Board select(int no) {
        return boardDAO.select(no);

        //아래 두줄을 위 한줄로 변경 가능
        /*Board board = boardDAO.select(no);
        return board;*/
    }

    @Override
    public int insert(Board board) {
        int result = boardDAO.insert(board);
        return result;
    }

    @Override
    public int update(Board board) {
        int result = boardDAO.update(board);
        return result;
    }

    @Override
    public int delete(int no) {
        int result = boardDAO.delete(no);
        return result;
    }

    @Override
    public List<Board> pageList(int pageNo) {
        List<Board> boardList = boardDAO.selectPageList(pageNo);
        return boardList;
    }

    @Override
    public int totalListCount() {
        int count = boardDAO.selectTotalCount();
        return count;
    }
}