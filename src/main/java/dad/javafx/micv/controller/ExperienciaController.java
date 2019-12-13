package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.model.CV;
import dad.javafx.micv.model.Experiencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.util.converter.LocalDateStringConverter;

public class ExperienciaController implements Initializable{

	private CV cv;
	private Experiencia experienciaSeleccionada = new Experiencia();
	
	@FXML
	private HBox view;

	@FXML
	private TableView<Experiencia> experienciaTable;

	@FXML
	private TableColumn<Experiencia, LocalDate> desdeColumn;

	@FXML
	private TableColumn<Experiencia, LocalDate> hastaColumn;

	@FXML
	private TableColumn<Experiencia, String> denominacionColumn;

	@FXML
	private TableColumn<Experiencia, String> empleadorColumn;

	@FXML
	private Button aniadirButton;

	@FXML
	private Button eliminarButton;
	
	public ExperienciaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExperienciaView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cv = MainController.getModel();
		
		cv.experienciasListProperty().bindBidirectional(experienciaTable.itemsProperty());
		denominacionColumn.setCellValueFactory(v -> v.getValue().denominacionProperty());
		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		empleadorColumn.setCellValueFactory(v -> v.getValue().empleadorProperty());
		empleadorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		desdeColumn.setCellValueFactory(v -> v.getValue().desdeProperty());
		desdeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
		hastaColumn.setCellValueFactory(v -> v.getValue().hastaProperty());
		hastaColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
		
		eliminarButton.disableProperty().bind(experienciaTable.getSelectionModel().selectedItemProperty().isNull());
	}

	public HBox getView() {
		return view;
	}

	@FXML
	void onAniadirAction(ActionEvent event) {
		ExperienciaDialogController experienciaDialog = new ExperienciaDialogController();
		Optional<Experiencia> result = experienciaDialog.showAndWait();
		result.ifPresent(exp -> {
			cv.experienciasListProperty().add(exp);
		});
	}

	@FXML
	void onEliminarAction(ActionEvent event) {
		experienciaSeleccionada = experienciaTable.getSelectionModel().getSelectedItem();
		if(experienciaSeleccionada != null){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Borrar experiencia");
			alert.setHeaderText("Confirmacion de borrado de experiencia.");
			alert.setContentText("¿Está seguro de que desea borrar la experiencia: "
									+ experienciaSeleccionada.getDenominacion()
									+ "(" + experienciaSeleccionada.getEmpleador() +")?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				cv.experienciasListProperty().remove(experienciaSeleccionada);
			}
		}
	}



}
