 package dad.javafx.micv.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nacionalidad {

	private StringProperty denominacion = new SimpleStringProperty();
	
	@Override
	public String toString() {
		return getDenominacion().toString();
	}

	public Nacionalidad(String denominacion) {
		setDenominacion(denominacion);
	}


	public StringProperty denominacionProperty() {
		return this.denominacion;
	}
	

	public String getDenominacion() {
		return this.denominacionProperty().get();
	}
	

	public void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	
	
	
}
