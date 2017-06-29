/**
 * Project Name:report-manage
 * File Name:IMysqlBaseMapper.java
 * Package Name:com.salt.api.reportmanage.db
 * Date:2017年6月21日下午6:06:15
 *
*/

package com.salt.api.reportmanage.db;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * ClassName:IMysqlBaseMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月21日 下午6:06:15 <br/>
 * @author   Jfei
 * @version
 * @see 	 
 */
public interface IMysqlBaseMapper<T> extends Mapper<T>,MySqlMapper<T>{

}
