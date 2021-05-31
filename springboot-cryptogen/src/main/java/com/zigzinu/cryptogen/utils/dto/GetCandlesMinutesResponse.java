package com.zigzinu.cryptogen.utils.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class GetCandlesMinutesResponse {
    
    private enum CandleStick {
        RISE("상승"), FALL("하락"), EVEN("보합");
        private final String kor;
        CandleStick(String kor) { this.kor = kor; }
        public String kor() { return kor; }
    }

    @JsonProperty("market")  
    private String market;                  // 마켓명
    @JsonProperty("candle_date_time_kst")  
    private String candleDateTimeKst;       // 캔들 기준 시각(KST 기준)
    @JsonProperty("opening_price")  
    private int openingPrice;       // 시가
    @JsonProperty("high_price")  
    private int highPrice;          // 고가
    @JsonProperty("low_price")  
    private int lowPrice;           // 저가
    @JsonProperty("trade_price")  
    private int tradePrice;         // 종가
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
            this.candleStick = CandleStick.FALL;
        } else if (this.openingPrice < this.tradePrice) {
            this.candleStick = CandleStick.RISE;
        } else if (this.openingPrice == this.tradePrice) {
            this.candleStick = CandleStick.EVEN;
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