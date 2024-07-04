package main.java.com.kwang.openApi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {

	public static String communicate(URL url, String method, String contentType) throws IOException {
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);	//��û��� ����
        conn.setRequestProperty("Content-type", contentType);
        
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd = null;
        StringBuilder sb = new StringBuilder();
        
        try {
        	
        	/* ������ ������ ��� */
        	if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        		rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        	}
        	/* ������ ������ ��� */
        	else {
        		rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        	}
        	
        	String line;
        	
        	/* BufferedReader���� ������ ���پ� �б� */
        	while ((line = rd.readLine()) != null) {
        		sb.append(line);
        	}
        	
        } catch (Exception e) {
			// TODO: handle exception
		} finally {
			/* �ڿ� ��ȯ �� ��� ���� */
			rd.close();
			conn.disconnect();
		}
        
        System.out.println(sb.toString());
        return sb.toString();
	}
}
