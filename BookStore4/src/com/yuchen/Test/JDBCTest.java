package com.yuchen.Test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.yuchen.Utils.JDBCUtils;

public class JDBCTest {

	@Test
	public void test() {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
	}

}
