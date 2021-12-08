package com.ssafy.vue.controller;

import java.util.List;
import java.util.Map;
import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.service.MemberService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/admin")
@Api("게시판 컨트롤러 API V1")
public class adminController {
	
	@Autowired
	private MemberService memberService;

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@GetMapping("/home")
	public String homeTest() throws Exception {
		logger.info("test - 호출");
		return "test";
	}

	@ApiOperation(value = "회원관리", notes = "모든 회원에 대한 조회.", response = Map.class)
	@GetMapping("/allUser")
	public ResponseEntity<List<MemberDto>> showUsers() throws Exception {
		return new ResponseEntity<List<MemberDto>>(memberService.allUsers(), HttpStatus.OK);
	}

	@ApiOperation(value = "유저삭제", notes = "유저 삭제함.", response = String.class)
	@DeleteMapping("/deleteUser/{articleno}")
	public boolean deleteUser(@PathVariable("articleno") @ApiParam(value = "삭제할 유저아이디 작성", required = true) String userid) throws Exception {
		if (memberService.deleteUser(userid)) {
			return true;
		}
		return false;
	}


}
