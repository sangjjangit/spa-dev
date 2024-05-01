package com.demo.service;

import com.demo.domain.Board;

import java.util.List;

public interface BoardService {

    public void register(Board board) throws Exception;

    public Board read(long boardNo) throws Exception;

    public void modify(Board board) throws Exception;

    public void remove(long boardNo) throws Exception;

    public List<Board> list() throws Exception;
}
