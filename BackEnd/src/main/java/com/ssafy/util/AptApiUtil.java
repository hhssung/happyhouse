package com.ssafy.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ssafy.vue.model.HouseInfoDto;

public class AptApiUtil {

	public static List<HouseInfoDto> getHouseInfoDto(String baseUrl, String serviceKey, int pageNo, int numOfRows,
			String LAWD_CD, String DEAL_YMD) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(baseUrl);
		urlBuilder.append("?");
		urlBuilder.append("ServiceKey=" + serviceKey); // 인증키
		urlBuilder.append("&" + "pageNo=" + pageNo); // 페이지 번호
		urlBuilder.append("&" + "numOfRows=" + numOfRows); // 한 페이지 결과 수
		urlBuilder.append("&" + "LAWD_CD=" + LAWD_CD); // 지역코드
		urlBuilder.append("&" + "DEAL_YMD=" + DEAL_YMD); // 계약월
		URL url = new URL(urlBuilder.toString());

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		// System.out.println(urlBuilder.toString());
		// System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			return null;
		}

		StringBuilder xmlStr = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			xmlStr.append(line);
		}
		rd.close();
		conn.disconnect();
		// System.out.println(xmlStr.toString());

		// https://howtodoinjava.com/java/xml/parse-string-to-xml-dom/ 참고
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(new StringReader(xmlStr.toString())));

		// https://sallykim5087.tistory.com/187 참고
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName(Constants.ITEM);
		List<HouseInfoDto> result = new ArrayList<HouseInfoDto>();

		String totalCountStr = doc.getElementsByTagName(Constants.TOTAL_COUNT).item(0).getTextContent();
		int totalCount = Integer.parseInt(totalCountStr);
		System.out.println(totalCount);
		int totalPages = totalCount % numOfRows == 0 ? totalCount / numOfRows : totalCount / numOfRows + 1;

		for (int idx = 0; idx < nList.getLength(); idx++) {
			Node nNode = nList.item(idx);
			HouseInfoDto dto = new HouseInfoDto();
			Element eElement = (Element) nNode;
			
			dto.setAptCode(getSingleTagValue(Constants.APT_CODE, eElement));
			dto.setAptName(getSingleTagValue(Constants.APT_NAME, eElement));
			dto.setDongName(getSingleTagValue(Constants.DONG_NAME, eElement));
			dto.setNumOfFloors(Integer.parseInt(getSingleTagValue(Constants.NUM_OF_FLOORS, eElement)));
			dto.setRecentPrice(getSingleTagValue(Constants.RECENT_PRICE, eElement));
			dto.setArea(getSingleTagValue(Constants.AREA, eElement));
			dto.setPage(pageNo);
			dto.setTotalPages(totalPages);
			
			result.add(dto);
		}

		return result;
	}

	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}

	private static String getSingleTagValue(String tag, Element eElement) {
		Node result = eElement.getElementsByTagName(tag).item(0); // tag에 해당하는 item 가져오기.
		if (result == null) {
			return Constants.NO_TEXT_CONTENT;
		} else {
			return result.getTextContent();
		}
	}
}
