package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.model.CV;
import dad.javafx.micv.model.Conocimiento;
import dad.javafx.micv.model.Nivel;
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
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;

public class ConocimientoController implements Initializable {
	
	private CV cv;
	private Conocimiento conocimientoSeleccionado = new Conocimiento();
	
	@FXML
	private HBox view;

	@FXML
	private TableView<Conocimiento> conocimientosTable;

	@FXML
	private TableColumn<Conocimiento, String> denominacionColumn;

	@FXML
	private TableColumn<Conocimiento, Nivel> nivelColumn;

	@FXML
	private Button aniadirConocimientoButton;

	@FXML
	private Button aniadirIdiomaButton;

	@FXML
	private Button eliminarButton;

	public ConocimientoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConocimientoView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cv = MainController.getModel();
		
		cv.habilidadesListProperty().bindBidirectional(conocimientosTable.itemsProperty());
		denominacionColumn.setCellValueFactory(v -> v.getValue().denominacionProperty());
		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nivelColumn.setCellValueFactory(v -> v.getValue().nivelProperty());
		nivelColumn.setCellFactory(ComboBoxTableCell.forTableColumn(Nivel.values()));
		
		eliminarButton.disableProperty().bind(conocimientosTable.getSelectionModel().selectedItemProperty().isNull());


	}

	public HBox getView() {
		return view;
	}

	@FXML
	void onAniadirConocimientoAction(ActionEvent event) {
		ConocimientoDialogController conocimientoDialog = new ConocimientoDialogController();
		Optional<Conocimiento> result = conocimientoDialog.showAndWait();
		result.ifPresent(conocimiento -> {
			cv.habilidadesListProperty().add(conocimiento);
		});
	}

	@FXML
	void onAniadirIdiomaAction(ActionEvent event) {
		IdiomaDialogController idiomaDialog = new IdiomaDialogController();
		Optional<Conocimiento> result = idiomaDialog.showAndWait();
		result.ifPresent(idioma -> {
			cv.habilidadesListProperty().add(idioma);
		});
	}

	@FXML
	void onEliminarAction(ActionEvent event) {
		conocimientoSeleccionado = conocimientosTable.getSelectionModel().getSelectedItem();
		if(conocimientoSeleccionado != null){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Borrar conocimiento");
			alert.setHeaderText("Confirmacion de borrado de conocimiento.");
			alert.setContentText("¿Está seguro de que desea borrar el conocimiento: "
									+ conocimientoSeleccionado.getDenominacion()
									+ "(" + conocimientoSeleccionado.getNivel() +")?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				cv.experienciasListProperty().remove(conocimientoSeleccionado);
			}
		}
	}

}
