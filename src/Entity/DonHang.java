package Entity;

import java.time.LocalDate;

public class DonHang {
	private String maDonHang;
	private SanPham sanpham;
	private int soluong;
	private int trangthai;
	private LocalDate ngaytao;
	private LocalDate ngayhoanthanh;
	
	//constructor insert
	public DonHang(  SanPham sanpham, int soluong, int trangthai, LocalDate ngaytao) {
		super();
		this.maDonHang = maDonHang;
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.trangthai = trangthai;
		this.ngaytao=ngaytao;
	}
	
	//contructor đọc 
	public DonHang(String maDonHang, SanPham sanpham, int soluong, int trangthai, LocalDate ngaytao,LocalDate ngayhoanthanh) {
		super();
		this.maDonHang = maDonHang;
		this.sanpham = sanpham;
		this.soluong = soluong;
		this.trangthai = trangthai;
		this.ngaytao=ngaytao;
		this.ngayhoanthanh=ngayhoanthanh;
	}
	
	
	public DonHang(String maDonHang) {
		super();
		this.maDonHang = maDonHang;
	}

	public LocalDate getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(LocalDate ngaytao) {
		this.ngaytao = ngaytao;
	}

	public LocalDate getNgayhoanthanh() {
		return ngayhoanthanh;
	}

	public void setNgayhoanthanh(LocalDate ngayhoanthanh) {
		this.ngayhoanthanh = ngayhoanthanh;
	}

	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", sanpham=" + sanpham + ", soluong=" + soluong + ", trangthai="
				+ trangthai + ", getMaDonHang()=" + getMaDonHang() + ", getSanpham()=" + getSanpham()
				+ ", getSoluong()=" + getSoluong() + ", getTrangthai()=" + getTrangthai() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
