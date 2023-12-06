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
import Entity.CongNhan;
import Entity.NhanVien;

 

public class ChamCongCongNhanDAO {
	
	
//	public List<ChamCongCongNhan> getDSChamCongCongDoan(String maCongDoan){
//		List<ChamCongCongNhan> dscn=new ArrayList<ChamCongCongNhan>();
//		ConnectDB.getInstance();
//		Connection con =ConnectDB.getConnection();
//		try {
//			String sql="	SELECT \r\n"
//					+ "    CC.[maChamCongCongNhan],\r\n"
//					+ "    CC.[maCongNhan],\r\n"
//					+ "    CN.[tenCongNhan],\r\n"
//					+ "    CC.[ngaycham],\r\n"
//					+ "    CC.[soluong],\r\n"
//					+ "    CC.[sogiotangca]\r\n"
//					+ "FROM \r\n"
//					+ "    [QuanLyLuong_Nhom2].[dbo].[ChamCongCongNhan] CC\r\n"
//					+ "JOIN \r\n"
//					+ "    [QuanLyLuong_Nhom2].[dbo].[BangPhanCong] BC ON CC.[maCongNhan] = BC.[maCongNhan]\r\n"
//					+ "JOIN \r\n"
//					+ "    [QuanLyLuong_Nhom2].[dbo].[CongNhan] CN ON CC.[maCongNhan] = CN.[maCongNhan]\r\n"
//					+ "WHERE \r\n"
//					+ "    CC.[maCongDoan] = ?;";
//			PreparedStatement statement= con.prepareStatement(sql);
//			
//			statement.setString(1, maCongDoan);
//			ResultSet rs =statement.executeQuery( );
//			while(rs.next()) {
//			 
//				java.sql.Date sqlngaycham = rs.getDate(4);
//	            // Chuyển đổi thành LocalDate
//	            LocalDate ngaycham = sqlngaycham.toLocalDate();
//	            
//				dscn.add(new ChamCongCongNhan(rs.getString(1),new CongNhan(rs.getString(2) ,rs.getString(3)),ngaycham,rs.getInt(5),rs.getInt(6)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dscn;
//	}
//	
//	public List<ChamCongCongNhan> getDSChamCongCongDoan(String maCongDoan){
//		List<ChamCongCongNhan> dscn=new ArrayList<ChamCongCongNhan>();
//		ConnectDB.getInstance();
//		Connection con =ConnectDB.getConnection();
//		try {
//			String sql="  	SELECT  \r\n"
//					+ "					    CC.[maChamCongCongNhan], \r\n"
//					+ "					   CC.[maCongNhan], \r\n"
//					+ "					   CN.[tenCongNhan], \r\n"
//					+ "					    CC.[ngaycham], \r\n"
//					+ "				     CC.[soluong], \r\n"
//					+ "					     CC.[sogiotangca] ,\r\n"
//					+ "					 CC.maCongDoan, \r\n"
//					+ " BC.soluongphancong"
//					+ "					 FROM  \r\n"
//					+ "					     [QuanLyLuong_Nhom2].[dbo].[ChamCongCongNhan] CC \r\n"
//					+ "					 JOIN  \r\n"
//					+ "					    [QuanLyLuong_Nhom2].[dbo].[BangPhanCong] BC ON CC.[maCongNhan] = BC.[maCongNhan] \r\n"
//					+ "					 JOIN  \r\n"
//					+ "					    [QuanLyLuong_Nhom2].[dbo].[CongNhan] CN ON CC.[maCongNhan] = CN.[maCongNhan] \r\n"
//					+ "					 WHERE  \r\n"
//					+ "					     CC.[maCongDoan] = ?";
//			PreparedStatement statement= con.prepareStatement(sql);
//			
//			statement.setString(1, maCongDoan);
//			ResultSet rs =statement.executeQuery( );
//			while(rs.next()) {
//			 
//				java.sql.Date sqlngaycham = rs.getDate(4);
//	            // Chuyển đổi thành LocalDate
//	            LocalDate ngaycham = sqlngaycham.toLocalDate();
//	            
//				dscn.add(new ChamCongCongNhan(rs.getString(1),new CongNhan(rs.getString(2) ,rs.getString(3)),ngaycham,rs.getInt(5),rs.getInt(6),new CongDoan(rs.getString(7)),rs.getInt(8)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dscn;
//	}
	
//	public List<ChamCongCongNhan> getDSChamCongCongDoan(String maCongDoan){
//		List<ChamCongCongNhan> dscn=new ArrayList<ChamCongCongNhan>();
//		ConnectDB.getInstance();
//		Connection con =ConnectDB.getConnection();
//		try {
//			String sql="SELECT \r\n"
//					+ "    CC.[maChamCongCongNhan],\r\n"
//					+ "    CC.[maCongNhan],\r\n"
//					+ "    CN.[tenCongNhan],\r\n"
//					+ "    CC.[ngaycham],\r\n"
//					+ "    CC.[soluong],\r\n"
//					+ "    CC.[sogiotangca],\r\n"
//					+ "    CC.[maCongDoan],\r\n"
//					+ "    BC.soluongphancong\r\n"
//					+ "FROM \r\n"
//					+ "    [QuanLyLuong_Nhom2].[dbo].[ChamCongCongNhan] CC\r\n"
//					+ "JOIN \r\n"
//					+ "    [QuanLyLuong_Nhom2].[dbo].[BangPhanCong] BC ON CC.[maCongNhan] = BC.[maCongNhan]  \r\n"
//					+ "JOIN \r\n"
//					+ "    [QuanLyLuong_Nhom2].[dbo].[CongNhan] CN ON CC.[maCongNhan] = CN.[maCongNhan]\r\n"
//					+ "WHERE \r\n"
//					+ "    CC.[maCongDoan] = ?\r\n"
//					+ "    AND CONVERT(date, CC.[ngaycham]) = CONVERT(date, GETDATE());";
//			PreparedStatement statement= con.prepareStatement(sql);
//			
//			statement.setString(1, maCongDoan);
//			ResultSet rs =statement.executeQuery( );
//			while(rs.next()) {
//			 
//				java.sql.Date sqlngaycham = rs.getDate(4);
//	            // Chuyển đổi thành LocalDate
//	            LocalDate ngaycham = sqlngaycham.toLocalDate();
//	            
//				dscn.add(new ChamCongCongNhan(rs.getString(1),new CongNhan(rs.getString(2) ,rs.getString(3)),ngaycham,rs.getInt(5),rs.getInt(6),new CongDoan(rs.getString(7)),rs.getInt(8)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dscn;
//	}
//	
	public List<ChamCongCongNhan> getDSChamCongCongDoan(String maCongDoan,String macongdoanphancong){
		List<ChamCongCongNhan> dscn=new ArrayList<ChamCongCongNhan>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT \r\n"
					+ "    CC.[maChamCongCongNhan],\r\n"
					+ "    CC.[maCongNhan],\r\n"
					+ "    CN.[tenCongNhan],\r\n"
					+ "    CC.[ngaycham],\r\n"
					+ "    CC.[soluong],\r\n"
					+ "    CC.[sogiotangca],\r\n"
					+ "    CC.[maCongDoan],\r\n"
					+ "    BC.soluongphancong\r\n"
					+ "FROM \r\n"
					+ "    [QuanLyLuong_Nhom2].[dbo].[ChamCongCongNhan] CC\r\n"
					+ "JOIN \r\n"
					+ "    [QuanLyLuong_Nhom2].[dbo].[BangPhanCong] BC ON CC.[maCongNhan] = BC.[maCongNhan]  \r\n"
					+ "JOIN \r\n"
					+ "    [QuanLyLuong_Nhom2].[dbo].[CongNhan] CN ON CC.[maCongNhan] = CN.[maCongNhan]\r\n"
					+ "WHERE \r\n"
					+ "    CC.[maCongDoan] = ?\r\n"
					+ "    AND CONVERT(date, CC.[ngaycham]) = CONVERT(date, GETDATE()) and maCongDoanDonHang=?";
			PreparedStatement statement= con.prepareStatement(sql);
			
			statement.setString(1, maCongDoan);
			statement.setString(2, macongdoanphancong);
			ResultSet rs =statement.executeQuery( );
			while(rs.next()) {
			 
				java.sql.Date sqlngaycham = rs.getDate(4);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaycham = sqlngaycham.toLocalDate();
	            
				dscn.add(new ChamCongCongNhan(rs.getString(1),new CongNhan(rs.getString(2) ,rs.getString(3)),ngaycham,rs.getInt(5),rs.getInt(6),new CongDoan(rs.getString(7)),rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscn;
	}
	
	public List<ChamCongCongNhan> getDSChamCongCongDoantheoNgay( String maCongDoan,LocalDate ngaycham1,String macongdoanphancong){
		List<ChamCongCongNhan> dscn=new ArrayList<ChamCongCongNhan>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT  \r\n"
					+ "		    CC.[maChamCongCongNhan], \r\n"
					+ "		     CC.[maCongNhan], \r\n"
					+ "		  CN.[tenCongNhan], \r\n"
					+ "	    CC.[ngaycham], \r\n"
					+ "		    CC.[soluong], \r\n"
					+ "		    CC.[sogiotangca], \r\n"
					+ "		     CC.[maCongDoan], \r\n"
					+ "		    BC.soluongphancong \r\n"
					+ "		 FROM  \r\n"
					+ "		     [QuanLyLuong_Nhom2].[dbo].[ChamCongCongNhan] CC \r\n"
					+ "		 JOIN  \r\n"
					+ "		    [QuanLyLuong_Nhom2].[dbo].[BangPhanCong] BC ON CC.[maCongNhan] = BC.[maCongNhan]   \r\n"
					+ "		 JOIN  \r\n"
					+ "		   [QuanLyLuong_Nhom2].[dbo].[CongNhan] CN ON CC.[maCongNhan] = CN.[maCongNhan] \r\n"
					+ "	 WHERE  \r\n"
					+ "		    CC.[maCongDoan] = ?   AND CONVERT(date, CC.[ngaycham]) = CONVERT(date, ?)  and maCongDoanDonHang=?";
			PreparedStatement statement= con.prepareStatement(sql);
			
			statement.setString(1, maCongDoan);
			statement.setDate(2, Date.valueOf(ngaycham1));
			statement.setString(3, macongdoanphancong);
			ResultSet rs =statement.executeQuery( );
			while(rs.next()) {
			 
				java.sql.Date sqlngaycham = rs.getDate(4);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaycham = sqlngaycham.toLocalDate();
	            
				dscn.add(new ChamCongCongNhan(rs.getString(1),new CongNhan(rs.getString(2) ,rs.getString(3)),ngaycham,rs.getInt(5),rs.getInt(6),new CongDoan(rs.getString(7)),rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscn;
	}
	
	public static boolean themChamCongCongNhan(ChamCongCongNhan cccn) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into ChamCongCongNhan (maCongNhan,macongdoan,ngaycham, soluong,sogiotangca ) values (?,?,?,?,? )");
		
			stmt.setString(1, cccn.getMaCongNhan().getMaCongNhan());
//			stmt.setBoolean(2, cn.getGioitinh());
			stmt.setString(2, cccn.getMaCongDoan().getMaCongDoan());
			stmt.setDate(3, Date.valueOf(cccn.getNgaycham()));
	 
			 
			 
			stmt.setInt(4,  cccn.getSoLuong());
			stmt.setInt(5,  cccn.getSogiotangca());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}  
		return n>0;
	}

	public boolean updateChamCong( int sogiotangca,int soluong,LocalDate ngaycham, String machamcong) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement("  update ChamCongCongNhan set  sogiotangca=? ,soluong=soluong+?,ngaycham=? where maChamCongCongNhan=?  ");
			stmt.setInt (1,sogiotangca);
			stmt.setInt(2,soluong);
			stmt.setDate(3, Date.valueOf(ngaycham));
			 
			stmt.setString(4,machamcong);
			n= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return n>0;
		
	}
	
	
	
	public List<ChamCongCongNhan> getchamcongtheomaCn(String maCn,int thang ,int nam){
		List<ChamCongCongNhan> dsChamCongCN=new ArrayList<ChamCongCongNhan>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="    SELECT cc.maChamCongCongNhan, cc.maCongNhan, cn.tenCongNhan, cc.ngaycham, cc.soluong, cc.sogiotangca,cc.macongdoan ,soluong*cd.giaCongDoan as giacongdoan\r\n"
					+ "  FROM [QuanLyLuong_Nhom2].[dbo].[ChamCongCongNhan] cc \r\n"
					+ "	  JOIN [QuanLyLuong_Nhom2].[dbo].[CongNhan] cn ON cc.maCongNhan = cn.maCongNhan \r\n"
					+ "	  join CongDoan cd on cc.macongdoan=cd.maCongDoan\r\n"
					+ "	  WHERE cc.maCongNhan = ? AND MONTH(cc.ngaycham) = ? AND YEAR(cc.ngaycham) = ?";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1,maCn);
			statement.setInt(2,thang);
			statement.setInt(3,nam);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				java.sql.Date sqlngaycham = rs.getDate(4);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaycham = sqlngaycham.toLocalDate();
				
	            dsChamCongCN.add(new ChamCongCongNhan( rs.getString(1),new CongNhan(rs.getString(2) ,rs.getString(3)),ngaycham,rs.getInt(5),rs.getInt(6),new CongDoan(rs.getString(7)),rs.getDouble(8) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChamCongCN;
	}
}
 