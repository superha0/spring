package kr.co.spring.day02.classes1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 해당 팩토리 클래스를 스프링 BeanFactory에 설계도로써 등록하자.
@Configuration
public class CarFactory {
	//Bean의 역할:항상 객체를 리턴해줘야한다.
	@Bean 
	public Car car() {
		return new Car(benzEngine());
	}
	
	@Bean
	public BenzEngine benzEngine() {
		return new BenzEngine();
	}
}
