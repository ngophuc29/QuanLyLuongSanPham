package Entity;

import java.time.LocalDate;

public class CongNhan {
	private String maCongNhan;
	private String tencongNhan;
	private boolean gioitinh;
	private LocalDate ngaysinh;
	private LocalDate ngaybatdaulamviec;
	private String cmnd;
	private String diachi;
	private String sodienthoai;
	private int bhxh;
	private double troCap;
	private double luongcb;
	private int trangthai;
	private String hinhanhnhanvien;
	// thieu hinh anh
	public CongNhan(String maCongNhan, String tencongNhan, boolean gioitinh, LocalDate ngaysinh,
			LocalDate ngaybatdaulamviec, String cmnd, String diachi, String sodienthoai, int bhxh,int trangthai, double troCap,
			double luongcb ) {
		super();
		this.maCongNhan = maCongNhan;
		this.tencongNhan = tencongNhan;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.ngaybatdaulamviec = ngaybatdaulamviec;
		this.cmnd = cmnd;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.bhxh = bhxh;
		this.troCap = troCap;
		this.luongcb = luongcb;
		this.trangthai = trangthai;
		 
	}
	public CongNhan(String maCongNhan) {
		super();
		this.maCongNhan = maCongNhan;
	}
	public CongNhan(String maCongNhan, String tencongNhan) {
		super();
		this.maCongNhan = maCongNhan;
		this.tencongNhan = tencongNhan;
	}
	public CongNhan(  String tencongNhan, boolean gioitinh, LocalDate ngaysinh,
			LocalDate ngaybatdaulamviec, String cmnd, String diachi, String sodienthoai, int bhxh,int trangthai, double troCap,
			double luongcb, String hinhanhnhanvien) {
		super();
		this.maCongNhan = maCongNhan;
		this.tencongNhan = tencongNhan;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.ngaybatdaulamviec = ngaybatdaulamviec;
		this.cmnd = cmnd;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.bhxh = bhxh;
		this.troCap = troCap;
		this.luongcb = luongcb;
		this.trangthai = trangthai;
		this.hinhanhnhanvien = hinhanhnhanvien;
	}
	
	public CongNhan(String tencongNhan, String diachi, String sodienthoai,String maCongNhan) {
		super();
		this.tencongNhan = tencongNhan;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.maCongNhan = maCongNhan;
	}
	
//	public CongNhan(String maCongNhan, String tencongNhan) {
//		super();
//		this.maCongNhan = maCongNhan;
//		this.tencongNhan = tencongNhan;
//	}
	public String getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(String maCongNhan) {
		this.maCongNhan = maCongNhan;
	}
	public String getTencongNhan() {
		return tencongNhan;
	}
	public void setTencongNhan(String tencongNhan) {
		this.tencongNhan = tencongNhan;
	}
	public boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public LocalDate getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(LocalDate ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public LocalDate getNgaybatdaulamviec() {
		return ngaybatdaulamviec;
	}
	public void setNgaybatdaulamviec(LocalDate ngaybatdaulamviec) {
		this.ngaybatdaulamviec = ngaybatdaulamviec;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public int getBhxh() {
		return bhxh;
	}
	public void setBhxh(int bhxh) {
		this.bhxh = bhxh;
	}
	public double getTroCap() {
		return troCap;
	}
	public void setTroCap(double troCap) {
		this.troCap = troCap;
	}
	public double getLuongcb() {
		return luongcb;
	}
	public void setLuongcb(double luongcb) {
		this.luongcb = luongcb;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public String getHinhanhnhanvien() {
		return hinhanhnhanvien;
	}
	public void setHinhanhnhanvien(String hinhanhnhanvien) {
		this.hinhanhnhanvien = hinhanhnhanvien;
	}
	@Override
	public String toString() {
		return "CongNhan [maCongNhan=" + maCongNhan + ", tencongNhan=" + tencongNhan + ", gioitinh=" + gioitinh
				+ ", ngaysinh=" + ngaysinh + ", ngaybatdaulamviec=" + ngaybatdaulamviec + ", cmnd=" + cmnd + ", diachi="
				+ diachi + ", sodienthoai=" + sodienthoai + ", bhxh=" + bhxh + ", troCap=" + troCap + ", luongcb="
				+ luongcb + ", trangthai=" + trangthai + ", hinhanhnhanvien=" + hinhanhnhanvien + "]";
	}
	
	
}
