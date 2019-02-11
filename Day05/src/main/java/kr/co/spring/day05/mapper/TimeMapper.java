package kr.co.spring.day05.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//쿼리문장과 그 쿼리를 실행할 메소드를 지정하는 것을 Mapping 이라고 한다.
	//간단한 한줄짜리 쿼리 같은 경우는 어노테이션을 이용해서 사용 가능함
	
	
	@Select("select sysdate from dual")
	public String getTime();
}
