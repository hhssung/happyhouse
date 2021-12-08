package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.util.Constants;
import com.ssafy.vue.model.QnaDto;
import com.ssafy.vue.model.QnaParameterDto;
import com.ssafy.vue.model.service.QnaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//http://localhost:9999/vue/swagger-ui.html
//@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RestController
@RequestMapping("/qna")
@Api("QNA 컨트롤러  API V1")
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	private QnaService qnaService;

	// ------------ 질문 --------------
	
	@ApiOperation(value = "QNA 질문 작성", notes = "새로운 QNA를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/question")
	public ResponseEntity<String> writeArticle(@RequestBody @ApiParam(value = "QNA 정보.", required = true) QnaDto qnaDto) throws Exception {
		logger.info("writeArticle - 호출");
		if (qnaService.writeArticle(qnaDto)) {
			return new ResponseEntity<String>(Constants.SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constants.FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "QNA 글목록", notes = "모든 QnA의 정보를 반환한다.", response = List.class)
	@GetMapping("/adminquestion")
	public ResponseEntity<List<QnaDto>> listArticle(
			@ApiParam(value = "게시글을 얻기위한 부가정보.", required = true) QnaParameterDto qnaParameterDto) throws Exception {
		logger.info("adminlistArticle - 호출");
		return new ResponseEntity<List<QnaDto>>(qnaService.listArticle(qnaParameterDto), HttpStatus.OK);
	}
	@ApiOperation(value = "QNA 미답변글목록", notes = "미답변 QnA의 정보를 반환한다.", response = List.class)
	@GetMapping("/question")
	public ResponseEntity<List<QnaDto>> adminListArticle(@ApiParam(value = "답변게시글을 얻기위한 부가정보.", required = true) QnaParameterDto qnaParameterDto) throws Exception {
		logger.info("listArticle - 호출");
		return new ResponseEntity<List<QnaDto>>(qnaService.adminListArticle(qnaParameterDto), HttpStatus.OK);
	}
	
	@ApiOperation(value = "QnA 수정", notes = "새로운 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/question")
	public ResponseEntity<String> modifyArticle(@RequestBody @ApiParam(value = "수정할 글정보.", required = true) QnaDto qnaDto) throws Exception {
		logger.info("modifyArticle - 호출");
		
		if (qnaService.modifyArticle(qnaDto)) {
			return new ResponseEntity<String>(Constants.SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constants.FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "QnA 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/question/{q_no}")
	public ResponseEntity<String> deleteArticle(@PathVariable("q_no") @ApiParam(value = "삭제할 글의 글번호.", required = true) int q_no) throws Exception {
		logger.info("deleteArticle - 호출");
		if (qnaService.deleteArticle(q_no)) {
			return new ResponseEntity<String>(Constants.SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constants.FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "QnA 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = QnaDto.class)
	@GetMapping("/question/{q_no}")
	public ResponseEntity<QnaDto> getArticle(@PathVariable("q_no") @ApiParam(value = "얻어올 글의 글번호.", required = true) int q_no) throws Exception {
		logger.info("getArticle - 호출 : " + q_no);
		qnaService.updateHit(q_no);
		return new ResponseEntity<QnaDto>(qnaService.getArticle(q_no), HttpStatus.OK);
	}
	
	// ------------ 답변 --------------
	
	@ApiOperation(value = "QNA 답변 작성", notes = "새로운 Answer를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/answer/{q_no}")
	public ResponseEntity<String> writeAnswer(@RequestBody @ApiParam(value = "Answer 정보.", required = true) QnaDto qnaDto) throws Exception {
		logger.info("writeAnswer - 호출");
		if (qnaService.writeAnswer(qnaDto)) {
			return new ResponseEntity<String>(Constants.SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constants.FAIL, HttpStatus.NO_CONTENT);
	}
	
	
	
}
