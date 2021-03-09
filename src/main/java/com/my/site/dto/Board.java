package com.my.site.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Board {
	private int id;
	private String regDate;
	private String updateDate;
	private String delDate;
	private int delStatus;
	private String name;
	private String code;
}
