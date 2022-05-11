set dateformat dMy

--use master
--go

--alter database HieuThuoc set single_user with rollback immediate
--go
--drop database HieuThuoc

create database HieuThuoc
go

use HieuThuoc
go

	create table NhanVien(
		maNhanVien int IDENTITY not null ,
		tenTaiKhoan varchar(30) unique not null,
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
		soDienThoai varchar(10) not null,
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
		--insert into HoaDon values()
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
		thoiGianKetThuc time null,
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
		soLuong int not null,
		maLoaiThuoc  int not null,
		ngaySanXuat date not null,
		hanSuDung date not null,
		donViTinh nvarchar(30) not null,
		donGia money not null,
		PRIMARY KEY(maThuoc)
		)
go
-- add constraint
go
	ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon622519 FOREIGN KEY (maKhachHang) REFERENCES KhachHang (maKhachHang);
	ALTER TABLE HoaDon ADD CONSTRAINT FKHoaDon622518 FOREIGN KEY (maNhanVien) REFERENCES NhanVien (maNhanVien);
	ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FKCTHD622519 FOREIGN KEY (maHoaDon) REFERENCES HoaDon(maHoaDon);
	ALTER TABLE ChiTietHoaDon ADD CONSTRAINT FKCTHD622518 FOREIGN KEY (maThuoc) REFERENCES Thuoc(maThuoc);
	ALTER TABLE NhanVien ADD CONSTRAINT FKNhanVien622519 FOREIGN KEY (maCaLam) REFERENCES CaLam(maCaLam);
	ALTER TABLE NhanVien ADD CONSTRAINT FKNhanVien622518 FOREIGN KEY (tenTaiKhoan) REFERENCES TaiKhoan(tenTaiKhoan);
	ALTER TABLE Thuoc ADD CONSTRAINT FKThuoc6225181 FOREIGN KEY (maNhaCungCap) REFERENCES NhaCungCap(maNhaCungCap);
	ALTER TABLE Thuoc ADD CONSTRAINT FKThuoc6225191 FOREIGN KEY (maLoaiThuoc) REFERENCES LoaiThuoc(maLoaiThuoc);
go

