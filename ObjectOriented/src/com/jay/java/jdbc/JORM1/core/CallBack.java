package com.jay.java.jdbc.JORM1.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface CallBack {
	public Object doExecute(Connection conn, PreparedStatement ps,ResultSet rs);
}
