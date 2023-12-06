package Entity;

import java.time.LocalDate;
import java.util.Locale;

public class ChamCongCongNhan {
	private String maChamCongCongNhan;
	private CongNhan maCongNhan;
	private CongNhan tenCongNhan;
	private CongDoan maCongDoan;
	private double tiencong;
	int soluongduocgiao;
	public ChamCongCongNhan(CongNhan maCongNhan, CongNhan tenCongNhan, LocalDate ngaycham, int soLuong,
			int sogiotangca) {
		super();
		this.maCongNhan = maCongNhan;
		this.tenCongNhan = tenCongNhan;
		this.ngaycham = ngaycham;
		this.soLuong = soLuong;
		this.sogiotangca = sogiotangca;
	}
	private LocalDate ngaycham;
	private int hiendien;
	private String caLam;
	private String ghiChu;
	private int soLuong;
	private int sogiotangca;
	public ChamCongCongNhan(String maChamCongCongNhan, CongNhan maCongNhan, LocalDate ngaycham, int hiendien, String caLam,
			String ghiChu, int soLuong, int sogiotangca) {
		super();
		this.maChamCongCongNhan = maChamCongCongNhan;
		this.maCongNhan = maCongNhan;
		this.ngaycham = ngaycham;
		this.hiendien = hiendien;
		this.caLam = caLam;
		this.ghiChu = ghiChu;
		this.soLuong = soLuong;
		this.sogiotangca = sogiotangca;
	}
	public String getMaChamCongCongNhan() {
		return maChamCongCongNhan;
	}
	public void setMaChamCongCongNhan(String maChamCongCongNhan) {
		this.maChamCongCongNhan = maChamCongCongNhan;
	}
	public CongNhan getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(CongNhan maCongNhan) {
		this.maCongNhan = maCongNhan;
	}
	public LocalDate getNgaycham() {
		return ngaycham;
	}
	public void setNgaycham(LocalDate ngaycham) {
		this.ngaycham = ngaycham;
	}
	public int getHiendien() {
		return hiendien;
	}
	public void setHiendien(int hiendien) {
		this.hiendien = hiendien;
	}
	public String getCaLam() {
		return caLam;
	}
	public void setCaLam(String caLam) {
		this.caLam = caLam;
	}
	public ChamCongCongNhan(CongNhan maCongNhan, LocalDate ngaycham, int hiendien, String caLam, String ghiChu,
			int soLuong, int sogiotangca) {
		super();
		this.maCongNhan = maCongNhan;
		this.ngaycham = ngaycham;
		this.hiendien = hiendien;
		this.caLam = caLam;
		this.ghiChu = ghiChu;
		this.soLuong = soLuong;
		this.sogiotangca = sogiotangca;
	}
	public ChamCongCongNhan(CongNhan maCongNhan, LocalDate ngaycham, int soLuong, int sogiotangca) {
		super();
		this.maCongNhan = maCongNhan;
		this.ngaycham = ngaycham;
		this.soLuong = soLuong;
		this.sogiotangca = sogiotangca;
	}
	public ChamCongCongNhan(CongNhan maCongNhan, CongDoan maCongDoan, LocalDate ngaycham, int soLuong,
			int sogiotangca) {
		super();
		this.maCongNhan = maCongNhan;
		this.maCongDoan = maCongDoan;
		this.ngaycham = ngaycham;
		this.soLuong = soLuong;
		this.sogiotangca = sogiotangca;
	}
	public CongDoan getMaCongDoan() {
		return maCongDoan;
	}
	public void setMaCongDoan(CongDoan maCongDoan) {
		this.maCongDoan = maCongDoan;
	}
	//
	public ChamCongCongNhan(String maChamCongCongNhan, CongNhan maCongNhan , LocalDate ngaycham,
			int soLuong, int sogiotangca,CongDoan maCongDoan,double tiencong) {
		super();
		this.maChamCongCongNhan = maChamCongCongNhan;
		this.maCongNhan = maCongNhan;
		this.tenCongNhan = tenCongNhan;
		this.ngaycham = ngaycham;
		this.soLuong = soLuong;
		this.sogiotangca = sogiotangca;
		this.maCongDoan = maCongDoan;
		this.tiencong=tiencong;
	}
	
	//
	public ChamCongCongNhan(String maChamCongCongNhan, CongNhan maCongNhan , LocalDate ngaycham,
			int soLuong, int sogiotangca,CongDoan congdoan,int soluongduocgiao) {
		super();
		this.maChamCongCongNhan = maChamCongCongNhan;
		this.maCongNhan = maCongNhan;
		this.tenCongNhan = tenCongNhan;
		this.ngaycham = ngaycham;
		this.soLuong = soLuong;
		this.sogiotangca = sogiotangca;
		this.maCongDoan=congdoan;
		this.soluongduocgiao=soluongduocgiao;
	}
	//
	public String getGhiChu() {
		return ghiChu;
	}
	public double getTiencong() {
		return tiencong;
	}
	public void setTiencong(double tiencong) {
		this.tiencong = tiencong;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getSoluongduocgiao() {
		return soluongduocgiao;
	}
	public void setSoluongduocgiao(int soluongduocgiao) {
		this.soluongduocgiao = soluongduocgiao;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getSogiotangca() {
		return sogiotangca;
	}
	public void setSogiotangca(int sogiotangca) {
		this.sogiotangca = sogiotangca;
	}
	@Override
	public String toString() {
		return "ChamCongCongNhan [maChamCongCongNhan=" + maChamCongCongNhan + ", maCongNhan=" + maCongNhan
				+ ", ngaycham=" + ngaycham + ", hiendien=" + hiendien + ", caLam=" + caLam + ", ghiChu=" + ghiChu
				+ ", soLuong=" + soLuong + ", sogiotangca=" + sogiotangca + "]";
	}
	
}
