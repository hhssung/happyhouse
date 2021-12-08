package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "YososuDto : 요소수정보", description = "요소수의 상세 정보를 나타낸다.")
public class YososuDto {
	
	@ApiModelProperty(value = "코드")
	private String code;
	@ApiModelProperty(value = "명칭")
	private String name;
	@ApiModelProperty(value = "주소")
	private String address;
	@ApiModelProperty(value = "전화번호")
	private String phone;
	@ApiModelProperty(value = "영업시간")
	private String openingHours;
	@ApiModelProperty(value = "재고량")
	private String stock;
	@ApiModelProperty(value = "가격")
	private String cost;
	@ApiModelProperty(value = "위도")
	private String lat;
	@ApiModelProperty(value = "경도")
	private String lng;
	@ApiModelProperty(value = "데이터기준일")
	private String date;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String cnt) {
		this.stock = cnt;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
