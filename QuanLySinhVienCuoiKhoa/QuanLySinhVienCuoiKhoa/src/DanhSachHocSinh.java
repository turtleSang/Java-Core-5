import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachHocSinh  {
	//1.Attribute
	ArrayList<HocSinh> listHocSinh;
	
	//2.Get set	
	public ArrayList<HocSinh> getListHocSinh() {
		return listHocSinh;
	}


	public void setListHocSinh(ArrayList<HocSinh> listHocSinh) {
		this.listHocSinh = listHocSinh;
	}

	//3.Constructor
	public DanhSachHocSinh() {
		this.listHocSinh = new ArrayList<HocSinh>();
	}
	//4.Input output
	public void nhap(Scanner scan) {
		HocSinh hs = new HocSinh();
		hs.nhap(scan);
		hs.tinhDTB();
		hs.xepLoai();
		this.listHocSinh.add(hs);
	}
	public void xuat() {
		for (HocSinh hocSinh : this.listHocSinh) {
			hocSinh.xuat();
		}
	}
	public void nhapDuLieuHS() {
		try {
			FileReader reader = new FileReader("src/DSHS.txt");
			BufferedReader buff = new BufferedReader(reader);
			String line;
			while ((line = buff.readLine()) != null) {
				String[] info = line.split(" # ");
				HocSinh hs = new HocSinh();
				hs.hoTen = info[0];
				hs.namSinh = Integer.parseInt(info[1]);
				hs.noiSinh = info[2];
				hs.diaChi = info[3];
				hs.setDiemToan(Float.parseFloat(info[4]));
				hs.setDiemLy(Float.parseFloat(info[5]));
				hs.setDiemHoa(Float.parseFloat(info[6]));
				hs.tinhDTB();
				hs.xepLoai();
				this.listHocSinh.add(hs);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//5.Business
	//Tính điểm TB
	public void tinhDiemTB() {
		for (HocSinh hocSinh : listHocSinh) {
			hocSinh.tinhDTB();
		}
	}
	//Xếp Loại
	public void xepLoai() {
		for (HocSinh hocSinh : listHocSinh) {
			hocSinh.xepLoai();
		}
	}
	//Tìm điểm TB cao nhất
	public float timDiemTBCaoNhat() {
		float maxDTB = -1;
		if (this.listHocSinh != null) {
			maxDTB= this.listHocSinh.get(0).getDiemTB();
			for (int i = 1; i < this.listHocSinh.size(); i++) {
				if (maxDTB < this.listHocSinh.get(i).getDiemTB()) {
					maxDTB = this.listHocSinh.get(i).getDiemTB();
				} 
			}
		}
		return maxDTB;
		
	}
	//Tìm và in list học sinh có điểm trung bình cao nhất
	public void timListHocSinhMaxDTB() {
		float maxDTB = timDiemTBCaoNhat();
		if (maxDTB == -1) {
			System.out.println("Không có học sinh trong danh sách");
		} else {
			ArrayList<HocSinh> listHSMaxDTB = new ArrayList<HocSinh>();
			for (HocSinh hs : this.listHocSinh) {
				if (hs.getDiemTB() == maxDTB) {
					listHSMaxDTB.add(hs);
				}
			}
			xuatLine();
			String textTieuDe = formatCell("%35s", "Danh Sách Học Sinh có DTB Cao nhất", "%64s");
			System.out.println("||" + textTieuDe + "||");
			xuatTheoFormat(listHSMaxDTB);
		}
	}
	//Sắp xếp theo DTB sử dụng QuickSort 
	public ArrayList<HocSinh> quickSortDTB(ArrayList<HocSinh> listHS, int left, int right) {
		int mid = (left + right)/2;
		int i = left;
		int j = right;
		do {
			while( listHS.get(i).getDiemTB()> listHS.get(mid).getDiemTB()) {
				i++;
			}
			while (listHS.get(j).getDiemTB()<listHS.get(mid).getDiemTB()) {
				j--;
			}
			if (i<=j) {
				Collections.swap(listHS, i, j);
				i++;
				j--;
			}
		} while (i<j);
		if (left < j) {
			quickSortDTB(listHS, left, j);
		}
		if (right > i) {
			quickSortDTB(listHS, i, right);
		}
		return listHS;
	}
	public void sapXepTheoDTB() {
		ArrayList<HocSinh> listSapXepDTB = quickSortDTB(this.listHocSinh, 0, this.listHocSinh.size()-1);
		String textTieuDe = formatCell("%35s", "Danh Sách Học Sinh Sắp xếp theo DTB", "%63s");
		System.out.println("||" + textTieuDe + "||");
		xuatTheoFormat(listSapXepDTB);
	}
	//Sắp xếp tên Sử dụng Bubble Sort
	public ArrayList<HocSinh> bubbleSortTen(ArrayList<HocSinh> listHS) {
		for (int i = 0; i < listHS.size(); i++) {
			for (int j = listHS.size() - 1; j > i; j--) {
				if (listHS.get(j).getHoTen().compareToIgnoreCase(listHS.get(j-1).getHoTen())<0) {
					Collections.swap(listHS, j, j-1);
				}
			}
		}
		return listHS;
	}
	public void sapXepTheoTen() {
		ArrayList<HocSinh> listSapXepTen = bubbleSortTen(this.listHocSinh);
		xuatLine();
		String textTieuDe = formatCell("%35s", "Danh Sách Học Sinh Sắp xếp theo tên", "%63s");
		System.out.println("||" + textTieuDe + "||");
		xuatTheoFormat(listSapXepTen);
	}
	//Xuất theo format
	public void xuatTheoFormat(ArrayList<HocSinh> listHSChon) {
		xuatFormatHeader();
		for (int i = 0; i < listHSChon.size(); i++) {
			xuatCellThuTu(i);
			listHSChon.get(i).xuatDong();
		}
		xuatLine();
	}	
	
	public void xuatLine() {
		System.out.println("=========================================================================================================================================");
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
		text += formatCell(padd1, "Điểm toán", padd1)+"|";
		text += formatCell(padd1, "Điểm lý", padd3)+"|";
		text += formatCell(padd2, "Điểm Hóa", padd1)+"|";
		text += formatCell(padd2, "Điểm TB", padd2)+"|";
		text += formatCell(padd3, "Xếp Loại", padd4)+"||";
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
