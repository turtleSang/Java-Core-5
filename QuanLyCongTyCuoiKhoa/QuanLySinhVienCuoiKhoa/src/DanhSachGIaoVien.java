import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachGIaoVien implements NhapXuat {
	//1.Attribute
	ArrayList<GiaoVien> listGiaoVien;
	//2.Get set
	
	public ArrayList<GiaoVien> getListGiaoVien() {
		return listGiaoVien;
	}

	public void setListGiaoVien(ArrayList<GiaoVien> listGiaoVien) {
		this.listGiaoVien = listGiaoVien;
	}

	//3.Constructor
	public DanhSachGIaoVien() {
		this.listGiaoVien = new ArrayList<GiaoVien>();
	}
	//4.input output
	public void nhapDuLieuGV() {
		try {
			FileReader reader = new FileReader("src/DSGV.txt");
			BufferedReader buff = new BufferedReader(reader);
			String line;
			while ((line = buff.readLine())!=null) {
				String[] info = line.split(" # ");
				GiaoVien gv = new GiaoVien(info[0], Integer.parseInt(info[1]), info[2], info[3], Integer.parseInt(info[4]), Boolean.parseBoolean(info[5]));
				gv.tinhThamNien();
				this.listGiaoVien.add(gv);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void nhap(Scanner scan) {
		GiaoVien gv = new GiaoVien();
		gv.nhap(scan);
		gv.tinhThamNien();
		this.listGiaoVien.add(gv);
	}
	public void xuat() {
		xuatLine();
		String textTieuDe = formatCell("%41s", "Danh Sách Giáo Viên", "%55s");
		System.out.println("||" + textTieuDe + "||");
		xuatTheoFormat(this.listGiaoVien);
	}
	//5.Business
	public void tinhThamNienAll() {
		for (GiaoVien gv : this.listGiaoVien) {
			gv.tinhThamNien();
		}
	}
	
	//Tìm listGV có thâm niên cao nhất
	public void timlistGVCoThamNienMax() {
		if (this.listGiaoVien != null) {
			GiaoVien gvMaxThamNien = this.listGiaoVien.get(0);
			ArrayList<GiaoVien> listGVMax = new ArrayList<GiaoVien>();
			int indexMax = 0;
			for (int i = 1; i < this.listGiaoVien.size(); i++) {
				if (gvMaxThamNien.getThamNien() < this.listGiaoVien.get(i).getThamNien()) {
					gvMaxThamNien = this.listGiaoVien.get(i);
					indexMax = i;
				}
			}
			listGVMax.add(gvMaxThamNien);
			for (int i = indexMax+1; i <this.listGiaoVien.size(); i++) {
				if (gvMaxThamNien.getThamNien() == this.listGiaoVien.get(i).getThamNien()) {
					listGVMax.add(this.listGiaoVien.get(i));
				}
			}
			xuatLine();
			String textTieuDe = formatCell("%35s", "Danh Sách Giáo Viên có thâm niên cao nhất", "%39s");
			System.out.println("||" + textTieuDe + "||");
			xuatTheoFormat(listGVMax);
				
		} else {
			System.out.println("Không có giáo viên trong danh sách");
		}		
	}	
	//Tìm list GV chuyên Tự nhiên có thâm niên cao nhất
		//Tìm list GV tự nhiên
	private ArrayList<GiaoVien> timListGVChuyenTuNhien() {
		ArrayList<GiaoVien> listGVTuNhien = new ArrayList<GiaoVien>();
		for (GiaoVien gv : this.listGiaoVien) {
			if(gv.getChuyenMon()) {
				listGVTuNhien.add(gv);
			}
		}
		return listGVTuNhien;
	}
		//Tìm và in ra list GV tự nhiên trên 5 năm
	public void timListGVTuNhienTren5Nam() {
		ArrayList<GiaoVien> listGVTuNhien = timListGVChuyenTuNhien();
		if (listGVTuNhien != null) {
			ArrayList<GiaoVien> listGVTuNhienThamNien5nam = new ArrayList<GiaoVien>();
			for (GiaoVien gv: listGVTuNhien) {
				if (gv.getThamNien()> 5) {
					listGVTuNhienThamNien5nam.add(gv);
				}
			}
			xuatLine();
			String textTieuDe = formatCell("%35s", "Danh Sách Giáo Viên Tự Nhiên có thâm niên 5 năm", "%33s");
			System.out.println("||" + textTieuDe + "||");
			xuatTheoFormat(listGVTuNhienThamNien5nam);
		} else {
			System.out.println("Trong list không có giáo viên tự nhiên");
		}
				
	}
	
	
	//Xuất theo format
	public void xuatTheoFormat(ArrayList<GiaoVien> listGVChon) {
		xuatFormatHeader();
		for (int i = 0; i < listGVChon.size(); i++) {
			xuatCellThuTu(i);
			listGVChon.get(i).xuatDong();
		}
		xuatLine();
	}
	public void xuatLine() {
		System.out.println("=======================================================================================================================");
	}
	private String formatCell(String paddLeft, String text, String paddRight) {
		return String.format(paddLeft, " ")+ text + String.format(paddRight, " ");
	}
	private void xuatFormatHeader() {
		String padd1 = "%1s";
		String padd2 = "%2s";
		String padd3 = "%3s";
		String padd4 = "%4s";
		String padd6 = "%6s";
		xuatLine();
		String text = "||" + formatCell(padd3, "STT", padd3) + "|";
		text += formatCell(padd3, "Họ Tên", padd6) + "|";
		text += formatCell(padd1, "Năm Sinh", padd2) + "|";
		text += formatCell(padd3, "Nơi Sinh", padd4) + "|";
		text+= formatCell(padd4, "Địa chỉ", padd4) +"|";
		text += formatCell(padd1, "Năm Giảng Dạy", padd1)+"|";
		text += formatCell(padd1, "Chuyên môn", padd4)+"|";
		text += formatCell(padd2, "Thâm niên", padd2)+"||";
		System.out.println(text);
		xuatLine();			
	}
	private void xuatCellThuTu(int i) {
		String paddLeft = "%3s";
		String paddRight = "%-5s";
		String text ="||"+ String.format(paddLeft, " ") + i + String.format(paddRight, " ") +"|";
		System.out.print(text);
	}
	
}
