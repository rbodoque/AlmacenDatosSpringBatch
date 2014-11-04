package es.gfi.batch.readers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class BamJsonReader {
	@JsonProperty("Record Count")
	int cuenta;
	
	
	@JsonProperty("Metric ID Array")
	String[] nombres;

	public String[] getNombres() {
		return nombres;
	}

	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}

	public int getCuenta() {
		return cuenta;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}	
	
	

}
