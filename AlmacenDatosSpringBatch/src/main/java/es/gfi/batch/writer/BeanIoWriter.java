package es.gfi.batch.writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.beanio.Marshaller;
import org.beanio.StreamFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;

public class BeanIoWriter implements ItemWriter<Map<String, String>>,
		ItemStream {
	String ficheroSalida;
	String ficheroTransformacion;
	// create a BeanIO StreamFactory
	StreamFactory factory = StreamFactory.newInstance();
	// load the mapping file from the working directory
	Marshaller mar = null;

	PrintWriter writer;
	private String version;
	private String modelo;

	// @BeforeJob
	// public void getInterstepData(JobExecution jobExecution) {
	//
	// this.jobId = jobExecution.getJobId();
	// }
	//
	//
	//
	@BeforeStep
	public void getInterstepData(StepExecution stepExecution) {
		JobExecution jobExecution = stepExecution.getJobExecution();

		modelo = jobExecution.getJobInstance().getJobName();
		version = stepExecution.getStepName();

	}

	//
	public void close() throws ItemStreamException {
		writer.close();

	}

	public void open(ExecutionContext arg0) throws ItemStreamException {

		factory.loadResource(modelo + "/" + version + ".xml");

		mar = factory.createMarshaller("boletas");

		try {
			writer = new PrintWriter(ficheroSalida);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ItemStreamException(e);
		}

	}

	public void update(ExecutionContext arg0) throws ItemStreamException {

	}

	public void write(List<? extends Map<String, String>> arg0)
			throws Exception {
		List<Map<String, String>> intermedio = new ArrayList<Map<String, String>>();
		for (Map<String, String> actual : arg0) {
			Marshaller salida = mar.marshal(actual);
			writer.println(salida.toString());
		}
		writer.flush();

	}

	public String getFicheroTransformacion() {
		return ficheroTransformacion;
	}

	public void setFicheroTransformacion(String ficheroTransformacion) {
		this.ficheroTransformacion = ficheroTransformacion;
	}

	public String getFicheroSalida() {
		return ficheroSalida;
	}

	public void setFicheroSalida(String ficheroSalida) {
		this.ficheroSalida = ficheroSalida;
	}

	public String getVersion() {
		return version;
	}

	public String getModelo() {
		return modelo;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
