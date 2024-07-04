package main.java.com.kwang.openApi.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import main.java.com.kwang.openApi.vo.DalyInfoItemsVo;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBodyVo {
	DalyInfoItemsVo items;
}
