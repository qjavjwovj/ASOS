package openApi;

import openApi.weather.AsosDalyInfoService;
import openApi.weather.AsosHourlyInfoService;

public class Main {

	static final String serviceKey = "lB%2B7VERrpmwBSvDg3tYufKLEpZtp10YxHert3qmbaLZK2mp0tXb5E1Ozb%2F0O%2BKwNPcWHejq3T6k94ZKSuNHXCA%3D%3D";
	
	public static void main(String[] args){
		
		AsosDalyInfoService dalyInfoService = new AsosDalyInfoService();
		AsosHourlyInfoService hourlyInfoService = new AsosHourlyInfoService();
		 
		try {
//			dalyInfoService.dalyInfoService(serviceKey);	//���û_����(����, ASOS) ���ڷ� ��ȸ����
			hourlyInfoService.hourlyInfoService(serviceKey);	//���û_����(����, ASOS) �ð��ڷ� ��ȸ����
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���μ��� ó�� �� ���� �߻�");
		}
	}
}