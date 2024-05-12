package openApi.weather;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import openApi.utils.StringUtils;
import openApi.utils.Utils;
import openApi.vo.DalyInfoItemVo;
import openApi.vo.response.BaseResponseVo;

public class AsosHourlyInfoService {
	
	public void hourlyInfoService(String serviceKey) throws IOException {
		
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/AsosHourlyInfoService/getWthrDataList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호 Default : 10*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수 Default : 1*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default : XML*/
        urlBuilder.append("&" + URLEncoder.encode("dataCd","UTF-8") + "=" + URLEncoder.encode("ASOS", "UTF-8")); /*자료 분류 코드(ASOS)*/
        urlBuilder.append("&" + URLEncoder.encode("dateCd","UTF-8") + "=" + URLEncoder.encode("HR", "UTF-8")); /*날짜 분류 코드(HR)*/
        urlBuilder.append("&" + URLEncoder.encode("startDt","UTF-8") + "=" + URLEncoder.encode("20230101", "UTF-8")); /*조회 기간 시작일(YYYYMMDD)*/
        urlBuilder.append("&" + URLEncoder.encode("startHh","UTF-8") + "=" + URLEncoder.encode("01", "UTF-8")); /*조회 기간 시작시(HH)*/
        urlBuilder.append("&" + URLEncoder.encode("endDt","UTF-8") + "=" + URLEncoder.encode("20230103", "UTF-8")); /*조회 기간 종료일(YYYYMMDD) (전일(D-1) 까지 제공)*/
        urlBuilder.append("&" + URLEncoder.encode("endHh","UTF-8") + "=" + URLEncoder.encode("00", "UTF-8")); /*조회 기간 종료시(HH)*/
        urlBuilder.append("&" + URLEncoder.encode("stnIds","UTF-8") + "=" + URLEncoder.encode("156", "UTF-8")); /*종관기상관측 지점 번호 (활용가이드 하단 첨부 참조)*/
        
        String jsonData = Utils.communicate(new URL(urlBuilder.toString()), "GET", "application/json");
        
        ObjectMapper mapper = new ObjectMapper();
        BaseResponseVo resVo = new BaseResponseVo();
        
        try {
        	resVo = mapper.readValue(jsonData, BaseResponseVo.class);
        } catch (Exception e) {
        	e.printStackTrace();
		}
        
        System.out.println("total row count : " + resVo.getResponse().getBody().getItems().getItem().size());
        for(DalyInfoItemVo i : resVo.getResponse().getBody().getItems().getItem()) {
        	System.out.println("지역명 : " + i.getStnNm() 
        					+ " | 일자 : " + i.getTm()
        					+ " | 강수량 : " + (StringUtils.isEmpty(i.getSumRn()) ? "0" : i.getSumRn()));
        }
	}
}
