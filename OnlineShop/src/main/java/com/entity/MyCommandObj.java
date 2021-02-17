package com.entity;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class MyCommandObj {

	String iteamdetail;
	String price;
	MultipartFile document;
	String iteam;
	
	public MyCommandObj() {
		
	}
	
	public String getIteamdetail() {
		return iteamdetail;
	}
	public void setIteamdetail(String iteamdetail) {
		this.iteamdetail = iteamdetail;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public MultipartFile getDocument() {
		return document;
	}

	public void setDocument(MultipartFile document) {
		this.document = document;
	}

	public String getIteam() {
		return iteam;
	}
	public void setIteam(String iteam) {
		this.iteam = iteam;
	}
	
	
	
	
}
