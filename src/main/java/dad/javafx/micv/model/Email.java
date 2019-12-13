package dad.javafx.micv.model;

import javax.xml.bind.annotation.XmlAttribute;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Email {
	
	private StringProperty direccion = new SimpleStringProperty();

	public StringProperty direccionProperty() {
		return this.direccion;
	}
	
	@XmlAttribute
	public String getDireccion() {
		return this.direccionProperty().get();
	}
	

	public void setDireccion(final String direccion) {
		this.direccionProperty().set(direccion);
	}
	
	
	
}
