package Entity;

public class CongDoan {
	private String maCongDoan;
	
	private String tenCongDoan;
	private  double giaCongDoan;
	private SanPham maSp;
	private int thutu;
	public CongDoan(String maCongDoan, String tenCongDoan, double giaCongDoan, SanPham maSp,int thutu) {
		super();
		this.maCongDoan = maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.giaCongDoan = giaCongDoan;
		this.maSp = maSp;
		this.thutu=thutu;
	}
	public int getThutu() {
		return thutu;
	}
	public void setThutu(int thutu) {
		this.thutu = thutu;
	}
	public String getMaCongDoan() {
		return maCongDoan;
	}
	public void setMaCongDoan(String maCongDoan) {
		this.maCongDoan = maCongDoan;
	}
	public String getTenCongDoan() {
		return tenCongDoan;
	}
	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}
	public CongDoan(String maCongDoan) {
		super();
		this.maCongDoan = maCongDoan;
	}
	public double getGiaCongDoan() {
		return giaCongDoan;
	}
	public CongDoan(String tenCongDoan, double giaCongDoan, SanPham maSp,int thutu) {
		super();
		this.tenCongDoan = tenCongDoan;
		this.giaCongDoan = giaCongDoan;
		this.maSp = maSp;
		this.thutu=thutu;
	}
	
	
	public CongDoan(String maCongDoan, String tenCongDoan, double giaCongDoan   ) {
		super();
		this.maCongDoan=maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.giaCongDoan = giaCongDoan;
		 
		
	}
	public void setGiaCongDoan(double giaCongDoan) {
		this.giaCongDoan = giaCongDoan;
	}
	public SanPham getMaSp() {
		return maSp;
	}
	public void setMaSp(SanPham maSp) {
		this.maSp = maSp;
	}
	@Override
	public String toString() {
		return "CongDoan [maCongDoan=" + maCongDoan + ", tenCongDoan=" + tenCongDoan + ", giaCongDoan=" + giaCongDoan
				+ ", maSp=" + maSp + "]";
	}
	
}
