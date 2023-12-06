package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;

//import Dao.test;

//import Database.ConnectDB;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class UiChinh2 extends JFrame {

	private JPanel contentPane;
	 
	public JPanel panelnhanvien;
	public JPanel panelcongnhan;
	public JPanel panelsanpham;
	public JPanel panelthongke;
	public JMenu mnNewMenu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiChinh2 frame = new UiChinh2();
					frame.setVisible(true);
//					System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//			        SwingUtilities.invokeLater(() -> {
//			            test scanner = new test();
//			            scanner.start();
//			        });
			       
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public UiChinh2() {
		
//		ConnectDB.getInstance().connect();
		
		setLocationRelativeTo(null);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1648, 833);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 152, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1632, 22);
		contentPane.add(menuBar);
		
		  mnNewMenu = new JMenu("Nhân Viên A");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Đăng Xuất");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Hệ Thống");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Hỗ Trợ");
		mnNewMenu_1.add(mntmNewMenuItem_1);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(258, 22, 1374, 772);
        contentPane.add(mainPanel);

        // Tạo một JLabel để hiển thị hình ảnh
        JLabel imageLabel = new JLabel();

        // Tạo ImageIcon từ hình ảnh và gán vào JLabel
        ImageIcon imageIcon = new ImageIcon(UiChinh2.class.getResource("/image/hinhnenchinh.jpg"));
        
        
        mainPanel.setLayout(new CardLayout(0, 0));
        imageLabel.setIcon(imageIcon);
        mainPanel.add(imageLabel, "name_163805171265800");
        
          panelnhanvien = new JPanel();
        panelnhanvien.setBackground(new Color(13, 152, 204));
      
        panelnhanvien.setBounds(0, 76, 258, 54);
        contentPane.add(panelnhanvien);
        panelnhanvien.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Nhân Viên");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(49, 189, 242));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(116, 11, 121, 32);
        panelnhanvien.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(UiChinh2.class.getResource("/image/receptionist.png")));
        lblNewLabel_1.setBounds(30, 0, 69, 64);
        panelnhanvien.add(lblNewLabel_1);
        
          panelcongnhan = new JPanel();
        panelcongnhan.setBackground(new Color(13, 152, 204));
        panelcongnhan.setForeground(new Color(13, 152, 204));
       
        panelcongnhan.setLayout(null);
        panelcongnhan.setBounds(0, 206, 258, 54);
        contentPane.add(panelcongnhan);
        
        JLabel lblCngNhn = new JLabel("Công Nhân ");
        lblCngNhn.setForeground(new Color(255, 255, 255));
        lblCngNhn.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblCngNhn.setBounds(114, 11, 121, 32);
        panelcongnhan.add(lblCngNhn);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon(UiChinh2.class.getResource("/image/worker (1).png")));
        lblNewLabel_1_1.setBounds(24, 0, 69, 64);
        panelcongnhan.add(lblNewLabel_1_1);
        
          panelsanpham = new JPanel();
        panelsanpham.setBackground(new Color(13, 152, 204));
    
        panelsanpham.setLayout(null);
        panelsanpham.setBounds(0, 335, 258, 64);
        contentPane.add(panelsanpham);
        
        JLabel lblSnPhm = new JLabel("Sản Phẩm");
        lblSnPhm.setForeground(new Color(255, 255, 255));
        lblSnPhm.setBackground(new Color(255, 255, 255));
        lblSnPhm.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSnPhm.setBounds(116, 21, 98, 32);
        panelsanpham.add(lblSnPhm);
        
        JLabel lblNewLabel_1_2 = new JLabel("");
        lblNewLabel_1_2.setIcon(new ImageIcon(UiChinh2.class.getResource("/image/sneakers.png")));
        lblNewLabel_1_2.setBounds(23, 0, 64, 64);
        panelsanpham.add(lblNewLabel_1_2);
        
          panelthongke = new JPanel();
          
          
     
        panelthongke.setBackground(new Color(13, 152, 204));
        panelthongke.setForeground(new Color(13, 152, 204));
        panelthongke.setLayout(null);
        panelthongke.setBounds(0, 476, 258, 54);
        contentPane.add(panelthongke);
        
        JLabel lblThngK = new JLabel("Thống Kê");
        lblThngK.setForeground(new Color(255, 255, 255));
        lblThngK.setBackground(new Color(13, 152, 204));
        lblThngK.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblThngK.setBounds(111, 11, 121, 32);
        panelthongke.add(lblThngK);
        
        JLabel lblNewLabel_1_3 = new JLabel("");
        lblNewLabel_1_3.setIcon(new ImageIcon(UiChinh2.class.getResource("/image/pie-chart.png")));
        lblNewLabel_1_3.setBounds(21, 0, 69, 64);
        panelthongke.add(lblNewLabel_1_3);
        
        JButton btnNewButton = new JButton("Đăng xuất");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    DangNhap dn = new DangNhap();
                    dn.setVisible(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(254, 61, 66));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnNewButton.setBounds(10, 659, 238, 54);
        contentPane.add(btnNewButton);
    	
    	 
        
        panelnhanvien.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		TabNhanVien tnv= new TabNhanVien();
//        		tnv.startTimer();
	           
        		panelnhanvien.setBackground(new Color(121 ,213,247));
        		panelcongnhan.setBackground(new Color(13, 152, 204));
        		panelsanpham.setBackground(new Color(13, 152, 204));
        		panelthongke.setBackground(new Color(13, 152, 204));
        		
                 mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
                 mainPanel.add(tnv, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
                 mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới
        	}
        });

        
        panelcongnhan.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		TabCongNhan tCn= new TabCongNhan();
       		 
        		panelcongnhan.setBackground(new Color(121 ,213,247));
        		panelnhanvien.setBackground(new Color(13, 152, 204));
        		panelsanpham.setBackground(new Color(13, 152, 204));
        		panelthongke.setBackground(new Color(13, 152, 204));
        		
        		
        		
        		
                mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
                mainPanel.add(tCn, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
                mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới
        	}
        });
        
        panelsanpham.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		TabSanPham tsp= new TabSanPham();
          		 
        		panelsanpham.setBackground(new Color(121 ,213,247));
        		panelcongnhan.setBackground(new Color(13, 152, 204));
        		panelnhanvien.setBackground(new Color(13, 152, 204));
        		panelthongke.setBackground(new Color(13, 152, 204));
        		
        		
        		
                mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
                mainPanel.add(tsp, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
                mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới
        		
        	}
        });
        
        panelthongke.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		TabThongKe ttk= new TabThongKe();
         		 
        		panelthongke.setBackground(new Color(121 ,213,247));
        		panelcongnhan.setBackground(new Color(13, 152, 204));
        		panelnhanvien.setBackground(new Color(13, 152, 204));
        		panelsanpham.setBackground(new Color(13, 152, 204));
        		
        		
        		
                mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
                mainPanel.add(ttk, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
                mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới
        		
        	}
        });
        
        
	}
	
}
