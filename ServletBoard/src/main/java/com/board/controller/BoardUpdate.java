package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardUpdate() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();		
		boardDAO.updateBoard(new BoardDTO(Integer.parseInt(request.getParameter("boardIndex")),request.getParameter("boardTitle"), request.getParameter("boardContent")));
		
		response.sendRedirect("/");
	}

}
