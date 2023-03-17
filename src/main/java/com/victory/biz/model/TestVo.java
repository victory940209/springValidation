package com.victory.biz.model;

import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestVo {


	@JsonProperty("name")
	@Pattern(regexp = "^[ㄱ-ㅎ가-힣]*$", message = "한글이 아닙니다.")
	private String name;


	@JsonProperty("email")
	@Email(message = "email 형식이 아닙니다.")
	private String email;


	@JsonProperty("phone")
	@Pattern(regexp = "/^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$", message = "핸드폰번호 11자리를 정확히 입력해주세요.")
	private String phone;


	@JsonProperty("test1")
	@NotNull(message = "null이면 안됩니다.")
	private String test1;

	@JsonProperty("test2")
	@NotBlank(message = "blank이면 안됩니다.")
	private String test2;

	@JsonProperty("test3")
	@NotEmpty(message = "empty이면 안됩니다.")
	private String test3;

}
