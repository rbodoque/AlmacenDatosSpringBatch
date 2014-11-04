package es.gfi.batch.readers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.data.RepositoryItemReader;

public class ItemReader extends RepositoryItemReader{
	
	@BeforeStep
    public void getInterstepData(StepExecution stepExecution) {
        JobExecution jobExecution = stepExecution.getJobExecution(); 
        
        String modelo = jobExecution.getJobInstance().getJobName();
        String version = stepExecution.getStepName();
        List arguments=new ArrayList();
        arguments.add(modelo);
        arguments.add(version);
        super.setArguments(arguments);
        
    }
	

}
