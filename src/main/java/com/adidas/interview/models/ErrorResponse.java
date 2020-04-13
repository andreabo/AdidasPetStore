package com.adidas.interview.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
public class ErrorResponse{

	@JsonProperty("code")
	private int code;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	@Override
 	public String toString(){
		return 
			"{" +
			"code = '" + code + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}