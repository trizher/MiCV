package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Titulo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class FormacionController implements Initializable{

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
		// TODO Auto-generated method stub
	}
	
	public HBox getView() {
		return view;
	}


	@FXML
	void onAniadirAction(ActionEvent event) {

	}

	@FXML
	void onEliminarAction(ActionEvent event) {

	}


}
