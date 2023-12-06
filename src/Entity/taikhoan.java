package Entity;

public class taikhoan {

	private int id;
	private String taikhoan;
	private String matkhau;
	public taikhoan(int id, String taikhoan, String matkhau) {
		super();
		this.id = id;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	@Override
	public String toString() {
		return "taikhoan [id=" + id + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + "]";
	}
	
}
