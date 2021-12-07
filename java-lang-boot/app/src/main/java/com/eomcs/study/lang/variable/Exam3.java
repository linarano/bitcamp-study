//변수: 스프링부트의 자동형변환
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam3")//클래스이름이 같을때 충돌방지
@RequestMapping("/lang/variable/exam3")
public class Exam3 {
//스프링 부트는 클라이언트가 보낸 값을 파라미터타입에 맞춰 자동형변환을 수행한다.
//=> 웹브라우저가 보내는 값은 무조건 "문자열이다."무얼보내든- 게시글, 단 파일업로드는 바이너리형식으로 보내짐, 날짜든뭐든 다 문자열 
 

  //=>100=> byte
  @GetMapping("/test1")
  public String test1(byte value) {
      
    return "==>" + value ; 
  }
  
  //32767
  @GetMapping("/test2")
  public String test2(short value) {
      
    return "==>" + value ; 
  }
  
  //456789
  @GetMapping("/test3")
  public String test3(int value) {
      
    return "==>" + value ; 
  }
  
  //2244445555
  @GetMapping("/test4")
  public String test4(long value) {
      
    return "==>" + value ; 
  }
  
 //3.14
  @GetMapping("/test5")
  public String test5(float value) {
      
    return "==>" + value ; 
  }
  
  //"3456.7898"
  @GetMapping("/test6")
  public String test6(double value) {
      
    return "==>" + value ; 
  }
  
 
   @GetMapping("/test7")
  public String test7(boolean value) {
      
    return "==>" + value ; 
  }
  
  @GetMapping("/test8")
  public String test8(char value) {
      
    return "==>" + value ; 
  }
  //2021-12-06
  @GetMapping("/test9")
  public String test9(java.sql.Date value) {
      
    return "==>" + value ; //실무에서는 안되지만 스트링부트는 날짜까지바꿔줌
  }
  /*
  @GetMapping("/test1")
  public String test1(byte value) {
      
    return "==>" + value ; 
  }
 */  
}

