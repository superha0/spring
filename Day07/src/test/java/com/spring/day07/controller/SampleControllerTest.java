package com.spring.day07.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.spring.day07.domain.Ticket;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 1) 컨트롤러 테스트를 위한 어노테이션
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)


// 2) controller의 bean 생성을 담당하는 servlet-context.xml 추가
@ContextConfiguration(
		{
			"file:src/main/webapp/WEB-INF/spring/root-context.xml",
			"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		})
@Log4j
public class SampleControllerTest {
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before	//org.junit.Before 를 import 해야함
	public void setup() {
		this.mockMvc = MockMvcBuilders.
				webAppContextSetup(ctx).
				build();
	}
	
	@Test
	public void testConvert() throws Exception {
		//GSON을 이용해서 일반 인스턴스를 JSON형태로 변환
		Ticket ticket = new Ticket();
		ticket.setBno(123);
		ticket.setOwner("Admin");
		ticket.setGrade("A");
		
		//Gson을 이용해 일반 자바 객체를 json 문자열 형태로 변환
		String jsonStr = new Gson().toJson(ticket);
		
		log.info("변환된 json문자열 : " +jsonStr);
		
		mockMvc.perform(post("/sample/ticket")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr))
		.andExpect(status().is(200));
	}
}
