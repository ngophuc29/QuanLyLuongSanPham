package Entity;

public class BangLuongNhanVien {
	private String maBangLuongNhanVien;
	private int thang;
	private int nam;
	private String MACHAMCONGNHANVIEN;
	private double troCap;
	private ChamCongNhanVien maChamCongNhanVien;
	private double luongtangca;
	private double luongcb;
	private int bhxh;
	private float hsluong;
	private int songaycong;
	private int soGiotangca;
	private double phat;
	private NhanVien NV;
	private double tongluong;
	private double tiencong;
	private int soNgayNghiCoPhep;
	private int soNgayNghiKhongPhep;
	public BangLuongNhanVien(String maBangLuongNhanVien, int thang, int nam, double troCap,
			ChamCongNhanVien maChamCongNhanVien, double luongtangca, double luongcb, int bhxh, float hsluong,
			int songaycong, int soGiotangca, double phat, NhanVien nV, double tongluong ) {
		super();
		this.maBangLuongNhanVien = maBangLuongNhanVien;
		this.thang = thang;
		this.nam = nam;
		this.troCap = troCap;
		this.maChamCongNhanVien = maChamCongNhanVien;
		this.luongtangca = luongtangca;
		this.luongcb = luongcb;
		this.bhxh = bhxh;
		this.hsluong = hsluong;
		this.songaycong = songaycong;
		this.soGiotangca = soGiotangca;
		this.phat = phat;
		NV = nV;
		this.tongluong = tongluong;
	
	}
	public BangLuongNhanVien(String maBangLuongNhanVien, int thang, int nam,  double troCap,String mACHAMCONGNHANVIEN,
			double luongtangca, double luongcb, int bhxh, float hsluong, int songaycong, int soGiotangca, double phat,
			NhanVien nV, double tongluong, double tiencong,int soNgayNghiCoPhep,int soNgayNghiKhongPhep) {
		super();
		this.maBangLuongNhanVien = maBangLuongNhanVien;
		this.thang = thang;
		this.nam = nam;
		MACHAMCONGNHANVIEN = mACHAMCONGNHANVIEN;
		this.troCap = troCap;
		this.luongtangca = luongtangca;
		this.luongcb = luongcb;
		this.bhxh = bhxh;
		this.hsluong = hsluong;
		this.songaycong = songaycong;
		this.soGiotangca = soGiotangca;
		this.phat = phat;
		NV = nV;
		this.tongluong = tongluong;
		this.tiencong=tiencong;
		this.soNgayNghiCoPhep=soNgayNghiCoPhep;
		this.soNgayNghiKhongPhep=soNgayNghiKhongPhep;
	}
	public int getSoNgayNghiCoPhep() {
		return soNgayNghiCoPhep;
	}
	public void setSoNgayNghiCoPhep(int soNgayNghiCoPhep) {
		this.soNgayNghiCoPhep = soNgayNghiCoPhep;
	}
	public int getSoNgayNghiKhongPhep() {
		return soNgayNghiKhongPhep;
	}
	public void setSoNgayNghiKhongPhep(int soNgayNghiKhongPhep) {
		this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
	}
	public BangLuongNhanVien(String maBangLuongNhanVien, int thang, int nam, String mACHAMCONGNHANVIEN, double troCap,
			ChamCongNhanVien maChamCongNhanVien2, double luongtangca, double luongcb, int bhxh, float hsluong,
			int songaycong, int soGiotangca, double phat, NhanVien nV, double tongluong, double tiencong) {
		super();
		this.maBangLuongNhanVien = maBangLuongNhanVien;
		this.thang = thang;
		this.nam = nam;
		MACHAMCONGNHANVIEN = mACHAMCONGNHANVIEN;
		this.troCap = troCap;
		maChamCongNhanVien = maChamCongNhanVien2;
		this.luongtangca = luongtangca;
		this.luongcb = luongcb;
		this.bhxh = bhxh;
		this.hsluong = hsluong;
		this.songaycong = songaycong;
		this.soGiotangca = soGiotangca;
		this.phat = phat;
		NV = nV;
		this.tongluong = tongluong;
		this.tiencong = tiencong;
	}
	
	
	public BangLuongNhanVien(NhanVien nV, double tongluong) {
		super();
		NV = nV;
		this.tongluong = tongluong;
	}
	public double getTiencong() {
		return tiencong;
	}
	public void setTiencong(double tiencong) {
		this.tiencong = tiencong;
	}
	public String getMaBangLuongNhanVien() {
		return maBangLuongNhanVien;
	}
	public void setMaBangLuongNhanVien(String maBangLuongNhanVien) {
		this.maBangLuongNhanVien = maBangLuongNhanVien;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public double getTroCap() {
		return troCap;
	}
	public void setTroCap(double troCap) {
		this.troCap = troCap;
	}
	public ChamCongNhanVien getMaChamCongNhanVien() {
		return maChamCongNhanVien;
	}
	public void setMaChamCongNhanVien(ChamCongNhanVien maChamCongNhanVien) {
		this.maChamCongNhanVien = maChamCongNhanVien;
	}
	public double getLuongtangca() {
		return luongtangca;
	}
	public void setLuongtangca(double luongtangca) {
		this.luongtangca = luongtangca;
	}
	public double getLuongcb() {
		return luongcb;
	}
	public void setLuongcb(double luongcb) {
		this.luongcb = luongcb;
	}
	public int getBhxh() {
		return bhxh;
	}
	public void setBhxh(int bhxh) {
		this.bhxh = bhxh;
	}
	public float getHsluong() {
		return hsluong;
	}
	public void setHsluong(float hsluong) {
		this.hsluong = hsluong;
	}
	public int getSongaycong() {
		return songaycong;
	}
	public void setSongaycong(int songaycong) {
		this.songaycong = songaycong;
	}
	public int getSoGiotangca() {
		return soGiotangca;
	}
	public void setSoGiotangca(int soGiotangca) {
		this.soGiotangca = soGiotangca;
	}
	public double getPhat() {
		return phat;
	}
	public void setPhat(double phat) {
		this.phat = phat;
	}
	public NhanVien getNV() {
		return NV;
	}
	public void setNV(NhanVien nV) {
		NV = nV;
	}
	public double getTongluong() {
		return tongluong;
	}
	public void setTongluong(double tongluong) {
		this.tongluong = tongluong;
	}
	@Override
	public String toString() {
		return "BangLuongNhanVien [maBangLuongNhanVien=" + maBangLuongNhanVien + ", thang=" + thang + ", nam=" + nam
				+ ", troCap=" + troCap + ", maChamCongNhanVien=" + maChamCongNhanVien + ", luongtangca=" + luongtangca
				+ ", luongcb=" + luongcb + ", bhxh=" + bhxh + ", hsluong=" + hsluong + ", songaycong=" + songaycong
				+ ", soGiotangca=" + soGiotangca + ", phat=" + phat + ", NV=" + NV + ", tongluong=" + tongluong + "]";
	}
	
	
}
