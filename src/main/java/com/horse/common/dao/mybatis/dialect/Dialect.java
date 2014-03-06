package com.horse.common.dao.mybatis.dialect;

public interface Dialect {
	public static enum Type {
		MYSQL, ORACLE
	}

	public abstract String getLimitString(String sql, int offset, int limit);

}
