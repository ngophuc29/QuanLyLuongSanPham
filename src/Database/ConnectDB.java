//package Database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ConnectDB {
//	public static Connection con =null;
//	private static ConnectDB instance =  new ConnectDB();
//	public static ConnectDB getinstance() {
//		return instance;
//	}
//	public void connect() throws SQLException{
//		
//			String url="jdbc:sqlserver://localhost:1433;databasename=QuanLyLuong_Nhom2";
//			String user="sa";
//			String password="sapassword";
//			con=DriverManager.getConnection(url, user, password);
//	}
//	public void disconnect() {
//		if(con!=null) {
//			try {
//				con.close();
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	public static Connection getConnection() {
//		return con;
//	}
//}
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection con = null;
    private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }

    public void connect() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyLuong_Nhom2";
        
        String user = "sa";
        String password = "sapassword";

        try {
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Đã đóng kết nối cơ sở dữ liệu.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
