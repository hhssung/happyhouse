package com.ssafy.vue.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QnaDto : Qna정보", description = "Qna의 상세 정보를 나타낸다.")
public class QnaDto {
	@ApiModelProperty(value = "질문 번호")
	private int q_no;
	@ApiModelProperty(value = "질문자 아이디")
	private String q_userid;
	@ApiModelProperty(value = "질문 제목")
	private String q_title;
	@ApiModelProperty(value = "질문 내용")
	private String q_content;
	@ApiModelProperty(value = "조회수")
	private int hit;
	@ApiModelProperty(value = "질문 작성일")
	private String q_regtime;

	@ApiModelProperty(value = "답변자 아이디")
	private String a_userid;
	@ApiModelProperty(value = "답변 내용")
	private String a_content;
	@ApiModelProperty(value = "답변 작성일")
	private String a_regtime;

	@ApiModelProperty(value = "답변 여부")
	private boolean answer_status;
	@ApiModelProperty(value = "공개 여부")
	private boolean open_status;
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getQ_userid() {
		return q_userid;
	}
	public void setQ_userid(String q_userid) {
		this.q_userid = q_userid;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getQ_regtime() {
		return q_regtime;
	}
	public void setQ_regtime(String q_regtime) {
		this.q_regtime = q_regtime;
	}
	public String getA_userid() {
		return a_userid;
	}
	public void setA_userid(String a_userid) {
		this.a_userid = a_userid;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public String getA_regtime() {
		return a_regtime;
	}
	public void setA_regtime(String a_regtime) {
		this.a_regtime = a_regtime;
	}
	public boolean isAnswer_status() {
		return answer_status;
	}
	public void setAnswer_status(boolean answer_status) {
		this.answer_status = answer_status;
	}
	public boolean isOpen_status() {
		return open_status;
	}
	public void setOpen_status(boolean open_status) {
		this.open_status = open_status;
	}
	@Override
	public String toString() {
		return "QnaDto [q_no=" + q_no + ", q_userid=" + q_userid + ", q_title=" + q_title + ", q_content=" + q_content
				+ ", hit=" + hit + ", q_regtime=" + q_regtime + ", a_userid=" + a_userid + ", a_content=" + a_content
				+ ", a_regtime=" + a_regtime + ", answer_status=" + answer_status + ", open_status=" + open_status
				+ "]";
	}
}
