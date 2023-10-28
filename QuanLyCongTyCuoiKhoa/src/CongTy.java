import java.util.ArrayList;
import java.util.Scanner;

public class CongTy implements NhapXuat {
	//1.Attribute
	private String tenCongTy;
	private String maSoThue;
	private float tongLuong;
	private DanhSachNhanSu listNhanSu;
	private DanhSachPhongBan listPhongBan;
	private DanhSachTask listTask;
	private ArrayList<TruongPhong> listTP;
	//2.getSet
	
	public String getTenCongTy() {
		return tenCongTy;
	}
	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}
	public String getMaSoThue() {
		return maSoThue;
	}
	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}
	public DanhSachNhanSu getDsNhanSu() {
		return listNhanSu;
	}
	public void setDsNhanSu(DanhSachNhanSu dsNhanSu) {
		this.listNhanSu = dsNhanSu;
	}
	public DanhSachPhongBan getListPhongBan() {
		return listPhongBan;
	}
	public void setListPhongBan(DanhSachPhongBan listPhongBan) {
		this.listPhongBan = listPhongBan;
	}
	public DanhSachTask getDsTask() {
		return listTask;
	}
	public void setDsTask(DanhSachTask listTask) {
		this.listTask = listTask;
	}
	public float getTongLuong() {
		return tongLuong;
	}
	//3.Constructor
	public CongTy() {
		this.listTP = new ArrayList<TruongPhong>();
	}
	//4.Input output
	@Override
	public void xuat() {
		

	}
	public void xuatDSNS() {
		this.listNhanSu.xuat();
	}
	public void xuatDSPhongBan() {
		this.listPhongBan.xuat();
	}
	public void xuatDSTask() {
		this.listTask.xuat();
	}
	//5.Business
	public void taoDuLieu() {
		this.listNhanSu = new DanhSachNhanSu();
		this.listNhanSu.taoDuLieuNS();
		
		this.listPhongBan = new DanhSachPhongBan();
		this.listPhongBan.taoDuLieuPB();
		
		this.listTask = new DanhSachTask();
		this.listTask.taoDulieuTask();
		
		this.layDSTruongPhong();
	}
	public void PhanBoNhanVien(Scanner scan) {		
		//Liệt kê danh sách phòng ban
		//Chọn mã phòng ban để phân bổ
		//Hỏi là muốn phân bổ hay không
		
		for (NhanSu ns : this.listNhanSu.getListNS()) {
			boolean flag = true;
			if (ns instanceof NhanVienThuong) {
				do {
					ns.xuat();
					System.out.println("Chọn 1 để phân bổ");
					System.out.println("chọn 2 bỏ qua không phân bổ");
					int chon = Integer.parseInt(scan.nextLine());
					switch (chon) {
					case 1: 
						xuatDSPhongBan();
						System.out.println("Mời chọn");
						String maPhong = scan.nextLine();
						PhongBan pb = layPhongBan(maPhong);
						if (pb != null) {
							ns.setMaPhongBan(maPhong);
							pb.getListNVT().add((NhanVienThuong)ns);
						}
						//Thêm nhân sự vào danh sách nhân sự phòng ban
						//Gán mã phòng ban cho nhân sự
						flag = false;
						break;
					case 2: 
						flag = false;
						break;
					default:
						break;
					}
				} while (flag);
			}
		}
	}
	private PhongBan layPhongBan(String maPhong) {
		for (PhongBan pb : this.listPhongBan.getListPhongBan()) {
			if (pb.getMaPhongBan().equalsIgnoreCase(maPhong)) {
				return pb;
			}
		}
		return null;
	}
	//Chỉ định trưởng phòng
	public void layDSTruongPhong() {
		for (NhanSu ns : this.listNhanSu.getListNS()) {
			if (ns instanceof TruongPhong) {
				this.listTP.add((TruongPhong)ns);
			}
		}
	}
	public void chiDinhTruongPhong(Scanner scan) {
		for (TruongPhong truongPhong : listTP) {
			boolean flag = true;
			do {
				truongPhong.xuat();
				System.out.println("Chọn 1 để chỉ định");
				System.out.println("chọn 2 bỏ qua không phân bổ");
				int chon = Integer.parseInt(scan.nextLine());
				switch (chon) {
				case 1:
					xuatDSPhongBan();
					System.out.println("Vui lòng bấm mã phòng ban phân bổ");
					String maPhong = scan.nextLine();
					PhongBan pb = layPhongBan(maPhong);
					if (pb != null) {
						truongPhong.setMaPhongBan(maPhong);
						pb.setTruongPhong(truongPhong);
						flag = false;
					} else {
						System.out.println("Vui lòng chọn lại theo danh sách");
					}
					break;
				case 2:
					flag = false;
					break;
				default:
					break;
				}
				
			} while (flag);
		}
	}
	//Phân Task
	public void phanTask() {
		NhanSu ns = null;
		do {
			for (Task objTask : this.listTask.getListTask()) {
				
			}
		} while (ns == null);
		
	}
}
