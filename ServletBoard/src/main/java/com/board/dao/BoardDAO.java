package com.board.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.board.dto.BoardDTO;

public class BoardDAO {
	
	DataSource dataSource;

	public BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BoardDTO> getBoardList() {

		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM BOARD";
			resultSet = stmt.executeQuery(sql);
			
			while (resultSet.next()) {
				int boardIndex = resultSet.getInt("board_index");
				String boardTitle = resultSet.getString("board_title");
				Date boardDate = resultSet.getDate("board_date");
				String boardWriter = resultSet.getString("board_writer");
				String boardContent = resultSet.getString("board_content");

				BoardDTO boardDTO = new BoardDTO(boardIndex, boardTitle, boardDate, boardWriter, boardContent);
				list.add(boardDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}
}
