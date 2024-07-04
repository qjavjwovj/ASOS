package main.java.com.kwang.openApi.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class DalyInfoItemVo {
	String stnNm;
	String tm;
	String sumRn;
}
