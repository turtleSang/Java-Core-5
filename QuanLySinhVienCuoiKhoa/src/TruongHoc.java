import java.util.Scanner;

public class TruongHoc implements NhapXuat{
	//1.Attribute
	DanhSachHocSinh dsHocSinh;
	DanhSachGIaoVien dsGiaoVien;
	//2.Get Set
	
	public DanhSachHocSinh getDsHocSinh() {
		return dsHocSinh;
	}

	public void setDsHocSinh(DanhSachHocSinh dsHocSinh) {
		this.dsHocSinh = dsHocSinh;
	}

	public DanhSachGIaoVien getDsGiaoVien() {
		return dsGiaoVien;
	}

	public void setDsGiaoVien(DanhSachGIaoVien dsGiaoVien) {
		this.dsGiaoVien = dsGiaoVien;
	}

	//3.Constructor
	public TruongHoc() {
		this.dsHocSinh = new DanhSachHocSinh();
		this.dsHocSinh.nhapDuLieuHS();
		this.dsGiaoVien = new DanhSachGIaoVien();
		this.dsGiaoVien.nhapDuLieuGV();
	}
	//4.Input output
	public void nhap(Scanner scan) {
		boolean flag = true;
		do {
			System.out.println("Vui lòng chọn:");
			System.out.println("1.Thêm GV || 2. Thêm HS || 0.Thoát về Menu Chính");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1: 
				this.dsGiaoVien.nhap(scan);
				break;
			case 2: 
				this.dsHocSinh.nhap(scan);
				break;
			case 0: 
				flag = false;
				break;
			default:
				break;
			}
		} while (flag);
	}
	public void xuat() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		do {
			System.out.println("Vui lòng chọn:");
			System.out.println("1.Xuất GV || 2. Xuất HS || 0.Thoát về Menu Chính");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1: 
				this.dsGiaoVien.xuatTheoFormat(this.dsGiaoVien.getListGiaoVien());
				break;
			case 2: 
				this.dsHocSinh.xuatTheoFormat(this.dsHocSinh.getListHocSinh());
				break;
			case 0: 
				flag = false;
				break;
			default:
				break;
			}
		} while (flag);
	}
	//5.Business
	public void timGiaoVienCoThamNienMax() {
		this.dsGiaoVien.timlistGVCoThamNienMax();
	}
	public void timGiaoVienTuNhienTren5nam() {
		this.dsGiaoVien.timListGVTuNhienTren5Nam();;
	}
	public void timDiemTBMax() {
		double diemTBMax = (double) Math.round(this.dsHocSinh.timDiemTBCaoNhat()*10)/10;
		System.out.println("Điểm Trung bình cao nhất là: " + diemTBMax);		
	}
	public void timDSHocSinhMaxDTB() {
		this.dsHocSinh.timListHocSinhMaxDTB();
	}
	public void sapXepQuickSortDTB() {
		this.dsHocSinh.sapXepTheoDTB();
	}
	public void sapXepBubleSortTen() {
		this.dsHocSinh.sapXepTheoTen();
	}
}
