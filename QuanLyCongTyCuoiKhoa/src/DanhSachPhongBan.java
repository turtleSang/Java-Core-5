import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DanhSachPhongBan implements NhapXuat {
	//1.Attribute
	private ArrayList<PhongBan> listPhongBan;
	//2.Get set
	public ArrayList<PhongBan> getListPhongBan() {
		return listPhongBan;
	}

	public void setListPhongBan(ArrayList<PhongBan> listPhongBan) {
		this.listPhongBan = listPhongBan;
	}
	//3.Constructor
	public DanhSachPhongBan() {
		this.listPhongBan = new ArrayList<PhongBan>();
	}
	//4.Input output
	@Override
	public void xuat() {
		for (PhongBan pb : this.listPhongBan) {
			pb.xuat();
		}

	}
	//5.Business
	public void taoDuLieuPB() {
		try {
			FileReader reader = new FileReader("src/DSPhongBan.txt");
			BufferedReader buff = new BufferedReader(reader);
			String line;
			while ((line = buff.readLine())!=null) {
				String[] list = line.split(" # ");
				PhongBan pb = new PhongBan(list[0], list[1]);
				this.listPhongBan.add(pb);
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
