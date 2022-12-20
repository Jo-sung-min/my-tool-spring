package com.spring.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data //기본생성자, getter, setter , toString 등 여러가지 자동으로 생성
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor //매개변수 없는 기본생성자
@AllArgsConstructor // 모든변수를 매개변수로 가지고있는 생성자 순서는 변수 선언순서로
//@RequiredArgsConstructor //특정변수만 생성자 매개변수로 가지는 생성자 만들고 싶을때 @NonNull 과 세트
						//이때 각 변수가 @NonNull 이나 final 일 경우 매개변수로 포함
public class SampleTv {
	//@NonNull
	private boolean power;
	//@NonNull
	private int ch;
	private  String col;
	
	private Date reg;
	
/*	
	public SampleTv() {	}
	public SampleTv(boolean power, int ch , String col , Date reg) {
		this.power = power; this.ch = ch; 
		this.col = col; this.reg = reg;
	} 
	
	
	public Date getReg() {
		return reg;
	}
	public void setReg(Date reg) {
		this.reg = reg;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}
	
	*/
	
}
