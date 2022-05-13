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
		insert into LoaiThuoc values(N'Giảm đau')
		insert into LoaiThuoc values(N'Da liễu')
		insert into LoaiThuoc values(N'Thực phẩm chức năng')
		insert into LoaiThuoc values(N'Hạ sốt giảm đau')
		insert into LoaiThuoc values(N'Tiêu hóa')
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
		insert into Thuoc values(2,'Taceedo-80',120,2,'20/01/2018','20/10/2023',N'lọ',250000)
		insert into Thuoc values(3,'Naprolat',130,3,'20/10/2019','20/10/2024',N'viên',90000)
		insert into Thuoc values(4,'Medi-Fluxetin',110,4,'20/10/2018','20/10/2022',N'lọ',250000)
		insert into Thuoc values(5,'Aquadetrim Vitamin D3',160,5,'20/12/2021','20/11/2025',N'Viên',350000)
		insert into Thuoc values(6,'Candid Mouth Paint',170,6,'21/09/2020','21/10/2022',N'lọ',88000)
		insert into Thuoc values(1,'Motarute Eye Drops',20,1,'20/10/2022','20/10/2023',N'hộp',90000)
		insert into Thuoc values(2,'Oxnas suspension',50,2,'20/01/2022','20/4/2025',N'lọ',650000)
		insert into Thuoc values(3,'Espacox 200mg',72,3,'20/06/2018','20/07/2025',N'lọ',60000)
		insert into Thuoc values(4,'Reduze',99,4,'12/3/2018','24/8/2022',N'hộp',43000)
		insert into Thuoc values(5,'Medaxetine 1.5g',102,5,'12/4/2022','01/1/2025',N'Viên',78000)
		insert into Thuoc values(6,'Fluocinolon 0,025%',104,6,'12/10/2019','15/5/2023',N'ống',98000)
		insert into Thuoc values(1,'Cebiat 90 sachet',105,1,'20/7/2020','20/4/2022',N'hộp',130000)
		insert into Thuoc values(2,'Cebiat 200',100,2,'20/8/2022','20/7/2024',N'hộp',120000)
		insert into Thuoc values(3,'Cefditoren 200',100,3,'12/7/2018','20/9/2023',N'lọ',160000)
		insert into Thuoc values(2,'Cefditoren 400',100,2,'20/8/2022','20/7/2024',N'hộp',120000)
		insert into Thuoc values(3,'Levofoxaxime',100,3,'12/7/2018','20/9/2023',N'lọ',160000)
		insert into Thuoc values(2,'Picencal Tablet',120,2,'20/01/2018','20/10/2023',N'Viên',250000)
		insert into Thuoc values(3,'Ropegold',130,3,'20/10/2019','20/10/2024',N'Bột pha tiêm',90000)
		insert into Thuoc values(4,'Noradrenaline Base Aguettant 1mg/ml',110,4,'20/10/2018','20/10/2022',N'Ống',250000)
		insert into Thuoc values(5,'Irbesartan',160,5,'20/12/2021','20/11/2025',N'viên',350000)
		insert into Thuoc values(1,'Tiger Balm Plaster-RD',20,1,'20/10/2022','20/10/2023',N'Miếng',90000)
		insert into Thuoc values(2,'Fegem-100',50,2,'20/01/2022','20/4/2025',N'Viên',650000)
		insert into Thuoc values(3,'Bostocef suspension',72,3,'20/06/2018','20/07/2025',N'Viên',60000)
		insert into Thuoc values(4,'Maropol Tab.',99,4,'12/3/2018','24/8/2022',N'hộp',43000)
		insert into Thuoc values(5,'Venocity',102,5,'12/4/2022','01/1/2025',N'hộp',78000)
		insert into Thuoc values(6,'Tiotic',104,6,'12/10/2019','15/5/2023',N'Viên',98000)
		insert into Thuoc values(1,'Nalidixic Acid Tablets',105,1,'20/7/2020','20/4/2022',N'hộp',130000)
		insert into Thuoc values(2,'Umecorn',100,2,'20/8/2022','20/7/2024',N'Lọ',120000)
		insert into Thuoc values(3,'Sinlumont 4',100,3,'12/7/2018','20/9/2023',N'Lọ',160000)
		insert into Thuoc values(2,'New Ameflu PM',100,2,'20/8/2022','20/7/2024',N'hộp',120000)
		insert into Thuoc values(2,'Grazincure',100,2,'20/8/2022','20/7/2024',N'hộp',120000)
		insert into Thuoc values(2,'Diasanté',100,2,'20/8/2022','20/7/2024',N'Viên',120000)
		insert into Thuoc values(3,'Nuceftri-1000',100,3,'12/7/2018','20/9/2023',N'Lọ',160000)
		insert into Thuoc values(2,'Escin',100,2,'20/8/2022','20/7/2024',N'hộp',120000)
		insert into Thuoc values(2,'Europanta',100,2,'20/8/2022','20/7/2024',N'Viên',120000)
		insert into Thuoc values(2,'Partamol-Cafein',120,2,'20/01/2018','20/10/2023',N'Viên',250000)
		insert into Thuoc values(3,'Bosditen 50 sachet',130,3,'20/10/2019','20/10/2024',N'Gói',90000)
		insert into Thuoc values(4,'Lisinopril STELLA 2.5 mg',110,4,'20/10/2018','20/10/2022',N'Viên',250000)
		insert into Thuoc values(5,'Élotada 20',160,5,'20/12/2021','20/11/2025',N'	Viên',350000)
		insert into Thuoc values(1,'Élotada 10',20,1,'20/10/2022','20/10/2023',N'Miếng',90000)
		insert into Thuoc values(2,'Venladep XR 37.5 mg',50,2,'20/01/2022','20/4/2025',N'Viên',650000)
		insert into Thuoc values(3,'Livercol 20mg',72,3,'20/06/2018','20/07/2025',N'Viên',60000)
		insert into Thuoc values(4,'Ferion',99,4,'12/3/2018','24/8/2022',N'Dung dịch uống',43000)
		insert into Thuoc values(5,'Arolox',102,5,'12/4/2022','01/1/2025',N'Chai',78000)
		insert into Thuoc values(6,'Alerinit 5mg',104,6,'12/10/2019','15/5/2023',N'Viên',98000)

		insert into Thuoc values(1,'Lisinopril STELLA 20 mg',105,1,'20/7/2020','20/4/2022',N'Viên',130000)
		insert into Thuoc values(2,'Glumeform 500 XR',100,2,'20/8/2022','20/7/2024',N'Viên',120000)
		insert into Thuoc values(3,'Glumeform 750 XR',100,3,'12/7/2018','20/9/2023',N'Viên',160000)
		insert into Thuoc values(2,'Glumeform 1000 XR',100,2,'20/8/2022','20/7/2024',N'hộp',120000)
		insert into Thuoc values(2,'Clarisol-250',100,2,'20/8/2022','20/7/2024',N'hộp',120000)
		insert into Thuoc values(2,'Diasanté',100,2,'20/8/2022','20/7/2024',N'Viên',120000)
		insert into Thuoc values(3,'Bidicarlin 1,6mg',100,3,'12/7/2018','20/9/2023',N'Lọ',160000)
		insert into Thuoc values(2,'Aleucin 500mg/5ml',100,2,'20/8/2022','20/7/2024',N'Ống',120000)
		insert into Thuoc values(2,'Núcleo C.M.P Forte',100,2,'20/8/2022','20/7/2024',N'Viên',120000)

	go
	insert into HoaDon values(1,1,200000,'29/1/2020')
	insert into HoaDon values(2,2,300000,'28/2/2020')
	insert into HoaDon values(3,3,400000,'11/3/2020')
	insert into HoaDon values(4,1,500000,'12/4/2020')
	insert into HoaDon values(5,1,200000,'29/1/2020')
	insert into HoaDon values(6,2,300000,'5/5/2020')
	insert into HoaDon values(7,3,400000,'7/01/2020')
	insert into HoaDon values(8,1,500000,'03/08/2020')
	insert into HoaDon values(9,1,200000,'06/08/2020')
	insert into HoaDon values(10,2,300000,'29/09/2020')
	insert into HoaDon values(11,3,400000,'27/11/2020')
	insert into HoaDon values(12,1,500000,'31/12/2020')
	insert into HoaDon values(13,1,200000,'11/01/2021')
	insert into HoaDon values(14,2,300000,'12/01/2021')
	insert into HoaDon values(15,3,400000,'23/03/2021')
	insert into HoaDon values(16,1,500000,'13/09/2021')
	insert into HoaDon values(16,1,200000,'20/10/2021')
	insert into HoaDon values(17,2,300000,'22/10/2021')
	insert into HoaDon values(18,3,400000,'06/12/2021')
	insert into HoaDon values(19,1,500000,'30/12/2021')
	insert into HoaDon values(20,1,200000,'18/02/2022')
	insert into HoaDon values(21,2,300000,'09/03/2022')
	insert into HoaDon values(22,3,400000,'09/03/2022')
	insert into HoaDon values(23,1,500000,'09/03/2022')
	insert into HoaDon values(24,1,200000,'15/03/2022')
	insert into HoaDon values(25,2,300000,'30/03/2022')
	insert into HoaDon values(26,3,400000,'30/06/2022')
	insert into HoaDon values(27,1,500000,'19/07/2022')
	insert into HoaDon values(28,1,200000,'21/07/2022')
	insert into HoaDon values(29,2,300000,'28/10/2022')
	insert into HoaDon values(30,3,400000,'22/11/2022')
	go

	insert into ChiTietHoaDon values(1,1,10,20000)
	insert into ChiTietHoaDon values(1,2,10,30000)
	insert into ChiTietHoaDon values(1,3,10,40000)
	insert into ChiTietHoaDon values(1,4,10,50000)
	insert into ChiTietHoaDon values(1,5,10,60000)

	insert into ChiTietHoaDon values(2,1,10,20000)
	insert into ChiTietHoaDon values(2,2,10,30000)
	insert into ChiTietHoaDon values(2,3,10,40000)
	insert into ChiTietHoaDon values(2,4,10,50000)
	insert into ChiTietHoaDon values(2,5,10,60000)

	insert into ChiTietHoaDon values(3,1,10,20000)
	insert into ChiTietHoaDon values(3,2,10,30000)
	insert into ChiTietHoaDon values(3,3,10,40000)
	insert into ChiTietHoaDon values(3,4,10,50000)
	insert into ChiTietHoaDon values(3,5,10,60000)
	
	insert into ChiTietHoaDon values(4,1,10,20000)
	insert into ChiTietHoaDon values(4,2,10,30000)
	insert into ChiTietHoaDon values(4,3,10,40000)
	insert into ChiTietHoaDon values(4,4,10,50000)
	insert into ChiTietHoaDon values(4,5,10,60000)

	insert into ChiTietHoaDon values(5,1,10,20000)
	insert into ChiTietHoaDon values(5,2,10,30000)
	insert into ChiTietHoaDon values(5,3,10,40000)
	insert into ChiTietHoaDon values(5,4,10,50000)
	insert into ChiTietHoaDon values(5,5,10,60000)

	insert into ChiTietHoaDon values(6,1,10,20000)
	insert into ChiTietHoaDon values(6,2,10,30000)
	insert into ChiTietHoaDon values(6,3,10,40000)
	insert into ChiTietHoaDon values(6,4,10,50000)
	insert into ChiTietHoaDon values(6,5,10,60000)

	insert into ChiTietHoaDon values(7,1,10,20000)
	insert into ChiTietHoaDon values(7,2,10,30000)
	insert into ChiTietHoaDon values(7,3,10,40000)
	insert into ChiTietHoaDon values(7,4,10,50000)
	insert into ChiTietHoaDon values(7,5,10,60000)
	
	insert into ChiTietHoaDon values(8,1,10,20000)
	insert into ChiTietHoaDon values(8,2,10,30000)
	insert into ChiTietHoaDon values(8,3,10,40000)
	insert into ChiTietHoaDon values(8,4,10,50000)
	insert into ChiTietHoaDon values(8,5,10,60000)

	insert into ChiTietHoaDon values(9,1,10,20000)
	insert into ChiTietHoaDon values(9,2,10,30000)
	insert into ChiTietHoaDon values(9,3,10,40000)
	insert into ChiTietHoaDon values(9,4,10,50000)
	insert into ChiTietHoaDon values(9,5,10,60000)
	
	insert into ChiTietHoaDon values(10,1,10,20000)
	insert into ChiTietHoaDon values(10,2,10,30000)
	insert into ChiTietHoaDon values(10,3,10,40000)
	insert into ChiTietHoaDon values(10,4,10,50000)
	insert into ChiTietHoaDon values(10,5,10,60000)

	insert into ChiTietHoaDon values(11,1,10,20000)
	insert into ChiTietHoaDon values(11,2,10,30000)
	insert into ChiTietHoaDon values(11,3,10,40000)
	insert into ChiTietHoaDon values(11,4,10,50000)
	insert into ChiTietHoaDon values(11,5,10,60000)

	insert into ChiTietHoaDon values(12,1,10,20000)
	insert into ChiTietHoaDon values(12,2,10,30000)
	insert into ChiTietHoaDon values(12,3,10,40000)
	insert into ChiTietHoaDon values(12,4,10,50000)
	insert into ChiTietHoaDon values(12,5,10,60000)

	insert into ChiTietHoaDon values(13,1,10,20000)
	insert into ChiTietHoaDon values(13,2,10,30000)
	insert into ChiTietHoaDon values(13,3,10,40000)
	insert into ChiTietHoaDon values(13,4,10,50000)
	insert into ChiTietHoaDon values(13,5,10,60000)
									 
	insert into ChiTietHoaDon values(14,1,10,20000)
	insert into ChiTietHoaDon values(14,2,10,30000)
	insert into ChiTietHoaDon values(14,3,10,40000)
	insert into ChiTietHoaDon values(14,4,10,50000)
	insert into ChiTietHoaDon values(14,5,10,60000)
									 
	insert into ChiTietHoaDon values(15,1,10,20000)
	insert into ChiTietHoaDon values(15,2,10,30000)
	insert into ChiTietHoaDon values(15,3,10,40000)
	insert into ChiTietHoaDon values(15,4,10,50000)
	insert into ChiTietHoaDon values(15,5,10,60000)
									 
	insert into ChiTietHoaDon values(16,1,10,20000)
	insert into ChiTietHoaDon values(16,2,10,30000)
	insert into ChiTietHoaDon values(16,3,10,40000)
	insert into ChiTietHoaDon values(16,4,10,50000)
	insert into ChiTietHoaDon values(16,5,10,60000)
									 
	insert into ChiTietHoaDon values(17,1,10,20000)
	insert into ChiTietHoaDon values(17,2,10,30000)
	insert into ChiTietHoaDon values(17,3,10,40000)
	insert into ChiTietHoaDon values(17,4,10,50000)
	insert into ChiTietHoaDon values(17,5,10,60000)
									 
	insert into ChiTietHoaDon values(18,1,10,20000)
	insert into ChiTietHoaDon values(18,2,10,30000)
	insert into ChiTietHoaDon values(18,3,10,40000)
	insert into ChiTietHoaDon values(18,4,10,50000)
	insert into ChiTietHoaDon values(18,5,10,60000)
									 
	insert into ChiTietHoaDon values(19,1,10,20000)
	insert into ChiTietHoaDon values(19,2,10,30000)
	insert into ChiTietHoaDon values(19,3,10,40000)
	insert into ChiTietHoaDon values(19,4,10,50000)
	insert into ChiTietHoaDon values(19,5,10,60000)				 
									 
	insert into ChiTietHoaDon values(20,1,10,20000)
	insert into ChiTietHoaDon values(20,2,10,30000)
	insert into ChiTietHoaDon values(20,3,10,40000)
	insert into ChiTietHoaDon values(20,4,10,50000)
	insert into ChiTietHoaDon values(20,5,10,60000)

	insert into ChiTietHoaDon values(21,1,10,20000)
	insert into ChiTietHoaDon values(21,2,10,30000)
	insert into ChiTietHoaDon values(21,3,10,40000)
	insert into ChiTietHoaDon values(21,4,10,50000)
	insert into ChiTietHoaDon values(21,5,10,60000)

	insert into ChiTietHoaDon values(22,1,10,20000)
	insert into ChiTietHoaDon values(22,2,10,30000)
	insert into ChiTietHoaDon values(22,3,10,40000)
	insert into ChiTietHoaDon values(22,4,10,50000)
	insert into ChiTietHoaDon values(22,5,10,60000)

	insert into ChiTietHoaDon values(23,1,10,20000)
	insert into ChiTietHoaDon values(23,2,10,30000)
	insert into ChiTietHoaDon values(23,3,10,40000)
	insert into ChiTietHoaDon values(23,4,10,50000)
	insert into ChiTietHoaDon values(23,5,10,60000)
									 
	insert into ChiTietHoaDon values(24,1,10,20000)
	insert into ChiTietHoaDon values(24,2,10,30000)
	insert into ChiTietHoaDon values(24,3,10,40000)
	insert into ChiTietHoaDon values(24,4,10,50000)
	insert into ChiTietHoaDon values(24,5,10,60000)
									 
	insert into ChiTietHoaDon values(25,1,10,20000)
	insert into ChiTietHoaDon values(25,2,10,30000)
	insert into ChiTietHoaDon values(25,3,10,40000)
	insert into ChiTietHoaDon values(25,4,10,50000)
	insert into ChiTietHoaDon values(25,5,10,60000)
									 
	insert into ChiTietHoaDon values(26,1,10,20000)
	insert into ChiTietHoaDon values(26,2,10,30000)
	insert into ChiTietHoaDon values(26,3,10,40000)
	insert into ChiTietHoaDon values(26,4,10,50000)
	insert into ChiTietHoaDon values(26,5,10,60000)
									 
	insert into ChiTietHoaDon values(27,1,10,20000)
	insert into ChiTietHoaDon values(27,2,10,30000)
	insert into ChiTietHoaDon values(27,3,10,40000)
	insert into ChiTietHoaDon values(27,4,10,50000)
	insert into ChiTietHoaDon values(27,5,10,60000)
									 
	insert into ChiTietHoaDon values(28,1,10,20000)
	insert into ChiTietHoaDon values(28,2,10,30000)
	insert into ChiTietHoaDon values(28,3,10,40000)
	insert into ChiTietHoaDon values(28,4,10,50000)
	insert into ChiTietHoaDon values(28,5,10,60000)
									 
	insert into ChiTietHoaDon values(29,1,10,20000)
	insert into ChiTietHoaDon values(29,2,10,30000)
	insert into ChiTietHoaDon values(29,3,10,40000)
	insert into ChiTietHoaDon values(29,4,10,50000)
	insert into ChiTietHoaDon values(29,5,10,60000)				 
									 
	insert into ChiTietHoaDon values(30,1,10,20000)
	insert into ChiTietHoaDon values(30,2,10,30000)
	insert into ChiTietHoaDon values(30,3,10,40000)
	insert into ChiTietHoaDon values(30,4,10,50000)
	insert into ChiTietHoaDon values(30,5,10,60000)
	--select *from HoaDon 
	--select *from ChiTietHoaDon
	--select *from thuoc