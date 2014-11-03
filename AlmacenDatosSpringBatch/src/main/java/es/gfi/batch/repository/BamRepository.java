package es.gfi.batch.repository;

import java.io.Serializable;
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

public class BamRepository implements PagingAndSortingRepository {

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
	
	Page<Map<String,String>> findByVersionModelo(String modelo,String version,PageRequest request){
		Map<String,String> result=new HashMap<String,String>();
		List<Map<String,String>> lista=new ArrayList<Map<String,String>>();
		result.put("primeraComumna", "segundo1");
		result.put("segundaComumna", "segundo1");
		result.put("terceraComumna", "tercero1");
		result.put("cuartaComumna", "quinto1");
		lista.add(result);
		
		result=new HashMap<String,String>();
		result.put("primeraComumna", "segundo2");
		result.put("segundaComumna", "segundo2");
		result.put("terceraComumna", "tercero2");
		result.put("cuartaComumna", "quinto2");
		lista.add(result);
		
		result=new HashMap<String,String>();
		result.put("primeraComumna", "segundo3");
		result.put("segundaComumna", "segundo3");
		result.put("terceraComumna", "tercero3");
		result.put("cuartaComumna", "quinto3");
		lista.add(result);
		
		Page page=new PageImpl(lista);
		
		return page;
	}

}
