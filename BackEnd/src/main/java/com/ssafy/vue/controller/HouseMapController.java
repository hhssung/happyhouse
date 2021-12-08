package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.HouseInfoDto;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.YososuDto;
import com.ssafy.vue.model.service.HouseMapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/map")
@Api("Map 컨트롤러  API V1")
public class HouseMapController {

	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseMapService houseMapService;

	@ApiOperation(value = "시도 정보", notes = "전국의 시도를 반환한다.", response = List.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		logger.info("sido - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseMapService.getSido(), HttpStatus.OK);
	}

	@ApiOperation(value = "구군 정보", notes = "전국의 구군을 반환한다.", response = List.class)
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(
			@RequestParam("sido") @ApiParam(value = "시도코드.", required = true) String sido) throws Exception {
		logger.info("gugun - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseMapService.getGugunInSido(sido), HttpStatus.OK);
	}

//	@GetMapping("/dong")
//	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
//		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
//	}

//	@GetMapping("/apt")
//	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception {
//		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInDong(dong), HttpStatus.OK);
//	}

	@ApiOperation(value = "아파트 정보", notes = "구군코드에 따른 아파트 정보 반환", response = List.class)
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> getAptByGuguncode(
			@RequestParam("gugunCode") @ApiParam(value = "구군코드.", required = true) String gugunCode,
			@RequestParam("pageNo") @ApiParam(value = "페이지 num.", required = true) int pageNo,
			@RequestParam("numOfRows") @ApiParam(value = "한 페이지에 몇 개의 정보인지.", required = true) int numOfRows,
			@RequestParam("date") @ApiParam(value = "YYYYMM 형식의 데이터", required = true) String date) throws Exception {
		logger.info("apt - 호출");
		return new ResponseEntity<List<HouseInfoDto>>(
				houseMapService.getAptByGugunCode(gugunCode, pageNo, numOfRows, date), HttpStatus.OK);
	}

	@ApiOperation(value = "아파트 정보", notes = "구군코드에 따른 아파트 정보 반환", response = List.class)
	@GetMapping("/yososu")
	public ResponseEntity<List<YososuDto>> getYososuInfo() throws Exception {
		logger.info("yososu - 호출");
		return new ResponseEntity<List<YososuDto>>(houseMapService.getYososuInfo(), HttpStatus.OK);
	}
}
