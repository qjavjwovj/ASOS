package main.java.com.kwang.openApi.service.wheather;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.kwang.openApi.util.StringUtils;
import main.java.com.kwang.openApi.util.Utils;
import main.java.com.kwang.openApi.vo.DalyInfoItemVo;
import main.java.com.kwang.openApi.vo.response.BaseResponseVo;

@Service
public class AsosDailyInfoService {
	
	public void dalyInfoService(String serviceKey) throws IOException {		
		/* URL �� �Ķ���� ���� */
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ Default : 1*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("365", "UTF-8")); /*�� ������ ��� �� Default : 10*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*��û�ڷ�����(XML/JSON) Default : XML*/
        urlBuilder.append("&" + URLEncoder.encode("dataCd","UTF-8") + "=" + URLEncoder.encode("ASOS", "UTF-8")); /*�ڷ� �з� �ڵ�(ASOS)*/
        urlBuilder.append("&" + URLEncoder.encode("dateCd","UTF-8") + "=" + URLEncoder.encode("DAY", "UTF-8")); /*��¥ �з� �ڵ�(DAY)*/
        urlBuilder.append("&" + URLEncoder.encode("startDt","UTF-8") + "=" + URLEncoder.encode("20230101", "UTF-8")); /*��ȸ �Ⱓ ������(YYYYMMDD)*/
        urlBuilder.append("&" + URLEncoder.encode("endDt","UTF-8") + "=" + URLEncoder.encode("20231231", "UTF-8")); /*��ȸ �Ⱓ ������(YYYYMMDD) (����(D-1)���� ����)*/
        urlBuilder.append("&" + URLEncoder.encode("stnIds","UTF-8") + "=" + URLEncoder.encode("156", "UTF-8")); /*���������� ���� ��ȣ (Ȱ�밡�̵� �ϴ� ÷�� ����)*/
        
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
        	System.out.println("������ : " + i.getStnNm() 
        					+ " | ���� : " + i.getTm()
        					+ " | ������ : " + (StringUtils.isEmpty(i.getSumRn()) ? "0" : i.getSumRn()));
        }
	}
}
