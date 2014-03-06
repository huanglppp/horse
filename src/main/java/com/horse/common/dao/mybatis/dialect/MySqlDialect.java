package com.horse.common.dao.mybatis.dialect;

public class MySqlDialect implements Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		StringBuilder pageSql = new StringBuilder(sql.length()+30);
		pageSql.append(sql);
		pageSql.append(" LIMIT ").append(offset).append(",").append(limit);
		return pageSql.toString();
	}

}
