 
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
import Entity.BangLuongCongNhan;
import Entity.BangLuongNhanVien;
import Entity.ChamCongNhanVien;
import Entity.CongNhan;
import Entity.NhanVien;
 

public class BangLuongCongNhanDAO {
	private ArrayList<BangLuongCongNhan> dsBangLuongCN;

	public BangLuongCongNhanDAO() {
		dsBangLuongCN = new ArrayList<BangLuongCongNhan>();
	}
 
	
	public List<BangLuongCongNhan> getchamcongtheongay(int thang , int nam){
		List<BangLuongCongNhan> dsBangLuongCN=new ArrayList<BangLuongCongNhan>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT [maBangLuongCongNhan], [maCN],[tongluong],[luongsanpham],[tongsogiotangca],phat,troCap,luongtangca from BangLuongCongNhan where thang=? and nam=? ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setInt(1, thang);
			statement.setInt(2, nam);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 
				
				dsBangLuongCN.add(new BangLuongCongNhan(rs.getString(1),new CongNhan(rs.getString(2)) ,rs.getDouble(3),rs.getDouble(4),rs.getInt(5),rs.getDouble(6),rs.getDouble(7),rs.getInt(8) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsBangLuongCN;
	}
 
	
	public boolean updateBangLuong(String maCN) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    int n = 0;

	    try {
	    	stmt = con.prepareStatement("   UPDATE BangLuongCongNhan\r\n"
	    			+ "SET\r\n"
	    			+ "    tongsogiotangca = (\r\n"
	    			+ "        SELECT SUM(sogiotangca) FROM ChamCongCongNhan\r\n"
	    			+ "        WHERE maCongNhan =?\r\n"
	    			+ "        AND MONTH(ngaycham) = MONTH(GETDATE())\r\n"
	    			+ "        AND YEAR(ngaycham) = YEAR(GETDATE())\r\n"
	    			+ "    ),\r\n"
	    			+ "    phat = 0,\r\n"
	    			+ "    luongtangca = (\r\n"
	    			+ "        SELECT ROUND(SUM(sogiotangca) * 10817, 2) FROM ChamCongCongNhan\r\n"
	    			+ "        WHERE maCongNhan =  ?\r\n"
	    			+ "        AND MONTH(ngaycham) = MONTH(GETDATE())\r\n"
	    			+ "        AND YEAR(ngaycham) = YEAR(GETDATE())\r\n"
	    			+ "    ),\r\n"
	    			+ "    luongsanpham = (\r\n"
	    			+ "        SELECT SUM(soluong * giaCongDoan)\r\n"
	    			+ "        FROM ChamCongCongNhan cc\r\n"
	    			+ "        INNER JOIN CongDoan cd ON cc.macongdoan = cd.macongdoan\r\n"
	    			+ "        WHERE cc.maCongNhan =  ?\r\n"
	    			+ "        AND MONTH(cc.ngaycham) = MONTH(GETDATE())\r\n"
	    			+ "        AND YEAR(cc.ngaycham) = YEAR(GETDATE())\r\n"
	    			+ "    ),\r\n"
	    			+ "    troCap = 500000,\r\n"
	    			+ "    tongluong = (\r\n"
	    			+ "        luongsanpham\r\n"
	    			+ "         + luongtangca\r\n"
	    			+ "            + troCap\r\n"
	    			+ "             - (\r\n"
	    			+ "            CASE\r\n"
	    			+ "                WHEN (SELECT bhxh FROM CongNhan WHERE maCongNhan = ?) = 0 THEN\r\n"
	    			+ "                    ((luongsanpham)\r\n"
	    			+ "                    + (tongsogiotangca * 10817)\r\n"
	    			+ "                    + TroCap) * 0.08\r\n"
	    			+ "                WHEN (SELECT bhxh FROM CongNhan WHERE maCongNhan =?) = 1 THEN 0\r\n"
	    			+ "            END\r\n"
	    			+ "        )-phat \r\n"
	    			+ "        \r\n"
	    			+ "    )\r\n"
	    			+ "WHERE [maCN] = ? AND thang = MONTH(GETDATE()) AND nam = YEAR(GETDATE());");

	    		stmt.setString(1, maCN);
	    		stmt.setString(2, maCN);
	    		stmt.setString(3, maCN);
	    		stmt.setString(4, maCN);
	    		stmt.setString(5, maCN);
	    		stmt.setString(6, maCN);
//	    		stmt.setString(7, maCN);
//	    		stmt.setString(8, maCN);
//	    		stmt.setString(9, maCN);
	    		n = stmt.executeUpdate();

	 



	    	 

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return n > 0;
	}

 
}
