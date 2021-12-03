//변수: 값을 저장할 메모리를 준비시키는 명령어
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam6")//클래스이름이 같을때 충돌방지
@RequestMapping("/lang/variable/exam6")
public class Exam1 {
  //변수선언
  //-값을 저장할 메모리를 담는 명령문
  @GetMapping("/test1")
  public String test1(String name, String tel, String gender) {
      
    return "클라이언트에서 받은 값: " + name + "," + tel + "," + gender;
  }
  
  //정수 변수 선언과 값의 범위 
  //정수-값을 저장하는 변수 선언과 범위확인
  @GetMapping("/test2")
  public String test2(byte b, short s, int i, long l) {
      
    return "클라이언트에서 받은 값 = " + b + ", " + s +", "+ i+ ", " + l ; 
  }
  
  //부동소수점 변수 선언과 값의 범위
  //부동소수점 값을 저장하는 메모리를 준비시키는 명령문
  //메모리 크기에 따른 값의 유효범위
  @GetMapping("/test3")
  public String test3(float f, double d) {
      
    return "클라이언트에서 받은 값 = " + f +",  "+ d; 
  }
  //문자변수 선언
  //-문자에 부여된 번호를 저장할 메모리를 준비시키는 명령문
  //http://localhost:8080/lang/variable/exam6/test4?c=%EA%B0%80
  @GetMapping("/test4")
  public String test4(char c) {//문자1개
      
    return "클라이언트에서 받은 값 = " + c + " , " + (int)c; 
  }
  
  //논리변수선언
  //boolean 리터럴은 true/false이다.(반드시소문자)
  //논리값으로 1/0, TRUE/FAULSE 는 스프링부트가 개입해섣가능
  @GetMapping("/test5")
  public String test5(boolean b) {//문자1개
      
    return "클라이언트에서 받은 값 = " + b ; 
  }
   
  
}
