package com.zigzinu.cryptogen.scheduler;

import com.zigzinu.cryptogen.utils.UpbitQuotationApi;
import com.zigzinu.cryptogen.utils.dto.GetCandlesMinutesResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TestScheduler {
	
	private final UpbitQuotationApi upbitQuotationApi;
	
	private final Logger L = LoggerFactory.getLogger(this.getClass());
	
    @Scheduled(fixedDelay = 3000)
	public void alert() {
        GetCandlesMinutesResponse[] response = upbitQuotationApi.getCandles("KRW-BTC", "5", "3");
		
		for (GetCandlesMinutesResponse r : response) {
			r.setCandleStick();
			L.info("{}", r);
		}

		L.info("{}", "");
	}

}