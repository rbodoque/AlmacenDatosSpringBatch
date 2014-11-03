package es.gfi.batch.writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.beanio.Marshaller;
import org.beanio.StreamFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;

public class BeanIoWriter implements ItemWriter<Map<String,String>>,ItemStream{

	 // create a BeanIO StreamFactory
    StreamFactory factory = StreamFactory.newInstance();
    // load the mapping file from the working directory
    Marshaller mar=null;
	
	public void close() throws ItemStreamException {
		// TODO Auto-generated method stub
		
	}

	public void open(ExecutionContext arg0) throws ItemStreamException {
		
		factory.loadResource("jobs/mapeoDisputasBoletas.xml");
		mar = factory.createMarshaller("boletas");
	}

	public void update(ExecutionContext arg0) throws ItemStreamException {
		// TODO Auto-generated method stub
		
	}

	public void write(List<? extends Map<String, String>> arg0)
			throws Exception {
		List<Map<String,String>> intermedio=new ArrayList<Map<String, String>>();
		for(Map<String, String> actual:arg0)
				intermedio.add(actual);
				
		Marshaller salida = mar.marshal(intermedio);
        
        salida.toString();
		
	}

	

}
