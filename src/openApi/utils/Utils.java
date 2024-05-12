package openApi.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {

	public static String communicate(URL url, String method, String contentType) throws IOException {
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);	//요청방식 셋팅
        conn.setRequestProperty("Content-type", contentType);
        
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd = null;
        StringBuilder sb = new StringBuilder();
        
        try {
        	
        	/* 응답이 성공인 경우 */
        	if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        		rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        	}
        	/* 응답이 실패인 경우 */
        	else {
        		rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        	}
        	
        	String line;
        	
        	/* BufferedReader에서 데이터 한줄씩 읽기 */
        	while ((line = rd.readLine()) != null) {
        		sb.append(line);
        	}
        	
        } catch (Exception e) {
			// TODO: handle exception
		} finally {
			/* 자원 반환 및 통신 종료 */
			rd.close();
			conn.disconnect();
		}
        
        System.out.println(sb.toString());
        return sb.toString();
	}
}
