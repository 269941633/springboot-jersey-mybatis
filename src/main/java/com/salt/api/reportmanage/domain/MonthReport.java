/**
 * Project Name:report-manage
 * File Name:MonthReport.java
 * Package Name:com.salt.api.reportmanage.domain
 * Date:2017年6月21日下午6:09:46
 *
*/

package com.salt.api.reportmanage.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * ClassName:MonthReport <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月21日 下午6:09:46 <br/>
 * @author   Jfei
 * @version
 * @see 	 
 */
@Table(name="month_report")
public class MonthReport {

	@Id
	private Integer id;
	
	private String areaCode;//区域编码
	
	private String areaName;//区域名称
	
	private Integer yearmonth;
	
	private String fillUserId;
	
	private String fillUserName;
	
	private Date createTime;
	
	private String formContent;

	
	private int state;//状态，0保存，1提交，提交后就不允许再修改了

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	public String getFillUserId() {
		return fillUserId;
	}

	public void setFillUserId(String fillUserId) {
		this.fillUserId = fillUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getFormContent() {
		return formContent;
	}

	public void setFormContent(String formContent) {
		this.formContent = formContent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getFillUserName() {
		return fillUserName;
	}

	public void setFillUserName(String fillUserName) {
		this.fillUserName = fillUserName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Integer getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(Integer yearmonth) {
		this.yearmonth = yearmonth;
	}
	
	
}

