package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.model.QnaDto;
import com.ssafy.vue.model.QnaParameterDto;
import com.ssafy.vue.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean writeArticle(QnaDto qnaDto) throws Exception {
		if(qnaDto.getQ_title() == null || qnaDto.getQ_content() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(QnaMapper.class).writeArticle(qnaDto) == 1;
	}
	
	@Override
	public List<QnaDto> listArticle(QnaParameterDto qnaParameterDto) throws Exception {
		int start = qnaParameterDto.getPg() == 0 ? 0 : (qnaParameterDto.getPg() - 1) * qnaParameterDto.getSpp();
		qnaParameterDto.setStart(start);
		return sqlSession.getMapper(QnaMapper.class).listArticle(qnaParameterDto);
	}

	@Override
	public List<QnaDto> adminListArticle(QnaParameterDto qnaParameterDto) throws Exception {
		int start = qnaParameterDto.getPg() == 0 ? 0 : (qnaParameterDto.getPg() - 1) * qnaParameterDto.getSpp();
		qnaParameterDto.setStart(start);
		return sqlSession.getMapper(QnaMapper.class).adminListArticle(qnaParameterDto);
	}
	@Override
	@Transactional
	public boolean modifyArticle(QnaDto qnaDto) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).modifyArticle(qnaDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int q_no) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).deleteArticle(q_no) == 1;
	}

	@Override
	public void updateHit(int q_no) throws Exception {
		sqlSession.getMapper(QnaMapper.class).updateHit(q_no);
	}

	@Override
	public QnaDto getArticle(int q_no) throws Exception {
		return sqlSession.getMapper(QnaMapper.class).getArticle(q_no);
	}

	@Override
	public boolean writeAnswer(QnaDto qnaDto) throws Exception {
		if( qnaDto.getA_content() == null ) {
			throw new Exception();
		}
		return sqlSession.getMapper(QnaMapper.class).writeAnswer(qnaDto) == 1;
	}

}
