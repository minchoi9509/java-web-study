package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public int insertBoard(BoardDTO boardDTO) {
		int result = 0;

		Connection con = null;
		PreparedStatement ptst = null;
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO BOARD VALUES (SEQ_BOARD_IDX.nextval, ?, SYSDATE, ?, ?)";
			ptst = con.prepareStatement(sql);
			ptst.setString(1, boardDTO.getBoardTitle());
			ptst.setString(2, "min");
			ptst.setString(3, boardDTO.getBoardContent());

			result = ptst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptst != null)
					ptst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}

	public ArrayList<BoardDTO> getBoardList() {

		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		Connection con = null;
		PreparedStatement ptst = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM BOARD";
			ptst = con.prepareStatement(sql);
			resultSet = ptst.executeQuery();

			while (resultSet.next()) {
				int boardIndex = resultSet.getRow();
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
				if (ptst != null)
					ptst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}
}
