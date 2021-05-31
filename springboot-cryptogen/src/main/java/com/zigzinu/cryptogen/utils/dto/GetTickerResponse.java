package com.zigzinu.cryptogen.utils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class GetTickerResponse {
    
    acc_trade_price	누적 거래대금(UTC 0시 기준)	Double
    acc_trade_price_24h	24시간 누적 거래대금	Double
    acc_trade_volume	누적 거래량(UTC 0시 기준)	Double
    acc_trade_volume_24h	24시간 누적 거래량	Double
    highest_52_week_price	52주 신고가	Double
    highest_52_week_date	52주 신고가 달성일	String
    lowest_52_week_price	52주 신저가	Double
    lowest_52_week_date	52주 신저가 달성일	String
    timestamp	타임스탬프	Long

    @JsonProperty("market")  
    private String market;                  // 종목 구분 코드
    @JsonProperty("trade_date_kst")  
    private String tradeDateKst;       // 최근 거래 일자(KST)
    @JsonProperty("trade_time_kst")  
    private String tradeTimeKst;       // 최근 거래 시각(KST)
    @JsonProperty("opening_price")  
    private int openingPrice;       // 시가
    @JsonProperty("high_price")  
    private int highPrice;          // 고가
    @JsonProperty("low_price")  
    private int lowPrice;           // 저가
    @JsonProperty("trade_price")  
    private int tradePrice;         // 종가
    @JsonProperty("prev_closing_price")  
    private int prevClosingPrice;         // 전일 종가
    @JsonProperty("change")  
    private String change;         // 변동
    @JsonProperty("signed_change_price")  
    private int signedChangePrice;         // 부호가 있는 변화액
    @JsonProperty("signed_change_rate")  
    private double signedChangeRate;         // 부호가 있는 변화율
    @JsonProperty("trade_volume")  
    private double tradeVolume;         // 가장 최근 거래량
    @JsonProperty("acc_trade_price")  
    private double tradeVolume;         // 가장 최근 거래량
    @JsonProperty("trade_volume")  
    private double tradeVolume;         // 가장 최근 거래량
    @JsonProperty("trade_volume")  
    private double tradeVolume;         // 가장 최근 거래량
    @JsonProperty("trade_volume")  
    private double tradeVolume;         // 가장 최근 거래량
    @JsonProperty("timestamp")  
    private long timestamp;                 // 해당 캔들에서 마지막 틱이 저장된 시각
    // @JsonProperty("candle_acc_trade_price")  
    // private double candleAccTradePrice;     // 누적 거래 금액
    // @JsonProperty("candle_acc_trade_volume")  
    // private double candleAccTradeVolume;    // 누적 거래량
    @JsonProperty("unit")  
    private int unit;                       // 분 단위(유닛)
    private CandleStick candleStick;

    public void setCandleStick() {
        if (this.openingPrice > this.tradePrice) {
            this.candleStick = CandleStick.BLUE;
        } else if (this.openingPrice < this.tradePrice) {
            this.candleStick = CandleStick.RED;
        } else if (this.openingPrice == this.tradePrice) {
            this.candleStick = CandleStick.DOJI;
        } 
    }

    @Override
    public String toString() {
        return this.market + " " + this.unit + "분봉" + 
                "(" + this.candleDateTimeKst + ") " + 
                "[" + this.candleStick.kor() + "] " +
                "저가:" + this.openingPrice + " " +
                "고가:" + this.tradePrice;
    }
}


// @Getter @Setter 
// @Builder @NoArgsConstructor @AllArgsConstructor
// public class PrepareAgentRequestBody {

// 	@NotEmpty
// 	@NotBlank
// 	@ApiModelProperty(required=true, value="Holder DID에 대한 키", example="RGQrd4y4Gq+m4ND5oGmEo9cbkwgB35N2hmORvA4cKtw=")
// 	@JsonProperty("wallet_key")
// 	private String walletKey;