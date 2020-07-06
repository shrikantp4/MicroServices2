package com.capgemini;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class CreateTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateTaskApplication.class, args);
	}
	
	@Bean
	  public TollProcessorTask tollProcessingTask(){
	  	return new TollProcessorTask();
	  } 
	  public class TollProcessorTask implements CommandLineRunner,TaskExecutionListener{

	  	@Override
	  	public void run(String... strings) throws Exception {

	  		for(String s: strings)
	  		System.out.println(s);
	  	
	  	}
	  	
	  	@Override
		public void onTaskEnd(TaskExecution taskExecution) {
			// TODO Auto-generated method stub
		System.out.print("End the Task and kill the process");	
		}

		@Override
		public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTaskStartup(TaskExecution taskExecution) {
			// TODO Auto-generated method stub
			System.out.print(" Task started successfully");	
			
			
		}

	  } 

}
