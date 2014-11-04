package es.gfi.batch.readers.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BamJsonReader {
	 
	
	
	
	@JsonProperty("Metric ID Array")
	List<String> nombres;

	@JsonProperty("Instance Data")
	List<Map<String,String>> instancias;
	
	public List<String> getNombres() {
		return nombres;
	}

	public void setNombres(List<String> nombres) {
		this.nombres = nombres;
	}

	public List getInstancias() {
		return instancias;
	}

	public void setInstancias(List instancias) {
		this.instancias = instancias;
	}
	
	
	

}
