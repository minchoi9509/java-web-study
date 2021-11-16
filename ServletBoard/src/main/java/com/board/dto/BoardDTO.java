package com.board.dto;

import java.util.Date;

public class BoardDTO {
	private int boardIndex;
	private String boardTitle;
	private Date boardDate;
	private String boardWriter = "min";
	private String boardContent;

	public BoardDTO(String boardTitle, String boardContent) {
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public BoardDTO(int boardIndex, String boardTitle, Date boardDate, String boardWriter, String boardContent) {
		this.boardIndex = boardIndex;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
	}

	public int getBoardIndex() {
		return boardIndex;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public String getBoardContent() {
		return boardContent;
	}

}
