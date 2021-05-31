package com.zigzinu.cryptogen.utils;

import com.zigzinu.cryptogen.utils.dto.GetCandlesMinutesResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpbitQuotationApi {

    private final RestTemplate restTemplate;

    private String serverUrl = "https://api.upbit.com";

    public GetCandlesMinutesResponse[] getCandles(String market, String minutes, String count){
        GetCandlesMinutesResponse[] response = restTemplate.getForObject(
                serverUrl + "/v1/candles/minutes/" + minutes + "?market=" + market + "&count=" + count, GetCandlesMinutesResponse[].class);
        // JsonObject[] jsonObjectArray = gson.fromJson(jsonString, JsonObject[].class);
        return response;
      }
}