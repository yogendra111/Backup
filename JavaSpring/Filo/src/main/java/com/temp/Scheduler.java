package com.temp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Scheduler {
	
    SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
	
	@Scheduled(cron = "* * * * * ?")
	public void Task() {
		Date now = new Date();
		System.out.println("Scheduled time: " + formatter.format(now));
	}

}
