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
import Entity.CongDoan;
import Entity.NhanVien;
import Entity.SanPham;

 

public class CongDoanDAO {
	
 
 
	public List<CongDoan> getAllcongdoantheosanpham(String masp){
		List<CongDoan> dscdtm=new ArrayList<CongDoan>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="  select * from [CongDoan] where masp=?";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1, masp);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 
				
	        	dscdtm.add(new  CongDoan(rs.getString(1),rs.getString(2),rs.getDouble(3),new SanPham(masp),rs.getInt(5)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dscdtm;
	}
 
	
	public List<CongDoan> getAllcongdoanDonhANGtheosanpham(String masp){
		List<CongDoan> dscdtm=new ArrayList<CongDoan>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql=" select MaCongDoanDonHang,CongDoanDonHang.maCongDoan,tenCongDoan,giaCongDoan,CongDoanDonHang.soLuongDatHang,TienDo,CongDoanDonHang.TrangThai\r\n"
					+ "from CongDoan\r\n"
					+ "join CongDoanDonHang on CongDoan.maCongDoan=CongDoanDonHang.maCongDoan\r\n"
					+ "join SanPham on CongDoan.maSP=SanPham.maSP\r\n"
					+ "join DonHang on DonHang.maDonHang=CongDoanDonHang.MaDonHang\r\n"
					+ "where SanPham.maSP=?";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1, masp);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 
				
	        	dscdtm.add(new  CongDoan(rs.getString(1),rs.getString(2),rs.getDouble(3),new SanPham(masp),rs.getInt(5)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dscdtm;
	}
	public static boolean themDanhSachCD(CongDoan cd) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into CongDoan (tenCongDoan,giaCongDoan,maSP,thutu) values (?,?,?,?)");
//			stmt.setString(1, nv.getMaNV());
			stmt.setString(1, cd.getTenCongDoan());
			 
			stmt.setDouble(2, cd.getGiaCongDoan());
			stmt.setString(3, cd.getMaSp().getMaSp());
			stmt.setDouble(4, cd.getThutu());
			 

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}  
		return n>0;
	}
 
	public static boolean updateCongDoan(double gia ,String ma  ) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("update CongDoan set  giaCongDoan=? where maCongDoan=? ");
			
			stmt.setDouble(1, gia);
			stmt.setString(2, ma);
		 
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
}
 