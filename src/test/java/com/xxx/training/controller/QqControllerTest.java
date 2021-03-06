/**  
 * @Title: QqControllerTest.java
 * @Package com.xxx.training.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author xxx
 * @date 2016-5-16 上午9:06:08
 * @version V1.0  
 */
package com.xxx.training.controller;


import com.xxx.training.BaseTest;
import com.xxx.training.entity.domain.Qq;
import org.junit.Before;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

/**
 * 项目名称：training
 * 
 * 类描述： 类名称：com.xxx.training.controller.QqControllerTest 创建人：xxx
 * 创建时间：2016-5-16 上午9:06:08 修改人： 修改时间：2016-5-16 上午9:06:08 修改备注：
 * 
 * @version V1.0
 */

public class QqControllerTest extends BaseTest {

	@Inject
	private WebApplicationContext wac;

	private MockMvc mmc;
	//mock 模拟 http请求测试controller
	@Before
	public void setUp(){
		mmc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testView() throws Exception{
		MvcResult result = mmc.perform(MockMvcRequestBuilders.get("/test/1.json")).andReturn();
		System.out.printf(result.getResponse().getContentAsString());
	}
	@Test
	public void testAdd()throws  Exception{
		MvcResult result = mmc.perform(MockMvcRequestBuilders.post("/qq/add")).andReturn();
		System.out.printf(result.getResponse().getContentAsString());
	}


	
//	@Test
	public void testJason() throws JsonProcessingException{
		Qq qq = new Qq();
		qq.setId("1");
		qq.setQq(123);
		ObjectMapper mapper =new ObjectMapper();
		mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING,false);  
		mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,false);  
		String jsonStr = mapper.writeValueAsString(qq);
		System.out.println(jsonStr);
		ObjectMapper objectMapper2 = new ObjectMapper();  
	    objectMapper2.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING,true);  
	    String jsonStr2 = objectMapper2.writeValueAsString(qq);  
	    System.out.println(jsonStr2);
		ObjectMapper objectMapper3 = new ObjectMapper();  
		objectMapper3.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,true);  
		String jsonStr3 = objectMapper3.writeValueAsString(qq);  
		System.out.println(jsonStr3);
	}

}
