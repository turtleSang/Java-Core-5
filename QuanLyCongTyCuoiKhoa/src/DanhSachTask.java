import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DanhSachTask implements NhapXuat {
	//1.Attribute
	private ArrayList<Task> listTask;
	//2.Get set
	
	//3.Constructor
	//4.Input output
	public DanhSachTask() {
		listTask = new ArrayList<Task>();
	}

	public ArrayList<Task> getListTask() {
		return listTask;
	}

	public void setListTask(ArrayList<Task> listTask) {
		this.listTask = listTask;
	}

	@Override
	public void xuat() {
		for (Task task : this.listTask) {
			task.xuat();
		}

	}
	public void taoDulieuTask() {
		try {
			FileReader reader = new FileReader("src/DSTask.txt");
			BufferedReader buff = new BufferedReader(reader);
			String line;
			while ((line = buff.readLine())!=null) {
				String[] list = line.split(" # ");
				Task task = new Task(list[0], list[1], Float.parseFloat(list[2]));
				this.listTask.add(task);
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
