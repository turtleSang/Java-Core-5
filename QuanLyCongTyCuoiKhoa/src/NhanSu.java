/*
 * Mục đích: tạo lớp nhân sự để quản lý thông tin nhân sự cho các lớp khác kế thừa
 */
public abstract class NhanSu implements NhapXuat {
	//1.Attribute
	protected String maNV;
	protected String tenNV;
	protected int namSinh;
	protected String email;
	protected String soDienThoai;
	protected String maPhongBan;
	protected DanhSachTask listTask;
	protected float luong;
	protected float soNgayLamViec;
	//2.Get set
	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public DanhSachTask getListTask() {
		return listTask;
	}

	public void setListTask(DanhSachTask listTask) {
		this.listTask = listTask;
	}

	public float getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(float soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public float getLuong() {
		return luong;
	}

	//3.Constructor
	//Thiết lập giá trị mặc định
	private void init() {
		this.maPhongBan = "-1";
		this.listTask = new DanhSachTask();
	}
	public NhanSu() {
		init();
	}

	public NhanSu(String maNV, String tenNV, int namSinh, String email, String soDienThoai) {
		init();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	public NhanSu(String maNV, String tenNV, int namSinh, String email, String soDienThoai, String maPhongBan,
				  float soNgayLamViec) {
		init();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.maPhongBan = maPhongBan;
		this.soNgayLamViec = soNgayLamViec;
	}
	
	//4.Input output
	public void xuat() {
		String temp = this.maPhongBan;
		if (this.maPhongBan.equalsIgnoreCase("-1")) {
			temp = "Chưa phân bổ"; 
		}
		System.out.print("Mã: " + this.maNV);
		System.out.print(" \t Tên Nhân Viên: " + this.tenNV);
		System.out.print("\t Năm Sinh: " + this.namSinh);
		System.out.print("\t Email: " + this.email);
		System.out.print("\t Số điện thoại: " + this.soDienThoai);
		System.out.print("\t Mã phòng ban: " + temp);
		System.out.print("\t Số ngày làm việc: " + this.soNgayLamViec);
		System.out.println("\t Lương: " + this.luong);
		if (this.listTask.getListTask().size()>0) {
			System.out.println("Danh sách task đang thực hiện");
			this.listTask.xuat();
		}
	}
	//5.Business methods
	public abstract void tinhLuong();
	
}
