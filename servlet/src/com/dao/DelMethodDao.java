package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DelMethodDao extends BaseDao{
	public double getBasePrice(Long delmethodid){
		String sql = "select price from fivecrowdsourcing.deliverymethod where delMethodId = "+delmethodid;
		double result = 0;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				result = rs.getDouble("price");
			}
			return result;
		} catch (SQLException se) {
			se.printStackTrace();
			return -1;
		}
	}
}
