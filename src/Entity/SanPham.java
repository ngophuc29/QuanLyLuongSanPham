package Entity;

public class SanPham {
		private String maSp;
		private String tenSp;
		private double giaSP;
		private String kieuDang;
		private String ChatLieu;
		 
		private int trangThai;
		public SanPham(String maSp, String tenSp, double giaSP, String kieuDang, String chatLieu,  
				int trangThai) {
			super();
			this.maSp = maSp;
			this.tenSp = tenSp;
			this.giaSP = giaSP;
			this.kieuDang = kieuDang;
			ChatLieu = chatLieu;
			 
			this.trangThai = trangThai;
		}
		public SanPham(String maSp) {
			super();
			this.maSp = maSp;
		}
		public SanPham(String maSp, String tenSp) {
			super();
			this.maSp = maSp;
			this.tenSp = tenSp;
		}
		public SanPham( String tenSp, double giaSP, String kieuDang, String chatLieu,  
				int trangThai) {
			super();
			this.maSp = maSp;
			this.tenSp = tenSp;
			this.giaSP = giaSP;
			this.kieuDang = kieuDang;
			ChatLieu = chatLieu;
			 
			this.trangThai = trangThai;
		}
		
		
		
		public SanPham(String maSp, String tenSp, double giaSP) {
			super();
			this.maSp = maSp;
			this.tenSp = tenSp;
			this.giaSP = giaSP;
		}
		public String getMaSp() {
			return maSp;
		}
		public void setMaSp(String maSp) {
			this.maSp = maSp;
		}
		public String getTenSp() {
			return tenSp;
		}
		public void setTenSp(String tenSp) {
			this.tenSp = tenSp;
		}
		public double getGiaSP() {
			return giaSP;
		}
		public void setGiaSP(double giaSP) {
			this.giaSP = giaSP;
		}
		public String getKieuDang() {
			return kieuDang;
		}
		public void setKieuDang(String kieuDang) {
			this.kieuDang = kieuDang;
		}
		public String getChatLieu() {
			return ChatLieu;
		}
		public void setChatLieu(String chatLieu) {
			ChatLieu = chatLieu;
		}
		 
		public int getTrangThai() {
			return trangThai;
		}
		public void setTrangThai(int trangThai) {
			this.trangThai = trangThai;
		}
		@Override
		public String toString() {
			return "SanPham [maSp=" + maSp + ", tenSp=" + tenSp + ", giaSP=" + giaSP + ", kieuDang=" + kieuDang
					+ ", ChatLieu=" + ChatLieu + ", trangThai=" + trangThai + "]";
		}
	 
	
}
