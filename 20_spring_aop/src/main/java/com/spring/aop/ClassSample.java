package com.spring.aop;

public class ClassSample {

	// AOP 프로그래밍 이해 예시1
	public void sample1() {
		
		// Boss , Employee , Mananger 공통
		System.out.println("출근한다.");
		
		// Boss , Employee , Mananger마다 업무가 다르다.
		System.out.println("사장의 일을 한다.");
		System.out.println("관리자의 일을 한다.");
		System.out.println("직원의 일을 한다.");
		
		// Boss , Employee , Mananger 공통
		System.out.println("퇴근한다.");
		
	}
	
	
	// AOP 프로그래밍 이해 예시2
	public void sample2() {
		
		try {
			
			// DB연결 객체 생성(insert,update,delete,select 공통)
			
			// insert , update, delete , select마다 기능이 다르다.
			
		} catch (Exception e) {
			// 예외처리 (insert,update,delete,select 공통)
		}
		
	}
	
	// AOP 프로그래밍 이해 예시3
	public void sample3() {
		
		// 로깅 , 응답속도 테스트
		
		// 핵심 로직
		
		// 로깅 , 응답속도 테스트
		
	}
	
	
	
	
	
	
	
}
