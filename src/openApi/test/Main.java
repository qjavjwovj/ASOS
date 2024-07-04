package openApi;

import openApi.weather.AsosDalyInfoService;
import openApi.weather.AsosHourlyInfoService;

public class Main {

	static final String serviceKey = "";
	
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