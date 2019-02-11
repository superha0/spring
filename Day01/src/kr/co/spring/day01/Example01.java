package kr.co.spring.day01;

import kr.co.spring.day01.classes1.AudiEngine;
import kr.co.spring.day01.classes1.BenzEngine;
import kr.co.spring.day01.classes1.Car;

public class Example01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car(new BenzEngine());
		Car car2 = new Car(new AudiEngine());
		
		car1.start();
		car2.start();
		car1.stop();
		car2.stop();
	}

}
