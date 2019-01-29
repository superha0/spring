package kr.co.spring.day02.classes1;

public class Car {
	
	private Engine engine;
	
	public Car(Engine engine) {
		this.engine = engine;
	}
	
	public void start() {
		engine.turnOn();
		System.out.println("자동차가 앞으로 갑니다.");
	}
	 
	public void stop() {
		engine.turnOff();
		System.out.println("자동차가 멈춥니다.");
	}

}
