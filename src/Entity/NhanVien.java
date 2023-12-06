package Entity;

import java.time.LocalDate;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String sodienthoai;
	private String diachi;
	private String chucVu;
	private boolean gioitinh;
	private LocalDate ngaySinh;
	private LocalDate ngaybatdaulamViec;
	private String cmnd;
	private float heSoLuong;
	private String idtaikhoan;
	private String matkhau;
	private double luongcoban;
	private int trinhdo;
	private String email;
	private int bhxh;
	private int trangthai;
	private int phongban;
	private double troCap;
	private String hinhanhnhanvien;
 //moi them  hinh anh ,nho them tren class voi file 4
	public NhanVien(String maNV, String tenNV, String sodienthoai, String diachi, String chucVu, boolean gioitinh,
			LocalDate ngaySinh, LocalDate ngaybatdaulamViec, String cmnd, float heSoLuong, 
			double luongcoban, int trinhdo, String email, int bhxh, int trangthai , double troCap,  String idtaikhoan,String matkhau
			 ) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.chucVu = chucVu;
		this.gioitinh = gioitinh;
		this.ngaySinh = ngaySinh;
		this.ngaybatdaulamViec = ngaybatdaulamViec;
		this.cmnd = cmnd;
		this.heSoLuong = heSoLuong;
		this.idtaikhoan = idtaikhoan;
		this.matkhau=matkhau;
		this.luongcoban = luongcoban;
		this.trinhdo = trinhdo;
		this.email = email;
		this.bhxh = bhxh;
		this.trangthai = trangthai;
	 
		this.troCap = troCap;
		 
		 
	}
	public NhanVien(  String tenNV, String sodienthoai, String diachi, String chucVu, boolean gioitinh,
			LocalDate ngaySinh, LocalDate ngaybatdaulamViec, String cmnd, float heSoLuong, String idtaikhoan,String matkhau,
			double luongcoban, int trinhdo, String email, int bhxh, int trangthai , double troCap,
			String hinhanhnhanvien) {
		super();
	 
		this.tenNV = tenNV;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.chucVu = chucVu;
		this.gioitinh = gioitinh;
		this.ngaySinh = ngaySinh;
		this.ngaybatdaulamViec = ngaybatdaulamViec;
		this.cmnd = cmnd;
		this.heSoLuong = heSoLuong;
		this.idtaikhoan = idtaikhoan;
		this.matkhau=matkhau;
		this.luongcoban = luongcoban;
		this.trinhdo = trinhdo;
		this.email = email;
		this.bhxh = bhxh;
		this.trangthai = trangthai;
	 
		this.troCap = troCap;
		this.hinhanhnhanvien = hinhanhnhanvien;
	}
	public NhanVien(String maNV, String tenNV,LocalDate ngaybatdaulamViec, String chucVu, String email, float heSoLuong,double troCap) {
	 
	this.maNV = maNV;
	this.tenNV = tenNV;
	this.chucVu = chucVu;
	this.ngaybatdaulamViec = ngaybatdaulamViec;
	this.email = email;
	this.heSoLuong = heSoLuong;
	this.troCap = troCap;
}
	
	public NhanVien( String tenNV, String sodienthoai, String diachi, String chucVu, boolean gioitinh,
			LocalDate ngaySinh, LocalDate ngaybatdaulamViec, String cmnd, float heSoLuong, String idtaikhoan,
			double luongcoban, int trinhdo, String email, int bhxh, int trangthai , double troCap,
			String hinhanhnhanvien,String maNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.chucVu = chucVu;
		this.gioitinh = gioitinh;
		this.ngaySinh = ngaySinh;
		this.ngaybatdaulamViec = ngaybatdaulamViec;
		this.cmnd = cmnd;
		this.heSoLuong = heSoLuong;
		this.idtaikhoan = idtaikhoan;
		this.luongcoban = luongcoban;
		this.trinhdo = trinhdo;
		this.email = email;
		this.bhxh = bhxh;
		this.trangthai = trangthai;
	 
		this.troCap = troCap;
		this.hinhanhnhanvien = hinhanhnhanvien;
	}

	public NhanVien(String maNV, String tenNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
	}

	public NhanVien(String maNV ) {
		super();
		this.maNV = maNV;
		 
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public LocalDate getNgaybatdaulamViec() {
		return ngaybatdaulamViec;
	}
	public void setNgaybatdaulamViec(LocalDate ngaybatdaulamViec) {
		this.ngaybatdaulamViec = ngaybatdaulamViec;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public float getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public String getIdtaikhoan() {
		return idtaikhoan;
	}
	public void setIdtaikhoan(String idtaikhoan) {
		this.idtaikhoan = idtaikhoan;
	}
	public double getLuongcoban() {
		return luongcoban;
	}
	public void setLuongcoban(double luongcoban) {
		this.luongcoban = luongcoban;
	}
	public int getTrinhdo() {
		return trinhdo;
	}
	public void setTrinhdo(int trinhdo) {
		this.trinhdo = trinhdo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBhxh() {
		return bhxh;
	}
	public void setBhxh(int bhxh) {
		this.bhxh = bhxh;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public int getPhongban() {
		return phongban;
	}
	public void setPhongban(int phongban) {
		this.phongban = phongban;
	}
	public double getTroCap() {
		return troCap;
	}
	public void setTroCap(double troCap) {
		this.troCap = troCap;
	}
	public String getHinhanhnhanvien() {
		return hinhanhnhanvien;
	}
	public void setHinhanhnhanvien(String hinhanhnhanvien) {
		this.hinhanhnhanvien = hinhanhnhanvien;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", sodienthoai=" + sodienthoai + ", diachi=" + diachi
				+ ", chucVu=" + chucVu + ", gioitinh=" + gioitinh + ", ngaySinh=" + ngaySinh + ", ngaybatdaulamViec="
				+ ngaybatdaulamViec + ", cmnd=" + cmnd + ", heSoLuong=" + heSoLuong + ", idtaikhoan=" + idtaikhoan
				+ ", luongcoban=" + luongcoban + ", trinhdo=" + trinhdo + ", email=" + email + ", bhxh=" + bhxh
				+ ", trangthai=" + trangthai + ", phongban=" + phongban + ", troCap=" + troCap + ", hinhanhnhanvien="
				+ hinhanhnhanvien + "]";
	}
 
	
	
}
