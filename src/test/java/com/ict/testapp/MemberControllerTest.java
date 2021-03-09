package com.ict.testapp;


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
	
}
