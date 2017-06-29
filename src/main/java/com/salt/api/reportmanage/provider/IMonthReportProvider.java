package com.salt.api.reportmanage.provider;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
@Path("/monthreport")
public interface IMonthReportProvider {
	

	@POST
	@Path("/queryPage")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON+";charset=UTF-8"})
	Response queryPage(@FormParam("areaCode") String areaCode,@FormParam("startYearMonth") String startYearMonth,@FormParam("endYearMonth") String endYearMonth,@FormParam("pageNo") String pageNo,@FormParam("pageSize") String pageSize,@FormParam("state") String state);
}