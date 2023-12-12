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
import Entity.ChamCongNhanVien;
import Entity.DonHang;
import Entity.NhanVien;
import Entity.SanPham;

 

public class sanPhamDAO {
	
	
	public List<SanPham> getAllsanPham(){
		List<SanPham> dssp=new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from SanPham";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
 
	            dssp.add(new  SanPham(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getInt(6) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dssp;
	}
	public List<SanPham> getAllsanPhamDangsanxuat(){
		List<SanPham> dssp=new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from SanPham where trangthai=1";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
 
	            dssp.add(new  SanPham(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getInt(6) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dssp;
	}
	
	public static boolean themDanhSachSP(SanPham sp) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into SanPham ( tenSP,giaSP,kieudang,chatLieu ,trangthai) values (?,?,?,? ,? )");
//			stmt.setString(1, nv.getMaNV());
			stmt.setString(1, sp.getTenSp());
			 
			stmt.setDouble(2, sp.getGiaSP());
			stmt.setString(3, sp.getKieuDang());
			stmt.setString(4, sp.getChatLieu());
			stmt.setInt(5, sp.getTrangThai());
			 

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}  
		return n>0;
	}
 
	
	public List<SanPham> getAllsanPhamDangDathang(){
		List<SanPham> dssp=new ArrayList<SanPham>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
//			String sql="\r\n"
//					+ "SELECT * \r\n"
//					+ "FROM SanPham \r\n"
//					+ "WHERE trangthai = 1 \r\n"
//					+ "  AND maSP IN (SELECT MaSanPham FROM [QuanLyLuong_Nhom2].[dbo].[DonHang] where trangthaiDonHang=1);";
			
			String sql=" select MaDonHang,MaSanPham,TenSanPham\r\n"
					+ "  from DonHang  \r\n"
					+ "  where trangthaiDonHang=1";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
 
//	            dssp.add(new  SanPham(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getInt(6) ));
				  dssp.add(new  SanPham(rs.getString(1),rs.getString(2) ,new DonHang(rs.getString(3) ) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dssp;
	}
	

 
}
 