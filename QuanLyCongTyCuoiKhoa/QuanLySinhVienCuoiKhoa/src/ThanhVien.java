import java.util.Scanner;

public abstract class ThanhVien implements NhapXuat {
	//1.Attribute
	protected String hoTen;
	protected int namSinh;
	protected String noiSinh;
	protected String diaChi;
	//2.Get set	
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	//3.Constructor	
	public ThanhVien() {
		// TODO Auto-generated constructor stub
	}

	public ThanhVien(String hoTen, int namSinh, String noiSinh, String diaChi) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
	}	
	//4.Input output
	public void nhap(Scanner scan) {
		System.out.print("Vui lòng nhập họ tên: ");
		this.hoTen = scan.nextLine();
		System.out.print("Vui lòng nhập năm sinh: ");
		this.namSinh = Integer.parseInt(scan.nextLine());
		System.out.print("Vui lòng nhập nơi sinh: ");
		this.noiSinh = scan.nextLine();
		System.out.print("Vui lòng nhập địa chỉ: ");
		this.diaChi = scan.nextLine();
	}
	public void xuat() {
		System.out.print("Họ Tên: " + this.hoTen);
		System.out.print("\tNăm sinh: " + this.namSinh);
		System.out.print("\tNơi sinh: " + this.noiSinh);
		System.out.print("\tĐịa chỉ: " + this.diaChi);
	}
	//Xuất theo format
	protected String formatText(String text) {
		String paddRight = "%-15s";
		return String.format(paddRight, text);
	}
	protected String formatNumCell(Number num) {
		String paddLeft = "%5s";
		String paddRight = "%-6s";
		return String.format(paddLeft, " ") + String.format(paddRight, num);
	}
	public void xuatDong() {
		String text = formatText(this.hoTen) + "|";
		text += formatNumCell(this.namSinh) +"|";
		text += formatText(this.noiSinh)+"|";
		text += formatText(this.diaChi)+"|";
		System.out.print(text);
	}

}
