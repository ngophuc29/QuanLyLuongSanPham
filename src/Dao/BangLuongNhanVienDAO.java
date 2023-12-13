 
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
import Entity.BangLuongNhanVien;
import Entity.ChamCongNhanVien;
import Entity.CongNhan;
import Entity.NhanVien;
 

public class BangLuongNhanVienDAO {
	private ArrayList<BangLuongNhanVien> dsBangLuongNV;

	public BangLuongNhanVienDAO() {
		dsBangLuongNV = new ArrayList<BangLuongNhanVien>();
	}

 
	
	public List<BangLuongNhanVien> getchamcongtheongay(int thang , int nam){
		List<BangLuongNhanVien> dsBangLuongNV=new ArrayList<BangLuongNhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT * from BangLuongNhanVien where thang=? and nam=? ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setInt(1, thang);
			statement.setInt(2, nam);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 ;
				
				 dsBangLuongNV.add(new BangLuongNhanVien(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11),rs.getDouble(12),new NhanVien( rs.getString(13)),rs.getDouble(14),rs.getDouble(15),rs.getInt(16),rs.getInt(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsBangLuongNV;
	}
 
	
	//lay cua 1 nhanvien
	
	public List<BangLuongNhanVien> getchamcongtheongayTheoTungNhanVien(String manv,int thang , int nam ){
		List<BangLuongNhanVien> dsBangLuongNV=new ArrayList<BangLuongNhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT * from BangLuongNhanVien where    maNV=? and thang=? and nam=?  ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1, manv);
			statement.setInt(2, thang);
			statement.setInt(3, nam);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 ;
				
				 dsBangLuongNV.add(new BangLuongNhanVien(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11),rs.getDouble(12),new NhanVien( rs.getString(13)),rs.getDouble(14),rs.getDouble(15),rs.getInt(16),rs.getInt(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsBangLuongNV;
	}
 
	
	public boolean updateBangLuong(String maNV) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    int n = 0;

	    try {
	    	stmt = con.prepareStatement("UPDATE BangLuongNhanVien\r\n"
	    			+ "SET songaycong = (\r\n"
	    			+ "    SELECT COUNT(*) FROM ChamCongNhanVien\r\n"
	    			+ "    WHERE maNV = ? AND hiendien = 2\r\n"
	    			+ "    AND MONTH(ngaycham) = MONTH(GETDATE()) -- Lọc theo tháng hiện tại\r\n"
	    			+ "    AND YEAR(ngaycham) = YEAR(GETDATE()) -- Lọc theo năm hiện tại\r\n"
	    			+ "),\r\n"
	    			+ "soNgaynghicophep = (  SELECT COUNT(*) FROM ChamCongNhanVien \r\n"
	    			+ "	    			  WHERE maNV =? AND hiendien = 1 \r\n"
	    			+ "	    		   AND MONTH(ngaycham) = MONTH(GETDATE()) \r\n"
	    			+ "	    			  AND YEAR(ngaycham) = YEAR(GETDATE()) ) "
	    			+ ",\r\n"
	    			+ "soNgaynghikhongphep = ( SELECT COUNT(*) FROM ChamCongNhanVien \r\n"
	    			+ "	    			  WHERE maNV = ? AND hiendien = 0 \r\n"
	    			+ "	    		   AND MONTH(ngaycham) = MONTH(GETDATE()) \r\n"
	    			+ "	    			  AND YEAR(ngaycham) = YEAR(GETDATE() ) )  "
	    			+ ",\r\n"
	    			+ "tongsogiotangca = (\r\n"
	    			+ "    SELECT SUM(sogiotangca) FROM ChamCongNhanVien\r\n"
	    			+ "    WHERE maNV = ?\r\n"
	    			+ "    AND MONTH(ngaycham) = MONTH(GETDATE())\r\n"
	    			+ "    AND YEAR(ngaycham) = YEAR(GETDATE())\r\n"
	    			+ "),\r\n"
	    			+ "phat = (\r\n"
	    			+ "    CASE\r\n"
	    			+ "        WHEN (\r\n"
	    			+ "            SELECT COUNT(*) FROM ChamCongNhanVien\r\n"
	    			+ "            WHERE maNV = ? AND hiendien = 0\r\n"
	    			+ "            AND YEAR(ngaycham) = YEAR(GETDATE())\r\n"
	    			+ "        ) > 24 THEN\r\n"
	    			+ "            ROUND(\r\n"
	    			+ "                (\r\n"
	    			+ "                    (SELECT COUNT(*) FROM ChamCongNhanVien\r\n"
	    			+ "                    WHERE maNV = ? AND hiendien = 0\r\n"
	    			+ "                    AND YEAR(ngaycham) = YEAR(GETDATE())) - 2\r\n"
	    			+ "                ) * 200000, 2\r\n"
	    			+ "            )\r\n"
	    			+ "        ELSE\r\n"
	    			+ "            0\r\n"
	    			+ "    END\r\n"
	    			+ "),"
	    			+ "trocap=500000,"
	    			 
	    			+ "luongtangca = (\r\n"
	    			+ "    SELECT ROUND(SUM(sogiotangca) * (luongCb / 26 / 8 * 1.5), 2) FROM ChamCongNhanVien\r\n"
	    			+ "    WHERE maNV = ?\r\n"
	    			+ "    AND MONTH(ngaycham) = MONTH(GETDATE())\r\n"
	    			+ "    AND YEAR(ngaycham) = YEAR(GETDATE())\r\n"
	    			+ "),\r\n"
	    			+ "tiencong = (\r\n"
	    			+ "    SELECT ROUND(\r\n"
	    			+ "        ((SELECT COUNT(*) FROM ChamCongNhanVien\r\n"
	    			+ "         WHERE maNV = ? AND hiendien = 2\r\n"
	    			+ "         AND caLam = N'Nguyên Buổi'\r\n"
	    			+ "         AND MONTH(ngaycham) = MONTH(GETDATE())\r\n"
	    			+ "         AND YEAR(ngaycham) = YEAR(GETDATE())) * 4500000 * hsluong / 26)\r\n"
	    			+ "        + ((SELECT COUNT(*) FROM ChamCongNhanVien\r\n"
	    			+ "         WHERE maNV = ? AND hiendien = 2\r\n"
	    			+ "         AND caLam = N'Nửa Buổi'\r\n"
	    			+ "         AND MONTH(ngaycham) = MONTH(GETDATE())\r\n"
	    			+ "         AND YEAR(ngaycham) = YEAR(GETDATE())) * 4500000 * hsluong / 26 / 2), 2\r\n"
	    			+ "    )\r\n"
	    			+ "    FROM BangLuongNhanVien\r\n"
	    			+ "    WHERE maNV = ? AND thang = MONTH(GETDATE()) AND nam = YEAR(GETDATE())\r\n"
	    			+ "),\r\n"
	    			+ "tongluong = (\r\n"
	    			+ "    SELECT ROUND(\r\n"
	    			+ "        (tiencong)\r\n"
	    			+ "        + (luongtangca)\r\n"
	    			+ "        + TroCap\r\n"
	    			+ "        - (\r\n"
	    			+ "            CASE\r\n"
	    			+ "                WHEN (SELECT bhxh FROM NhanVien WHERE maNV = ?) = 0 THEN\r\n"
	    			+ "                    ((tiencong)\r\n"
	    			+ "                    + (tongsogiotangca * luongtangca)\r\n"
	    			+ "                    + TroCap) * 0.08\r\n"
	    			+ "                WHEN (SELECT bhxh FROM NhanVien WHERE maNV = ?) = 1 THEN 0\r\n"
	    			+ "            END\r\n"
	    			+ "        )\r\n"
	    			+ "    - phat, 2)\r\n"
	    			+ ")\r\n"
	    			+ "WHERE maNV = ? AND thang = MONTH(GETDATE()) AND nam = YEAR(GETDATE());");

	    		stmt.setString(1, maNV);
	    		stmt.setString(2, maNV);
	    		stmt.setString(3, maNV);
	    		stmt.setString(4, maNV);
	    		stmt.setString(5, maNV);
	    		stmt.setString(6, maNV);
	    		stmt.setString(7, maNV);
	    		stmt.setString(8, maNV);
	    		stmt.setString(9, maNV);
	    		stmt.setString(10, maNV);
	    		stmt.setString(11, maNV);
	    		stmt.setString(12, maNV);
	    		stmt.setString(13, maNV);
	    	
	    		n = stmt.executeUpdate();

	 



	    	 

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return n > 0;
	}
	
	
public static boolean updateHeSoLuong(double hsLuong ,String ma  ) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("update BangLuongNhanVien set  hsluong=? where maNV=? AND thang = MONTH(GETDATE()) AND nam = YEAR(GETDATE()) ");
			
			stmt.setDouble(1, hsLuong);
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
