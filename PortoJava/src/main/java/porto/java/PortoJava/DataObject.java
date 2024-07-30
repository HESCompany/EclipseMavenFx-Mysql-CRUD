package porto.java.PortoJava;

public class DataObject {
	int C1;
	int C2;
	int C3;
	int Ids = -1;
	String Del = "Delete";
	
	DataObject(int C1, int C2, int C3, int Ids) {
		this.C1 = C1;
		this.C2 = C2;
		this.C3 = C3;
		this.Ids = Ids;
	}
	
	public String getC1() {
		return String.valueOf(C1);
	}
	public String getC2() {
		return String.valueOf(C2);
	}
	public String getC3() {
		return String.valueOf(C3);
	}
	public String getDel() {
		return Del;
	}
	public int getIds() {
		return Ids;
	}
	
	public void setC1(String val) {
		this.C1 = Integer.valueOf(val);
	}
	public void setC2(String val) {
		this.C2 = Integer.valueOf(val);
	}
	public void setC3(String val) {
		this.C3 = Integer.valueOf(val);
	}
}
