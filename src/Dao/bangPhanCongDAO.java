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
import Entity.BangPhanCong;
import Entity.CongDoan;
import Entity.CongNhan;
import Entity.NhanVien;

 

public class bangPhanCongDAO {
	
	
	public List<BangPhanCong> DSPC(String maCongDoan){
		List<BangPhanCong> dscn=new ArrayList<BangPhanCong>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="  -- Công nhân đã phân công\r\n"
					+ "SELECT\r\n"
					+ "    CN.[maCongNhan],\r\n"
					+ "    CN.[tenCongNhan],\r\n"
					+ "    BP.[maCongDoan],\r\n"
					+ "    BP.[ngayPhanCong],\r\n"
					+ "    BP.[trangthaiphancong],\r\n"
					+ "    BP.[soluongphancong]\r\n"
					+ "FROM\r\n"
					+ "    [QuanLyLuong_Nhom2].[dbo].[CongNhan] AS CN\r\n"
					+ "LEFT JOIN\r\n"
					+ "    [QuanLyLuong_Nhom2].[dbo].[BangPhanCong] AS BP ON CN.[maCongNhan] = BP.[maCongNhan]\r\n"
					+ "WHERE\r\n"
					+ "    BP.[maCongDoan] = ? AND BP.[trangthaiphancong] = 1\r\n"
					+ "\r\n"
					+ "UNION\r\n"
					+ "\r\n"
					+ "-- Công nhân chưa phân công\r\n"
					+ "	SELECT \r\n"
					+ "		CN.[maCongNhan], \r\n"
					+ "		CN.[tenCongNhan], \r\n"
					+ "		BP.[maCongDoan], \r\n"
					+ "		BP.[ngayPhanCong], \r\n"
					+ "					 BP.[trangthaiphancong], \r\n"
					+ "					    BP.[soluongphancong]  \r\n"
					+ "					    \r\n"
					+ "					 FROM \r\n"
					+ "					  [QuanLyLuong_Nhom2].[dbo].[CongNhan] AS CN \r\n"
					+ "					 LEFT JOIN \r\n"
					+ "					   [QuanLyLuong_Nhom2].[dbo].[BangPhanCong] AS BP ON CN.[maCongNhan] = BP.[maCongNhan] AND BP.[trangthaiphancong] = 1 \r\n"
					+ "					 WHERE  \r\n"
					+ "					     BP.[maCongNhan] IS NULL"
					+ "";
			PreparedStatement statement= con.prepareStatement(sql);
			
			statement.setString(1, maCongDoan);
			ResultSet rs =statement.executeQuery( );
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(4);
				Date dz= new Date(2023, 11, 11);
	            // Chuyển đổi thành LocalDate
				if(sqlDate==null) {
					sqlDate= dz;
				}
	            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
	            
				dscn.add(new BangPhanCong(new CongNhan(rs.getString(1)),rs.getString(2),new CongDoan(rs.getString(3)), ngaybatdaulamViec,rs.getInt(5),rs.getInt(6) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscn;
	}
	
//	filter chua phan cong  dang sua nha
	public List<BangPhanCong> DSPC(){
		List<BangPhanCong> dscn=new ArrayList<BangPhanCong>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="	SELECT\r\n"
					+ "    CN.[maCongNhan],\r\n"
					+ "    CN.[tenCongNhan],\r\n"
					+ "    BP.[maCongDoan],\r\n"
					+ "	BP.[ngayPhanCong],\r\n"
					+ "    BP.[trangthaiphancong],\r\n"
					+ "    BP.[soluongphancong] \r\n"
					+ "     \r\n"
					+ "FROM\r\n"
					+ "    [QuanLyLuong_Nhom2].[dbo].[CongNhan] AS CN\r\n"
					+ "LEFT JOIN\r\n"
					+ "    [QuanLyLuong_Nhom2].[dbo].[BangPhanCong] AS BP ON CN.[maCongNhan] = BP.[maCongNhan] AND BP.[trangthaiphancong] = 1\r\n"
					+ "WHERE\r\n"
					+ "    BP.[maCongNhan] IS NULL"
					 
					+ "";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(4);
				Date dz= new Date(2023, 11, 11);
	            // Chuyển đổi thành LocalDate
				if(sqlDate==null) {
					sqlDate= dz;
				}
	            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
	            
				dscn.add(new BangPhanCong(new CongNhan(rs.getString(1)),rs.getString(2),new CongDoan(rs.getString(3)), ngaybatdaulamViec,rs.getInt(5), rs.getInt(6) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscn;
	}
	
	
//	filter da phan cong 
	
	public List<BangPhanCong> DSPC(String maCongDoan,int trangthai){
		List<BangPhanCong> dscn=new ArrayList<BangPhanCong>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="\r\n"
					+ "\r\n"
					+ "  SELECT \r\n"
					+ "					     CN.[maCongNhan], \r\n"
					+ "				    CN.[tenCongNhan], \r\n"
					+ "					    BP.[maCongDoan], \r\n"
					+ "				 BP.[ngayPhanCong] ,\r\n"
					+ "				   BP.[trangthaiphancong] ,\r\n"
					+ "					BP.soluongphancong"
					+ "					  FROM\r\n"
					+ "					   [QuanLyLuong_Nhom2].[dbo].[CongNhan] AS CN\r\n"
					+ "					LEFT JOIN  \r\n"
					+ "					    [QuanLyLuong_Nhom2].[dbo].[BangPhanCong] AS BP\r\n"
					+ "					  ON \r\n"
					+ "					       CN.[maCongNhan] = BP.[maCongNhan]\r\n"
					+ "					   WHERE \r\n"
					+ "					    BP.[maCongDoan] = ? and BP.[trangthaiphancong]=?;"
					+ "";
			PreparedStatement statement= con.prepareStatement(sql);
			
			statement.setString(1, maCongDoan);
			statement.setInt(2, trangthai);
			ResultSet rs =statement.executeQuery( );
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(4);
				Date dz= new Date(2023, 11, 11);
	            // Chuyển đổi thành LocalDate
				if(sqlDate==null) {
					sqlDate= dz;
				}
	            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
	            
				dscn.add(new BangPhanCong(new CongNhan(rs.getString(1)),rs.getString(2),new CongDoan(rs.getString(3)), ngaybatdaulamViec,rs.getInt(5),rs.getInt(6) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscn;
	}
	
	
 
//	
//	public static boolean insertPhanCong(BangPhanCong bpc) {
//
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n=0;
//		try { 
//			stmt = con.prepareStatement("insert into BangPhanCong (maCongNhan,maCongDoan,ngayPhanCong,trangthaiphancong ) values (?,?,?,? )");
//			stmt.setString(1, bpc.getMaCongNhan().getMaCongNhan());
//			stmt.setString(2, bpc.getMaCongDoan().getMaCongDoan());
//			
//			stmt.setDate(3, Date.valueOf(bpc.getNgayCham()));
//			stmt.setInt(4, bpc.getTrangthaiphancong());
//			 
//		 
//
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}  
//		return n>0;
//	}
	
	public static boolean insertPhanCong(BangPhanCong bpc) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into BangPhanCong (maCongNhan,maCongDoan,ngayPhanCong,trangthaiphancong,soluongphancong,maCongDoanDonHang ) values (?,?,?,?,?,? )");
			stmt.setString(1, bpc.getMaCongNhan().getMaCongNhan());
			stmt.setString(2, bpc.getMaCongDoan().getMaCongDoan());
			
			stmt.setDate(3, Date.valueOf(bpc.getNgayCham()));
			stmt.setInt(4, bpc.getTrangthaiphancong());
			 
			stmt.setInt(5, bpc.getSoluongphancong());
			 
			stmt.setString(6, bpc.getCongdoandonhang().getMaCongDoanDonHang());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}  
		return n>0;
	}
	
	
	//dem so luong phan cong 
	public int tongsoluongphancong(String maCD) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int p = 0;
	    try {
	        String sql = " SELECT  DonHang.SoluongDatHang\r\n"
	        		+ "FROM CongDoan\r\n"
	        		+ "INNER JOIN SanPham ON CongDoan.maSP = SanPham.maSP\r\n"
	        		+ "INNER JOIN DonHang ON DonHang.MaSanPham = SanPham.maSP \r\n"
	        		+ "where maCongDoan=?";

	        preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setString(1, maCD); // Đặt giá trị cho placeholder
	       
	        resultSet = preparedStatement.executeQuery();
	         
	        if (resultSet.next()) {
	            p += resultSet.getInt("SoluongDatHang");
	            System.out.println("Total SoluongDatHang for maCongDoan " + maCD + ": " + p);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return p;
	}
 //delete phan cong sau khi duoc cham cong
		public static boolean deleteBangPhanCongTheoMaCN(String macn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt=con.prepareStatement("delete from BangPhanCong where maCongNhan =?");
			stmt.setString(1,macn);
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
		 
	}
		
		
		//update hoàn thành
		
		public static boolean updateHoanThanh(String macn,String maCongDoan,String macongdoandonhang ) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n=0;
			
			try {
				stmt=con.prepareStatement("update BangPhanCong set trangthaiphancong=2  where  maCongNhan =? and maCongDoan=? and maCongDoanDonHang=?");
				 
				stmt.setString(1,macn);
				stmt.setString(2,maCongDoan);
				stmt.setString(3,macongdoandonhang);
				n=stmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return n>0;
			 
		}
}
//;