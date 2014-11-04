package es.gfi.batch.repository;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import es.gfi.batch.readers.dto.BamJsonReader;

public class BamRepository implements PagingAndSortingRepository {
	
	

	private RestTemplate restTemplate;
	private String urlBam;
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String getUrlBam() {
		return urlBam;
	}

	public void setUrlBam(String urlBam) {
		this.urlBam = urlBam;
	}

	
	
	public Object save(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable save(Iterable entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findOne(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable findAll(Iterable ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public Iterable findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Page findByVersionModelo(String modelo,String version,PageRequest request){
		restTemplate= new RestTemplate();
		
		BamJsonReader respuesta = restTemplate.getForObject("http://localhost:8080/json/objInstancias.json", BamJsonReader.class);
		
		respuesta.getInstancias().get(0);
		List listaRespuesta=new ArrayList();
		for(int i=0;i<respuesta.getInstancias().size();i++){
			Map instanciaActual=(Map)respuesta.getInstancias().get(i);
			List<String> listaValores=(List)instanciaActual.get("Metric Data");
			Map linea=new HashMap<String,String>();
			for(int j=0;j<listaValores.size();j++){
				linea.put(respuesta.getNombres().get(j), listaValores.get(j));
			}
			listaRespuesta.add(linea);		
		}
		Page page=new PageImpl(listaRespuesta);
		
		if(request.getPageNumber()==2){
			return new PageImpl(new ArrayList());
		}else{
			return page;
		}
	}

}
