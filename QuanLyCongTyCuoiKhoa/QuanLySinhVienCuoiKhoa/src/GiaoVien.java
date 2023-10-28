import java.time.LocalDate;
import java.util.Scanner;

public class GiaoVien extends ThanhVien implements NhapXuat {
	//Constant
	final boolean TU_NHIEN = true;
	final boolean XA_HOI = false;
	
	//1.Attribute
	private int namGiangDay;
	private boolean chuyenMon;
	private int thamNien;
	//2.Get set
	
	public int getNamGiangDay() {
		return namGiangDay;
	}

	public int getThamNien() {
		return thamNien;
	}

	public void setNamGiangDay(int namGiangDay) {
		this.namGiangDay = namGiangDay;
	}

	public boolean getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(boolean chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	//3.Constructor
	public GiaoVien() {
		// TODO Auto-generated constructor stub
	}

	public GiaoVien(String hoTen, int namSinh, String noiSinh, String diaChi, int namDay, boolean chuyenMon) {
		super(hoTen, namSinh, noiSinh, diaChi);
		this.namGiangDay = namDay;
		this.chuyenMon = chuyenMon;
	}
	//4.Input output

	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.print("Vui lòng nhập năm giảng dạy: ");
		this.namGiangDay = Integer.parseInt(scan.nextLine());
		int chon;
		do {
			System.out.println("Vui lòng chọn chuyên ngành giảng dạy");
			System.out.println("1. Tự nhiên \t| 2. Xã hội");
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				this.chuyenMon = TU_NHIEN;
				break;
			case 2: 
				this.chuyenMon = XA_HOI;
				break;
			default:
				break;
			}
		} while (chon>2 || chon <1);
	}
	@Override
	public void xuat() {
		super.xuat();
		System.out.print("\tNăm Giảng dạy: " + this.namGiangDay);
		if (this.chuyenMon) {
			System.out.print("\tChuyên ngành: Tự Nhiên");
		} else {
			System.out.print("\tChuyên ngành: Xã hội");
		}
		System.out.println("\t Thâm Niên: " + this.thamNien +" năm");
	}
	
	//5.Business method
	public int layNamHienTai() {
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		return year;
	}
	public void tinhThamNien() {
		int namHienTai = layNamHienTai();
		this.thamNien = namHienTai-this.namGiangDay;
	}
	//Xuất theo format
	@Override
	public void xuatDong() {
		super.xuatDong();
		String text = formatNumCell(this.namGiangDay) +"    |";
		String textChuyenNganh;
		if (this.chuyenMon) {
			textChuyenNganh ="Tự nhiên";
		} else {
			textChuyenNganh ="Xã Hội";
		}
		text += formatText(textChuyenNganh) + "|";
		text += formatNumCell(this.thamNien)+"  ||";
		System.out.println(text);
	}
	
	

}
