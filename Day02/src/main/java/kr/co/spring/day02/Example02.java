package kr.co.spring.day02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.co.spring.day02.classes2.Car;

public class Example02 {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		Car car = context.getBean("car", Car.class);
		car.start();
		
	}
}
