package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.QnaDto;
import com.ssafy.vue.model.QnaParameterDto;

@Mapper
public interface QnaMapper {

	// QUESTION
	public int writeArticle(QnaDto qnaDto) throws SQLException;
	public List<QnaDto> listArticle(QnaParameterDto qnaParameterDto) throws SQLException;
	public List<QnaDto> adminListArticle(QnaParameterDto qnaParameterDto) throws SQLException;
	public int modifyArticle(QnaDto qnaDto) throws SQLException;
	public int deleteArticle(int q_no) throws SQLException;
	public void updateHit(int q_no) throws SQLException;
	public QnaDto getArticle(int q_no) throws SQLException;
	
	// ANSWER
	public int writeAnswer(QnaDto qnaDto) throws SQLException;

}
