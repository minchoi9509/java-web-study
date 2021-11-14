package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;

public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardView() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		
		request.setAttribute("boardList", boardDAO.getBoardList());
	
		request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
