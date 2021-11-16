package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;

public class BoardViewDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardViewDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		
		request.setAttribute("boardDetail", boardDAO.getBoardDetail(Integer.parseInt(request.getParameter("index"))));

		request.getRequestDispatcher("/WEB-INF/view/board/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
