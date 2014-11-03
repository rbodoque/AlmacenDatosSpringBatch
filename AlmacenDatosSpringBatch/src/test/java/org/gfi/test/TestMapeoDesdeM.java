package org.gfi.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.beanio.Marshaller;
import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.junit.Test;

public class TestMapeoDesdeM {

	@Test
	public void test() {
		
		 // create a BeanIO StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file from the working directory
        factory.loadResource("jobs/mapeoDisputas.xml");
        
        
        Marshaller mar = factory.createMarshaller("contacts");
        
        
        Map valores = new Hashtable();
        valores.put("recordType", "tipo");
        valores.put("fileDate", new Date());
        List valoresLs=new ArrayList();
        valoresLs.add(valores);
        
        Marshaller salida = mar.marshal(valoresLs);
        
        salida.toString();
        
        
        //String json="contactsJson:{[{recordType:'tipo', fileDate:'12122014'},{recordType:'tipo2', fileDate:'13122014'}]}";
        String json="contactsJson:1";
        Unmarshaller umar = factory.createUnmarshaller("contactsJson");
        Object salida2 = umar.unmarshal(json);
        salida2.toString();
        
//        out.flush();
//        out.close();
		
		
		
	}

}
