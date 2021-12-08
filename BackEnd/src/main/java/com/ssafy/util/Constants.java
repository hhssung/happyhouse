package com.ssafy.util;

public final class Constants {

	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	public static final String NO_TEXT_CONTENT = "-"; // xml Text가 없을 경우 출력

	// data.go.kr API KEY
	public static final String API_KEY = "jQWbqhezmbhig%2BdFGrnAcWPNcPL0zhwDP1%2B4QP0jrLfLZHBpoDhNEimp3vE6Go%2FSnoNB4aatnHSe3RoOLG5Eqw%3D%3D";
	
	// APT API
	public static final String APT_DEAL_URL = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";

	// API elements명 - dto 매치
	public static final String APT_CODE = "일련번호"; // 아파트 일련번호
	public static final String APT_NAME = "아파트"; // 아파트 이름
	public static final String DONG_NAME = "법정동"; // 법정동
	public static final String NUM_OF_FLOORS = "층"; // 층수
	public static final String RECENT_PRICE = "거래금액"; // 거래된 금액
	public static final String ITEM = "item"; // item
	public static final String TOTAL_COUNT = "totalCount"; // 페이지 명시를 위한 전체 house 개수
	public static final String AREA = "전용면적"; // 전용면적

	// YOSOSU API
	public static final String YOSOSU_URL = "https://api.odcloud.kr/api/15094782/v1/uddi:6b2017af-659d-437e-a549-c59788817675";

	// YOSOSU elements명 - dto 매치
	public static final String Y_ITEM = "item"; // item
	
	public static final String Y_CODE = "코드"; 
	public static final String Y_NAME = "명칭"; 
	public static final String Y_ADDRESS = "주소"; 
	public static final String Y_PHONE = "전화번호"; 
	public static final String Y_OPENING_HOURS = "영업시간"; 
	public static final String Y_STOCK = "재고량"; 
	public static final String Y_COST = "가격"; 
	public static final String Y_LAT = "위도"; 
	public static final String Y_LNG = "경도"; 
	public static final String Y_DATE = "데이터기준일";
	
	
}
