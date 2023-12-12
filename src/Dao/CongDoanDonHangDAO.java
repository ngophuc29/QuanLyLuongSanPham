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
import Entity.ChamCongCongNhan;
import Entity.ChamCongNhanVien;
import Entity.CongDoan;
import Entity.CongDoanDonhang;
import Entity.CongNhan;
import Entity.NhanVien;
import Entity.SanPham;

 

public class CongDoanDonHangDAO {
	
	public static boolean themCongDoanDonHang(String maDonHang) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    int n = 0;
	    try {
	        stmt = con.prepareStatement("INSERT INTO CongDoanDonHang ([MaDonHang], [MaCongDoan], [soLuongDatHang], [TienDo], [TrangThai])\r\n"
	                + "SELECT [MaDonHang], maCongDoan, [DonHang].[soLuongDatHang], 0 as TienDo, 1 as Trangthaicongdoan\r\n"
	                + "FROM CongDoan\r\n"
	                + "INNER JOIN SanPham ON CongDoan.maSP = SanPham.maSP\r\n"
	                + "INNER JOIN [DonHang] ON [DonHang].[MaSanPham] = SanPham.maSP\r\n"
	                + "WHERE MaDonHang = ?;");
	        
	        stmt.setString(1, maDonHang);
	        n = stmt.executeUpdate(); // Thực hiện lệnh SQL INSERT
	    } catch (SQLException e) {
	        // TODO: handle exception
	        e.printStackTrace();
	    }  
	    return n > 0;
	}

	public List<CongDoanDonhang> getAllcongdoanDonHangtheosanpham(String masp){
		List<CongDoanDonhang> dscdtm=new ArrayList<CongDoanDonhang>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT  [MaCongDoanDonHang]\r\n"
					+ "       \r\n"
					+ "      ,CongDoan.[MaCongDoan],tenCongDoan,giaCongDoan\r\n"
					+ "      ,CongDoanDonHang.[soLuongDatHang]\r\n"
					+ "      ,CongDoanDonHang.[TienDo]\r\n"
					+ "      ,CongDoanDonHang.[TrangThai]\r\n"
					+ "  FROM [QuanLyLuong_Nhom2].[dbo].[CongDoanDonHang]\r\n"
					+ "  join CongDoan on CongDoan.maCongDoan=CongDoanDonHang.MaCongDoan\r\n"
					+ "  join SanPham on CongDoan.maSP=SanPham.maSP\r\n"
					+ "join DonHang on DonHang.maDonHang=CongDoanDonHang.MaDonHang\r\n"
					+ "where SanPham.maSP=?  and CongDoanDonHang.[TrangThai]=1";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1, masp);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 
				
	        	dscdtm.add(new CongDoanDonhang(rs.getString(1), new CongDoan(rs.getString(2), rs.getString(3), rs.getDouble(4)), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dscdtm;
	}
	
	
	
	
	public List<CongDoanDonhang> getAllcongdoanDonHangtheosanphamCo2MaSptrungnhau(String masp ,String madonhang){
		List<CongDoanDonhang> dscdtm=new ArrayList<CongDoanDonhang>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="  SELECT  [MaCongDoanDonHang] \r\n"
					+ "					   \r\n"
					+ "				     ,CongDoan.[MaCongDoan],tenCongDoan,giaCongDoan \r\n"
					+ "					     ,CongDoanDonHang.[soLuongDatHang] \r\n"
					+ "					     ,CongDoanDonHang.[TienDo] \r\n"
					+ "					     ,CongDoanDonHang.[TrangThai] \r\n"
					+ "					   FROM [QuanLyLuong_Nhom2].[dbo].[CongDoanDonHang] \r\n"
					+ "					 join CongDoan on CongDoan.maCongDoan=CongDoanDonHang.MaCongDoan \r\n"
					+ "					   join SanPham on CongDoan.maSP=SanPham.maSP \r\n"
					+ "					 join DonHang on DonHang.maDonHang=CongDoanDonHang.MaDonHang \r\n"
					+ "					 where SanPham.maSP=?  and CongDoanDonHang.[TrangThai]=1 and CongDoanDonHang.MaDonHang=?";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1, masp);
			statement.setString(2, madonhang);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 
				
	        	dscdtm.add(new CongDoanDonhang(rs.getString(1), new CongDoan(rs.getString(2), rs.getString(3), rs.getDouble(4)), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dscdtm;
	}
	//update tiến độ
	
			public static boolean updateTiendo( int tiendo,String maCongDoan,String macongdoandonhang ) {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement stmt = null;
				int n=0;
				
				try {
					stmt=con.prepareStatement(" update CongDoanDonHang set TienDo =TienDo+? where MaCongDoanDonHang=? and MaCongDoan=?");
					 
					stmt.setInt(1,tiendo);
					stmt.setString(2,macongdoandonhang);
					stmt.setString(3,maCongDoan);
					n=stmt.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return n>0;
				 
			}
			
			//update trang thai cong doan don hang
			
			public static boolean updatetrangthaiCongDoanDonHang(  String maCongDoan,String macongdoandonhang ) {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				PreparedStatement stmt = null;
				int n=0;
				
				try {
					stmt=con.prepareStatement(" UPDATE CongDoanDonHang SET TrangThai = 2 WHERE MaCongDoanDonHang = ? AND TienDo = soLuongDatHang AND MaCongDoan = ?");
					 
			 
					stmt.setString(1,macongdoandonhang);
					stmt.setString(2,maCongDoan);
					n=stmt.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return n>0;
				 
			}
			//lay tien do cua cong doan don hang truoc 
			public int tiendocuacongdoandonhangtruoc (String MaCongDoanDonHang) {
				ConnectDB.getInstance();
				Connection con =ConnectDB.getConnection();
				PreparedStatement preparedStatement = null;
		        ResultSet resultSet = null;
		        int p=0;
		        try {
		           
		            String sql = "  select tiendo from [CongDoanDonHang] where [MaCongDoanDonHang]=? ";
		            preparedStatement = con.prepareStatement(sql);
		            preparedStatement.setString(1, MaCongDoanDonHang); // set parameter value
		            
		      
		            resultSet = preparedStatement.executeQuery();
		             
		            if (resultSet.next()) {
		                p = resultSet.getInt(1);
		               System.out.println("tien do truoc : " + p);
		           }
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
				return p;
			}
			
			//lay tien do cua cong doan don hang truoc 
			public int tiendocuacongdoandonhangHientai (String MaCongDoanDonHang) {
				ConnectDB.getInstance();
				Connection con =ConnectDB.getConnection();
				PreparedStatement preparedStatement = null;
		        ResultSet resultSet = null;
		        int p=0;
		        try {
		           
		            String sql = "  select tiendo from [CongDoanDonHang] where [MaCongDoanDonHang]=? ";
		            preparedStatement = con.prepareStatement(sql);
		            preparedStatement.setString(1, MaCongDoanDonHang); // set parameter value
		            
		      
		            resultSet = preparedStatement.executeQuery();
		             
		            if (resultSet.next()) {
		                p = resultSet.getInt(1);
		               System.out.println("tien do hien tai : " + p);
		           }
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
				return p;
			}
			
}
 