package kr.co.spring.day04.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j 
public class JDBCTest {
	// 1) 오라클 드라이버 로딩하기
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 2) JDBC 테스트
	
	@Test
	
	public void testConnection() {
		//java 8의 기능인 try ~ with 문을 이용
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","spring","1234")) {
			
			log.info(conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}


