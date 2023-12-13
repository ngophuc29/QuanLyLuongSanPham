package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ChamCongNhanVien {
	private String maChamCongNhanVien;
	private NhanVien NV;
	private LocalDate ngayCham;
	private int hiendien;
	private String caLam;
	private String ghiChu;
	private int sogioTangca;
	
	private LocalTime thoigianden;
	private LocalTime thoigiandi;
	
	
	
	public ChamCongNhanVien(String maChamCongNhanVien, NhanVien nV, LocalDate ngayCham, int hiendien, String caLam,String ghiChu, int sogioTangca) {
		super();
		this.maChamCongNhanVien = maChamCongNhanVien;
		this.NV = nV;
		this.ngayCham = ngayCham;
		this.hiendien = hiendien;
		this.caLam = caLam;
		this.ghiChu = ghiChu;
		this.sogioTangca = sogioTangca;
	}
	
	// co them thoi gian den va thoi gian di
	
	
	
	 public ChamCongNhanVien(NhanVien nV) {
		super();
		this.NV = nV;
	}
 
	public ChamCongNhanVien(String maChamCongNhanVien, NhanVien nV, LocalDate ngayCham, int hiendien, String caLam,
			String ghiChu, int sogioTangca, LocalTime thoigianden, LocalTime thoigiandi) {
		super();
		this.maChamCongNhanVien = maChamCongNhanVien;
		NV = nV;
		this.ngayCham = ngayCham;
		this.hiendien = hiendien;
		this.caLam = caLam;
		this.ghiChu = ghiChu;
		this.sogioTangca = sogioTangca;
		this.thoigianden = thoigianden;
		this.thoigiandi = thoigiandi;
	}

	public ChamCongNhanVien(String maChamCongNhanVien) {
		super();
		this.maChamCongNhanVien = maChamCongNhanVien;
	}

	public String getMaChamCongNhanVien() {
		return maChamCongNhanVien;
	}
	public void setMaChamCongNhanVien(String maChamCongNhanVien) {
		this.maChamCongNhanVien = maChamCongNhanVien;
	}
	public NhanVien getNV() {
		return NV;
	}
	public void setNV(NhanVien nV) {
		NV = nV;
	}
	public LocalDate getNgayCham() {
		return ngayCham;
	}
	public void setNgayCham(LocalDate ngayCham) {
		this.ngayCham = ngayCham;
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
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getSogioTangca() {
		return sogioTangca;
	}
	public void setSogioTangca(int sogioTangca) {
		this.sogioTangca = sogioTangca;
	}
	
	
	public LocalTime getThoigianden() {
		return thoigianden;
	}

	public void setThoigianden(LocalTime thoigianden) {
		this.thoigianden = thoigianden;
	}

	public LocalTime getThoigiandi() {
		return thoigiandi;
	}

	public void setThoigiandi(LocalTime thoigiandi) {
		this.thoigiandi = thoigiandi;
	}

	@Override
	public String toString() {
		return "ChamCongNhanVien [maChamCongNhanVien=" + maChamCongNhanVien + ", NV=" + NV + ", ngayCham=" + ngayCham
				+ ", hiendien=" + hiendien + ", caLam=" + caLam + ", ghiChu=" + ghiChu + ", sogioTangca=" + sogioTangca
				+ "]";
	}
 
	
}
