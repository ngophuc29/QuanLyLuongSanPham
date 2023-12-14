package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Database.ConnectDB;
import Entity.ChamCongNhanVien;
import Entity.CongNhan;
import Entity.NhanVien;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ChamCongNhanVienDAO {
	private ArrayList<ChamCongNhanVien> dsChamCongNV;

	public ChamCongNhanVienDAO() {
		dsChamCongNV = new ArrayList<ChamCongNhanVien>();
	}

//	public List<ChamCongNhanVien> getDanhSachChamCongNhanVien() {
//		
//		
//		
//		List<ChamCongNhanVien> dsChamCongNV=new ArrayList<ChamCongNhanVien>();
//		ConnectDB.getInstance();
//		Connection con =ConnectDB.getConnection();
//		try {
//			String sql="SELECT * from [ChamCongNhanVien]";
//			Statement statement= con.createStatement();
//			ResultSet rs =statement.executeQuery(sql);
//			while(rs.next()) {
//				
//				java.sql.Date sqlDate = rs.getDate(3);
//	            // Chuyển đổi thành LocalDate
//	            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
//	            
//	     
//	            
//	            
//	            dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaybatdaulamViec,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dsChamCongNV;
//	}
	
//	public List<ChamCongNhanVien> getchamcongtheongay(LocalDate ngaycham){
//		List<ChamCongNhanVien> dsChamCongNV=new ArrayList<ChamCongNhanVien>();
//		ConnectDB.getInstance();
//		Connection con =ConnectDB.getConnection();
//		try {
//			String sql="SELECT * from [ChamCongNhanVien] where ngaycham=? ";
//			PreparedStatement statement= con.prepareStatement(sql);
//			 
//			statement.setDate(1, Date.valueOf(ngaycham));
//			ResultSet rs =statement.executeQuery();
//			while(rs.next()) {
//				
//				java.sql.Date sqlDate = rs.getDate(3);
//	            // Chuyển đổi thành LocalDate
//	            LocalDate ngaychamm = sqlDate.toLocalDate();
//				
//				 dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaychamm,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dsChamCongNV;
//	}
	
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
				
	            
//	            java.time.LocalDateTime sqlDateTimeThoigianden = rs.getTimestamp(9).toLocalDateTime();
//
//		         // Lấy ngày từ LocalDateTime
//		         java.time.LocalDate thoigiandenDate = sqlDateTimeThoigianden.toLocalDate();
//
//		         // Chuyển đổi thành LocalDateTime bằng cách thêm thời gian mặc định (ví dụ: 00:00:00)
//		         java.time.LocalDateTime thoigiandenzz = thoigiandenDate.atStartOfDay();
//
//		         LocalDateTime thoigianden=thoigiandenzz ;
	            
//	            java.sql.Timestamp timestamp = rs.getTimestamp(9);
//	            java.time.LocalDateTime thoigianden = null;
//
//	            if (timestamp != null) {
//	                java.time.LocalDateTime sqlDateTimeThoigianden = timestamp.toLocalDateTime();
//	                java.time.LocalDate thoigiandenDate = sqlDateTimeThoigianden.toLocalDate();
//	                java.time.LocalDateTime thoigiandenzz = thoigiandenDate.atStartOfDay();
//	                thoigianden = thoigiandenzz;
//	            } else {
//	                // Gán thoigianden bằng rỗng (null) nếu timestamp là null
//	                thoigianden = null;
//	            }
//	            
//	            java.sql.Timestamp timestamp1 = rs.getTimestamp(10);
//	            java.time.LocalDateTime thoigiandi = null;
//
//	            if (timestamp1 != null) {
//	                java.time.LocalDateTime sqlDateTimeThoigiandi = timestamp1.toLocalDateTime();
//	                java.time.LocalDate thoigiandiDate = sqlDateTimeThoigiandi.toLocalDate();
//	                java.time.LocalDateTime thoigiandizz = thoigiandiDate.atStartOfDay();
//	                thoigiandi = thoigiandizz;
//	            } else {
//	                // Gán thoigianden bằng rỗng (null) nếu timestamp là null
//	            	thoigiandi = null;
//	            }
	            
	            
	            java.sql.Timestamp timestamp = rs.getTimestamp(9);
	            java.time.LocalTime thoigianden  = null;

	            if (timestamp != null) {
	                // Chuyển đổi Timestamp thành LocalDateTime
	                java.time.LocalDateTime sqlDateTimeThoigianden = timestamp.toLocalDateTime();
	                
	                // Lấy giờ từ LocalDateTime
	                thoigianden  = sqlDateTimeThoigianden.toLocalTime();
	            }
	            
	            
	            java.sql.Timestamp timestamp1 = rs.getTimestamp(10);
	            java.time.LocalTime thoigiandi  = null;

	            if (timestamp1 != null) {
	                // Chuyển đổi Timestamp thành LocalDateTime
	                java.time.LocalDateTime sqlDateTimeThoigiandi = timestamp1.toLocalDateTime();
	                
	                // Lấy giờ từ LocalDateTime
	                thoigiandi  = sqlDateTimeThoigiandi.toLocalTime();
	            }
				 dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaychamm,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),thoigianden,thoigiandi,rs.getInt(11)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChamCongNV;
	}
