package control;

import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Transaccion;
import model.TransaccionData;
import model.Type;

public class WindowA implements Initializable {

	private String[] types = { "GASTO", "INGRESO" };
	
	// Buttons
	@FXML
	private Button acceptBTN;
	@FXML
	private Button addBTN;
	@FXML
	private Button deleteBTN;
	@FXML
	private Button applyFilterBTN;

	// Table View
	@FXML
	private TableView<Transaccion> movesTable;
	@FXML
	private TableColumn<Transaccion, String> valueCol;
	@FXML
	private TableColumn<Transaccion, Type> typeCol;
	@FXML
	private TableColumn<Transaccion, String> descriptionCol;
	@FXML
	private TableColumn<Transaccion, Date> dateCol;

	// Text Fields

	@FXML
	private TextField dateTF;
	@FXML
	private TextArea descTF;
	@FXML
	private TextField typeTF;
	@FXML
	private TextField valueTF;
	@FXML
	private TextField balanceTF;
	@FXML
	private TextField expensesTF;
	@FXML
	private TextField infoundTF;
	@FXML
	private TextField descriptionTF;

	// Choice Box
	@FXML
	private ChoiceBox<String> typeCB;

	// Date Picker
	@FXML
	private DatePicker higherDateDP;
	@FXML
	private DatePicker inferiorDateDP;
	@FXML
	private DatePicker dateDP;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		// Filling the choice box of types
		fillTypeCB();

		// Initialization of the columns in the table view
		valueCol.setCellValueFactory(new PropertyValueFactory<>("monto"));
		typeCol.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		dateCol.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<>("desc"));
		movesTable.setItems(TransaccionData.data);
	}

	@FXML
	void addQuantity(ActionEvent event) throws ParseException {
		Type tipoValor = Type.GASTO;

		// Gets the values from the scene builder interface
		String valor = "";
		Double valorDouble = 0.0;
		String descripcion = descriptionTF.getText();
		String tipo = typeCB.getValue();
		Date fecha = new Date();
		fecha = java.sql.Date.valueOf(dateDP.getValue());
		;

		// Validations of the date types and classes
		if (confirmDouble(valueTF.getText())) {
			valor = valueTF.getText();
			valorDouble = Double.parseDouble(valor);
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error de tipo de dato");
			alert.setContentText(
					"El número ingresado no cuenta con el formato de tipo decimal (Use \".\" como separador)");
			Optional<ButtonType> result = alert.showAndWait();
		}

		// sets the type according the enumeration class "Type"
		if (tipo.equals("INGRESO")) {
			tipoValor = Type.INGRESO;
		}

		TransaccionData.data.add(new Transaccion(valorDouble, descripcion, tipoValor, fecha));
		clear();
	}
	
	@FXML
	void applyFilter(ActionEvent event) {
		
	}

	@FXML
	void undoFilter(ActionEvent event) {

	}

	/**
	 * 
	 */
	public void fillTypeCB() {
		typeCB.getItems().addAll(types);
	}

	/**
	 * Verifies that a string can be passed to type double
	 * 
	 * @param value, String, string being checked
	 * @return out, boolean, true true if string can be passed to double, false
	 *         otherwise
	 */
	public boolean confirmDouble(String value) {

		boolean out = true;
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) != '.' && value.charAt(i) != '1' && value.charAt(i) != '2' && value.charAt(i) != '3'
					&& value.charAt(i) != '4' && value.charAt(i) != '5' && value.charAt(i) != '6'
					&& value.charAt(i) != '7' && value.charAt(i) != '8' && value.charAt(i) != '9'
					&& value.charAt(i) != '0') {
				out = false;
				break;
			}
		}
		return out;
	}

	/**
	 * Clears all the text fields
	 */
	public void clear() {
		dateTF.setText("");
		descTF.setText("");
		valueTF.setText("");
		typeTF.setText("");
	}

}
