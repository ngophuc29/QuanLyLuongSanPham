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
import Entity.NhanVien;

 

public class nhanVienDAO {
	
	
	public List<NhanVien> getAllnhanvien(){
		List<NhanVien> dsnv=new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from NhanVien";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				
				java.sql.Date sqlDate = rs.getDate(8);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
	            
	            java.sql.Date sqlDatesinh = rs.getDate(7);
	            // Chuyển đổi thành LocalDate
	            LocalDate sqlDatesinhh = sqlDatesinh.toLocalDate();
	            
	            
	            dsnv.add(new  NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6),sqlDatesinhh,ngaybatdaulamViec,rs.getString(9),rs.getFloat(10), rs.getDouble(11),rs.getInt(12),rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getDouble(16),rs.getString(17),rs.getString(18)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	
	
	public static boolean themDanhSachNV(NhanVien nv) {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into NhanVien (tenNV,sodienthoai,diachi,chucvu,gioitinh,ngaySinh,ngaybatdaulamViec,cmnd,hesoluong,idtaikhoan,matkhau,luongcoban,trinhdo,email,bhxh,trangthai,troCap) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//			stmt.setString(1, nv.getMaNV());
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getSodienthoai());
			stmt.setString(3, nv.getDiachi());
			stmt.setString(4, nv.getChucVu());
			stmt.setBoolean(5, nv.getGioitinh());
			stmt.setDate(6, Date.valueOf(nv.getNgaySinh()));
			stmt.setDate(7, Date.valueOf(nv.getNgaybatdaulamViec()));
			stmt.setString(8, nv.getCmnd());
			stmt.setFloat(9, nv.getHeSoLuong());
			stmt.setString(10, nv.getIdtaikhoan());
			stmt.setString(11, nv.getMatkhau());
			stmt.setDouble(12, nv.getLuongcoban());
			stmt.setInt(13, nv.getTrinhdo());
			stmt.setString(14, nv.getEmail());
			stmt.setInt(15, nv.getBhxh());
			stmt.setInt(16, nv.getTrangthai());
			stmt.setDouble(17, nv.getTroCap());
			 
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}  
		return n>0;
	}

	public List<NhanVien> getAllnhanvienTheoten(String ten){
		List<NhanVien> dsnv=new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT * from NhanVien where tenNV=? ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1, ten);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				
				java.sql.Date sqlDate = rs.getDate(8);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
	            
	            java.sql.Date sqlDatesinh = rs.getDate(7);
	            // Chuyển đổi thành LocalDate
	            LocalDate sqlDatesinhh = sqlDatesinh.toLocalDate();
	            
				
	            dsnv.add(new  NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6),sqlDatesinhh,ngaybatdaulamViec,rs.getString(9),rs.getFloat(10), rs.getDouble(11),rs.getInt(12),rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getDouble(16),rs.getString(17),rs.getString(18)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	
	
	public List<NhanVien> getAllnhanvienTheoChucVu(String chucvu){
		List<NhanVien> dsnv=new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT * from NhanVien where chucvu=? ";
			PreparedStatement statement= con.prepareStatement(sql);
			 
			statement.setString(1, chucvu);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				
				java.sql.Date sqlDate = rs.getDate(8);
	            // Chuyển đổi thành LocalDate
	            LocalDate ngaybatdaulamViec = sqlDate.toLocalDate();
	            
	            java.sql.Date sqlDatesinh = rs.getDate(7);
	            // Chuyển đổi thành LocalDate
	            LocalDate sqlDatesinhh = sqlDatesinh.toLocalDate();
	            
				
	            dsnv.add(new  NhanVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6),sqlDatesinhh,ngaybatdaulamViec,rs.getString(9),rs.getFloat(10), rs.getDouble(11),rs.getInt(12),rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getDouble(16),rs.getString(17),rs.getString(18)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
 
	public static boolean update(NhanVien nv) {
		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("update NhanVien set tenNV=?,sodienthoai=?,diachi=?,chucvu=?,gioitinh=?,ngaySinh=?,ngaybatdaulamViec=?,cmnd=?,hesoluong=?,idtaikhoan=?,luongcoban=?,trinhdo=?,email=?,bhxh=?,trangthai=?,troCap=?  where maNV=? ");
			
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getSodienthoai());
			stmt.setString(3, nv.getDiachi());
			stmt.setString(4, nv.getChucVu());
			stmt.setBoolean(5, nv.getGioitinh());
			stmt.setDate(6, Date.valueOf(nv.getNgaySinh()));
			stmt.setDate(7, Date.valueOf(nv.getNgaybatdaulamViec()));
			stmt.setString(8, nv.getCmnd());
			stmt.setFloat(9, nv.getHeSoLuong());
			stmt.setString(10, nv.getIdtaikhoan());
			stmt.setDouble(11, nv.getLuongcoban());
			stmt.setInt(12, nv.getTrinhdo());
			stmt.setString(13, nv.getEmail());
			stmt.setInt(14, nv.getBhxh());
			stmt.setInt(15, nv.getTrangthai());
			stmt.setDouble(16, nv.getTroCap());
 
			stmt.setString(17, nv.getMaNV());
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
	
	// lấy chức vụ thông qua mã nhân viên
	public String laychucvu (String manv) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String p="";
        try {
           
            String sql = "select chucvu from NhanVien where maNV=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, manv); // set parameter value
             
      
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
}
 