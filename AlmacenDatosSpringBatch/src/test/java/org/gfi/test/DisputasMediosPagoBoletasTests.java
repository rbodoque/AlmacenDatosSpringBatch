/*
 * Copyright 2007-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gfi.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/simple-job-launcher-context.xml", "/appcontext.xml"})
public class DisputasMediosPagoBoletasTests {
	@Autowired()
	private JobLauncherTestUtils boletas;
	
	
	@Test
	public void testLaunchJob() throws Exception {
		 JobParametersBuilder jobParametersBuilder =
		            new JobParametersBuilder();
		 jobParametersBuilder.addString("out.file.name", "salida.txt");
		
		
		
		 boletas.launchJob(jobParametersBuilder.toJobParameters());

	}
}
