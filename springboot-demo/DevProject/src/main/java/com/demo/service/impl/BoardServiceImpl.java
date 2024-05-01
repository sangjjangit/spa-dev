package com.demo.service.impl;

import com.demo.domain.Board;
import com.demo.exception.BoardRecordNotFoundException;
import com.demo.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private List<Board> boardList = new ArrayList<>();

    private long counter = 0;
    @Override
    public void register(Board board) throws Exception {
        counter++;

        board.setBoardNo(counter);

        boardList.add(board);
    }

    @Override
    public Board read(long boardNo) throws Exception {
        Board board = null;
        for(int i = 0; i < boardList.size(); i++) {
            Board tempBoard = boardList.get(i);
            if(tempBoard.getBoardNo() == boardNo) {
                board = tempBoard;
                break;
            }
        }

// 게시판의 글이 존재하지 않으면 사용자가 정의한 예외를 발생시킨다.
        if (board == null) {
            throw new BoardRecordNotFoundException("Not Found boardNo = " + boardNo);
        }

        return board;
    }

    @Override
    public void modify(Board board) throws Exception {
        Board tempBoard = null;
        for(int i = 0; i < boardList.size(); i++) {
            tempBoard = boardList.get(i);
            if(tempBoard.getBoardNo() == board.getBoardNo()) {
                break;
            }
        }

        if(tempBoard != null) {
            tempBoard.setTitle(board.getTitle());
            tempBoard.setContent(board.getContent());
        }
    }

    @Override
    public void remove(long boardNo) throws Exception {
        for(int i = 0; i < boardList.size(); i++) {
            Board board = boardList.get(i);

            if(board.getBoardNo() == boardNo) {
                boardList.remove(i);
                return;
            }
        }

    }

    @Override
    public List<Board> list() throws Exception {
        return boardList;
    }
}