//	public List<ChamCongNhanVien> getchamcongdahiendien(LocalDate ngaycham){
//		List<ChamCongNhanVien> dsChamCongNV=new ArrayList<ChamCongNhanVien>();
//		ConnectDB.getInstance();
//		Connection con =ConnectDB.getConnection();
//		try {
//			String sql="SELECT * from [ChamCongNhanVien] where ngaycham=? and hiendien=2 ";
//			PreparedStatement statement= con.prepareStatement(sql);
//			 
//			statement.setDate(1, Date.valueOf(ngaycham));
//			ResultSet rs =statement.executeQuery();
//			while(rs.next()) {
//				
//				java.sql.Date sqlDate = rs.getDate(3);
//	            // Chuyển đổi thành LocalDate
//	            LocalDate ngaychamm = sqlDate.toLocalDate();
//	            
//	            //thoi gian den va thoi gian di
//	            
//	         // Assuming rs is your ResultSet object
//	            java.time.LocalDateTime sqlDateTimeThoigianden = rs.getTimestamp(8).toLocalDateTime();
//
//	            // Chuyển đổi thành LocalDate
//	            LocalDateTime thoigianden = sqlDateTimeThoigianden.toLocalDateTime();
//	            
//				
//				 dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaychamm,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dsChamCongNV;
//	}

	
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
	            
	            //thoi gian den va thoi gian di
	            
//	         // Assuming rs is your ResultSet object
//	            java.time.LocalDateTime sqlDateTimeThoigianden = rs.getTimestamp(8).toLocalDateTime();
//
//	            // Chuyển đổi thành LocalDate
//	            LocalDateTime thoigianden = sqlDateTimeThoigianden.toLocalDate();
	            
