package com.yn.common;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Result extends JSONObject{
	
	private static final Logger log = LoggerFactory.getLogger(Result.class);
	
	public Result(){
		try {
			this.put("status", "");
			this.put("msg", "");
			this.put("data", "");
		} catch (JSONException e) {
			log.error("Result constructor error:{}",e.getMessage());
		}
	}
	
	public Result(String status, String msg, Object data){
		try {
			this.put("status", status);
			this.put("msg", msg);
			this.put("data", data);
		} catch (JSONException e) {
			log.error("Result constructor error:{}",e.getMessage());
		}
	}
	
	public void addData(Object data) {
		if(data == null) return;
		try {
			this.put("data", data);
		} catch (JSONException e) {
			log.error("Result.addData error:{}",e.getMessage());
		}
	}
	
	public void addStatus(String status){
		if(StringUtils.isBlank(status)){
			log.info("Result.addStatus status is blank");
		}
		try {
			this.put("status", status);
		} catch (JSONException e) {
			log.error("Result.addStatus error:{}",e.getMessage());
		}
	}
	
	public void addMsg(String msg){
		try {
			this.put("msg", msg);
		} catch (JSONException e) {
			log.error("Result.addMsg error:{}",e.getMessage());
		}
	}

}
