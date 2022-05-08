	
	create database HieuThuoc
go


	use HieuThuoc 
go
	create table NhanVien(
		maNhanVien int IDENTITY not null ,
		tenTaiKhoan varchar(30) not null,
		maCaLam int not null,
		tenNhanVien nvarchar(30) not null,
		CMND varchar(12) not null,
		soDienThoai varchar(10) not null,
		diaChi nvarchar(100) null,
		ngaySinh date not null,
		gioiTinh bit not null,
		luong money not null,
		PRIMARY KEY(maNhanVien)
		)
	create table KhachHang(
		maKhachHang int IDENTITY not null,
		tenKhachHang nvarchar (30) not null,
		soDienThoai nvarchar(10) not null,
		diaChi nvarchar(100) null,
		PRIMARY KEY (maKhachHang)
		)

	create table HoaDon(
		maHoaDon  int IDENTITY not null,
		maKhachHang int not null,
		maNhanVien int not null ,
		tongTien float(10) not null,
		ngayLap date not null DEFAULT GETDATE(),
		PRIMARY KEY (maHoaDon)
		)
	create table ChiTietHoaDon (
		maHoaDon int not null,
		maThuoc int not null,
		soLuong int not null,
		donGia float(10) not null
		PRIMARY KEY (maHoaDon,maThuoc)
		)
	create table CaLam(
		maCaLam int not null DEFAULT 0,
		tenCaLam nvarchar(30) not null,
		thoiGianBatDau date not null,
		thoiGianKetThuc date null,
		 PRIMARY KEY (maCaLam)
		)

	create table TaiKhoan(
		tenTaiKhoan varchar(30) not null,
		matKhau varchar(30) not null,
		PRIMARY KEY(tenTaiKhoan)
		)
	create table NhaCungCap( 
		maNhaCungCap int IDENTITY not null,
		tenNhaCungCap nvarchar(30) not null,
		soDienThoai varchar(10) not null, 
		diaChi nvarchar(50) 
		 PRIMARY KEY(maNhaCungCap)
		)
	create table LoaiThuoc(
		maLoaiThuoc  int IDENTITY not null,
		tenLoai nvarchar(30) not null,
		PRIMARY KEY(maLoaiThuoc)
		)
	create table Thuoc(
		maThuoc  int IDENTITY not null ,
		maNhaCungCap int not null ,
		tenThuoc  nvarchar(30) not null,
		soLuonng int not null,
		maLoaiThuoc  int not null,
		ngaySanXuat date not null,
		hanSuDung date not null,
		donViTinh nvarchar(30) not null,
		donGia money not null,
		PRIMARY KEY(maThuoc)
		)
go
	ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon622519 FOREIGN KEY (maKhachHang) REFERENCES KhachHang (maKhachHang);
	ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon622518 FOREIGN KEY (maNhanVien) REFERENCES NhanVien (maNhanVien);
	ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FKCTHD622519 FOREIGN KEY (maHoaDon) REFERENCES HoaDon(maHoaDon);
	ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FKCTHD622518 FOREIGN KEY (maThuoc) REFERENCES Thuoc(maThuoc);
	ALTER TABLE NhanVien ADD CONSTRAINT FKNhanVien622519 FOREIGN KEY (maCaLam) REFERENCES CaLam(maCaLam);
	ALTER TABLE NhanVien ADD CONSTRAINT FKNhanVien622518 FOREIGN KEY (tenTaiKhoan) REFERENCES TaiKhoan(tenTaiKhoan);
	ALTER TABLE Thuoc ADD CONSTRAINT FKThuoc622519 FOREIGN KEY (maLoaiThuoc) REFERENCES LoaiThuoc(maLoaiThuoc);
	ALTER TABLE Thuoc ADD CONSTRAINT FKThuoc622518 FOREIGN KEY (maNhaCungCap) REFERENCES NhaCungCap(maNhaCungCap);
go
