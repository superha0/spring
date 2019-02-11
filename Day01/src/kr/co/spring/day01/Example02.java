package kr.co.spring.day01;

import kr.co.spring.day01.classes2.Car;
import kr.co.spring.day01.classes2.CarFactory;


public class Example02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarFactory factory = new CarFactory();
		Car car = factory.car();
		car.start();
	}

}
