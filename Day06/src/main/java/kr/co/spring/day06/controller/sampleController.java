package kr.co.spring.day06.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	
	
	//서버 클라이언트에게 데이터를 전달 할 때는
	// 반드시 Model 객체를 메소드의 매개변수로 넣어줘야 한다.
	@GetMapping("/ex03")
	public String ex03(Model model) {
		//전달할 데이터를 addAttribute 메소드를 이용해 넣어준다.
		model.addAttribute("name", "jhadsf");
		model.addAttribute("age",30);
		
		return "ex03"; //ex03.jsp 로 포워딩 (forward)
	}
	
	
	
	//JAVA Bean의 자동 어트리뷰트 전달
	// *Java bean 규칙
	// 1) 생성자에 매개변수가 없어야 한다. (보통 기본 생성자만 이용)
	// 2) 메소드 getter/setter 만 있어야 한다.
	
	// *Java Bean 은 Spring Framework 에서 자동으로 만들어주는 객체
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO sampleDTO, @ModelAttribute("page") int page) {
		//@ModelAttribute : 매개변수로 변수를 attribute 로 등록시켜줌
		log.info("dto : " + sampleDTO); // sampleDTO 가 자동으로 어트리뷰트가 된다,
		log.info("page: " + page);
		
		//sampleDTO가 자동으로 어트리뷰트로 등록되어서 ex04에 전달됨.
		//이 때 key값은 클래스의 앞글자(SampleDTO)를 
		// 소문자로 만든 형태(sampleDTO)로 지정됨
		
		return "ex04";
	}
	
	
	//Controller 메소드의 리턴타입
	// void, String
	// VO, DTO => 주로 JSON 타입을 생성할 때 사용함 (RestFul 개발)
	//ResponseEntity => HTTP 헤더 정보와 내용을 가공
	//	* 에러 코드 설정 또는 응답 (response)에 대한 내용을 직접 가공
	// Model, ModelAndView : 모델로 데이터를 반환하거나 
	// 모델과 화면을 동시에 보여주는 경우에 사용 (최근에는 잘 사용 안함)
	// HttpHeaders : 응답에 내용이 없이 단순 헤더 메시지만 전달
	
	
	// 메소드가 void 타입일 경우
	//url 의 이름을 jsp 로 활용
	
	public void ex05() {
		log.info("ex05.........................");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("ex06.........................");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(30);
		dto.setName("aaa");
		
		return dto;
	}
	
	
	
	
	
	
}
