package dad.javafx.micv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Conocimiento;
import dad.javafx.micv.model.Nivel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ConocimientoController implements Initializable{
	
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
			// TODO Auto-generated method stub
			
		}

	    public HBox getView() {
			return view;
		}

		@FXML
	    void onAniadirConocimientoAction(ActionEvent event) {

	    }

	    @FXML
	    void onAniadirIdiomaAction(ActionEvent event) {

	    }

	    @FXML
	    void onEliminarAction(ActionEvent event) {

	    }


}
