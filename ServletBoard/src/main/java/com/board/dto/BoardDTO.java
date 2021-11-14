package com.board.dto;

import java.util.Date;

public class BoardDTO {
	private int boardIndex;
	private String boardTitle;
	private Date boardDate;
	private String boardWriter;
	private String boardContent;

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

	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

}
