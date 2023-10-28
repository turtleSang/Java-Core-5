import java.util.Scanner;

public class HocSinh extends ThanhVien implements NhapXuat {
	//1.Attribute
	private float diemToan;
	private float diemLy;
	private float diemHoa;
	private float diemTB;
	private String xepLoai;
	//2.Get set
	public float getDiemToan() {
		return diemToan;
	}
	
	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}

	public float getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}

	public float getDiemTB() {
		return diemTB;
	}
	public String getXepLoai() {
		return xepLoai;
	}

	//3.Constructor
	public HocSinh() {
		// TODO Auto-generated constructor stub
	}
	public HocSinh(String hoTen, int namSinh, String noiSinh, String diaChi,
			float diemToan, float diemLy, float diemHoa) {
		super(hoTen, namSinh, noiSinh, diaChi);
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}
	//4.Input output
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.print("Vui lòng nhập điểm Toán: ");
		this.diemToan = Float.parseFloat(scan.nextLine());
		System.out.print("Vui lòng nhập điểm Lý: ");
		this.diemLy = Float.parseFloat(scan.nextLine());
		System.out.print("Vui lòng nhập điểm Hóa: ");
		this.diemHoa = Float.parseFloat(scan.nextLine());
	}
	@Override
	public void xuat() {
		super.xuat();
		System.out.print("\tĐiểm Toán: " + this.diemToan);
		System.out.print("\tĐiểm Lý: " + this.diemLy);
		System.out.print("\tĐiểm Hóa: " + this.diemHoa);
		System.out.print("\tĐiểm TB : " +((double)Math.round(this.diemTB*10)/10));
		System.out.println("\tXếp loại: " + this.xepLoai);
	}
	//5.Business
	public void tinhDTB() {
		this.diemTB = (this.diemToan + this.diemLy + this.diemHoa)/3;
	}
	public void xepLoai() {
		if (this.diemTB < 5) {
			this.xepLoai = "Dưới TB";
		} else  if (this.diemTB < 7) {
			this.xepLoai = "TB";
		} else if (this.diemTB < 8) {
			this.xepLoai = "Khá";
		} else if (this.diemTB < 9) {
			this.xepLoai = "Giỏi";
		} else {
			this.xepLoai = "Xuất sắc";
		}
	}
	@Override
	public void xuatDong() {
		super.xuatDong();
		String text = formatNumCell(this.diemToan) +"|";
		text += formatNumCell(this.diemLy) + "|";
		text += formatNumCell(this.diemHoa) + "|";
		text += formatNumCell((double) Math.round(this.diemTB*10)/10) + "|";
 		text += formatText(xepLoai) + "||";
		System.out.println(text);
	}
}
