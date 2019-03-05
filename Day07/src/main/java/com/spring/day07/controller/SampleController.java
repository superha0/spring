package com.spring.day07.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.day07.domain.SampleVO;
import com.spring.day07.domain.Ticket;

import lombok.extern.log4j.Log4j;

//RestController 어노테이션 : 현재 컨트롤러의 모든 작업을 RESTFul 방식으로
@RestController 
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	// RestFul Controller는 데이터 제공 방식을 직접 지정할 수 있다.
	// Produces 프로퍼티를 활용 => MIME 타입 지정
	
	
	//1) 평문(Plain Text) 보내기
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		return "안뇽";
	}
	
	//2) JSON 또는 XML 형식으로 보내기
	// Java의 인스턴스가 리턴된다.
	
	@GetMapping(value="/getSample",
			produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(123, "AAA", "ㅎㅅㅎ");
	}
	
	//컬렉션 타입의 객체 보내기
	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
		
		// Java 8 스트림 채널 이용
		return IntStream.range(1,10).mapToObj(i -> new SampleVO(i, i+"first", i+"last")).collect(Collectors.toList());
	}
	
	//RESTFul 방식은 페이지가 아닌 데이터를 전달하고 있음
	//잘못된 데이터들에 대해서는 잘못 되었다.라는 응답을 따로 해줄 수 있음
	//에러코드를 맘대로 설정해서 사용가능하다.
	
	//ResponseEntity : 응답의 상태코드와 에러 메세지 등을 같이 전달할 수 있음.
	@GetMapping(value="/check", params= {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo); //502
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo); //200
		}
		return result;
	}
	
	//@PathVariable
	//URL형식으로 파라미터 담기
	//일반 Controller 또는 RestController모두 사용하지만
	//보통 Rest 방식을 구현하기 위해 많이 사용하는 것이 일반적(관례)
	
	//PathVariable을 이용할 때는 파라미터에 자바의 기본자료형이 들어갈 수 없다.
	//ex) double ---> X
	//ex) Double ---> O
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,
							@PathVariable("pid") Integer pid) {
		return new String[] {"category: " + cat, "productid: "+pid};
	}
	
	//@RequestBody
	// 요청(request)의 내용(body)을 원하는 타입(보통 클래스) 변환 요구
	// * 요청의 내용은 JSON형태가 보통임
	// JSON 형식의 키값과 변환할 클래스의 멤버변수의 이름이 일치해야 한다.
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert json to ticket" + ticket);
		
		return ticket;
	}
	
}
