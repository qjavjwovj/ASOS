package openApi;

import openApi.weather.AsosDalyInfoService;
import openApi.weather.AsosHourlyInfoService;

public class Main {

	static final String serviceKey = "lB%2B7VERrpmwBSvDg3tYufKLEpZtp10YxHert3qmbaLZK2mp0tXb5E1Ozb%2F0O%2BKwNPcWHejq3T6k94ZKSuNHXCA%3D%3D";
	
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