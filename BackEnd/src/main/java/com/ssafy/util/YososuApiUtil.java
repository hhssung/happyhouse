package com.ssafy.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ssafy.vue.model.YososuDto;

public class YososuApiUtil {

	public static List<YososuDto> getYososuDto(String baseUrl, String serviceKey) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(baseUrl);
		urlBuilder.append("?");
		urlBuilder.append("serviceKey=" + serviceKey); // 인증키
		urlBuilder.append("&" + "page=" + "1"); // 페이지 번호
		urlBuilder.append("&" + "perPage=" + "1000"); // 한 페이지 결과 수
		urlBuilder.append("&" + "returnType=" + "XML"); // xml로 리턴
		URL url = new URL(urlBuilder.toString());

		System.out.println(urlBuilder.toString());

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

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

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(new StringReader(xmlStr.toString())));

		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName(Constants.Y_ITEM);
		List<YososuDto> result = new ArrayList<YososuDto>();

		for (int idx = 0; idx < nList.getLength(); idx++) {
			NodeList itemList = nList.item(idx).getChildNodes();
			YososuDto dto = new YososuDto();

			// <col name="경도"> 에서 name 안의 attribute 값 가져오기. 이후 dto에 집어넣기.
			for (int j = 0; j < itemList.getLength(); j++) {
				String attribute = itemList.item(j).getAttributes().getNamedItem("name").getNodeValue();
				String value = itemList.item(j).getTextContent();
				putValue(attribute, value, dto);
			}
			result.add(dto);
		}

		return result;
	}

	private static void putValue(String attribute, String value, YososuDto dto) {
		if (attribute.equals(Constants.Y_CODE)) {
			dto.setCode(value);
			return;
		}
		if (attribute.equals(Constants.Y_NAME)) {
			dto.setName(value);
			return;
		}
		if (attribute.equals(Constants.Y_ADDRESS)) {
			dto.setAddress(value);
			return;
		}
		if (attribute.equals(Constants.Y_PHONE)) {
			dto.setPhone(value);
			return;
		}
		if (attribute.equals(Constants.Y_OPENING_HOURS)) {
			dto.setOpeningHours(value);
			return;
		}
		if (attribute.equals(Constants.Y_STOCK)) {
			dto.setStock(value);
			return;
		}
		if (attribute.equals(Constants.Y_COST)) {
			dto.setCost(value);
			return;
		}
		if (attribute.equals(Constants.Y_LAT)) {
			dto.setLat(value);
			return;
		}
		if (attribute.equals(Constants.Y_LNG)) {
			dto.setLng(value);
			return;
		}
		if (attribute.equals(Constants.Y_DATE)) {
			dto.setDate(value);
			return;
		}
	}
}
