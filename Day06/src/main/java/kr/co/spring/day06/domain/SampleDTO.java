package kr.co.spring.day06.domain;

import lombok.Data;

// DTO : Data Transfer Object
// 클라이언트가 서버에게 전송하는 데이터(파라미터)들을 담기 위한 객체.

// * 파라미터들의 자료형은 무조건 String 형태임
// 예전에는 사용자가 원하는 타입에 맞춰서 Parsing 작업을 했어야 했음
// 하지만 스프링에서는 Front Controller가 알아서 Parsing 작업까지 해줌

@Data
public class SampleDTO{
	private String name;
	private int age;
}
