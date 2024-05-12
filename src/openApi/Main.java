package openApi;

import openApi.weather.AsosDalyInfoService;
import openApi.weather.AsosHourlyInfoService;

public class Main {

	static final String serviceKey = "";
	
	public static void main(String[] args){
		
		AsosDalyInfoService dalyInfoService = new AsosDalyInfoService();
		AsosHourlyInfoService hourlyInfoService = new AsosHourlyInfoService();
		
		try {
//			dalyInfoService.dalyInfoService(serviceKey);	//기상청_지상(종관, ASOS) 일자료 조회서비스
			hourlyInfoService.hourlyInfoService(serviceKey);	//기상청_지상(종관, ASOS) 시간자료 조회서비스
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("프로세스 처리 중 에러 발생");
		}
	}
}