package com.azp.retrofitsample.model;

import com.google.gson.annotations.SerializedName;

public class Users{

	@SerializedName("name")
	private String name;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

}