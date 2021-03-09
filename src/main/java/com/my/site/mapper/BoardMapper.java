package com.my.site.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.my.site.dto.Board;

@Mapper
public interface BoardMapper {	
	Board getBoardByBoardCode(String boardCode);
}
