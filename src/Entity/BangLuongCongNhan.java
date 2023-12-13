package Entity;

public class BangLuongCongNhan {
	private String maBangLuongCongNhan;
	private int thang;
	private CongNhan  maCongNhan;
	private int nam;
	private double tongluong;
	private ChamCongCongNhan maChamCongCognNhan;
	private double luongsanpham;
	private int bhxh;
	private int tongsogiotangca;
	private double phat;
	private double troCap;
	private double luongtangca;
	
	private int soluonglamdc ;
	
	public BangLuongCongNhan(String maBangLuongCongNhan, int thang, int nam, double tongluong,
			ChamCongCongNhan maChamCongCognNhan, double luongsanpham, int bhxh, int tongsogiotangca, double phat,
			double troCap, double luongtangca) {
		super();
		this.maBangLuongCongNhan = maBangLuongCongNhan;
		this.thang = thang;
		this.nam = nam;
		this.tongluong = tongluong;
		this.maChamCongCognNhan = maChamCongCognNhan;
		this.luongsanpham = luongsanpham;
		this.bhxh = bhxh;
		this.tongsogiotangca = tongsogiotangca;
		this.phat = phat;
		this.troCap = troCap;
		this.luongtangca = luongtangca;
	}
	
	
	public BangLuongCongNhan(String maBangLuongCongNhan, CongNhan maCongNhan, double tongluong, double luongsanpham,
			int tongsogiotangca, double phat, double troCap, double luongtangca) {
		super();
		this.maBangLuongCongNhan = maBangLuongCongNhan;
		this.maCongNhan = maCongNhan;
		this.tongluong = tongluong;
		this.luongsanpham = luongsanpham;
		this.tongsogiotangca = tongsogiotangca;
		this.phat = phat;
		this.troCap = troCap;
		this.luongtangca = luongtangca;
	}


	public BangLuongCongNhan(CongNhan maCongNhan, double tongluong, int soluonglamdc) {
		super();
		this.maCongNhan = maCongNhan;
		this.tongluong = tongluong;
		this.soluonglamdc = soluonglamdc;
	}


	public CongNhan getMaCongNhan() {
		return maCongNhan;
	}


	public void setMaCongNhan(CongNhan maCongNhan) {
		this.maCongNhan = maCongNhan;
	}


	public String getMaBangLuongCongNhan() {
		return maBangLuongCongNhan;
	}
	public void setMaBangLuongCongNhan(String maBangLuongCongNhan) {
		this.maBangLuongCongNhan = maBangLuongCongNhan;
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
	public double getTongluong() {
		return tongluong;
	}
	public void setTongluong(double tongluong) {
		this.tongluong = tongluong;
	}
	public ChamCongCongNhan getMaChamCongCognNhan() {
		return maChamCongCognNhan;
	}
	public void setMaChamCongCognNhan(ChamCongCongNhan maChamCongCognNhan) {
		this.maChamCongCognNhan = maChamCongCognNhan;
	}
	public double getLuongsanpham() {
		return luongsanpham;
	}
	public void setLuongsanpham(double luongsanpham) {
		this.luongsanpham = luongsanpham;
	}
	public int getBhxh() {
		return bhxh;
	}
	public void setBhxh(int bhxh) {
		this.bhxh = bhxh;
	}
	public int getTongsogiotangca() {
		return tongsogiotangca;
	}
	public void setTongsogiotangca(int tongsogiotangca) {
		this.tongsogiotangca = tongsogiotangca;
	}
	public double getPhat() {
		return phat;
	}
	public void setPhat(double phat) {
		this.phat = phat;
	}
	public double getTroCap() {
		return troCap;
	}
	public void setTroCap(double troCap) {
		this.troCap = troCap;
	}
	public double getLuongtangca() {
		return luongtangca;
	}
	public void setLuongtangca(double luongtangca) {
		this.luongtangca = luongtangca;
	}
	
	public int getSoluonglamdc() {
		return soluonglamdc;
	}


	public void setSoluonglamdc(int soluonglamdc) {
		this.soluonglamdc = soluonglamdc;
	}


	@Override
	public String toString() {
		return "BangLuongCongNhan [maBangLuongCongNhan=" + maBangLuongCongNhan + ", thang=" + thang + ", nam=" + nam
				+ ", tongluong=" + tongluong + ", maChamCongCognNhan=" + maChamCongCognNhan + ", luongsanpham="
				+ luongsanpham + ", bhxh=" + bhxh + ", tongsogiotangca=" + tongsogiotangca + ", phat=" + phat
				+ ", troCap=" + troCap + ", luongtangca=" + luongtangca + "]";
	}
	
	
}	
