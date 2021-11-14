package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardInsert() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setBoardTitle(request.getParameter("boardTitle"));
		boardDTO.setBoardContent(request.getParameter("boardContent"));
		
		boardDAO.insertBoard(boardDTO);
		
		response.sendRedirect("/");
	}

}
