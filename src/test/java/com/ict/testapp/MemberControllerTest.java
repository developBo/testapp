package com.ict.testapp;


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//스프링에서 JUnit을 사용한 테스트를 할 경우
//SpringJUnit4ClassRunner 라는 스프링 테스트를 위한 Runner 클래스를 지정해야 함

@RunWith(SpringJUnit4ClassRunner.class)
public class MemberControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberControllerTest.class);
	
}
