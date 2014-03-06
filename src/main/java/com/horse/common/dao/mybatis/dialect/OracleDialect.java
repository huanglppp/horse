package com.horse.common.dao.mybatis.dialect;

public class OracleDialect implements Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		StringBuilder pageSql = new StringBuilder(sql.length()+100);
		pageSql.append("select t2.* from (select t1.*,rownum rnum from (");
		pageSql.append(sql);
		pageSql.append(") t1 )t2 where t2.rnum > ").append(offset);
		pageSql.append(" and t2.rnum <= ").append(offset+limit);
		return pageSql.toString();
	}

}
