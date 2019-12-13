package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.model.CV;
import dad.javafx.micv.model.Titulo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.util.converter.LocalDateStringConverter;

public class FormacionController implements Initializable{

	private CV cv;
	private Titulo tituloSeleccionado = new Titulo();
	
	@FXML
	private HBox view;

	@FXML
	private TableView<Titulo> formacionTable;

	@FXML
	private TableColumn<Titulo, LocalDate> desdeColumn;

	@FXML
	private TableColumn<Titulo, LocalDate> hastaColumn;

	@FXML
	private TableColumn<Titulo, String> denominacionColumn;

	@FXML
	private TableColumn<Titulo, String> organizadorColumn;

	@FXML
	private Button aniadirButton;

	@FXML
	private Button eliminarButton;
	
	public FormacionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormacionView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cv = MainController.getModel();
		
		cv.formacionListProperty().bindBidirectional(formacionTable.itemsProperty());
		denominacionColumn.setCellValueFactory(v -> v.getValue().denominacionProperty());
		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		organizadorColumn.setCellValueFactory(v -> v.getValue().organizadorProperty());
		organizadorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		desdeColumn.setCellValueFactory(v -> v.getValue().desdeProperty());
		desdeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
		hastaColumn.setCellValueFactory(v -> v.getValue().hastaProperty());
		hastaColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
		
		eliminarButton.disableProperty().bind(formacionTable.getSelectionModel().selectedItemProperty().isNull());
	}
	
	public HBox getView() {
		return view;
	}


	@FXML
	void onAniadirAction(ActionEvent event) {
		FormacionDialogController formacionDialog = new FormacionDialogController();
		Optional<Titulo> result = formacionDialog.showAndWait();
		result.ifPresent(titulo -> {
			cv.formacionListProperty().add(titulo);
		});
	}

	@FXML
	void onEliminarAction(ActionEvent event) {
		tituloSeleccionado = formacionTable.getSelectionModel().getSelectedItem();
		if(tituloSeleccionado != null){
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Borrar título");
			alert.setHeaderText("Confirmacion de borrado de título.");
			alert.setContentText("¿Está seguro de que desea borrar el título: "
									+ tituloSeleccionado.getDenominacion()
									+ "(" + tituloSeleccionado.getOrganizador() +")?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				cv.formacionListProperty().remove(tituloSeleccionado);
			}
		}
	}


}
