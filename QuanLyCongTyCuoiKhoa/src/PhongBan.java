import java.util.ArrayList;

/*
 * Mục đích: Quản lý các phòng ban
 */
public class PhongBan implements NhapXuat {
	//1.Attribute
	private String maPhongBan;
	private String tenPhongBan;
	private TruongPhong truongPhong;
	private ArrayList<NhanVienThuong> listNVT;
	//2.Get set	
	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}

	public ArrayList<NhanVienThuong> getListNVT() {
		return listNVT;
	}

	public void setListNVT(ArrayList<NhanVienThuong> listNVT) {
		this.listNVT = listNVT;
	}
	//3.Constructor
	public PhongBan() {
		this.truongPhong = null;
		this.listNVT = new ArrayList<NhanVienThuong>();
	}
	

	public PhongBan(String maPhongBan, String tenPhongBan) {
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.listNVT = new ArrayList<NhanVienThuong>();
	}

	//4.Input output
	@Override
	public void xuat() {
		System.out.println("*******Thông Tin Phòng Ban*********");
		System.out.println("Tên: " + this.tenPhongBan + " \t Mã: " + this.maPhongBan);
		if (this.truongPhong!=null) {
			System.out.print("Trưởng phòng: ");
			this.truongPhong.xuat();
		}else {
			System.out.println("Phòng ban chưa có trưởng phòng");
		}
		System.out.println("Danh Sách nhân viên");
		for (NhanVienThuong nvt : listNVT) {
			nvt.xuat();
		}
		System.out.println("********END Thông Tin********************");
	}
	//5.Business
	
	

}
