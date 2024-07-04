package main.java.com.kwang.openApi.vo.request;

import lombok.Data;

@Data
public class AsosDailyVo {
	private String serviceKey;
	private String startDate;
	private String endtDate;
	private String stnlds;
}
