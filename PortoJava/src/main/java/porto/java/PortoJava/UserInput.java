package porto.java.PortoJava;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;

public class UserInput implements Initializable {
	@FXML
	private TableView<DataObject> Table;
	@FXML
	private TableColumn<DataObject, String> C1;
	@FXML
	private TableColumn<DataObject, String> C2;
	@FXML
	private TableColumn<DataObject, String> C3;
	@FXML
	private TableColumn<DataObject, String> Delete;
	@FXML
	private TextField C1F;
	@FXML
	private TextField C2F;
	@FXML
	private TextField C3F;
	@FXML
	private Button Create;

	ObservableList<DataObject> data =
            FXCollections.observableArrayList();
	
	// Event Listener on TableView[#Table].onMouseClicked
	@FXML
	public void Select(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on TableColumn[#C1].onEditCommit	
	@FXML
	public void C1D(CellEditEvent event) {
		DataObject rkr = ((DataObject) event.getTableView().getItems().get(
				event.getTablePosition().getRow())
		);
		Main.Update("C1 = "+String.valueOf(event.getNewValue()), rkr.getIds());
        data = Main.read();
		Table.setItems(data);
	}
	// Event Listener on TableColumn[#C2].onEditCommit
	@FXML
	public void C2D(CellEditEvent event) {
		DataObject rkr = ((DataObject) event.getTableView().getItems().get(
				event.getTablePosition().getRow())
		);
		Main.Update("C2 = "+String.valueOf(event.getNewValue()), rkr.getIds());
        data = Main.read();
		Table.setItems(data);
	}
	// Event Listener on TableColumn[#C3].onEditCommit
	@FXML
	public void C3D(CellEditEvent event) {
		DataObject rkr = ((DataObject) event.getTableView().getItems().get(
				event.getTablePosition().getRow())
		);
		Main.Update("C3 = "+String.valueOf(event.getNewValue()), rkr.getIds());
        data = Main.read();
		Table.setItems(data);
	}
		
	// Event Listener on Button[#Create].onAction
	@FXML
	public void OnCreate(ActionEvent event) {
		// TODO Autogenerated
				
		if (!C1F.getText().isEmpty()) {
			if (!C2F.getText().isEmpty()) {
				if (!C3F.getText().isEmpty()) {
					Main.Create(Integer.valueOf( C1F.getText()), Integer.valueOf(C2F.getText()), Integer.valueOf(C3F.getText()) );
			        data = Main.read();
					Table.setItems(data);
			        C1F.clear();
			        C2F.clear();
			        C3F.clear();
				}
			}
		}
	}
		
	// Event Listener on Button[#Delete].onAction
	@FXML
	public void OnDelete(CellEditEvent event) {
			DataObject rkr = ((DataObject) event.getTableView().getItems().get(
					event.getTablePosition().getRow())
			);
			Main.Delete(rkr);
	        data = Main.read();
			Table.setItems(data);
	}
			
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		C1.setCellFactory(TextFieldTableCell.forTableColumn());
		C2.setCellFactory(TextFieldTableCell.forTableColumn());
		C3.setCellFactory(TextFieldTableCell.forTableColumn());
		
		// TODO Auto-generated method stub		
        C1.setCellValueFactory(
                new PropertyValueFactory<DataObject, String>("C1"));
        C2.setCellValueFactory(
                new PropertyValueFactory<DataObject, String>("C2"));
        C3.setCellValueFactory(
                new PropertyValueFactory<DataObject, String>("C3"));
        Delete.setCellValueFactory(
                new PropertyValueFactory<DataObject, String>("Del"));
        
        data = Main.read();
		Table.setItems(data);
	}
}
