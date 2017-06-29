package com.salt.api.reportmanage.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class RestVo implements Serializable{

	
	private static final long serialVersionUID = 1L;

	/*
	 * 状态，0成功，1失败
	 */
	private String state;
	
	/*
	 *	状态信息，成功，失败
	 */
	private String stateInfo;
	
	/*
	 * 失败时的异常信息
	 */
	private String exceptionMsg;
	
	
	/*
	 * 成功时的数据
	 */
	private Object data;

	

	
	public RestVo() {
		super();
		this.state = "1";
		this.data = null;
		this.stateInfo = "成功";
		this.exceptionMsg="";
	}



	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}


	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
		try{
			this.data = JSON.toJSON(data);
		}catch(Exception e){
			
		}

	}
	
	public static RestVo getInstance(){
		return new RestVo();
	}
	
	public void setSuccess(String state,String stateInfo,Object data){
		this.state = state;
		this.stateInfo = stateInfo;
		this.data = data;
	}
	public void setSuccess(String state,Object data){
		this.state = state;
		this.stateInfo = "成功";
		this.data = data;
	}
	public void setSuccess(Object data){
		this.state = "1";
		this.stateInfo = "成功";
		this.data = data;
	}
	
	public void setFail(String state,String stateInfo,String exceptionMsg){
		this.state = state;
		this.stateInfo = stateInfo;
		this.exceptionMsg = exceptionMsg;
	}
	public void setFail(String state,String exceptionMsg){
		this.state = state;
		this.stateInfo = "失败";
		this.exceptionMsg = exceptionMsg;
	}
	public void setFail(String exceptionMsg){
		this.state = "0";
		this.stateInfo = "失败";
		this.exceptionMsg = exceptionMsg;
	}
}
