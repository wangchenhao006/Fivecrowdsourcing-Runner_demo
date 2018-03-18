package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Merchant;
import com.entity.Runner;

public class RunnerDao extends BaseDao implements IRunnerDao {

	
	
	// 检查商户密码
		public Runner checkRunner(String phone, String password) {
			String sql = "SELECT * FROM fivecrowdsourcing.runner where phone=? AND password=?;";
			Runner runner = null;
			try (Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, phone);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					runner = new Runner();
					runner.setRunnerid(rs.getLong("runnerId"));
					//runner.setTofgid(rs.getLong("tofgId"));
					runner.setPhone(rs.getString("phone"));
					runner.setName(rs.getString("name"));
					runner.setPassword(rs.getString("password"));
					runner.setIdcardnumber(rs.getString("idCardNumber"));
					//runner.setAddress(rs.getString("address"));
					runner.setPhotoofidcardinhand(rs.getString("photoOfIdCardInhand"));
					runner.setPhotoofidcardoppo(rs.getString("photoOfIdCardOppo"));
					runner.setPhotoofidcardposi(rs.getString("photoOfIdCardPosi"));
					runner.setPhotoofhealcert(rs.getString("photoOfHealCert"));
					runner.setBalance(rs.getDouble("balance"));
					runner.setIntegral(rs.getInt("integral"));
					runner.setMargin(rs.getShort("margin"));
					
					
					//runner.setStorename(rs.getString("storeName"));
				
					//runner.setBuslicensephoto(rs.getString("busLicensePhoto"));
					//runner.setFoodbuslicensephoto(rs
							//.getString("foodBusLicensePhoto"));
					//runner.setIdcardphoto(rs.getString("idCardPhoto"));
					
				}
				return runner;
			} catch (SQLException se) {
				se.printStackTrace();
				return runner;
			}
		}
		
		
		

	@Override
	public List<Runner> findRunners() {
		// TODO Auto-generated method stub
		List<Runner> result = new ArrayList<Runner>();
		String query = "select * from runner";
		ResultSet rs = this.executeQuery(query, null);
		try {
			while (rs.next()) {
				Runner runner = new Runner();
				runner = new Runner();
				runner.setRunnerid(rs.getLong("runnerId"));
				runner.setName(rs.getString("name"));
				runner.setPassword(rs.getString("password"));
				runner.setIdcardnumber(rs.getString("idCardNumber"));
				runner.setPhone(rs.getString("phone"));
				runner.setPhotoofidcardinhand(rs.getString("photoofidcardinhand"));
				runner.setPhotoofidcardposi(rs.getString("photoofidcardposi"));
				runner.setPhotoofidcardoppo(rs.getString("photoofidcardoppo"));
				runner.setPhotoofhealcert(rs.getString("photoofhealcert"));
				runner.setMargin(rs.getShort("margin"));
				result.add(runner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return result;
	}

	@Override
	public Integer insertValidatedRunners(List<Runner> validatedRunners) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String query = "";
				ArrayList<String> params = new ArrayList<>();
				for (Runner runner : validatedRunners) {
					params.add(runner.getPhone());
					params.add(runner.getName());
					params.add(runner.getPassword());
					params.add(runner.getIdcardnumber());
					params.add(runner.getPhotoofidcardinhand());
					params.add(runner.getPhotoofidcardoppo());
					params.add(runner.getPhotoofidcardposi());
					params.add(Short.toString(runner.getMargin()));
					//params.add(runner.getMargin().toString);
					params.add(runner.getPhotoofhealcert());
					query = query
							+ " INSERT INTO validatedrunner(phone,name,idCardNumber,photoOfIdCartInhand,photoOfIdCardOppo,photoOfIdCardPosi,photoOfHealCert,margin) VALUES(?,?,?,?,?,?,?,?,?);";
					// +" delete from runner where runnerId=?;";
				}

				int rs = this.executeUpdate(query, params);
				return rs;
	}

	@Override
	public Integer deleteRunnersfromTemp(List<Runner> validatedRunners) {
		// TODO Auto-generated method stub
		// TODO 从暂时的列表里删除runner信息
		String query = "";
		ArrayList<String> params = new ArrayList<>();
		for (Runner runner : validatedRunners) {
			params.add(runner.getRunnerid().toString());
			query = query + "  delete from runner where runnerId=?;";
		}

		int rs = this.executeUpdate(query, params);
		return rs;
	}
	
	public Runner getRunnerById(Long runnerid) {
		String query = "select * from runner where runnerId = "+runnerid;
		ResultSet rs = this.executeQuery(query, null);
		Runner runner = new Runner();
		try {
			while (rs.next()) {
				runner = new Runner();
				runner.setRunnerid(rs.getLong("runnerId"));
				runner.setName(rs.getString("name"));
				runner.setPassword(rs.getString("password"));
				runner.setIdcardnumber(rs.getString("idCardNumber"));
				runner.setPhone(rs.getString("phone"));
				runner.setPhotoofidcardinhand(rs.getString("photoofidcartinhand"));
				runner.setPhotoofidcardposi(rs.getString("photoofidcardposi"));
				runner.setPhotoofidcardoppo(rs.getString("photoofidcardoppo"));
				runner.setPhotoofhealcert(rs.getString("photoofhealcert"));
				runner.setMargin(rs.getShort("margin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return runner;
	}
	public boolean updateValidatedRunner(Runner runner) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `fivecrowdsourcing`.`validatedrunner` SET `balance`=?, "
				+ "`integral`=? WHERE `runnerId`=?;";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setDouble(1, runner.getBalance());
			pstmt.setInt(2, runner.getIntegral());
			pstmt.setLong(3, runner.getRunnerid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateRunner(Runner runner) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `fivecrowdsourcing`.`runner` SET `phone`=?, "
				+ "`name`=?, `idCardNumber`=?, `photoOfIdCardInhand`=?, "
				+ "`photoOfIdCardOppo`=?, `photoOfIdCardPosi`=?, `photoOfHealCert`=? "
				+ "  WHERE `runnerId`=?;";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, runner.getPhone());
			pstmt.setString(2, runner.getName());
			pstmt.setString(3, runner.getIdcardnumber());
			pstmt.setString(4, runner.getPhotoofidcardinhand());
			pstmt.setString(5, runner.getPhotoofidcardoppo());
			pstmt.setString(6, runner.getPhotoofidcardposi());
			pstmt.setString(7, runner.getPhotoofhealcert());
				
			pstmt.setLong(8, runner.getRunnerid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}


