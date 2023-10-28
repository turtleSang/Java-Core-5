import java.util.Scanner;

public class XuLy {
	static Scanner scan = new Scanner(System.in);
	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		TruongHoc truongHoc = new TruongHoc();
		doMenu(truongHoc);
	}
	public static void inMenu() {
		System.out.println("Vui lòng chọn");
		System.out.println("1.Xuất danh sách thành viên");
		System.out.println("2.Thêm Thành Viên");
		System.out.println("3.Tìm danh sách GV có thâm niên cao nhất");
		System.out.println("4.Tìm danh sách GV Tự Nhiên trên 5 năm");
		System.out.println("5.Tìm Điểm TB cao nhất của HS");
		System.out.println("6.Tìm DS Học sinh có DTB cao nhất");
		System.out.println("7.Sắp xếp học sinh theo DTB (QuickSort)");
		System.out.println("8.Sắp xếp học sinh theo ABC (BubbleSort)");
		System.out.println("0. Thoát chương trình");
	}
	public static void doMenu(TruongHoc truong) {
		boolean flag = true;
		do {
			inMenu();
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 0:
				flag = false;
				break;
			case 1:
				truong.xuat();
				break;
			case 2:
				truong.nhap(scan);
				truong.getDsHocSinh().tinhDiemTB();
				break;
			case 3:
				truong.timGiaoVienCoThamNienMax();
				break;
			case 4:
				truong.timGiaoVienTuNhienTren5nam();
				break;
			case 5:
				truong.timDiemTBMax();
				break;
			case 6:
				truong.timDSHocSinhMaxDTB();
				break;
			case 7:
				truong.sapXepQuickSortDTB();
				break;
			case 8:
				truong.sapXepBubleSortTen();
				break;

			default:
				System.out.println("Vui lòng chọn các lựa chọn bên dưới");
				break;
			}
		} while (flag);
	}

}
