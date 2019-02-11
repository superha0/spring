package kr.co.spring.day01.classes2;


// 자동차 객체를 생성하는 공장의 역할을 하는 팩토리 클래스
// 메인이 요청하면 공장에서는 자동차 객체를 만들어서 반환시켜준다.

// IOC의 시작
public class CarFactory {

	// 메소드의 이름은 Bean의 이름이 된다.
	// 메소드의 결과는 Bean이 된다.
	
	public Car car() {
		return new Car(benzEngine());
	}
	
	public BenzEngine benzEngine() {
		return new BenzEngine();
	}
}
