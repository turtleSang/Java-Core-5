import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DanhSachNhanSu implements NhapXuat {
	//1.Attribute
	private ArrayList<NhanSu> listNS;
	//2.Get set methods
	public ArrayList<NhanSu> getListNS() {
		return listNS;
	}

	public void setListNS(ArrayList<NhanSu> listNS) {
		this.listNS = listNS;
	}
	//3.Constructor
	public DanhSachNhanSu() {
		this.listNS = new ArrayList<NhanSu>();
	}
	//4.Input outPut
	@Override
	public void xuat() {
		for (NhanSu nhanSu : this.listNS) {
			nhanSu.xuat();
		}

	}
	//5.Business method
	public void taoDuLieuNS() {
		try {
			FileReader reader = new FileReader("src/DSNS.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] listText = line.split(" # ");
				NhanSu ns;
				//Kiểm tra là trưởng phòng hay nv thường
				if (listText[listText.length-1].equalsIgnoreCase("true")) {
					ns = new TruongPhong();	
				}else {
					ns = new NhanVienThuong();					
				}
				ns.setMaNV(listText[0]);
				ns.setTenNV(listText[1]);
				ns.setNamSinh(Integer.parseInt(listText[2]));
				ns.setEmail(listText[3]);
				ns.setSoDienThoai(listText[4]);
				ns.setSoNgayLamViec(Float.parseFloat(listText[5]));
				this.listNS.add(ns);
			}			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
