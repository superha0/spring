package kr.co.spring.day03.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component
@ToString  //toString  메소드를 오버로딩함 - lombok
@Getter //Getter 만들기
public class SampleHotel {

	//단일 생성자 의존성 묵시적 자동 주입
	//스프링 4.3버전 이상부터 지원
	private Chef chef;
	
	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
}
