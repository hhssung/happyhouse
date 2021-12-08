package com.ssafy.vue.model.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.util.AptApiUtil;
import com.ssafy.util.Constants;
import com.ssafy.util.YososuApiUtil;
import com.ssafy.vue.model.HouseInfoDto;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.YososuDto;
import com.ssafy.vue.model.mapper.HouseMapMapper;

@Service
public class HouseMapServiceImpl implements HouseMapService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getAptInDong(dong);
	}

	@Override
	public List<HouseInfoDto> getAptByGugunCode(String gugunCode, int pageNo, int numOfRows, String date) throws Exception {
		return AptApiUtil.getHouseInfoDto(Constants.APT_DEAL_URL, Constants.API_KEY, pageNo, numOfRows, gugunCode, date);
	}

	@Override
	public List<YososuDto> getYososuInfo() throws Exception {
		return YososuApiUtil.getYososuDto(Constants.YOSOSU_URL, Constants.API_KEY);
	}

}
