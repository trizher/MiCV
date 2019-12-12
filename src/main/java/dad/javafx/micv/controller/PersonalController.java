package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.model.CV;
import dad.javafx.micv.model.Nacionalidad;
import dad.javafx.micv.model.Personal;
import dad.javafx.utils.LectorCSV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable{
	
    @FXML
    private GridPane view;

	@FXML
	private TextField dniText;

	@FXML
	private TextField nombreText;

	@FXML
	private TextField apellidosText;

	@FXML
	private TextArea direccionArea;

	@FXML
	private TextField codigoPostalText;

	@FXML
	private TextField localidadText;

	@FXML
	private ComboBox<String> paisCombo;

	@FXML
	private ListView<Nacionalidad> nacionalidadListV;

	@FXML
	private Button aniadirNacionalidadButton;

	@FXML
	private Button quitarNacionalidadButton;

	@FXML
	private DatePicker fechaNacimientoPicker;
	
	private ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
	private CV model = new CV();
	
	public PersonalController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PersonalView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.setPersonal(new Personal());
		nacionalidades.addAll(LectorCSV.lectorNacionalidades());
		paisCombo.getItems().addAll(LectorCSV.lectorPaises());
		
		model.getPersonal().identificacionProperty().bindBidirectional(dniText.textProperty());
		model.getPersonal().nombreProperty().bindBidirectional(nombreText.textProperty());
		model.getPersonal().apellidosProperty().bindBidirectional(apellidosText.textProperty());
		model.getPersonal().fechaNacimientoProperty().bindBidirectional(fechaNacimientoPicker.valueProperty());
		model.getPersonal().direccionProperty().bindBidirectional(direccionArea.textProperty());
		model.getPersonal().codigoPostalProperty().bindBidirectional(codigoPostalText.textProperty());
		model.getPersonal().localidadProperty().bindBidirectional(localidadText.textProperty());
		model.getPersonal().paisProperty().bindBidirectional(paisCombo.valueProperty());
		model.getPersonal().nacionalidadListProperty().bindBidirectional(nacionalidadListV.itemsProperty());
		
	}

	public GridPane getView() {
		return view;
	}
	

	@FXML
	void onAniadirNacionalidadAction(ActionEvent event) {
		ChoiceDialog<Nacionalidad> dialog = new ChoiceDialog<Nacionalidad>(nacionalidades.get(0), nacionalidades);
		dialog.setTitle("Nueva nacionalidad");
		dialog.setHeaderText("Añadir nacionalidad");
		dialog.setContentText("Seleccione una nacionalidad");

		Optional<Nacionalidad> result = dialog.showAndWait();
		result.ifPresent(nacionalidad -> {
			if(!model.getPersonal().getNacionalidadList().contains(nacionalidad)) {
				model.getPersonal().getNacionalidadList().add(nacionalidad);
			}
		});
	}

	@FXML
	void onQuitarNacionalidadAction(ActionEvent event) {
		model.getPersonal().getNacionalidadList().remove(nacionalidadListV.getSelectionModel().getSelectedItem());
	}


}
