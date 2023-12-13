package Dao;
 

import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.ConnectDB;
import Entity.CongNhan;
import Entity.NhanVien;

 

public class congNhanDAO {
	
	
	public List<CongNhan> getAllcongNhan(){
		List<CongNhan> dscn=new ArrayList<CongNhan>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from CongNhan";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(5);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
	            
	            java.sql.Date sqlDatesinh = rs.getDate(4);
	            // Chuyển đổi thành LocalDate
	            LocalDate sqlDatesinhh = sqlDatesinh.toLocalDate();
	            
	            
				dscn.add(new CongNhan(rs.getString(1),rs.getString(2),rs.getBoolean(3),sqlDatesinhh,ngaybatdaulamViec,rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getDouble(11),rs.getDouble(12) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscn;
	}
	
	
	public static boolean themDanhSachCN(CongNhan cn) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into CongNhan (tenCongNhan,gioitinh,ngaySinh,ngaybatdaulamViec,cmnd,diachi,sodienthoai,bhxh,trangthai,troCap,luongcb ) values (?,?,?,?,?,?,?,?,?,?,? )");
		
			stmt.setString(1, cn.getTencongNhan());
			stmt.setBoolean(2, cn.getGioitinh());
			stmt.setDate(3, Date.valueOf(cn.getNgaysinh()));
			stmt.setDate(4, Date.valueOf(cn.getNgaybatdaulamviec()));
			stmt.setString(5, cn.getCmnd());
			stmt.setString(6, cn.getDiachi());
			stmt.setString(7, cn.getSodienthoai());
			stmt.setInt(8, cn.getBhxh());
			stmt.setInt(9, cn.getTrangthai());
			stmt.setDouble(10, cn.getTroCap());
			stmt.setDouble(11, cn.getLuongcb());
	 
		 

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}  
		return n>0;
	}
public static boolean update(CongNhan cn) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("update CongNhan set tenCongNhan=?,sodienthoai=?,diachi=?  where maCongNhan=? ");
			
			stmt.setString(1, cn.getTencongNhan());
			stmt.setString(2, cn.getSodienthoai());
			stmt.setString(3, cn.getDiachi());
		 
 
			stmt.setString(4, cn.getMaCongNhan());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return n>0;
	}
 

public List<CongNhan> getAllCongNhanTheoma(String ma){
	List<CongNhan> dscn=new ArrayList<CongNhan>();
	ConnectDB.getInstance();
	Connection con =ConnectDB.getConnection();
	try {
		String sql="SELECT * from Congnhan where maCongNhan like ? ";
		PreparedStatement statement= con.prepareStatement(sql);
		 
		statement.setString(1, "%"+ma+"%");
		ResultSet rs =statement.executeQuery();
		while(rs.next()) {
			
			
			java.sql.Date sqlDate = rs.getDate(5);
            // Chuyển đổi thành LocalDate
            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
            
            java.sql.Date sqlDatesinh = rs.getDate(4);
            // Chuyển đổi thành LocalDate
            LocalDate sqlDatesinhh = sqlDatesinh.toLocalDate();
            
			
            dscn.add(new CongNhan(rs.getString(1),rs.getString(2),rs.getBoolean(3),sqlDatesinhh,ngaybatdaulamViec,rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getDouble(11),rs.getDouble(12) ));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return dscn;
}
}
 