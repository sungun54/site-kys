package com.my.site.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	private int id;
	private String regDate;
	private String updateDate;
	private String delDate;
	private int displayStatus;
	private int delStatus;
	private String title;
	private String body;
	private int boardId;
	private int hit;
}
