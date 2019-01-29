package kr.co.spring.day02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.spring.day02.classes1.Car;
import kr.co.spring.day02.classes1.CarFactory;

public class Example01 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CarFactory.class);
		
		Car car = context.getBean("car", Car.class);
		car.start();
	}
}
