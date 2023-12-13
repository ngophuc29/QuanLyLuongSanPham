CREATE DATABASE [QuanLyLuong_Nhom2]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyLuong', FILENAME = N'D:\QuanLyLuongNhom2\Data\QuanLyLuong.mdf' , SIZE = 139264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyLuong_log', FILENAME = N'D:\QuanLyLuongNhom2\Data\QuanLyLuong_log.ldf' , SIZE = 598016KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )

go
CREATE TABLE SanPham
(
	maSP nvarchar(50) NOT NULL PRIMARY KEY ,
	tenSP varchar(50),
	giaSP float,
	kieudang nvarchar(50),
	chatLieu nvarchar(50),
	soluong int,
	trangthai int
);
go

go

CREATE TABLE CongDoan
(
	maCongDoan nvarchar(50) NOT NULL PRIMARY KEY,
	tenCongDoan varchar(50),
	giaCongDoan float,
	 maSP nvarchar(50)
);

go
ALTER TABLE CongDoan
ADD CONSTRAINT FK_congdoan_sanpham
FOREIGN KEY (maSP) REFERENCES SanPham(maSP);
 go
CREATE TABLE BangPhanCong
(
	maBangPhanCong nvarchar(50 ) NOT NULL PRIMARY KEY,
	maCongNhan nvarchar(50),
	ngayCham date ,
	maCongDoan nvarchar(50)
);
go

ALTER TABLE BangPhanCong
ADD CONSTRAINT FK_congdoan_BangPhanCong
FOREIGN KEY (maCongDoan) REFERENCES CongDoan(maCongDoan);
go

CREATE TABLE CongNhan
(
	maCongNhan nvarchar(50) NOT NULL PRIMARY KEY,
	tenCongNhan nvarchar(50),
	gioitinh int,
	ngaySinh date,
	ngaybatdaulamViec date,
	cmnd nvarchar(15),
	diachi nvarchar(50),
	sodienthoai nvarchar(15),
	bhxh int,
	trangthai int

);
go
ALTER TABLE BangPhanCong
ADD CONSTRAINT FK_congnhan_bangphancong
FOREIGN KEY (maCongNhan) REFERENCES CongNhan(maCongNhan);
go 

CREATE TABLE ChamCongCongNhan
( 
	maChamCongCongNhan nvarchar(50) NOT NULL PRIMARY KEY ,
	maCongNhan nvarchar(50),
	ngaycham date ,
	hiendien int ,
	calam nvarchar(10),
	ghichu nvarchar(50),
	soluong int 
);
ALTER TABLE ChamCongCongNhan
ADD CONSTRAINT FK_congnhan_ChamCongCongNhan
FOREIGN KEY (maCongNhan) REFERENCES CongNhan(maCongNhan);

go 
CREATE TABLE BangLuongCongNhan
(
	maBangLuongCongNhan nvarchar(50) NOT NULL PRIMARY KEY,
	thang int,
	nam int,
	tongluong float,
	maChamCongCongNhan nvarchar(50),
	luongsanpham float,
	bhxh int,
	songaynghikhongphep int ,
	phat float ,
	songaynghikhongpheptrongnam int 
);
 ALTER TABLE BangLuongCongNhan
ADD CONSTRAINT FK_chamcongcongnhan_bangLuongCongnhan
FOREIGN KEY (maChamCongCongNhan) REFERENCES ChamCongCongNhan(maChamCongCongNhan);
go

CREATE TABLE TaiKhoan
(
	id int  PRIMARY KEY,
	 taikhoan nvarchar(20),
	 matkhau nvarchar(20)

);
 
 ALTER TABLE NhanVien
ADD CONSTRAINT FK_taikhoan_nhanvien
FOREIGN KEY (idtaikhoan) REFERENCES TaiKhoan(id);
go
CREATE TABLE NhanVien
(
	maNV nvarchar(50) NOT NULL PRIMARY KEY,
	tenNV nvarchar(50),
	sodienthoai nvarchar(15),
	diachi nvarchar(50),
	chucvu int ,
	gioitinh int,
	ngaySinh date,
	ngaybatdaulamViec date,
	cmnd nvarchar(15),
	hesoluong float,
	idtaikhoan int,
	luongcoban float,
	trinhdo int,
	email nvarchar(20),
	bhxh int,
	trangthai int

);
 
go 
CREATE TABLE ChamCongNhanVien
(
	maChamCongCongNhan nvarchar(50) NOT NULL PRIMARY KEY,
	maNV nvarchar(50),
	ngaycham date ,
	hiendien int ,
	calam nvarchar(10),
	ghichu nvarchar(50),
	sogiotangca int 
);


 ALTER TABLE ChamCongNhanVien
ADD CONSTRAINT FK_nhanvien_chamcongnhanvien
FOREIGN KEY (maNV) REFERENCES NhanVien(maNV);
go
 drop table BangLuongNhanVien


CREATE TABLE BangLuongNhanVien
(
[maBangLuongNhanVien] nvarchar(50) NOT NULL PRIMARY KEY 
      ,[thang] int 
      ,[nam] int 
      ,[trocap] float 
      ,[maChamCongNhanVien] nvarchar(50)
      ,[luongtangca] float
      ,[luongcb] float
      ,[bhxh] int 
      ,[hsluong] float 
      ,[songaycong] int 
      ,[tongsogiotangca] int 
      ,[phat] float 
      ,[maNV] nvarchar(50)
      ,[tongluong] float
	 
);

EXEC sp_fkeys 'ChamCongNhanVien'

 ALTER TABLE BangLuongNhanVien
ADD CONSTRAINT FK_chamcongnhanvien_bangluongnhanVienn
FOREIGN KEY (maChamCongNhanVien) REFERENCES ChamCongNhanVien(maChamCongNhanVien);