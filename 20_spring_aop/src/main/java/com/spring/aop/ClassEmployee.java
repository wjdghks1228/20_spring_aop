package com.spring.aop;

// 테스트 목적의 클래스3
public class ClassEmployee implements IPosition{

	@Override
	public void work() {
		System.out.println("직원의 일을 한다.");
	}

	@Override
	public void getWorkTime() {
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//AfterReturning/ Throwing 이후 실행되는 부가 method 들을 Advice라고 부른다.
	
	@Override //AfterReturning Advice 예시
	public void normal(String title, int salary) {
		System.out.println("직급 : " + title);
		System.out.println("급여 : " + salary);		
	}

	@Override	//AfterThrowing Advice 예시
	public void mistake() {
		System.out.println(3/0);
	}

}
