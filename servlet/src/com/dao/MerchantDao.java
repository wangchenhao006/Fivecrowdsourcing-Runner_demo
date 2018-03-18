package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.dao.*;
import com.entity.Merchant;
import com.entity.Runner;
import com.entity.Typeofgoods;
import com.mysql.jdbc.Statement;

public class MerchantDao extends BaseDao implements IMerchantDao {

	// 检查商户密码
	public Merchant checkMerchant(String phone, String password) {
		String sql = "SELECT * FROM fivecrowdsourcing.merchant where phone=? AND password=?;";
		Merchant merchant = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, phone);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				merchant = new Merchant();
				merchant.setMerchantid(rs.getLong("merchantId"));
				merchant.setTofgid(rs.getLong("tofgId"));
				merchant.setName(rs.getString("name"));
				merchant.setIdcardnumber(rs.getString("idCardNumber"));
				merchant.setAddress(rs.getString("address"));
				merchant.setPhone(rs.getString("phone"));
				merchant.setStorename(rs.getString("storeName"));
				merchant.setPassword(rs.getString("password"));
				merchant.setBuslicensephoto(rs.getString("busLicensePhoto"));
				merchant.setFoodbuslicensephoto(rs
						.getString("foodBusLicensePhoto"));
				merchant.setIdcardphoto(rs.getString("idCardPhoto"));
				merchant.setMargin(rs.getLong("margin"));
			}
			return merchant;
		} catch (SQLException se) {
			se.printStackTrace();
			return merchant;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.IMerchantDao#addMerchant(com.entity.Merchant)
	 */
	public boolean updateMerchant(Merchant merchant) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `fivecrowdsourcing`.`merchant` SET `tofgId`=?, "
				+ "`name`=?, `idCardNumber`=?, `idCardPhoto`=?, "
				+ "`storeName`=?, `phone`=?, `address`=?, "
				+ "`busLicensePhoto`=?, `foodBusLicensePhoto`=?, `longitude`=?, "
				+ "`latitude`=? WHERE `merchantId`=?;";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, merchant.getTofgid());
			pstmt.setString(2, merchant.getName());
			pstmt.setString(3, merchant.getIdcardnumber());
			pstmt.setString(4, merchant.getIdcardphoto());
			pstmt.setString(5, merchant.getStorename());
			pstmt.setString(6, merchant.getPhone());
			pstmt.setString(7, merchant.getAddress());
			pstmt.setString(8, merchant.getBuslicensephoto());
			pstmt.setString(9, merchant.getFoodbuslicensephoto());
			pstmt.setDouble(11, merchant.getLatitude());
			pstmt.setDouble(10, merchant.getLongitude());
			pstmt.setLong(12, merchant.getMerchantid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// 用于支付后更新商户的余额值
	public boolean updateMerchantBalance(Merchant merchant) {
		// TODO Auto-generated method stub
		String sql = "UPDATE `fivecrowdsourcing`.`validatedmerchant` SET `balance`=?, "
				+ "WHERE `merchantId`=?;";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setDouble(1, merchant.getBalance());
			pstmt.setLong(2, merchant.getMerchantid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.IMerchantDao#findMerchants()
	 */
	@Override
	public List<Merchant> findMerchants() {
		// TODO Auto-generated method stub
		List<Merchant> result = new ArrayList<Merchant>();
		String query = "select * from merchant";
		ResultSet rs = this.executeQuery(query, null);
		try {
			while (rs.next()) {
				Merchant merchant = new Merchant();
				merchant = new Merchant();
				merchant.setMerchantid(rs.getLong("merchantId"));
				merchant.setTofgid(rs.getLong("tofgId"));
				merchant.setName(rs.getString("name"));
				merchant.setIdcardnumber(rs.getString("idCardNumber"));
				merchant.setAddress(rs.getString("address"));
				merchant.setPhone(rs.getString("phone"));
				merchant.setStorename(rs.getString("storeName"));
				merchant.setPassword(rs.getString("password"));
				merchant.setBuslicensephoto(rs.getString("busLicensePhoto"));
				merchant.setFoodbuslicensephoto(rs
						.getString("foodBusLicensePhoto"));
				merchant.setIdcardphoto(rs.getString("idCardPhoto"));
				merchant.setMargin(rs.getLong("margin"));
				result.add(merchant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.IMerchantDao#findMerchants(java.lang.String)
	 */
	@Override
	public Merchant findMerchantById(String merchantId) {
		Merchant merchant = new Merchant();
		String query = "select * from merchant where merchantId=?";
		ArrayList<String> params = new ArrayList<>();
		params.add(merchantId);
		ResultSet rs = this.executeQuery(query, params);
		try {
			while (rs.next()) {
				merchant = new Merchant();
				merchant.setMerchantid(rs.getLong("merchantId"));
				merchant.setTofgid(rs.getLong("tofgId"));
				merchant.setName(rs.getString("name"));
				merchant.setIdcardnumber(rs.getString("idCardNumber"));
				merchant.setAddress(rs.getString("address"));
				merchant.setPhone(rs.getString("phone"));
				merchant.setStorename(rs.getString("storeName"));
				merchant.setPassword(rs.getString("password"));
				merchant.setBuslicensephoto(rs.getString("busLicensePhoto"));
				merchant.setFoodbuslicensephoto(rs
						.getString("foodBusLicensePhoto"));
				merchant.setIdcardphoto(rs.getString("idCardPhoto"));
				merchant.setMargin(rs.getLong("margin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return merchant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.IMerchantDao#findMerchantsByDept(java.lang.String)
	 */
	@Override
	public Merchant findValidatedMerchantById(Long merchantId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM fivecrowdsourcing.validatedmerchant where merchantId=?;";
		Merchant merchant = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, merchantId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				merchant = new Merchant();
				merchant.setMerchantid(rs.getLong("merchantId"));
				merchant.setTofgid(rs.getLong("tofgId"));
				merchant.setName(rs.getString("name"));
				merchant.setIdcardnumber(rs.getString("idCardNumber"));
				merchant.setAddress(rs.getString("address"));
				merchant.setPhone(rs.getString("phone"));
				merchant.setStorename(rs.getString("storeName"));
				merchant.setPassword(rs.getString("password"));
				merchant.setBuslicensephoto(rs.getString("busLicensePhoto"));
				merchant.setFoodbuslicensephoto(rs.getString("foodBusLicensePhoto"));
				merchant.setIdcardphoto(rs.getString("idCardPhoto"));
				merchant.setMargin(rs.getLong("margin"));
				merchant.setBalance(rs.getDouble("balance"));
			}
			return merchant;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.IMerchantDao#findMerchantsByRole(java.lang.String)
	 */
	@Override
	public List<Merchant> findMerchantsByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.IMerchantDao#delMerchantById(int)
	 */
	@Override
	public int delMerchantById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.IMerchantDao#updateMerchantById(int, com.entity.Merchant)
	 */
	@Override
	public int updateMerchantById(int id, Merchant role) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.IMerchantDao#checkMerchant(java.lang.String)
	 */
	@Override
	public boolean checkMerchant(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Typeofgoods findTypeOfGoodsNameById(Long tofgId) {
		// TODO Auto-generated method stub
		Typeofgoods typeofgoods = new Typeofgoods();
		String query = "select * from typeofgoods where tofgId=?";
		ArrayList<String> params = new ArrayList<>();
		params.add(tofgId.toString());
		ResultSet rs = this.executeQuery(query, params);
		try {
			while (rs.next()) {
				String name = rs.getString("name");
				Long delMethodId = (long) rs.getInt("delMethodId");
				typeofgoods.setTofgid(tofgId);
				typeofgoods.setName(name);
				typeofgoods.setDelmethodid(delMethodId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return typeofgoods;
	}

	@Override
	public Integer insertValidatedMerchants(List<Merchant> validatedMerchants) {
		// TODO Auto-generated method stub
		String query = "";
		ArrayList<String> params = new ArrayList<>();
		for (Merchant merchant : validatedMerchants) {
			params.add(merchant.getTofgid().toString());
			params.add(merchant.getName());
			params.add(merchant.getIdcardnumber());
			params.add(merchant.getIdcardphoto());
			params.add(merchant.getPassword());
			params.add(merchant.getStorename());
			params.add(merchant.getPhone());
			params.add(merchant.getAddress());
			params.add(merchant.getBuslicensephoto());
			params.add(merchant.getFoodbuslicensephoto());
			params.add(merchant.getMargin().toString());
			params.add(null);
			params.add(null);
			query = query
					+ " INSERT INTO validatedmerchant(tofgId,name,idCardNumber,idCardPhoto,password,storeName,"
					+ " phone,address,busLicensePhoto,foodBusLicensePhoto,margin,longitude,latitude) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		}

		int rs = this.executeUpdate(query, params);
		return rs;
	}

	@Override
	public Integer deleteMerchantsfromTemp(List<Merchant> validatedMerchants) {
		// TODO Auto-generated method stub
		String query = "";
		ArrayList<String> params = new ArrayList<>();
		for (Merchant merchant : validatedMerchants) {
			params.add(merchant.getMerchantid().toString());
			query = query + "  delete from merchant where merchantId=?;";
		}

		int rs = this.executeUpdate(query, params);
		return rs;
	}

}
