package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.QnaDto;
import com.ssafy.vue.model.QnaParameterDto;

public interface QnaService {
	
	// QUESTION
	public List<QnaDto> listArticle(QnaParameterDto qnaParameterDto) throws Exception;
	public List<QnaDto> adminListArticle(QnaParameterDto qnaParameterDto) throws Exception;
	public boolean writeArticle(QnaDto qnaDto) throws Exception;
	public boolean modifyArticle(QnaDto qnaDto) throws Exception;
	public boolean deleteArticle(int q_no) throws Exception;
	public void updateHit(int q_no) throws Exception;
	public QnaDto getArticle(int q_no) throws Exception;
	
	// ANSWER
	public boolean writeAnswer(QnaDto qnaDto) throws Exception;

}
