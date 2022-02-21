package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import model.StudentData;

public class VentanaA implements Initializable{
	
	@FXML
	private Button addBTN;

    @FXML
    private TableColumn<Student, String> codeCol;

    @FXML
    private TableColumn<Student, String> nameCol;

    @FXML
    private TableColumn<Student, Integer> natIDCol;

    @FXML
    private TableView<Student> studentTable;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));//el nombre debe concordar con la variable student (la cual contiene name como parámetro)
		codeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
		natIDCol.setCellValueFactory(new PropertyValueFactory<>("natIDCol"));
		
		StudentData.data.add(new Student("Gabriel", 123, "A00377741"));
		StudentData.data.add(new Student("Gabirel", 456, "A00345346"));
		StudentData.data.add(new Student("T C Jans", 789, "A003324568"));
		
		studentTable.setItems(StudentData.data);
		
	}
	
	 @FXML
	    void addStudent(ActionEvent event) {
		 	if (event.getSource() == addBTN) {
		 		StudentData.data.add(new Student("Test", 000, "000000000"));
		 	}
	    }
    
}