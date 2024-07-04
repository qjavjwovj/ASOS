package main.java.com.kwang.openApi.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown =true)
public class DalyInfoItemsVo {
	List<DalyInfoItemVo> item;
}