//	            java.time.LocalDateTime sqlDateTimeThoigianden = rs.getTimestamp(9).toLocalDateTime();
//
//	         // Lấy ngày từ LocalDateTime
//	         java.time.LocalDate thoigiandenDate = sqlDateTimeThoigianden.toLocalDate();
//
//	         // Chuyển đổi thành LocalDateTime bằng cách thêm thời gian mặc định (ví dụ: 00:00:00)
//	         java.time.LocalDateTime thoigiandenzz = thoigiandenDate.atStartOfDay();
//
//	         LocalDateTime thoigianden=thoigiandenzz ;
//	            java.sql.Timestamp timestamp = rs.getTimestamp(9);
//	            java.time.LocalDateTime thoigianden = null;
//
//	            if (timestamp != null) {
//	                java.time.LocalDateTime sqlDateTimeThoigianden = timestamp.toLocalDateTime();
//	                java.time.LocalDate thoigiandenDate = sqlDateTimeThoigianden.toLocalDate();
//	                java.time.LocalDateTime thoigiandenzz = thoigiandenDate.atStartOfDay();
//	                thoigianden = thoigiandenzz;
//	            } else {
//	                // Gán thoigianden bằng rỗng (null) nếu timestamp là null
//	                thoigianden = null;
//	            }
//	            
//	            java.sql.Timestamp timestamp1 = rs.getTimestamp(10);
//	            java.time.LocalDateTime thoigiandi = null;
//
//	            if (timestamp1 != null) {
//	                java.time.LocalDateTime sqlDateTimeThoigiandi = timestamp1.toLocalDateTime();
//	                java.time.LocalDate thoigiandiDate = sqlDateTimeThoigiandi.toLocalDate();
//	                java.time.LocalDateTime thoigiandizz = thoigiandiDate.atStartOfDay();
//	                thoigiandi = thoigiandizz;
//	            } else {
//	                // Gán thoigianden bằng rỗng (null) nếu timestamp là null
//	            	thoigiandi = null;
//	            }
	            
	            
	            java.sql.Timestamp timestamp = rs.getTimestamp(9);
	            java.time.LocalTime thoigianden  = null;

	            if (timestamp != null) {
	                // Chuyển đổi Timestamp thành LocalDateTime
	                java.time.LocalDateTime sqlDateTimeThoigianden = timestamp.toLocalDateTime();
	                
	                // Lấy giờ từ LocalDateTime
	                thoigianden  = sqlDateTimeThoigianden.toLocalTime();
	            }
	            
	            
	            java.sql.Timestamp timestamp1 = rs.getTimestamp(10);
	            java.time.LocalTime thoigiandi  = null;

	            if (timestamp1 != null) {
	                // Chuyển đổi Timestamp thành LocalDateTime
	                java.time.LocalDateTime sqlDateTimeThoigiandi = timestamp1.toLocalDateTime();
	                
	                // Lấy giờ từ LocalDateTime
	                thoigiandi  = sqlDateTimeThoigiandi.toLocalTime();
	            }
				 dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaychamm,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),thoigianden,thoigiandi,rs.getInt(11)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChamCongNV;
	}
	
	public boolean updateChamCong(int hiendien,String calam,String ghichu,int sogiotangca,LocalTime thoigianden, LocalTime thoigiandi,int ditre,String machamcong,LocalDate ngaycham) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement("  update ChamCongNhanVien set hiendien=?,calam=?,ghichu=?,sogiotangca=?,thoigianden=?,thoigiandi=?,ditre=? where maChamCongNhanVien=? and ngaycham=?");
			stmt.setInt (1,hiendien);
			stmt.setString(2,calam);
			stmt.setString(3,ghichu);
			stmt.setInt(4,sogiotangca);
			
			// Kiểm tra và chuyển đổi thoigianden
			Time timeden = null;
			if (thoigianden != null) {
			    timeden = Time.valueOf(thoigianden);
			}
			stmt.setTime(5, timeden);

			// Kiểm tra và chuyển đổi thoigiandi
			Time timedi = null;
			if (thoigiandi != null) {
			    timedi = Time.valueOf(thoigiandi);
			}
			stmt.setTime(6, timedi);

 
			stmt.setInt(7,ditre);
			
			stmt.setString(8,machamcong);
			stmt.setDate(9, Date.valueOf(ngaycham));
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
			stmt=con.prepareStatement("  update ChamCongNhanVien set hiendien=?,thoigianden=GETDATE() where maNV=? and ngaycham=?");
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
	public boolean updateChamCong2(String manv,LocalDate ngaycham) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement("  update ChamCongNhanVien set thoigiandi=GETDATE() where maNV=? and ngaycham=?");
		
			stmt.setString(1,manv);
			stmt.setDate(2, Date.valueOf(ngaycham));
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
			String sql="SELECT [maChamCongNhanVien]\r\n"
					+ "      ,[maNV]\r\n"
					+ "      ,[ngaycham]\r\n"
					+ "      ,[hiendien]\r\n"
					+ "      ,[calam]\r\n"
					+ "      ,[ghichu]\r\n"
					+ "      ,[sogiotangca]\r\n"
					+ "      ,[tenNV]\r\n"
					+ "      , ditre from [ChamCongNhanVien] where maNV=? and month(ngaycham)=? and year(ngaycham)=? ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1,maNV);
			statement.setInt(2,thang);
			statement.setInt(3,nam);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(3);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaychamm = sqlDate.toLocalDate();
				
				 dsChamCongNV.add(new ChamCongNhanVien(rs.getString(1),new NhanVien(rs.getString(2),rs.getString(8)),ngaychamm,rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChamCongNV;
	}
 
	
	
	//update thoi gian den va thoi gian di
	public boolean updatethoigiandenvathoigiandi(String maNV ) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement("IF (SELECT thoigiandi FROM ChamCongNhanVien WHERE ngaycham = CAST(GETDATE() AS DATE) AND maNV = ?) IS NULL\r\n"
					+ "BEGIN\r\n"
					+ "    UPDATE ChamCongNhanVien\r\n"
					+ "    SET \r\n"
					+ "        thoigianden = CASE\r\n"
					+ "                        WHEN thoigianden IS NULL THEN GETDATE()\r\n"
					+ "                        ELSE thoigianden\r\n"
					+ "                    END,\r\n"
					+ "        thoigiandi = CASE\r\n"
					+ "                        WHEN thoigianden IS NOT NULL THEN GETDATE()\r\n"
					+ "                        ELSE thoigiandi\r\n"
					+ "                    END\r\n"
					+ "    WHERE ngaycham = CAST(GETDATE() AS DATE) AND maNV = ?;\r\n"
					+ "END");
//			stmt.setInt (1,hiendien);
			stmt.setString(1,maNV);
			stmt.setString(2,maNV);
//			stmt.setString(3,ghichu);
//			stmt.setInt(4,sogiotangca);
//			stmt.setString(5,machamcong);
//			stmt.setDate(6, Date.valueOf(ngaycham));
			n= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return n>0;
		
	}
	//update calam va ghi chu 
	public boolean updatecalamvaghichu(String maNV ) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement(" UPDATE ChamCongNhanVien\r\n"
					+ "SET \r\n"
					+ "    calam = CASE\r\n"
					+ "                WHEN thoigiandi IS NOT NULL THEN\r\n"
					+ "                    CASE\r\n"
					+ "                        WHEN DATEDIFF(HOUR, thoigianden, thoigiandi) >= 8 THEN N'Nguyên buổi'\r\n"
					+ "                        WHEN DATEDIFF(HOUR, thoigianden, thoigiandi) > 6 THEN N'Nửa buổi'\r\n"
					+ "                        WHEN DATEDIFF(HOUR, thoigianden, thoigiandi) < 4 THEN ''\r\n"
					+ "                        ELSE ''\r\n"
					+ "                    END\r\n"
					+ "                ELSE ''\r\n"
					+ "            END,\r\n"
					+ "    ghichu = CASE\r\n"
					+ "                WHEN thoigiandi IS NOT NULL AND DATEDIFF(HOUR, thoigianden, thoigiandi) < 3 THEN N'Về sớm không tính công'\r\n"
					+ "                ELSE ''\r\n"
					+ "            END,\r\n"
					+ "    hiendien = CASE\r\n"
					+ "                   WHEN DATEDIFF(HOUR, thoigianden, thoigiandi) < 4 THEN 2\r\n"
					+ "                   ELSE 2\r\n"
					+ "               END\r\n"
					+ "WHERE ngaycham = CAST(GETDATE() AS DATE) AND maNV = ?;");
