package kr.co.spring.day06.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.spring.day06.domain.SampleDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*") // 해당 컨트롤러로 접근하기 위한 기본 url 설정
@Log4j
public class sampleController {
	
	
	//특정 url로 요청이 들어왔을때 해야 할 메소드를 작성한다.
	//메소드들은 Front Controller에 의해 실행된다.
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..........");
	}
	
	// 웹 서버 통신 방식(자바와 무관 -> 스프링과도 무관)
	// GET 방식 : 파라미터가 url 을 통해서 전달됨
	// POST 방식 : parameter가 header에 숨겨져서 전달됨
	// 컨트롤러 메소드를 만들 때 미리 통신 방식(요청 방식)을 지정할 수 있음
	
	// 1) 옛날방식.. 여러가지 방식을 종합적으로 지원
	// 	--> 자주쓰임
	// value 매개변수에는 url 이 들어간다.
	// method 매개변수에는 통신방식을 설정한다.
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicRequest() {
		log.info("basic request.............");
	}
	
	// 2) GET 또는 POST 방식만 지원하고 싶을 경우
	//@GetMapping : Get 방식만 지원
	//@PostMapping : Post 방식만 지원
	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		log.info("basic get..................");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto.toString());
		return "ex01";
	}
	
	//파라미터 키 값을 이용해 명시적으로 수집하기
	//@ReauestParam(파라미터의 키값)
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name")String name, @RequestParam("age") Integer age) {
		
		log.info("name : " + name);
		log.info("age : " + age);
		
		return "ex02";
	}
	
	// 배열 형태의 데이터 받기
	// 보통 사용자가 체크박스로 체크한 내용들 받아낼때 사용함
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}
	
}
