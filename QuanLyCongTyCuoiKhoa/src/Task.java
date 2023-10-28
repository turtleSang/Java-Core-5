/*Mục đích: Quản lý nghiệp vụ liên quan đến Task cho nhân viên
 * 
 * */
public class Task implements NhapXuat {
	//1.Attribute
	private String maTask;
	private String tenTask;
	private float gioThucHien;
	private String maNV;
	//2.Get Set
	
	public String getMaTask() {
		return maTask;
	}

	public void setMaTask(String maTask) {
		this.maTask = maTask;
	}

	public String getTenTask() {
		return tenTask;
	}

	public void setTenTask(String tenTask) {
		this.tenTask = tenTask;
	}

	public float getGioThucHien() {
		return gioThucHien;
	}

	public void setGioThucHien(float gioThucHien) {
		this.gioThucHien = gioThucHien;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	//3.Constructor
	public Task() {
		this.maNV = "-1";
	}
	

	public Task(String maTask, String tenTask, float gioThucHien) {
		super();
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.gioThucHien = gioThucHien;
	}

	public Task(String maTask, String tenTask, float gioThucHien, String maNV) {
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.gioThucHien = gioThucHien;
		this.maNV = maNV;
	}	
	//4.Input output
	public void xuat() {
		System.out.print("Mã task: " + this.maTask);
		System.out.print("\t Tên task: " + this.tenTask);
		System.out.println("\t Giờ thực hiện" + this.getGioThucHien());
		
	}
	//5.Business method

}
