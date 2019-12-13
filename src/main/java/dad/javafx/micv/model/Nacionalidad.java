 package dad.javafx.micv.model;

import javax.xml.bind.annotation.XmlAttribute;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nacionalidad {

	private StringProperty denominacion = new SimpleStringProperty();
	
	@Override
	public String toString() {
		return getDenominacion().toString();
	}
	
	public Nacionalidad() {
	}

	public Nacionalidad(String denominacion) {
		setDenominacion(denominacion);
	}

	public StringProperty denominacionProperty() {
		return this.denominacion;
	}
	
	@XmlAttribute
	public String getDenominacion() {
		return this.denominacionProperty().get();
	}
	
	public void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	
	
	
}
