package es.gfi.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class ConfiguracionModeloVersiones implements StepExecutionListener{

	
	
	public void beforeStep(StepExecution stepExecution) {
		 JobExecution jobExecution = stepExecution.getJobExecution(); 
	        
	        String nombreTrabajo = jobExecution.getJobInstance().getJobName();
	        String nombrePaso = stepExecution.getStepName();
	        
	        JobParametersBuilder jobParametersBuilder =
		            new JobParametersBuilder();
	        
	        
	       
	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
