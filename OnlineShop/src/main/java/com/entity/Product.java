package com.entity;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.codec.binary.Base64;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="product_name")
	private String productname;
	
	private BigDecimal price;
	
	private String seller;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private byte[] image;

	@Transient
	private String imgUtility;

	public Product() {
		
	}
	
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		BigDecimal afterrounding =rounding(price);
		this.price = afterrounding;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	private BigDecimal rounding(BigDecimal price) {
	
		return price.setScale(3, RoundingMode.HALF_UP);
	}
	
	//method for encoding
	public String getImgUtility() throws UnsupportedEncodingException {

	    byte[] encodeBase64 = Base64.encodeBase64(getImage());
	     String base64Encoded = new String(encodeBase64, "UTF-8");              
	    return base64Encoded;
	}

}
