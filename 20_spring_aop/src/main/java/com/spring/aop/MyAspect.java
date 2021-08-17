package com.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect  // AOP에서 Aspect 사용 선언 어노테이션
public class MyAspect {
														//해당클래스 이름이 들어간다.
	private static Logger logger = LoggerFactory.getLogger(MyAspect.class);
	
	/*
	 *  # execution 명시자 
	 *  					!!띄어쓰기를 구분으로 한다.
	 *  - execution(수식어패턴 리턴타입패턴 클래스이름패턴?메서드이름패턴(파라미터패턴)) 
	 *  - 각 패턴은 *을 이용하여 모든값을 표현할 수 있다.
	 *  
	 *  
	 *  [패키지]
	 *  com.spring.aop	  > com.spring.aop패키지를 타겟
	 *  com.spring.aop..  > com.spring.aop로 시작하는 하위의 모든 패키지를 타겟
	 *  
	 *  [리턴타입]
	 *  *		> 모든 리턴 타입 타겟
	 *  void	> 리턴 타입이 void인 메서드만 타겟
	 *  !void	> 리턴 타입이 void가 아닌 메서드만 타겟 
	 *  
	 *  [매개 변수 지정]
	 *  (..)		>  0개 이상의 모든 파라미터 타겟
	 *  (*)			> 1개의 파라미터만 타겟
	 *  (*,*)		> 2개의 파라미터만 타겟
	 *  (String,*)	> 2개의 파라미터중 첫번째 파라미터가 String타입만 타겟
	 *  
	 *  
	 *  샘플 예시
	 *  
	 *  execution(public void set*(..)) 					> 리턴 타입이 void이고 메서드 이름이 set으로 시작하고 파라미터가 0개 이상인 메서드 타겟
	 *  execution(* abc.*.*()) 								> abc패키지에 속한 파라미터가 없는 모든 메서드 타겟
	 *  execution(* abc..*.*(..)) 							> abc패키지 및 하위 패키지에 있는 파라미터가 0개 이상인 메서드 타겟
	 *  execution(Long com.spring.aop.ClassBoos.work(..))   > 리턴 타입인 Long인 com.spring.aop 패키지 안의 ClassBoss클래스의 work 메서드 타겟
	 *  execution (* get*(*)) 								> 이름이 get으로 시작하고 파라미터가 한 개인 메서드 타겟
	 *  execution(* get*(*,*)) 								> 이름이 get으로 시작하고 파라미터가 2개인 메서드 타겟
	 *  execution(* read*(Integer,..)) 						> 메서드 이름이 read 로시작하고, 첫번째 파라미터 타입이 Integer이며 한개 이상의 파라미터를 갖는 메서드 타겟
	 *  
	 * */
	
	@Pointcut("execution(* work())") //중복되는 메서드를 기술
	private void pointcut() {
		//특정한 의미가 없다
	}
	
	// 메서드 호출 전
	//@Before("pointcut()")
	@Before("execution(* work())") // 특정 패키지,클래스의 메서드를 지정
	public void before() {
		//System.out.println("AOP Before 메서드 호출 : 출근한다.");
		logger.info("AOP Before 메서드 호출 : 츨근한다.");		//Sysout.println 하지 말고 로거로 찍어라 .
	}
	
	// 메서드 호출 후
	@After("pointcut()")
	//@After("execution(* work())")
	public void after() {
		//System.out.println("AOP After 메서드 호출 : 퇴근한다.");
		logger.info("AOP After 메서드 호출 : 퇴근한다.");
	}
	
	//////////////////////////////////////////////////////////////
	
	// 메서드 호출 전후
	@Around("execution(* getWorkTime())")
	public void around(ProceedingJoinPoint pjp) {
		
		try {
			
			//메서드 호출 전
			System.out.println("=========================");
			long startTime = System.currentTimeMillis();
			
			// 메서드 호출
			pjp.proceed(); // ProceedingJoinPoint의 proceed메서드를 사용하여 호출된 메서드가 동작
			
			// 메서드 호출 후
			long endTime = System.currentTimeMillis();
			System.out.println("업무 소요 시간 : " + (endTime - startTime) + "초");
			System.out.println("=========================");
			
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
	} 
	
	//////////////////////////////////////////////////////////
	
	// 호출된 메서드가 성공적으로 실행 후
	@AfterReturning("execution(* normal(..))")
	public void afterReturning(JoinPoint jp) { // JoinPoint를 통하여서 메서드의 파라메타를 전달받을 수 있다.
//		System.out.println("1 : " + Arrays.toString(jp.getArgs())); // 메서드의 파라미터를 확인
//		System.out.println("2:" + jp.getKind());					// 메서드의 종류
//		System.out.println("3:" + jp.getSignature().getName());		// 어드바이즈메서드에 대한 설명(descrption)이 반환
//		System.out.println("4:" + jp.getTarget().toString());		// 대상 객체를 반환
//		System.out.println("5:" + jp.getThis().toString());			// 프록시 객체를 반환	
//		System.out.println("AOP AfterReturning 메소드 호출 : 정상적으로 업무를 마무리 하였다.\n");
		
		logger.info("1 : " + Arrays.toString(jp.getArgs()));
		logger.info("2:" + jp.getKind());
		logger.info("3:" + jp.getSignature().getName());
		logger.info("4:" + jp.getTarget().toString());
		logger.info("5:" + jp.getThis().toString());
		logger.info("AOP AfterReturning 메소드 호출 : 정상적으로 업무를 마무리 하였다.\n");
	}
	
	
	// 호출된 메서드에서 예외 발생 후
	@AfterThrowing("execution(public void com.spring.aop.ClassEmployee.mistake())")
	public void afterThrowing() {
		//System.out.println("AOP After Throwing 메서드 호출 : 실수로 보고서를 다른 상사에게 보냈다.");
		logger.info("AOP After Throwing 메서드 호출 : 실수로 보고서를 다른 상사에게 보냈다.");
	}
	
	
	
	
	
	
}