//			stmt.setInt (1,hiendien);
			stmt.setString(1,maNV);
//			stmt.setString(3,ghichu);
//			stmt.setInt(4,sogiotangca);
//			stmt.setString(5,machamcong);
//			stmt.setDate(6, Date.valueOf(ngaycham));
			n= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return n>0;
		
	}
	
	//update di tre 
	public boolean updateditre(String maNV ) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement(" IF (SELECT thoigianden FROM ChamCongNhanVien WHERE ngaycham = CAST(GETDATE() AS DATE) AND maNV = ?) IS NOT NULL\r\n"
					+ "BEGIN\r\n"
					+ "    DECLARE @desiredTime TIME = '07:30:00';\r\n"
					+ "    \r\n"
					+ "    UPDATE ChamCongNhanVien\r\n"
					+ "    SET\r\n"
					+ "        ditre = CASE\r\n"
					+ "                    WHEN CAST(thoigianden AS TIME) > @desiredTime THEN 1\r\n"
					+ "                    ELSE ditre\r\n"
					+ "                END\r\n"
					+ "    WHERE ngaycham = CAST(GETDATE() AS DATE) AND maNV = ?;\r\n"
					+ "END");
//			stmt.setInt (1,hiendien);
			stmt.setString(1,maNV);
			stmt.setString(2,maNV);
//			stmt.setString(3,ghichu);
//			stmt.setInt(4,sogiotangca);
//			stmt.setString(5,machamcong);
//			stmt.setDate(6, Date.valueOf(ngaycham));
			n= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return n>0;
		
	}
}
