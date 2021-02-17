package com.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.codec.binary.Base64;


@Entity
@Table(name="iteams")
public class Iteam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String itemname;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "picture")
	private byte[] iteampicture;
	
	@Column(name = "price", precision=10, scale=2)
	private BigDecimal price;
	
	@Column(name = "seller")
	private String seller;
	
	@OneToMany(cascade =CascadeType.ALL)
	@JoinColumn(name="itm_frid", referencedColumnName="id")
	private List<UsersMessages> messages = new ArrayList<>();
	
	@Column(name = "iteam_message")
	private String iteamMessageDetails;
	
	@Column(name="sellername")
	private String sellername;
	
	@Transient
	private String imgUtility;
	
	public Iteam() {
		
	}
	public Iteam(String sellername ,String itemname, byte[] iteampicture, BigDecimal price, String seller, String iteamMessageDetails) {
		super();
		this.itemname = itemname;
		this.iteampicture = iteampicture;
		this.price = price;
		this.seller = seller;
		this.iteamMessageDetails = iteamMessageDetails;
		this.sellername = sellername;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public byte[] getIteampicture() {
		return iteampicture;
	}
	public void setIteampicture(byte[] iteampicture) {
		this.iteampicture = iteampicture;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		BigDecimal afterrounding = rounding(price);
		this.price = afterrounding;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}

	public List<UsersMessages> getMessages() {
		return messages;
	}

	public void setMessages(List<UsersMessages> messages) {
		this.messages = messages;
	}

	public String getIteamMessageDetails() {
		return iteamMessageDetails;
	}
	public void setIteamMessageDetails(String iteamMessageDetails) {
		this.iteamMessageDetails = iteamMessageDetails;
	}
	
	private BigDecimal rounding(BigDecimal price) {
		
		return price.setScale(3, RoundingMode.HALF_UP);
	}
	
	//method for encoding
		public String getImgUtility() throws UnsupportedEncodingException {

		    byte[] encodeBase64 = Base64.encodeBase64(getIteampicture());
		     String base64Encoded = new String(encodeBase64, "UTF-8");              
		    return base64Encoded;
		}
	
	
	
}
