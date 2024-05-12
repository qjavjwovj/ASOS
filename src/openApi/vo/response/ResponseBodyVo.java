package openApi.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import openApi.vo.DalyInfoItemsVo;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBodyVo {
	DalyInfoItemsVo items;
}
