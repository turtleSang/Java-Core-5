import java.util.Scanner;

public class XuLy {
	static Scanner scan = new Scanner(System.in);
	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		CongTy cty = new CongTy();
		cty.taoDuLieu();
//		cty.xuatDSNS();
//		cty.xuatDSPhongBan();
//		cty.xuatDSTask();
		//cty.PhanBoNhanVien(scan);
		cty.layDSTruongPhong();
		cty.chiDinhTruongPhong(scan);
		cty.xuatDSNS();
	}

}
