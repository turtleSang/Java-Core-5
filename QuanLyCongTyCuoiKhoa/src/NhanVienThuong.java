
public class NhanVienThuong extends NhanSu {
	//Constants
	final int LUONGNGAY = 200;
	final int PHUCAP_1 = 300;
	final int PHUCAP_2 = 1000;	
	//1.Attribute
	//2.Get set
	//3.Constructor
	public NhanVienThuong() {
		super();
	}

	public NhanVienThuong(String maNV, String tenNV, int namSinh, String email, String soDienThoai) {
		super(maNV, tenNV, namSinh, email, soDienThoai);
		// TODO Auto-generated constructor stub
	}

	public NhanVienThuong(String maNV, String tenNV, int namSinh, String email, String soDienThoai, String maPhongBan,
			float soNgayLamViec) {
		super(maNV, tenNV, namSinh, email, soDienThoai, maPhongBan, soNgayLamViec);
		// TODO Auto-generated constructor stub
	}
	//4.Input output
	//5.Business

	@Override
	public void tinhLuong() {
		

	}

}
