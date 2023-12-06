package GiaoDien;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import Dao.BangLuongCongNhanDAO;
import Dao.thongkeDAO;
import Entity.BangLuongNhanVien;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.QuadCurve2D;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class TabThongKe extends JPanel {

	/**
	 * Create the panel.
	 */
	private thongkeDAO tkdao= new thongkeDAO();
	 private int[] tongSoLuong   ;
	    private String[] tenSP  ;
//	
	public TabThongKe() {
		 
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1365, 799);
		add(tabbedPane);
		
		JPanel panelQuanLyNhanVien = new JPanel();
		tabbedPane.addTab("Thống kê lương", null, panelQuanLyNhanVien, null);
		panelQuanLyNhanVien.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(13, 152, 204));
		panel.setBounds(10, 11, 1365, 765);
		panelQuanLyNhanVien.add(panel);
		
		FixButton lammoithemcongdoan = new FixButton("Lọc");
		lammoithemcongdoan.setIcon(new ImageIcon(TabThongKe.class.getResource("/image/search.png")));
		lammoithemcongdoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lammoithemcongdoan.setForeground(new Color(255, 255, 255));
		lammoithemcongdoan.setBackground(new Color(69, 129, 142));
		lammoithemcongdoan.setBounds(687, 282, 150, 40);
		panel.add(lammoithemcongdoan);
		
		FixButton btnlammoithongkeluong = new FixButton("Làm Mới");
		btnlammoithongkeluong.setIcon(new ImageIcon(TabThongKe.class.getResource("/image/reload (1).png")));
		btnlammoithongkeluong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnlammoithongkeluong.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnlammoithongkeluong.setForeground(new Color(255, 255, 255));
		btnlammoithongkeluong.setBackground(new Color(0, 158, 15));
		btnlammoithongkeluong.setBounds(914, 282, 150, 40);
		panel.add(btnlammoithongkeluong);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(114, 67, 251, 124);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel("Tổng công nhân");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(69, 11, 133, 19);
		panel_1_1.add(lblNewLabel);
		
		JLabel tongluongcongnhan = new JLabel("tongluongcongnhanoday");
		tongluongcongnhan.setHorizontalAlignment(SwingConstants.CENTER);
		tongluongcongnhan.setFont(new Font("Dialog", Font.BOLD, 15));
		tongluongcongnhan.setBounds(10, 61, 231, 19);
		panel_1_1.add(tongluongcongnhan);
		
		
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(533, 67, 251, 124);
		panel.add(panel_1_1_1);
		
		JLabel lblTngNhnVin = new JLabel("Tổng nhân viên");
		lblTngNhnVin.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTngNhnVin.setBounds(69, 11, 133, 19);
		panel_1_1_1.add(lblTngNhnVin);
		
		JLabel tongluongnhanvien = new JLabel("tongluongcongnhanoday");
		tongluongnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		tongluongnhanvien.setFont(new Font("Dialog", Font.BOLD, 15));
		tongluongnhanvien.setBounds(10, 64, 231, 19);
		panel_1_1_1.add(tongluongnhanvien);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(957, 67, 251, 124);
		panel.add(panel_1_2);
		
		JLabel lblTngS = new JLabel("Tổng số Lương");
		lblTngS.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTngS.setBounds(67, 11, 133, 19);
		panel_1_2.add(lblTngS);
		
		JLabel tongluong = new JLabel("tongluongcongnhanoday");
		tongluong.setHorizontalAlignment(SwingConstants.CENTER);
		tongluong.setFont(new Font("Dialog", Font.BOLD, 15));
		tongluong.setBounds(10, 65, 231, 19);
		panel_1_2.add(tongluong);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tháng");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(114, 282, 78, 36);
		panel.add(lblNewLabel_2_1);
		
		JComboBox thangthongKeLuong = new JComboBox();
		thangthongKeLuong.setBounds(202, 290, 78, 28);
		panel.add(thangthongKeLuong);
		
		thangthongKeLuong.addItem("1");
		thangthongKeLuong.addItem("2");
		thangthongKeLuong.addItem("3");
		thangthongKeLuong.addItem("4");
		thangthongKeLuong.addItem("5");
		thangthongKeLuong.addItem("6");
		thangthongKeLuong.addItem("7");
		thangthongKeLuong.addItem("8");
		thangthongKeLuong.addItem("9");
		thangthongKeLuong.addItem("10");
		thangthongKeLuong.addItem("11");
		thangthongKeLuong.addItem("12");
		
		
		
		LocalDate locallaythangnamhientai = LocalDate.now();
		int thang = locallaythangnamhientai.getMonthValue();
		 
		thangthongKeLuong.setSelectedItem(thang+"");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Năm");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(356, 282, 78, 36);
		panel.add(lblNewLabel_2_1_1);
		
		
		
		
		JComboBox namthongke = new JComboBox();
		namthongke.setBounds(430, 290, 78, 28);
		panel.add(namthongke);
		
		namthongke.addItem("2022");
		namthongke.addItem("2023");
		namthongke.addItem("2024");
		namthongke.addItem("2025");
		namthongke.addItem("2026");
		namthongke.addItem("2027");
		
		
 
		
		 int namHienTai = LocalDate.now().getYear();

	        // Đặt giá trị mặc định cho `JComboBox` là năm hiện tại
		 namthongke.setSelectedItem(String.valueOf(namHienTai));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(42, 351, 1253, 386);
		panel.add(tabbedPane_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane_1.addTab("Nhân Viên", null, panel_2, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1228, 353);
		panel_2.add(scrollPane);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		tabbedPane_1.addTab("Công Nhân", null, panel_3_1, null);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 11, 1228, 353);
		panel_3_1.add(scrollPane_1_1);
		
		JPanel panelccnv = new JPanel();
		tabbedPane.addTab("Thống kê sản phâm", null, panelccnv, null);
		panelccnv.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1338, 760);
		panelccnv.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(13, 152, 204));
		panel_3.setBounds(10, 11, 1328, 738);
		panel_1.add(panel_3);
		
		FixButton lammoithemcongdoan_1 = new FixButton("Lọc");
		lammoithemcongdoan_1.setIcon(new ImageIcon(TabThongKe.class.getResource("/image/search.png")));
		lammoithemcongdoan_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lammoithemcongdoan_1.setForeground(Color.WHITE);
		lammoithemcongdoan_1.setBackground(new Color(69, 129, 142));
		lammoithemcongdoan_1.setBounds(651, 218, 150, 40);
		panel_3.add(lammoithemcongdoan_1);
		
		FixButton btnthongkesanpham = new FixButton("Làm Mới");
		btnthongkesanpham.setIcon(new ImageIcon(TabThongKe.class.getResource("/image/reload (1).png")));
		btnthongkesanpham.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthongkesanpham.setForeground(Color.WHITE);
		btnthongkesanpham.setBackground(new Color(0, 158, 15));
		btnthongkesanpham.setBounds(871, 218, 150, 40);
		panel_3.add(btnthongkesanpham);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(761, 67, 438, 124);
		panel_3.add(panel_1_2_1);
		
		JLabel lblTngS_1 = new JLabel("Tổng số Doanh Thu");
		lblTngS_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTngS_1.setBounds(152, 11, 154, 19);
		panel_1_2_1.add(lblTngS_1);
		
		JLabel tongdoanhthu = new JLabel("<dynamic>");
		tongdoanhthu.setHorizontalAlignment(SwingConstants.CENTER);
		tongdoanhthu.setFont(new Font("Dialog", Font.BOLD, 15));
		tongdoanhthu.setBounds(10, 57, 418, 19);
		panel_1_2_1.add(tongdoanhthu);
		
		JLabel lblNewLabel_2 = new JLabel("Tháng");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(141, 219, 78, 36);
		panel_3.add(lblNewLabel_2);
		
		JComboBox thangthongsanpham = new JComboBox();
		thangthongsanpham.setBounds(224, 226, 78, 28);
		panel_3.add(thangthongsanpham);
		
		
		thangthongsanpham.addItem("1");
		thangthongsanpham.addItem("2");
		thangthongsanpham.addItem("3");
		thangthongsanpham.addItem("4");
		thangthongsanpham.addItem("5");
		thangthongsanpham.addItem("6");
		thangthongsanpham.addItem("7");
		thangthongsanpham.addItem("8");
		thangthongsanpham.addItem("9");
		thangthongsanpham.addItem("10");
		thangthongsanpham.addItem("11");
		thangthongKeLuong.addItem("12");
		
		
		
		 
		 
		thangthongsanpham.setSelectedItem(thang+"");
		
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Năm");
		lblNewLabel_2_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2.setBounds(338, 219, 78, 36);
		panel_3.add(lblNewLabel_2_1_2);
		
		JComboBox namthongKesanpham = new JComboBox();
		namthongKesanpham.setBounds(418, 226, 78, 28);
		panel_3.add(namthongKesanpham);
		
		
		namthongKesanpham.addItem("2022");
		namthongKesanpham.addItem("2023");
		namthongKesanpham.addItem("2024");
		namthongKesanpham.addItem("2025");
		namthongKesanpham.addItem("2026");
		namthongke.addItem("2027");
		
		
 
		
		  

	        // Đặt giá trị mặc định cho `JComboBox` là năm hiện tại
		 namthongKesanpham.setSelectedItem(String.valueOf(namHienTai));
		
		JPanel panel_1_2_1_1 = new JPanel();
		panel_1_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1_2_1_1.setLayout(null);
		panel_1_2_1_1.setBounds(130, 67, 438, 124);
		panel_3.add(panel_1_2_1_1);
		
		JLabel lblTngSSn = new JLabel("Tổng số sản phẩm hoàn thành");
		lblTngSSn.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTngSSn.setBounds(165, 11, 133, 19);
		panel_1_2_1_1.add(lblTngSSn);
		
		JLabel tongsanpham = new JLabel("<dynamic>");
		tongsanpham.setHorizontalAlignment(SwingConstants.CENTER);
		tongsanpham.setFont(new Font("Dialog", Font.BOLD, 15));
		tongsanpham.setBounds(10, 61, 418, 19);
		panel_1_2_1_1.add(tongsanpham);
		 
 

		
		//set các tổng lương
		tongluongnhanvien.setText(tkdao.tongluongnhanvien(Integer.parseInt(thangthongKeLuong.getSelectedItem().toString()), Integer.parseInt(namthongke.getSelectedItem().toString()))+"");
		tongluongcongnhan.setText(tkdao.tongluongcongnhan(Integer.parseInt(thangthongKeLuong.getSelectedItem().toString()), Integer.parseInt(namthongke.getSelectedItem().toString()))+"");
		tongluong.setText(tkdao.tongluong(Integer.parseInt(thangthongKeLuong.getSelectedItem().toString()), Integer.parseInt(namthongke.getSelectedItem().toString()))+"");
		
		
		
		tongdoanhthu.setText(tkdao.tongdoanhthu(Integer.parseInt(thangthongsanpham.getSelectedItem().toString()), Integer.parseInt(namthongKesanpham.getSelectedItem().toString()))+"");
		tongsanpham.setText(tkdao.tongsanphamhoanthanh(Integer.parseInt(thangthongsanpham.getSelectedItem().toString()), Integer.parseInt(namthongKesanpham.getSelectedItem().toString()))+"");
		
		 
		List<Integer> tongluonng = tkdao.tongSoLuong(Integer.parseInt(thangthongsanpham.getSelectedItem().toString()), Integer.parseInt(namthongKesanpham.getSelectedItem().toString()));

		 tongSoLuong = new int[tongluonng.size()];

		for (int i = 0; i < tongluonng.size(); i++) {
		    tongSoLuong[i] = tongluonng.get(i);
		    
		    
		    System.out.println(tongSoLuong[i]);
		}
		 
		List<String> dssp = tkdao.tensanpham( );

		  tenSP = new String[dssp.size()];

		for (int i = 0; i < dssp.size(); i++) {
			tenSP[i] = dssp.get(i);
		    
		    System.out.println(tenSP[i]);
		}

		// Use the tenSP array here
		
		
		JPanel chartPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int padding = 50;
                int width = getWidth() - 2 * padding;
                int height = getHeight() - 2 * padding;

                // Vẽ trục x và trục y
                g2d.drawLine(padding, getHeight() - padding, getWidth() - padding, getHeight() - padding);
                g2d.drawLine(padding, padding, padding, getHeight() - padding);

                // Vẽ các đường thẳng đánh dấu cho các giá trị trục y
                int numTicks = 11; // Số lượng đường thẳng đánh dấu trục y
                int tickSpacing = height / (numTicks - 1);

                for (int i = 0; i < numTicks; i++) {
                    int x = padding;
                    int y = getHeight() - padding - i * tickSpacing;

                    g2d.drawLine(x, y, x - 5, y);
                    g2d.drawString(String.valueOf(i * 500), x - 40, y + 5);
                }

                // Tính toán độ dài của mỗi cột
                int columnWidth = width / tenSP.length;

                // Vẽ các điểm dữ liệu và đường cong giữa chúng
                for (int i = 0; i < tenSP.length; i++) {
                    int x = padding + i * columnWidth + columnWidth / 2;
                    int y = getHeight() - padding - (int) (((double) tongSoLuong[i] / getMaxValue()) * height);

                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(x - 5, y - 5, 10, 10);

                    if (i > 0) {
                        int prevX = padding + (i - 1) * columnWidth + columnWidth / 2;
                        int prevY = getHeight() - padding - (int) (((double) tongSoLuong[i - 1] / getMaxValue()) * height);

                        g2d.setColor(Color.RED);
                        g2d.draw(curvedLine(prevX, prevY, x, y));
                    }

                    g2d.setColor(Color.BLACK);
                    g2d.drawString(tenSP[i], x - 20, getHeight() - padding + 15);
                    g2d.drawString(String.valueOf(tongSoLuong[i]), x - 10, y - 10);
                }
            }
        };

        
        chartPanel.setBounds(44, 277, 1238, 428);
        panel_3.add(chartPanel);
      
    }

   
		 
	 
 
	 private int getMaxValue() {
	        int max = tongSoLuong[0];
	        for (int value : tongSoLuong) {
	            if (value > max) {
	                max = value;
	            }
	        }
	        return max;
	    }

	    private Shape curvedLine(int x1, int y1, int x2, int y2) {
	        int ctrlX = (x1 + x2) / 2;
	        int ctrlY = Math.min(y1, y2) - Math.abs(x1 - x2) / 2;

	        return new QuadCurve2D.Double(x1, y1, ctrlX, ctrlY, x2, y2);
	    }
}
