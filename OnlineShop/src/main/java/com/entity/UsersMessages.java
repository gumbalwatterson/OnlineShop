package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usersmessages")
public class UsersMessages  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "message")
	private String message;
	
	@Column(name = "message_fromuser")
	private String messageFromUser;
	
	@Column(name = "hasbeenread")
	private int hasbennread; // if message was already read set it as 1 else 0
	
	public UsersMessages() {
		
	}
	
	
	public UsersMessages(String message, String messageFromUser , int hasbeenread) {
		super();
		this.message = message;
		this.messageFromUser = messageFromUser;
		this.hasbennread =  hasbeenread;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageFromUser() {
		return messageFromUser;
	}
	public void setMessageFromUser(String messageFromUser) {
		this.messageFromUser = messageFromUser;
	}

	public int getHasbennread() {
		return hasbennread;
	}

	public void setHasbennread(int hasbennread) {
		this.hasbennread = hasbennread;
	}
	
	
}
