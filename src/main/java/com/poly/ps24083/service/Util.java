package com.poly.ps24083.service;


public class Util {
	public String getAttr(String text1,String text2,int add) {
		return add==1?text1:text2;
	}
	public boolean checkisEmpty(String s) {
		return s.isEmpty()?false:true;
	}
	public String checkEmail(String email,String empty,String notify) {
		if(!checkisEmpty(email)) {
			return empty;
		}else if(!email.matches(patternEmail())) {
			return notify;
		}
		return "";
	}
	
	
	public String checkPassword(String pass,String empty,String notify) {
		if(!checkisEmpty(pass)) {
			return empty;
		}else if(!pass.matches(patternPass())) {
			return notify;
		}
		return "";
	}
	
	public String checkID(String id,String empty,String notify) {
		if(!checkisEmpty(id)) {
			return empty;
		}else if(!id.matches(patternID())) {
			return notify;
		}
		return "";
	}
	public String checkFulName(String fullName,String empty,String notify) {
		if(!checkisEmpty(fullName)) {
			return empty;
		}else if(!fullName.matches(patternFullName())) {
			return notify;
		}
		return "";
	}
	public String patternEmail() {
		return  "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
	}
	public String patternPass() {
		return "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";
	}
	public String patternID() {
		return "^(?=.*[a-z])(?=.*\\d).{5,}$";
	}
	public String patternFullName() {
		return "^(?:(?:[A-Za-z]+\\s){1,10})?[A-Za-z]+$"; 
	}
	
}
