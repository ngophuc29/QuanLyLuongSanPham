package Dao;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import Entity.ChamCongNhanVien;
import GiaoDien.TabNhanVien;
import GiaoDien.UiChinh2;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;

public class test {

    private static final int FRAME_WIDTH = 640;
    private static final int FRAME_HEIGHT = 480;
    private String manv;
    private JFrame frame;
    private JLabel imageLabel;
    private List<String> listnv=new ArrayList<>();
    private MultiFormatReader multiFormatReader;
    private ChamCongNhanVienDAO ccnv;
    public static int check=1;
    public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public List<String> getListnv() {
		return listnv;
	}

	public void setListnv(List<String> listnv) {
		this.listnv = listnv;
	}

	public test() {
		Database.ConnectDB.getInstance().connect();
        multiFormatReader = new MultiFormatReader();
        initGUI();
    }

    private void initGUI() {
        frame = new JFrame("Camera QR Scanner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        frame.getContentPane().add(imageLabel);

        frame.pack();
        frame.setVisible(true);
    }

    public void start() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::processFrame, 0, 33, TimeUnit.MILLISECONDS);
    }

    private int processFrame() {
        Mat frame = new Mat();
        VideoCapture capture = new VideoCapture(0);
        capture.set(Videoio.CAP_PROP_FRAME_WIDTH, FRAME_WIDTH);
        capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, FRAME_HEIGHT);

        if (capture.read(frame)) {
            BufferedImage image = matToBufferedImage(frame);
        
            ImageIcon icon = new ImageIcon(image);
            imageLabel.setIcon(icon);

            scanQRCode(frame);
        }

        capture.release();
        return 1;
    }

    private void scanQRCode(Mat frame) {
        LuminanceSource source = new BufferedImageLuminanceSource(matToBufferedImage(frame));
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        
        try {
        	Thread.sleep(2000);
            Result result = multiFormatReader.decode(bitmap);
            String qrData = result.getText();
           
            chamcong(qrData);
            
            // Thực hiện các xử lý khác với qrData tại đây

        } catch (Exception e) {
            // Không tìm thấy mã QR
//        	System.out.println("Lỗi: " + e.getMessage());
        }
    }
    private void chamcong(String qrData) {
    	LocalDate locallaythangnamhientai = LocalDate.now();
        ccnv=new ChamCongNhanVienDAO();
        List<ChamCongNhanVien> list= ccnv.getchamcongdahiendien(locallaythangnamhientai);    
        int a=0;
        for (ChamCongNhanVien chamCongNhanVien : list) {
        	
        	if(qrData.equals(chamCongNhanVien.getNV().getMaNV())) {
        		a=1;
        	}
        	
		}
        if(a==0) {
        	ccnv.updateChamCong1(2, qrData, locallaythangnamhientai);
      		 System.out.println("Điểm danh thành công");
      		 
        }else {
        	System.out.println("Nhân viên đã điểm danh");
        	
        }
    }
    private BufferedImage matToBufferedImage(Mat mat) {
        MatOfByte buffer = new MatOfByte();
        org.opencv.imgcodecs.Imgcodecs.imencode(".png", mat, buffer);
        byte[] bytes = buffer.toArray();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        
        try {
            return ImageIO.read(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        SwingUtilities.invokeLater(() -> {
//            test scanner = new test();
//            scanner.start();
//        });
//    }
}