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
import Entity.BangLuongCongNhan;
import Entity.BangLuongNhanVien;
import Entity.ChamCongCongNhan;
import Entity.ChamCongNhanVien;
import Entity.CongDoan;
import Entity.CongNhan;
import Entity.NhanVien;
import Entity.SanPham;

 

public class thongkeDAO {
 
	public String tongluongnhanvien(int thang ,int nam) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String p="";
        try {
           
            String sql = "SELECT CONCAT(FORMAT(SUM(tongluong), 'N0'), ' VNĐ')  \r\n"
            		+ "FROM (\r\n"
            		+ "select  tongluong  from BangLuongNhanVien where thang=? and nam=?\r\n"
            		+ " \r\n"
            		+ ") AS TongLuongTongCong;";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, thang); // set parameter value
            preparedStatement.setInt(2, nam);
       
            resultSet = preparedStatement.executeQuery();
             
            if (resultSet.next()) {
                p += resultSet.getString(1);
               System.out.println("Total salary for code 123: " + p);
           }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return p;
	}
	
	public String tongluongcongnhan(int thang ,int nam) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String p="";
        try {
           
            String sql = "SELECT CONCAT(FORMAT(SUM(tongluong), 'N0'), ' VNĐ')  \r\n"
            		+ "FROM (\r\n"
            		+ "select  tongluong  from BangLuongCongNhan where thang=? and nam=?\r\n"
            		+ " \r\n"
            		+ ") AS TongLuongTongCong;";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, thang); // set parameter value
            preparedStatement.setInt(2, nam);
       
            resultSet = preparedStatement.executeQuery();
             
            if (resultSet.next()) {
                p += resultSet.getString(1);
               System.out.println("Total salary for code 123: " + p);
           }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return p;
	}
	public String tongluong (int thang,int nam) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String p="";
        try {
           
            String sql = "SELECT CONCAT(FORMAT(SUM(tongluong), 'N0'), ' VNĐ')  \r\n"
+ "FROM (\r\n"
            		+ "SELECT tongluong\r\n"
            		+ "FROM BangLuongNhanVien\r\n"
            		+ "WHERE thang = ? AND nam = ?\r\n"
            		+ "UNION ALL\r\n"
            		+ "SELECT tongluong\r\n"
            		+ "FROM BangLuongCongNhan\r\n"
            		+ "WHERE thang = ? AND nam = ?\r\n"
            		+ ") AS TongLuongTongCong;";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, thang); // set parameter value
            preparedStatement.setInt(2, nam);
            preparedStatement.setInt(3, thang);
            preparedStatement.setInt(4, nam);
            resultSet = preparedStatement.executeQuery();
             
            if (resultSet.next()) {
                p += resultSet.getString(1);
               System.out.println("Total salary for code 123: " + p);
           }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return p;
	}
	
	
	public String tongdoanhthu (int thang,int nam) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String p="";
        try {
           
            String sql = " SELECT CONCAT(FORMAT(SUM(tongDoanhThu), 'N0'), ' VNĐ')\r\n"
            		+ "FROM (\r\n"
            		+ "    SELECT SUM(doanhThu) AS tongDoanhThu\r\n"
            		+ "    FROM (\r\n"
            		+ "        SELECT\r\n"
            		+ "            SP.maSP,\r\n"
            		+ "			CD.maCongDoan,\r\n"
            		+ "            SP.tenSP,\r\n"
            		+ "            SUM(CD.giaCongDoan) AS tongGiaCongDoan,\r\n"
            		+ "            SUM(CC.soluong) AS tongSoLuong,\r\n"
            		+ "            SP.giaSP,\r\n"
            		+ "            SUM(giaSP * CC.soluong) AS doanhThu\r\n"
            		+ "        FROM SanPham SP\r\n"
            		+ "        JOIN CongDoan CD ON SP.maSP = CD.maSP\r\n"
            		+ "        JOIN ChamCongCongNhan CC ON CD.maCongDoan = CC.macongdoan\r\n"
            		+ "        WHERE CD.tenCongDoan = 'Hoàn thành đôi giày'\r\n"
            		+ "          AND MONTH(CC.ngaycham) = ? AND YEAR(CC.ngaycham) = ?\r\n"
            		+ "        GROUP BY SP.maSP, SP.tenSP, SP.giaSP,CD.maCongDoan\r\n"
            		+ "    ) AS T\r\n"
            		+ ") AS TongLuongTongCong;";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, thang); // set parameter value
            preparedStatement.setInt(2, nam);
      
            resultSet = preparedStatement.executeQuery();
             
            if (resultSet.next()) {
                p += resultSet.getString(1);
               System.out.println("Total salary for code 123: " + p);
           }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return p;
	}
	
	public int tongsanphamhoanthanh (int thang,int nam) {
		ConnectDB.getInstance();
Connection con =ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int p=0;
        try {
           
            String sql = " SELECT sum(soluong)    \r\n"
            		+ "      \r\n"
            		+ "  FROM [QuanLyLuong_Nhom2].[dbo].[ChamCongCongNhan] cz\r\n"
            		+ "  join CongDoan cc on cc.maCongDoan=cz.macongdoan \r\n"
            		+ "  join SanPham sp on sp.maSP=cc.maSP\r\n"
            		+ "  where tenCongDoan='Hoàn thành đôi giày' and month(ngaycham)=? and year(ngaycham)=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, thang); // set parameter value
            preparedStatement.setInt(2, nam);
      
            resultSet = preparedStatement.executeQuery();
             
            if (resultSet.next()) {
                p += resultSet.getInt(1);
               System.out.println("Total salary for code 123: " + p);
           }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return p;
	}
	
	
	public List<Integer> tongSoLuong(int thang, int nam) {
	    List<Integer> ds = new ArrayList<>();
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    try {
	        String sql = "SELECT SUM(CC.soluong) AS tongSoLuong "
	                + "FROM SanPham SP "
	                + "JOIN CongDoan CD ON SP.maSP = CD.maSP "
	                + "JOIN ChamCongCongNhan CC ON CD.maCongDoan = CC.macongdoan "
	                + "WHERE CD.tenCongDoan = 'Hoàn thành đôi giày' "
	                + "AND MONTH(CC.ngaycham) = ? AND YEAR(CC.ngaycham) = ? "
	                + "GROUP BY SP.maSP, SP.tenSP, CD.maCongDoan";
	        PreparedStatement statement = con.prepareStatement(sql);

	        statement.setInt(1, thang);
	        statement.setInt(2, nam);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            int tongSoLuong = rs.getInt("tongSoLuong");
	            ds.add(tongSoLuong);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ds;
	}
	
	public List<String> tensanpham( ) {
	    List<String> ds = new ArrayList<>();
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    try {
	        String sql = " SELECT tenSP  FROM SanPham  ";
	        PreparedStatement statement = con.prepareStatement(sql);

	 
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	        	String tongSoLuong = rs.getString("tenSP");
	            ds.add(tongSoLuong);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ds;
	}
	
	public List<BangLuongNhanVien> getthongkeluongnhanvien( int thang , int nam ){
		List<BangLuongNhanVien> dsBangLuongNV=new ArrayList<BangLuongNhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
String sql="SELECT NhanVien.maNV ,tenNV,tongluong from BangLuongNhanVien\r\n"
					+ "			join NhanVien on NhanVien.maNV=BangLuongNhanVien.maNV\r\n"
					+ "			where  thang=? and nam=? order by tongluong desc ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			 
			statement.setInt(1, thang);
			statement.setInt(2, nam);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 ;
				
				 dsBangLuongNV.add(new BangLuongNhanVien(new NhanVien(rs.getString(1),rs.getString(2)),rs.getDouble(3) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
		return dsBangLuongNV;
	}
	
	
	public List<BangLuongCongNhan> getthongkeluongcongnhan( int thang , int nam ){
		List<BangLuongCongNhan> dstklcn=new ArrayList<BangLuongCongNhan>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql=" SELECT CongNhan.maCongNhan ,tenCongNhan ,  sum(soluong) ,tongluong from [BangLuongCongNhan]\r\n"
					+ "			join CongNhan on CongNhan.maCongNhan=[BangLuongCongNhan].maCN\r\n"
					+ "			join ChamCongCongNhan on ChamCongCongNhan.maCongNhan=[BangLuongCongNhan].maCN\r\n"
					+ "			where  thang=? and nam=? \r\n"
					+ "			group by CongNhan.maCongNhan ,tenCongNhan ,tongluong\r\n"
					+ "			order by tongluong,sum(soluong) desc";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			 
			statement.setInt(1, thang);
			statement.setInt(2, nam);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 ;
				
				 dstklcn.add( new BangLuongCongNhan(new CongNhan(rs.getString(1),rs.getString(2)),rs.getDouble(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
		return dstklcn;
	}
	
	
	
	public List<ChamCongCongNhan> getthongkesanpham( int thang , int nam ){
		List<ChamCongCongNhan> dstksp=new ArrayList<ChamCongCongNhan>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql=" SELECT sp.maSP,tenSP, SUM(soluong), SUM(soluong * giaSP)\r\n"
					+ "FROM ChamCongCongNhan cz\r\n"
					+ "JOIN CongDoan cc ON cc.maCongDoan = cz.macongdoan\r\n"
					+ "JOIN SanPham sp ON sp.maSP = cc.maSP\r\n"
					+ "WHERE tenCongDoan = 'Hoàn thành đôi giày' AND MONTH(ngaycham) = ? AND YEAR(ngaycham) = ?\r\n"
					+ "GROUP BY tenSP, sp.maSP;";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			 
			statement.setInt(1, thang);
			statement.setInt(2, nam);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				 ;
				
				 dstksp.add( new ChamCongCongNhan(new SanPham(rs.getString(1),rs.getString(2)),rs.getInt(3),rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
		return dstksp;
	}
	
}