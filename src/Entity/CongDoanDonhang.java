package Entity;

public class CongDoanDonhang {
	private String maCongDoanDonHang;
	private CongDoan congdoan;
	private int soluongdathang;
	private int tiendo;
	private int trangthai;
	public CongDoanDonhang(String maCongDoanDonHang, CongDoan congdoan, int soluongdathang, int tiendo, int trangthai) {
		super();
		this.maCongDoanDonHang = maCongDoanDonHang;
		this.congdoan = congdoan;
		this.soluongdathang = soluongdathang;
		this.tiendo = tiendo;
		this.trangthai = trangthai;
	}
	public String getMaCongDoanDonHang() {
		return maCongDoanDonHang;
	}
	public void setMaCongDoanDonHang(String maCongDoanDonHang) {
		this.maCongDoanDonHang = maCongDoanDonHang;
	}
	public CongDoan getCongdoan() {
		return congdoan;
	}
	public void setCongdoan(CongDoan congdoan) {
		this.congdoan = congdoan;
	}
	public int getSoluongdathang() {
		return soluongdathang;
	}
	public void setSoluongdathang(int soluongdathang) {
		this.soluongdathang = soluongdathang;
	}
	public int getTiendo() {
		return tiendo;
	}
	public CongDoanDonhang(String maCongDoanDonHang) {
		super();
		this.maCongDoanDonHang = maCongDoanDonHang;
	}
	public void setTiendo(int tiendo) {
		this.tiendo = tiendo;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	@Override
	public String toString() {
		return "CongDoanDonhang [maCongDoanDonHang=" + maCongDoanDonHang + ", congdoan=" + congdoan
				+ ", soluongdathang=" + soluongdathang + ", tiendo=" + tiendo + ", trangthai=" + trangthai + "]";
	}
 
	
	
}
