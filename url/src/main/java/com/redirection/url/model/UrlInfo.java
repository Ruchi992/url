package com.redirection.url.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlInfo {

	@Id
	private int id;
	
	private String short_url;
	
	private String full_url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShort_url() {
		return short_url;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}

	public String getFull_url() {
		return full_url;
	}

	public void setFull_url(String full_url) {
		this.full_url = full_url;
	}
	
	
}