-- insert khach hang

		insert into KhachHang values(N'Trần Đình Chiến','0121354643',N'68 Nguyễn Thái Sơn, Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Trần Hùng Cường','0904758375',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Nguyễn Văn Mạnh Cường','0908564664',N'Quận 12, Thành Phố Hồ Chí Minh')
		insert into KhachHang values( N'Trí Tài','0125649875',N'Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Mai Lộc','0123415678',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Võ Văn Nghĩa','0124563985',N'Quận 12, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Nguyễn Canh',N'0125863498',N' Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Long Cánh',N'0125986789',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Trần Dần',N'0936587491',N'Quận 12, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Ông Lê Tân','0125649875',N'Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Nguyễn Kinh',N'0548154961',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values( N'Tinh Tinh','0124563985',N'Quận 1, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Châu Khải Đức',N'0125876349',N' Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Tú Cần',N'0123436985',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Văn Thiên',N'0941414141',N'Quận 2, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Trương Tú',N'0236548961',N'Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Võ Văn Tài',N'0124141242',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Võ Tính',N'0988888888',N'Quận 12, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Trần Thị Cúc',N'0999999944',N' Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Kim Ngân',N'0985552424',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Võ Ánh',N'0236589641',N'Quận 12, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Trần Nam',N'0454545454',N'Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Nguyễn Trần Dương', N'0345484444',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Phạm Lê Ngân',N'0346491541',N'Quận 12, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Huỳnh Thị Thúy',N'0434648494',N' Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Văn Thị Thu Yến',N'0963587124',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values( N'Văn Kim Tú',N'0345691844',N'Quận 12, Thành Phố Hồ Chí Minh')
		insert into KhachHang values( N'Lê Hiền Nhi',N'0934615874',N'Gò Vấp, Thành Phố Hồ Chí Minh')
		insert into KhachHang values(N'Oanh Thị Hiền',N'012694899 ',N'Tân Bình, Thành Phố Hồ Chí Minh')
		insert into KhachHang values( N'Nguyễn Yến Nhi',N'013254698 ',N'Quận 12, Thành Phố Hồ Chí Minh')
	go

	-- insert calam
	insert into CaLam values('1',N'ca sáng','07:00:00','11:30:00')
		insert into CaLam values('2',N'ca chiều','11:30:00','17:30:00')
		insert into CaLam values('3',N'ca tối','17:30:00','22:30:00')

	go

	-- insert loai thuoc
		insert into LoaiThuoc values(N'Kháng sinh')
		insert into LoaiThuoc values(N'Hô hấp')
		insert into LoaiThuoc values(N'Tim mạch')
		insert into LoaiThuoc values(N'Dùng ngoài')
		insert into LoaiThuoc values(N'Thực phẩm chức năng')
		insert into LoaiThuoc values(N'Hạ sốt giảm đau')
	go

	-- insert loai thuoc
		insert into TaiKhoan values(N'NV111', N'123456')
		insert into TaiKhoan values(N'NV112', N'123123')
		insert into TaiKhoan values(N'NV113', N'123456')
		insert into TaiKhoan values(N'NV114', N'222222')
	go

	-- insert nhan vien
	insert into NhanVien values('NV111','1',N'Nguyễn Đức Vũ','0268585975','0121354643',N'Gò Vấp','28/03/1997','1','7000000')
		insert into NhanVien values('NV112','2',N'Nguyễn Tấn Đạt','0268585975','023344567',N'Gò Vấp','28/01/1998','1','7000000')
		insert into NhanVien values('NV113','3',N'Tùng Văn Sơn','0268585975','025528124',N'Gò Vấp','28/12/1999','1','7000000')
	go

	-- insert nha cung cap
		insert into NhaCungCap values(N'Công ty TNHH Mediphar USA','0903850866',N'93 Đất Thánh, F6, Tân Bình, Tp.HCM')
		insert into NhaCungCap values(N'Công ty CP Traphaco (TRA)','18006612',N'75 Yên Ninh, Ba Đình, Hà Nội, Việt Nam')
		insert into NhaCungCap values(N'Công ty CPD Hậu Giang (DHG)','0903850866',N'93 Đất Thánh, F6, Tân Bình, Tp.HCM')
		insert into NhaCungCap values(N'Công ty TNHH Mediphar USA','0292389143',N'288 NVC, P. An Hòa, Q. Ninh Kiều, TP. Cần Thơ')
		insert into NhaCungCap values(N'Công ty CPDP Hà Tây','0433522525',N'10A Quang Trung – Hà Đông – Hà Nội')
		insert into NhaCungCap values(N'Công ty CPDP Mekophar','0283865025',N'297/5 LKT, Quận 11, Tp Hồ Chí Minh.')
		go

	-- insert thuoc
			insert into Thuoc values(2,'COTTUF L100ML',120,2,'20/01/2018','20/10/2023',N'lọ',250000)
		insert into Thuoc values(3,'COVERSYL 5ML L30V',130,3,'20/10/2019','20/10/2024',N'viên',90000)
		insert into Thuoc values(4,'CURAM 625MG',110,4,'20/10/2018','20/10/2022',N'lọ',250000)
		insert into Thuoc values(5,'CURIOSIN T15G',160,5,'20/12/2021','20/11/2025',N'viên',350000)
		insert into Thuoc values(6,'Dactarin T10G',170,6,'21/09/2020','21/10/2022',N'hộp',88000)
		insert into Thuoc values(1,'Davic H10G x 10G',20,1,'20/10/2022','20/10/2023',N'hộp',90000)
		insert into Thuoc values(2,'Decogen H25V x 4V',50,2,'20/01/2022','20/4/2025',N'hộp',650000)
		insert into Thuoc values(3,'Doctor Cool H3B',72,3,'20/06/2018','20/07/2025',N'viên',60000)
		insert into Thuoc values(4,'Dogalic L100V',99,4,'12/3/2018','24/8/2022',N'hộp',43000)
		insert into Thuoc values(5,'Doctor Cool H3B',102,5,'12/4/2022','01/1/2025',N'hộp',78000)
		insert into Thuoc values(6,'Doctor Cool H5B',104,6,'12/10/2019','15/5/2023',N'viên',98000)
		insert into Thuoc values(1,'Doctor Cool H9B',105,1,'20/7/2020','20/4/2022',N'hộp',130000)
		insert into Thuoc values(2,'Doctor Cool H17B',100,2,'20/8/2022','20/7/2024',N'hộp',120000)
		insert into Thuoc values(3,'COTTUF L100ML',100,3,'12/7/2018','20/9/2023',N'hộp',160000)
	go


