package kr.co.spring.day03.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	//의존성 자동주입
	//chef의 Setter를 의존성 자동주입 하기 위한 수단으로 지정함
	
	//@Autowired : 의존하고 있는 클래스의 객체를 자동으로 탐색하여 의존성 주입까지 해주는 어노테이션
	@Setter(onMethod_ = {@Autowired})
	private Chef chef;
}
