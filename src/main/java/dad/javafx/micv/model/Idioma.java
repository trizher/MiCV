package dad.javafx.micv.model;

import javax.xml.bind.annotation.XmlAttribute;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idioma extends Conocimiento{
	
	private StringProperty certificacion = new SimpleStringProperty();

	public StringProperty certificacionProperty() {
		return this.certificacion;
	}
	
	@XmlAttribute
	public String getCertificacion() {
		return this.certificacionProperty().get();
	}
	

	public void setCertificacion(final String certificacion) {
		this.certificacionProperty().set(certificacion);
	}
	
	
	
}
