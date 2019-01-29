package kr.co.spring.day02.classes2;

public class BenzEngine extends Engine{

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("벤츠 엔진 시동 걸기");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("벤츠 엔진 시동 끄기");
	}
}
