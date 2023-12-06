package Entity;

import java.time.LocalDate;

public class BangPhanCong {
	 
	private CongNhan maCongNhan;
	private String tenCongnhan;
	private CongDoan maCongDoan;
	private LocalDate ngayCham;
	private int trangthaiphancong;
	private int soluongphancong;
	
	private CongDoanDonhang congdoandonhang;
	public BangPhanCong(CongNhan maCongNhan, CongDoan maCongDoan, LocalDate ngayCham, int trangthaiphancong) {
		super();
		this.maCongNhan = maCongNhan;
		this.maCongDoan = maCongDoan;
		this.ngayCham = ngayCham;
		this.trangthaiphancong = trangthaiphancong;
	}
	
	public BangPhanCong(CongNhan maCongNhan, CongDoan maCongDoan, LocalDate ngayCham, int trangthaiphancong,CongDoanDonhang congdoandonhang,int soluongphancong) {
		super();
		this.maCongNhan = maCongNhan;
		this.maCongDoan = maCongDoan;
		this.ngayCham = ngayCham;
		this.trangthaiphancong = trangthaiphancong;
		this.congdoandonhang=congdoandonhang;
		this.soluongphancong=soluongphancong;
	}
	
	public CongDoanDonhang getCongdoandonhang() {
		return congdoandonhang;
	}

	public void setCongdoandonhang(CongDoanDonhang congdoandonhang) {
		this.congdoandonhang = congdoandonhang;
	}

	public BangPhanCong(CongNhan maCongNhan, String tenCongnhan, CongDoan maCongDoan, LocalDate ngayCham,
			int trangthaiphancong) {
		super();
		this.maCongNhan = maCongNhan;
		this.tenCongnhan = tenCongnhan;
		this.maCongDoan = maCongDoan;
		this.ngayCham = ngayCham;
		this.trangthaiphancong = trangthaiphancong;
	}
	
	
	//
	public BangPhanCong(CongNhan maCongNhan, String tenCongnhan, CongDoan maCongDoan, LocalDate ngayCham,
			int trangthaiphancong,int soluongphancong) {
		super();
		this.maCongNhan = maCongNhan;
		this.tenCongnhan = tenCongnhan;
		this.maCongDoan = maCongDoan;
		this.ngayCham = ngayCham;
		this.trangthaiphancong = trangthaiphancong;
		this.soluongphancong=soluongphancong;
	}
	//
	
	public String getTenCongnhan() {
		return tenCongnhan;
	}
	public int getSoluongphancong() {
		return soluongphancong;
	}

	public void setSoluongphancong(int soluongphancong) {
		this.soluongphancong = soluongphancong;
	}
	public void setTenCongnhan(String tenCongnhan) {
		this.tenCongnhan = tenCongnhan;
	}

	public CongNhan getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(CongNhan maCongNhan) {
		this.maCongNhan = maCongNhan;
	}
	public CongDoan getMaCongDoan() {
		return maCongDoan;
	}
	public void setMaCongDoan(CongDoan maCongDoan) {
		this.maCongDoan = maCongDoan;
	}
	public LocalDate getNgayCham() {
		return ngayCham;
	}
	public void setNgayCham(LocalDate ngayCham) {
		this.ngayCham = ngayCham;
	}
	public int getTrangthaiphancong() {
		return trangthaiphancong;
	}
	public void setTrangthaiphancong(int trangthaiphancong) {
		this.trangthaiphancong = trangthaiphancong;
	}
	@Override
	public String toString() {
		return "BangPhanCong [maCongNhan=" + maCongNhan + ", maCongDoan=" + maCongDoan + ", ngayCham=" + ngayCham
				+ ", trangthaiphancong=" + trangthaiphancong + "]";
	}
 
	 
	
}
