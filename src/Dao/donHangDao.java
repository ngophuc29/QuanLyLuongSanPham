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
import Entity.DonHang;
import Entity.NhanVien;
import Entity.SanPham;

 

public class donHangDao {
	
	
	 
	public List<DonHang> DSDH(){
		List<DonHang> dsdh=new ArrayList<DonHang>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql=" select * from DonHang order by madonhang asc";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				
			 
				java.sql.Date sqlDateDatHang = rs.getDate(6);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaydathang = sqlDateDatHang.toLocalDate();
	            
	            java.sql.Date sqlDateHoanThanh = rs.getDate(7);
	            // Chuyển đổi thành LocalDate
 
//				Date dz= new Date(2023, 11, 11);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngayHoanThanh = null;
				if(sqlDateHoanThanh==null) {
					 
					 
					 ngayHoanThanh= null;
				}else {
					  ngayHoanThanh= sqlDateHoanThanh.toLocalDate();
				}
				
			    
			    
				dsdh.add(new DonHang(rs.getString(1), new SanPham(rs.getString(2) ,rs.getString(3)), rs.getInt(4), rs.getInt(5),ngaydathang,ngayHoanThanh));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsdh;
	}
 
	
	public static boolean insertDonhang(DonHang dh) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into DonHang ( MaSanPham,TenSanPham,soLuongDatHang,trangthaiDonHang,ngaytaodonhang ) values (?,?,?,?,? )");
			stmt.setString(1,dh.getSanpham().getMaSp());
			stmt.setString(2,dh.getSanpham().getTenSp());
			stmt.setInt(3,dh.getSoluong());
			stmt.setInt(4,dh.getTrangthai());
			stmt.setDate(5, Date.valueOf(dh.getNgaytao()));

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}  
		return n>0;
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
		
	//update hoàn thành của đơn hàng
		
		public static boolean updateHoanThanh( LocalDate ngayhoanthanh,String macongdoanhonhang, String madonhangdungdeupdate ) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n=0;
			
			try {
				stmt=con.prepareStatement("UPDATE [DonHang]\r\n"
						+ "SET trangthaiDonHang = 2,\r\n"
						+ "    ngayhoanthanh = ?\r\n"
						+ "WHERE [MaDonHang] IN (\r\n"
						+ "    SELECT CDH.[MaDonHang]\r\n"
						+ "    FROM [QuanLyLuong_Nhom2].[dbo].[CongDoanDonHang] AS CDH\r\n"
						+ "    INNER JOIN [QuanLyLuong_Nhom2].[dbo].[CongDoan] AS C ON CDH.[MaCongDoan] = C.[MaCongDoan]\r\n"
						+ "    WHERE CDH.[TrangThai] = 2\r\n"
						+ "    AND C.[tenCongDoan] = 'Hoàn thành đôi giày'\r\n"
						+ "    AND CDH.[MaCongDoanDonHang] = ?\r\n "
						+ "   AND cdh.MaDonHang=?"
						+ ")");
				 
				stmt.setDate(1, Date.valueOf(ngayhoanthanh));
				stmt.setString(2, macongdoanhonhang);
				stmt.setString(3, madonhangdungdeupdate);
				n=stmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return n>0;
			 
		}
}
//;