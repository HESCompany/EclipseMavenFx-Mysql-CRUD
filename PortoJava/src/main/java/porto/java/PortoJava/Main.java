package porto.java.PortoJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App.main(args);
	}

	public static void Update(String QPiece, int id) {
		try {
			Connection konektor = Connect.init();
			konektor.prepareStatement("update serverdata set " + QPiece + " where dataid = "+String.valueOf(id)).executeUpdate();
		} catch (SQLException e) {
            System.out.println("Update Failed");
		}
	}
	
	public static void Create(int C1, int C2, int C3) {
		try {
			Connection konektor = Connect.init();
			PreparedStatement sqlbuilder = konektor.prepareStatement("insert into serverdata(C1,C2,C3) values (?,?,?)");
			sqlbuilder.setInt(1, C1);
			sqlbuilder.setInt(2, C2);
			sqlbuilder.setInt(3, C3);
			sqlbuilder.executeUpdate();
		} catch (SQLException e) {
            System.out.println("Create Failed");
		}
	}

	public static void Delete(DataObject obj) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You sure want to delete ?", ButtonType.YES, ButtonType.CANCEL);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
			try {
				Connection konektor = Connect.init();
				konektor.prepareStatement("delete from serverdata where dataid= "+String.valueOf(obj.getIds())).executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static ObservableList<DataObject> read() {
		ObservableList<DataObject> dets = FXCollections.observableArrayList();
		try {
			Connection konektor = Connect.init();
			ResultSet dataread = konektor.prepareStatement("Select * from serverdata").executeQuery();
			while(dataread.next()){
            	DataObject datafit = new
            			DataObject(dataread.getInt("C1"),dataread.getInt("C2"),dataread.getInt("C3"),dataread.getInt("dataid"));
            	dets.add(datafit);
			}
		} catch (Exception e) {
            System.out.println("Reading Failed");
		}
		return dets;
	}
	
	public static class Connect {
	    static String user="root";
	    static String pass="";
	    static String url="jdbc:mysql://localhost/portodb";
	    static String driver="com.mysql.cj.jdbc.Driver";
	    public static Connection init(){
	        Connection conn=null;
	        try{
	            Class.forName(driver);
	            conn= DriverManager.getConnection(url,user,pass);
	        }catch (ClassNotFoundException | SQLException e){
	            throw new RuntimeException();
	        }
	        return conn;
	    }
	}
}
