package kr.or.spring.day03.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.spring.day03.sample.Restaurant;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

//Junit 테스트 환경 설정(스프링으로 지정함)
@RunWith(SpringJUnit4ClassRunner.class)

//환경 설정 정보가 담겨있는 파일을 불러오기
// * Spring 에서의 환경설정 정보는 결국 Bean을 만들어내는 설계도들
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j 
//lombok에서 제공하는 로그 객체 사용
public class SampleTest {
	
	//Bean으로 등록해 높은 Restaurant 클래스의 Bean을 SampleTest에서 주입받
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	
	//테스트 코드 작성하기
	@Test
	public void testRestaurant() {
		// 매개변수로 전달되는 객체가 null값이면 테스트 종료 ( 예외 발생 )
		assertNotNull(restaurant);
		
		log.info("---의존주입테스트---");
		log.info(restaurant);
		log.info(restaurant.getChef());
		log.info("------------------");
	}

}
