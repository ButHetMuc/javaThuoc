
	create database HieuThuoc
go
	use HieuThuoc 
go
	create table NhanVien(
		maNhanVien int IDENTITY not null ,
		tenTaiKhoan varchar(30) unique not null,
		maCaLam int not null,
		tenNhanVien nvarchar(30) not null,
		CMND varchar(12) unique not null,
		soDienThoai varchar(10) unique not null,
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
		thoiGianBatDau time not null,
		thoiGianKetThuc time not null,
		 PRIMARY KEY (maCaLam)
		)

	create table TaiKhoan(
		tenTaiKhoan varchar(30) not null,
		matKhau varchar(30) not null,
		PRIMARY KEY(tenTaiKhoan)
		)
	create table NhaCungCap( 
		maNhaCungCap int not null,
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
	insert CaLam values(1,'ca sáng','7:00AM','12:00PM')
	insert CaLam values(2,'ca sáng','1:00PM','6:00PM')
	insert CaLam values(3,'ca sáng','7:00PM','11:00PM')

go
	insert NhaCungCap values(1,N'Thuốc Bắc','0977777777',N'xóm Núi')
	insert NhaCungCap values(2,N'Thuốc Nam','0988888888',N'xóm Biển')
	insert NhaCungCap values(3,N'Thuốc Đông','0966666666',N'xóm Đồi')
	insert NhaCungCap values(4,N'Thuốc Tây','0944444444',N'xóm Mất Điện')
go
	insert TaiKhoan values('admin','admin')
	insert TaiKhoan values('nhanvien1','123456')
	insert TaiKhoan values('nhanvien2','123456')
	insert TaiKhoan values('nhanvien3','123456')
go
	insert LoaiThuoc values (N'Thuốc chữa bệnh')
	insert LoaiThuoc values (N'Thực phẩm chức năng')
	insert LoaiThuoc values (N'Thuốc kháng sinh')
	insert LoaiThuoc values (N'Thuốc giảm đau')
	insert LoaiThuoc values (N'Thuốc tiêu hóa')
	insert LoaiThuoc values (N'Thuốc hạ sốt')
	insert LoaiThuoc values (N'Thuốc kháng viêm')
go	
	insert Thuoc values (1,'paracetamol 500mg',1000,1,'2020-07-07','2022-07-07',N'vỉ',10000)
	insert Thuoc values (2,'Montegol 5',2000,2,'2021-08-06','2023-08-06',N'vỉ',10000)
	insert Thuoc values (3,'Momate-S',3000,3,'2021-05-05','2023-05-05',N'vỉ',10000)
	insert Thuoc values (1,'Mocetrol',1000,4,'2019-03-13','2021-03-13',N'vỉ',10000)
	insert Thuoc values (2,'Mixtard 30 Flexpeni',3000,5,'2022-05-04','2024-05-04',N'vỉ',10000)
	insert Thuoc values (3,'Misenbo',2000,6,'2020-12-24','2023-12-24',N'vỉ',10000)
	insert Thuoc values (1,'Mircera',1000,7,'2021-08-08','2023-08-08',N'vỉ',10000)
	insert Thuoc values (2,'Milgamma N',1000,1,'2019-09-09','2021-09-09',N'vỉ',10000)
	insert Thuoc values (3,'Microclismi',1000,2,'2018-10-10','2021-10-10',N'vỉ',10000)
	insert Thuoc values (4,'Metformin',1000,3,'2017-03-02','2020-03-02',N'vỉ',10000)
	insert Thuoc values (4,'Medoxicam',1000,4,'2021-04-05','2023-04-05',N'vỉ',10000)
	insert Thuoc values (1,'Magne B6 Corbiere',1000,5,'2022-05-13','2024-05-13',N'vỉ',10000)
go
	insert NhanVien values ('admin',1,N'Benzamin','133234444','0912345678',N'Englan','1998-12-24',1,7000000)
	insert NhanVien values ('nhanvien1',2,N'Augustus','133234445','0912345679',N'La mã','1993-12-24',1,7000000)
	insert NhanVien values ('nhanvien3',3,N'Alexandrot','133234446','0912345671',N'Marcedonia','2001-12-24',1,7000000)
	insert NhanVien values ('nhanvien2',2,N'Melmet2','133234447','0912345672',N'Istanbul','1999-12-24',1,7000000)