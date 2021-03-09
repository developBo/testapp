package com.ict.testapp;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//스프링에서 JUnit을 사용한 테스트를 할 경우
//SpringJUnit4ClassRunner 라는 스프링 테스트를 위한 Runner 클래스를 지정해야 함

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // Controller 와 Web환경에서 사용되는 bean(class)들을 자동으로 생성하고 등록
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
																"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
															//자동으로 애플리케이션 컨텍스트 설정 파일들을 연결 처리함
public class MemberControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberControllerTest.class);
	// system.println 실제 앱에서는 사용 안하고 Logger를 사용함
	
	//테스트를 위한 클래스 필드 선언함
	@Autowired
	private WebApplicationContext wac; //현재 실행중인 웹 에플리케이션에 대한 객체 선언
	private MockMvc mockMvc;
	//client 요청내용을 controller 에서 받아서 처리하는 것과 동일한 작동 테스트를 진행하는 클래스임
	
	//JUnit 테스트 진행 전에 먼저 실행할 것을 지정할 때 사용
	@Before
	public void setup() {
		//테스트용 목업 객체 빌드함
		this.mockMvc= MockMvcBuilders.webAppContextSetup(this.wac).build();
		LOGGER.info("setup() 메소드 call...");
	}
	
	// 실제 테스트 내용을 작성한 메소드
	@Test
	public void testMemberRegister() {
		LOGGER.info("test start...");
		
		// 테스트 메소드 내부에서 mockMvc 를 이용해서 테스트할 대상 컨트롤러의 매핑 url과
		// 요청 데이터를 전송하는 가상의 요청을 작성함 : perform() 메소드 사용함
		try {
		mockMvc.perform(post("/member/memberEnroll.do")
		.param("userid", "test007")
		.param("passwd", "test007")
		.param("email", "test007@ict.org")
		.param("tel", "01012345678")
		.param("passwd", "test007"))
		
		.andDo(print()) //실행 처리하고 결과 출력함
		.andExpect(status().isOk()  // 에러 없는 정상 상태임을 응답하는 것으로 테스트를 검증함
				
		);
		
		LOGGER.info("test end...");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
