/**
 * Project Name:report-manage
 * File Name:MonthReportProvider.java
 * Package Name:com.salt.api.reportmanage
 * Date:2017年6月21日下午3:11:38
 *
*/

package com.salt.api.reportmanage.provider;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.salt.api.reportmanage.domain.MonthReport;
import com.salt.api.reportmanage.service.MonthReportService;
import com.salt.api.reportmanage.util.StringUtil;
import com.salt.api.reportmanage.vo.RestVo;

/**
 * @author   Jfei
 * @version
 * @see 	 
 */
@Service
public class MonthReportProvider implements IMonthReportProvider{

	private static Logger logger = LoggerFactory.getLogger(MonthReportProvider.class.getName());
	
	@Autowired
	private MonthReportService monthReportService;
	
	
	public Response queryPage(String areaCode, String startYearMonth, String endYearMonth,
			String pageNo, String pageSize,String state) {
		RestVo vo = new RestVo();
		try {
			PageInfo<MonthReport> page = this.monthReportService.queryPage(areaCode, 
					StringUtil.isNotBlank(startYearMonth) ? Integer.valueOf(startYearMonth) : null,
					StringUtil.isNotBlank(endYearMonth) ? Integer.valueOf(endYearMonth) : null, 
					Integer.valueOf(pageNo), Integer.valueOf(pageSize),
					StringUtil.isNotBlank(state) ? Integer.valueOf(state) : null);
			
			JSONObject r = new JSONObject();
			r.put("pages", page.getPages());
			r.put("count", page.getTotal());
			r.put("dataList", page.getList());
			vo.setSuccess(r);
			
		} catch (Exception e) {
			logger.error("分页查询，系统出错...",e);
			vo.setFail(e.getMessage());
		}
		
		
		return Response.ok(vo).build();
	}

	

}

