package com.victory.biz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victory.biz.model.ResultVo;
import com.victory.biz.model.TestVo;
import com.victory.system.util.HttpUrlConnectUtil;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class TestController {

	@Autowired
	HttpUrlConnectUtil apiCon;


	@PostMapping(value = "/test")
	public Map<String, Object> test(@RequestBody @Valid TestVo param) throws Exception {

		log.debug("param : " +  param);
		Map<String, Object> result = new HashMap<>();

		result.put("resultKey","resultValue");

		return result;

	}


	@PostMapping(value = "/testVo")
	public TestVo testVo(@RequestBody TestVo param) throws Exception {

		log.debug("param : ", param);

		TestVo tv = TestVo.builder().test1("returnVal").test2("returnVal2").test3("returnVal3").build();

		log.debug("return vo : ", tv);

		return tv;

	}


	@PostMapping(value = "/testResultVoPost")
	public ResultVo testResultVoPost(@RequestBody Map<String, Object> param) throws Exception {

		log.debug("param : ", param);

		ResultVo tv = ResultVo.builder().result("resultasd0").resultMsg("resultMsggasdasd").build();

		log.debug("return vo : ", tv);

		return tv;

	}


	@GetMapping(value = "/testResultVoGet")
	public ResultVo testResultVoGet(@RequestParam  Map<String, Object> param) throws Exception {

		log.debug("param : ", param);

		ResultVo tv = ResultVo.builder().result("resultasd0").resultMsg("resultMsggasdasd").build();

		log.debug("return vo : {}", tv);

		return tv;

	}


	@PostMapping(value = "/apiConPost")
	public TestVo apiConPost(@RequestBody Map<String, Object> param,
			@RequestHeader Map<String, Object> requestHeader) throws Exception {

		String url = param.get("url").toString();
		String port = param.get("port").toString();
		String resulturl = "http://127.0.0.1:" + port + "/" + url;

		TestVo forObject = new TestVo();
		try {

			forObject = apiCon.apiPost(resulturl, param, requestHeader, TestVo.class);
			log.info("###end-point`s return value : ", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}


	@PostMapping(value = "/apiConPostVo")
	public ResultVo apiConPostVo(@RequestBody TestVo param, @RequestHeader Map<String, Object> requestHeader)
			throws Exception {

		String resulturl = "http://127.0.0.1:" + param.getTest1() + "/" + param.getTest2();

		ResultVo forObject = new ResultVo();
		try {

			forObject = apiCon.apiPost(resulturl, param, requestHeader, ResultVo.class);
			log.info("###end-point`s return value : ", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}

	@PostMapping(value = "/apiConGet")
	public TestVo apiConGet(@RequestBody  Map<String, Object> param,
			@RequestHeader Map<String, Object> requestHeader) throws Exception {

		String url = param.get("url").toString();
		String port = param.get("port").toString();
		String resulturl = "http://127.0.0.1:" + port + "/" + url;

		TestVo forObject = new TestVo();
		try {

			forObject = apiCon.apiGet(resulturl, param, requestHeader, TestVo.class);
			log.info("###end-point`s return value : {}", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}


	@PostMapping(value = "/apiConGetVo")
	public TestVo apiConGetVo(@RequestBody TestVo param, @RequestHeader Map<String, Object> requestHeader)
			throws Exception {

		String resulturl = "http://127.0.0.1:" + param.getTest1() + "/" + param.getTest2();

		TestVo forObject = new TestVo();
		try {

			forObject = apiCon.apiGet(resulturl, param, requestHeader, TestVo.class);
			log.info("###end-point`s return value : {}", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}
}
