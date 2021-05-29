package com.zigzinu.cryptogen.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {
	
	final Logger L = LoggerFactory.getLogger(this.getClass());
	
    @Scheduled(fixedDelay = 1000)
	public void alert() {
        Date d = new Date();

		L.info("현재 시간 : {}", d);
	}

}