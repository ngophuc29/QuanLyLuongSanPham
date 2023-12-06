package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Database.ConnectDB;
import Entity.ChamCongNhanVien;
import Entity.CongNhan;
import Entity.NhanVien;
 

public class ChamCongNhanVienDAO {
	private ArrayList<ChamCongNhanVien> dsChamCongNV;

	public ChamCongNhanVienDAO() {
		dsChamCongNV = new ArrayList<ChamCongNhanVien>();
	}

	public List<ChamCongNhanVien> getDanhSachChamCongNhanVien() {
		
		
		
		List<ChamCongNhanVien> dsChamCongNV=new ArrayList<ChamCongNhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT * from [ChamCongNhanVien]";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(3);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
	            
	     
	            
	            
	            dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaybatdaulamViec,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChamCongNV;
	}
	
	public List<ChamCongNhanVien> getchamcongtheongay(LocalDate ngaycham){
		List<ChamCongNhanVien> dsChamCongNV=new ArrayList<ChamCongNhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT * from [ChamCongNhanVien] where ngaycham=? ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setDate(1, Date.valueOf(ngaycham));
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(3);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaychamm = sqlDate.toLocalDate();
				
				 dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaychamm,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChamCongNV;
	}
	public List<ChamCongNhanVien> getchamcongdahiendien(LocalDate ngaycham){
		List<ChamCongNhanVien> dsChamCongNV=new ArrayList<ChamCongNhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT * from [ChamCongNhanVien] where ngaycham=? and hiendien=2 ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setDate(1, Date.valueOf(ngaycham));
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(3);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaychamm = sqlDate.toLocalDate();
				
				 dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaychamm,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChamCongNV;
	}

	
	public boolean updateChamCong(int hiendien,String calam,String ghichu,int sogiotangca,String machamcong,LocalDate ngaycham) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement("  update ChamCongNhanVien set hiendien=?,calam=?,ghichu=?,sogiotangca=? where maChamCongNhanVien=? and ngaycham=?");
			stmt.setInt (1,hiendien);
			stmt.setString(2,calam);
			stmt.setString(3,ghichu);
			stmt.setInt(4,sogiotangca);
			stmt.setString(5,machamcong);
			stmt.setDate(6, Date.valueOf(ngaycham));
			n= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return n>0;
		
	}
	public boolean updateChamCong1(int hiendien,String manv,LocalDate ngaycham) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement("  update ChamCongNhanVien set hiendien=? where maNV=? and ngaycham=?");
			stmt.setInt (1,hiendien);
			stmt.setString(2,manv);
			stmt.setDate(3, Date.valueOf(ngaycham));
			n= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return n>0;
		
	}
	public List<ChamCongNhanVien> getchamcongtheomaNV(String maNV,int thang ,int nam){
		List<ChamCongNhanVien> dsChamCongNV=new ArrayList<ChamCongNhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT * from [ChamCongNhanVien] where maNV=? and month(ngaycham)=? and year(ngaycham)=? ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1,maNV);
			statement.setInt(2,thang);
			statement.setInt(3,nam);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(3);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaychamm = sqlDate.toLocalDate();
				
				 dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaychamm,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChamCongNV;
	}
 
}
