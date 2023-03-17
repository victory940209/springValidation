package com.victory.biz.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {


	@JsonProperty("test")
	private String resultMsg;

	@JsonProperty("test2")
	private String result;

}
