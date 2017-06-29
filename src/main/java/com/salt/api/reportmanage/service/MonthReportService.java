/**
 * Project Name:report-manage
 * File Name:MonthReportService.java
 * Package Name:com.salt.api.reportmanage
 * Date:2017年6月21日下午6:13:28
 *
*/

package com.salt.api.reportmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salt.api.reportmanage.dao.MonthReportMapper;
import com.salt.api.reportmanage.domain.MonthReport;
import com.salt.api.reportmanage.util.StringUtil;

/**
 * ClassName:MonthReportService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月21日 下午6:13:28 <br/>
 * @author   Jfei
 * @version
 * @see 	 
 */
@Service
public class MonthReportService {

	
	@Autowired
	private MonthReportMapper monthReportMapper;
	
	
	public MonthReport findById(Integer id){
		return this.monthReportMapper.selectByPrimaryKey(id);
	}
	
	public Integer save(MonthReport r){
		if(r.getId() == null	){
			this.monthReportMapper.insertUseGeneratedKeys(r);
		}else{
			this.monthReportMapper.updateByPrimaryKey(r);
		}
		return r.getId();
	}
	
	public MonthReport find(String areaCode, String yearMonth){
		Example e = new Example(MonthReport.class);
		e.createCriteria().andEqualTo("areaCode", areaCode)
								.andEqualTo("yearmonth", yearMonth);
		List<MonthReport> list = this.monthReportMapper.selectByExample(e);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
	
	public void delete(List<Integer> ids){
		Example e = new Example(MonthReport.class);
		e.createCriteria().andIn("id", ids);
		this.monthReportMapper.deleteByExample(e);
	}
	
   public  PageInfo<MonthReport>	queryPage(String areaCode, Integer startYearMonth, Integer endYearMonth,
			int pageNo, int pageSize,Integer state){
		
	   Example e = new Example(MonthReport.class);
	   Criteria c = e.createCriteria();
	   c = StringUtil.isNotBlank(areaCode) ? c.andEqualTo("areaCode", areaCode): c;
	   c = startYearMonth != null ? c.andGreaterThanOrEqualTo("yearmonth", startYearMonth) : c;
	   c = endYearMonth != null ? c.andLessThanOrEqualTo("yearmonth", endYearMonth) : c;
	   c = state != null ? c.andEqualTo("state",state) : c;
	   e.orderBy("yearmonth").desc();
	   
	   Page<MonthReport> page = PageHelper.startPage(pageNo, pageSize);
	   this.monthReportMapper.selectByExample(e);
	   
	   return page.toPageInfo();
	}
			
}

