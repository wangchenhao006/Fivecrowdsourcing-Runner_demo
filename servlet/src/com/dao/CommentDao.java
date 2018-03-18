package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.entity.Evaluation;

public class CommentDao extends BaseDao implements ICommentDao {

	@Override
	public Integer insertAComment(Evaluation evaluation) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `fivecrowdsourcing`.`evaluation`(`delOrderId`,`delTime`,`delQuality`,`delAttitude`,`content`)"
				+ "VALUES(?,?,?,?,?);";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, evaluation.getDelorderid());
			pstmt.setLong(2, evaluation.getDeltime());
			pstmt.setLong(3, evaluation.getDelquality());
			pstmt.setLong(4, evaluation.getDelquality());
			pstmt.setLong(5, evaluation.getDelattitude());
			pstmt.setString(6, evaluation.getContent());
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException se) {
			se.printStackTrace();
			return 0;
		}
	}

}
