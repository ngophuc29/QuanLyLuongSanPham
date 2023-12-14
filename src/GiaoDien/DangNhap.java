package GiaoDien;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;

import Dao.nhanVienDAO;
import Database.ConnectDB;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txttk;
	private nhanVienDAO nvdao=new nhanVienDAO();
	
	private JPasswordField txtmk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap() throws SQLException {
		Image icon= new ImageIcon (this.getClass().getResource("/image/worker (1).png")).getImage(); 
		this.setIconImage(icon);
 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1211, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(DangNhap.class.getResource("/image/hinhdangnhap.jpg")));
		lblNewLabel.setBounds(0, -13, 616, 612);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CÔNG TY CỔ PHẦN THỜI TRANG EVASHOES");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(678, 99, 478, 59);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tài Khoản");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(678, 202, 94, 36);
		contentPane.add(lblNewLabel_2);
		
		txttk = new JTextField();
		txttk.setBounds(841, 204, 253, 36);
		contentPane.add(txttk);
		txttk.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật Khẩu");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(678, 286, 94, 36);
		contentPane.add(lblNewLabel_2_1);
		
		txtmk = new JPasswordField();
		txtmk.setBounds(841, 288, 253, 36);
		contentPane.add(txtmk);
		
		JButton btnDangNhap = new FixButton("Đăng Nhập");
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDangNhap.setBounds(678, 390, 468, 71);
		contentPane.add(btnDangNhap);
		
		
		
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB.getInstance();
				Connection con =ConnectDB.getConnection();
				try {
					
					 
					String sqlLogin="Select * From nhanvien where idtaikhoan=? and matkhau =?";
				 
						PreparedStatement pst = con.prepareStatement(sqlLogin);
						 pst.setString(1, txttk.getText());
						pst.setString(2, txtmk.getText());
						
						ResultSet rs= pst.executeQuery();
					
						
						if(txttk.getText().equals("")||txtmk.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa nhập tài khoàn hoặc mật khẩu!!");
						}
						else if(rs.next()) {
							UiChinh2 tc= new UiChinh2();
//							datPhong dt= new datPhong();
							tc.setVisible(true);
							
//							tc.txtmanvdn.setText(txttk.getText());
//							dt.txtmanvintable.setText(txttk.getText());
//							maNV=txttk.getText();
							//Phân quyền
						 
							 
							 
							 
						 
							//Phân quyền
							String input =  txttk.getText(); // Lấy chuỗi đầu vào từ JTextField
							
//							String laychucvu = nvdao.laychucvu(input);
						 ;
							
							if(input.equals("QLPX")) {
							 
//								tc.txtquyendangnhap.setText("Nhân Viên");
								 tc.mnNewMenu.setText("Quản Lý Phân Xưởng");
								tc.panelnhanvien.setVisible(false);
								tc.panelthongke.setVisible(false);
								
								tc.panelcongnhan.setBounds(0, 76, 258, 54);
								tc.panelsanpham.setBounds(0, 206, 258, 54);
								
								
								tc.panelnhanvien.setBackground(Color.GRAY);
								tc.panelnhanvien.removeMouseListener(tc.panelnhanvien.getMouseListeners()[0]);
								
								tc.panelthongke.setEnabled(false);
								tc.panelthongke.setBackground(Color.GRAY);
								tc.panelthongke.removeMouseListener(tc.panelthongke.getMouseListeners()[0]);
								
								tc.panelnhanvien.setToolTipText("Mục Này Dành Cho Quản lý");
								tc.panelthongke.setToolTipText("Mục Này Dành Cho Kế toán và quản lý");
							}
							else if  (input.equals("KETOAN")){
								 tc.mnNewMenu.setText("Kế Toán");
						 
						 
//								tc.panelnhanvien.removeMouseListener(tc.panelnhanvien.getMouseListeners()[0]);

								
								tc.panelsanpham.setVisible(false);
								 
								tc.panelsanpham.removeMouseListener(tc.panelsanpham.getMouseListeners()[0]);
								
								 
						 
//								tc.panelcongnhan.removeMouseListener(tc.panelcongnhan.getMouseListeners()[0]);
								
								tc.panelthongke.setVisible(false);
								
								
								tc.panelnhanvien.setToolTipText("Mục Này Dành Cho Quản lý");
								tc.panelthongke.setToolTipText("Mục Này Dành Cho Kế toán và quản lý");
								tc.panelthongke.setToolTipText("Mục Này Dành Cho Kế toán và quản lý phân xưởng");
							}
							else {
								 tc.mnNewMenu.setText("Quản lý");
									tc.panelnhanvien.setVisible(true);
									tc.panelsanpham.setVisible(true);
									tc.panelcongnhan.setVisible(true);
									tc.panelthongke.setVisible(true);
									 
							}
							
							
							
							// End Phân Quyền
							
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
							dispose();
							 
						}
						else {
							JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}
